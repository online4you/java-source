// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CSVFile.java

package com.innova4j.puloader;

import com.innova4j.puloader.file.TotalFile;
import com.innova4j.util.CSVUtil;
import com.innova4j.util.filereaders.*;
import com.innova4j.util.filereaders.exception.ColumnNameNotFoundException;
import com.innova4j.util.filereaders.jibx.*;
import com.innova4j.util.time.Chronometer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import org.apache.log4j.Logger;
import org.jibx.runtime.JiBXException;

// Referenced classes of package com.innova4j.puloader:
//            InsertBatch, CSVFileUpdate, PULoaderSQL, Context

public class CSVFile
{

    public CSVFile(String fileName)
    {
        totalInfo = new TotalFile(null, fileName, null);
    }

    public CSVFile(Context context, Logger logger, TextFileGroup csvDefinition, int fileIndex, TotalFile totalInfo)
    {
        this.csvDefinition = csvDefinition;
        this.fileIndex = fileIndex;
        this.totalInfo = totalInfo;
        if(totalInfo.getLabel() == null)
            this.totalInfo.setLabel(getLabel(this.totalInfo.getFileName()));
        if(totalInfo.hasUpdate() && totalInfo.getLabelUpdateFile() == null)
            this.totalInfo.setLabelUpdateFile(CSVFileUpdate.getLabel(totalInfo.getUpdateFileName()));
        Columns cols = csvDefinition.getTextFile(fileIndex).getColumns();
        columns = new String[cols.sizeColumnList()];
        for(int i = 0; i < cols.sizeColumnList(); i++)
            columns[i] = cols.getColumn(i).getName();

        this.context = context;
        this.logger = logger;
    }

    public void loadDataForUpdate(String storagePath, Hashtable updateData, PULoaderSQL pSQL, String originalLabel)
        throws FileNotFoundException, JiBXException, IOException, ColumnNameNotFoundException
    {
        //CSVFileReader fileCsvX = CSVUtil.openCSVFile(storagePath + totalInfo.getFileName(), csvDefinition.getDelimiter(), csvDefinition.getTextFile(fileIndex).getColumns(), csvDefinition.getTextFile(fileIndex).getCharsetName());
        CSVFileReader fileCsvX = CSVUtil.openCSVFile(storagePath + totalInfo.getFileName(), csvDefinition.getDelimiter(), csvDefinition.getTextFile(fileIndex).getColumns(), "UTF-8");
        DataRow fileRecord = fileCsvX.getNextRow();
        String pstmt = "INSERT INTO " + totalInfo.getTableName() + " (";
        for(int i = 0; i < columns.length; i++)
        {
            if(i > 0)
                pstmt = pstmt + ", ";
            pstmt = pstmt + columns[i];
        }

        pstmt = pstmt + ") VALUES (";
        for(int i = 0; i < columns.length; i++)
        {
            if(i > 0)
                pstmt = pstmt + ", ";
            pstmt = pstmt + "?";
        }

        pstmt = pstmt + ")";
        pSQL.createPreparedInsertStament(pstmt);
        if(pSQL.getContext().isFatalError())
            return;
        String updateStr = null;
        if(totalInfo.getKey().length < columns.length)
        {
            updateStr = "UPDATE " + totalInfo.getTableName() + " SET  ";
            String updateWhereStr = " WHERE ";
            for(int i = totalInfo.getKey().length; i < columns.length; i++)
            {
                if(i > totalInfo.getKey().length)
                    updateStr = updateStr + ", ";
                updateStr = updateStr + columns[i] + " = ?";
            }

            for(int i = 0; i < totalInfo.getKey().length; i++)
            {
                if(i > 0)
                    updateWhereStr = updateWhereStr + " AND ";
                updateWhereStr = updateWhereStr + totalInfo.getKey()[i] + " = ?";
            }

            pSQL.createPreparedUpdateStament(updateStr + updateWhereStr);
            if(pSQL.getContext().isFatalError())
                return;
        } else
        {
            logger.debug("Update statement not has been created. [table= " + totalInfo.getTableName() + "]");
        }
        String dataValues[] = new String[columns.length];
        String keyValues[] = new String[totalInfo.getKey().length];
        String totalRecords = String.valueOf(updateData.size());
        pSQL.getPBar().setMaximum(updateData.size());
        pSQL.getPBar().setValue(0);
        int updatedCounter = 0;
        for(; updateData.size() != 0 && fileCsvX.hasMoreElements() && pSQL.getContext().isProcessing(); fileRecord = fileCsvX.getNextRow())
        {
            String keys = "";
            for(int i = 0; i < totalInfo.getKey().length; i++)
            {
                if(!keys.equals(""))
                    keys = keys + "|";
                keys = keys + fileRecord.get(fileCsvX.getHeaders().getPosition(totalInfo.getKey()[i]));
                keyValues[i] = fileRecord.get(fileCsvX.getHeaders().getPosition(totalInfo.getKey()[i]));
            }

            String event = (String)updateData.get(keys);
            if(event != null && (event.equals("I") || event.equals("U")))
            {
                updatedCounter++;
                pSQL.getPBar().setValue(updatedCounter);
                pSQL.getActionLabel().setText(originalLabel + " (" + totalInfo.getTableName().toLowerCase() + ": " + updatedCounter + "/" + totalRecords + " )");
                updateData.remove(keys);
                for(int i = 0; i < columns.length; i++)
                    dataValues[i] = fileRecord.get(i + 1);

                if(!event.equals("U") || updateStr != null)
                    pSQL.writeUpdatedData(totalInfo.getTableName(), dataValues, keyValues, event);
                continue;
            }
            if(event != null)
            {
                context.setError(true);
                logger.error("Unknown event. [file=" + totalInfo.getFileName() + ", keys=" + keys + ", event= " + event + "]");
            }
        }

        pSQL.destroyPreparedStaments();
    }

    public void loadDataForDelete(Hashtable deleteData, PULoaderSQL pSQL, String originalLabel)
        throws FileNotFoundException, JiBXException, IOException, ColumnNameNotFoundException
    {
        String deleteStr = "DELETE FROM " + totalInfo.getTableName() + " WHERE ";
        for(int i = 0; i < totalInfo.getKey().length; i++)
        {
            if(i > 0)
                deleteStr = deleteStr + " AND ";
            deleteStr = deleteStr + totalInfo.getKey()[i] + " = ?";
        }

        pSQL.createPreparedDeleteStament(deleteStr);
        if(pSQL.getContext().isFatalError())
            return;
        String totalRecords = String.valueOf(deleteData.size());
        pSQL.getPBar().setMaximum(deleteData.size());
        pSQL.getPBar().setValue(0);
        int updatedCounter = 0;
        String key = null;
        String keyValues[];
        for(Iterator loop = deleteData.keySet().iterator(); loop.hasNext(); pSQL.writeUpdatedData(totalInfo.getTableName(), null, keyValues, "D"))
        {
            key = (String)loop.next();
            updatedCounter++;
            pSQL.getPBar().setValue(updatedCounter);
            pSQL.getActionLabel().setText(originalLabel + " (" + totalInfo.getTableName().toLowerCase() + ": " + updatedCounter + "/" + totalRecords + " )");
            StringTokenizer tok = new StringTokenizer(key, "|");
            keyValues = new String[tok.countTokens()];
            for(int count = 0; tok.hasMoreElements(); count++)
                keyValues[count] = (String)tok.nextElement();

        }

        pSQL.destroyPreparedStaments();
    }

    public void loadData(String storagePath, PULoaderSQL pSQL, String originalLabel)
        throws FileNotFoundException, JiBXException, IOException, ColumnNameNotFoundException
    {
        boolean isModeBatch = true;
        int maxBatchElements = 1500;
        Chronometer crono = new Chronometer();
        crono.start();
        //CSVFileReader fileCsvX = CSVUtil.openCSVFile(storagePath + totalInfo.getFileName(), csvDefinition.getDelimiter(), csvDefinition.getTextFile(fileIndex).getColumns(), csvDefinition.getTextFile(fileIndex).getCharsetName());
        CSVFileReader fileCsvX = CSVUtil.openCSVFile(storagePath + totalInfo.getFileName(), csvDefinition.getDelimiter(), csvDefinition.getTextFile(fileIndex).getColumns(), "UTF-8");
        DataRow fileRecord = fileCsvX.getNextRow();
        String pstmt = "INSERT INTO " + totalInfo.getTableName() + " (";
        for(int i = 0; i < columns.length; i++)
        {
            if(i > 0)
                pstmt = pstmt + ", ";
            pstmt = pstmt + columns[i];
        }

        pstmt = pstmt + ") VALUES (";
        for(int i = 0; i < columns.length; i++)
        {
            if(i > 0)
                pstmt = pstmt + ", ";
            pstmt = pstmt + "?";
        }

        pstmt = pstmt + ")";
        pSQL.createPreparedInsertStament(pstmt);
        if(pSQL.getContext().isFatalError())
            return;
        pSQL.getPBar().setIndeterminate(true);
        int counter = 1;
        String dataValues[] = new String[columns.length];
        List valuesList = null;
        InsertBatch insertBatch = null;
        int countInsert = 0;
        while(fileCsvX.hasMoreElements() && pSQL.getContext().isProcessing()) 
        {
            pSQL.getActionLabel().setText(originalLabel + "(" + totalInfo.getTableName().toLowerCase() + "- " + counter + " )");
            if(!isModeBatch)
            {
                for(int i = 0; i < columns.length; i++)
                    dataValues[i] = fileRecord.get(i + 1);

                pSQL.writeTotalData(totalInfo.getTableName(), dataValues);
                if(++countInsert >= maxBatchElements)
                {
                    pSQL.commit();
                    countInsert = 0;
                }
                fileRecord = fileCsvX.getNextRow();
                counter++;
            } else
            {
                valuesList = new ArrayList();
                for(int l = 0; l < maxBatchElements && fileCsvX.hasMoreElements(); l++)
                {
                    dataValues = new String[columns.length];
                    try
                    {
                        for(int i = 0; i < columns.length; i++){
                            dataValues[i] = fileRecord.get(i + 1);}
                        valuesList.add(dataValues);

                    }
                    catch(IndexOutOfBoundsException e)
                    {
                    	String values="";
                    	if (dataValues!=null){
	                    	for (int v=0;v<dataValues.length;v++){
	                    		values+=dataValues[v] + " ";
	                    	}
	                    	values=values.trim();
                    	}
                    	logger.error("Error getting a column from a CSV file. The CSVDefinition has errors.. [table = " + totalInfo.getTableName()+"] for values [" + values + "]" );
                        //context.setError(true);
                        //throw new ColumnNameNotFoundException("Error getting a column from a CSV file. The CSVDefinition has errors.. [table = " + totalInfo.getTableName());
                    }
                    
                    fileRecord = fileCsvX.getNextRow();
                    counter++;
                }

                insertBatch = new InsertBatch(context, logger, valuesList, totalInfo.getTableName(), pSQL);
                insertBatch.executeBatch();
            }
        }
        counter--;
        pSQL.commit();
        pSQL.destroyPreparedStaments();
        pSQL.getPBar().setIndeterminate(false);
        crono.stop();
        logger.info("[crono] load time [table= " + totalInfo.getTableName() + ", time=" + crono.mtime() + " minutes, expected to insert records=" + counter + ", inserted records=" + pSQL.getRecords(totalInfo.getTableName()) + "]");
    }

    public String getFileName()
    {
        return totalInfo.getFileName();
    }

    public String getFileLabel()
    {
        return totalInfo.getLabel();
    }

    public String[] getColumnNames()
    {
        return columns;
    }

    public boolean equals(Object csvFile)
    {
        boolean result = false;
        if(csvFile != null && (csvFile instanceof CSVFile))
        {
            String name = ((CSVFile)csvFile).getFileName();
            if(getFileName().equals(name))
                result = true;
        }
        return result;
    }

    public String getTableName()
    {
        return totalInfo.getTableName();
    }

    public String getUpdateFileName()
    {
        return totalInfo.getUpdateFileName();
    }

    public TotalFile getFileInfo()
    {
        return totalInfo;
    }

    public static String getLabel(String fileName)
    {
        return fileName.substring(0, fileName.indexOf("."));
    }

    private TextFileGroup csvDefinition;
    private int fileIndex;
    private String columns[];
    private TotalFile totalInfo;
    private Context context;
    private Logger logger;
}
