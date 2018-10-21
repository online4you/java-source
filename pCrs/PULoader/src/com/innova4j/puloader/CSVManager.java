// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CSVManager.java

package com.innova4j.puloader;

import com.innova4j.puloader.file.FileInfo;
import com.innova4j.puloader.file.TotalFile;
import com.innova4j.puloader.relationship.Node;
import com.innova4j.util.CSVUtil;
import com.innova4j.util.filereaders.exception.ColumnNameNotFoundException;
import com.innova4j.util.filereaders.jibx.TextFile;
import com.innova4j.util.filereaders.jibx.TextFileGroup;
import com.innova4j.util.time.Chronometer;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import org.apache.log4j.Logger;
import org.jibx.runtime.JiBXException;

// Referenced classes of package com.innova4j.puloader:
//            PULoaderSQL, CSVFile, CSVFileUpdate, Context

public class CSVManager
{

    public Context getcontext()
    {
        return context;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public PULoaderSQL getPSQL()
    {
        return pSQL;
    }

    public void setPSQL(PULoaderSQL pSQL)
    {
        this.pSQL = pSQL;
    }

    public Logger getLogger()
    {
        return logger;
    }

    public void setLogger(Logger logger)
    {
        this.logger = logger;
    }

    public JProgressBar getPBar()
    {
        return pBar;
    }

    public void setPBar(JProgressBar pBar)
    {
        this.pBar = pBar;
    }

    public void setActionLabel(JLabel actionLabel)
    {
        this.actionLabel = actionLabel;
    }

    public CSVManager(Context context, Logger logger)
    {
        totalFiles = new LinkedList();
        updateFiles = new LinkedList();
        this.logger = null;
        this.context = context;
        this.logger = logger;
        pSQL = new PULoaderSQL(context, logger);
    }

    public void loadStructures()
        throws FileNotFoundException, JiBXException, IOException, ColumnNameNotFoundException
    {
        java.io.InputStream tFis = context.getCsvTotalFileDefinition().openStream();
        java.io.InputStream uFis = context.getCsvUpdateFileDefinition().openStream();
        TextFileGroup totalCsvDefinition = CSVUtil.readStructureFile(tFis);
        int totalFilesCount = totalCsvDefinition.sizeTextFileList();
        TextFileGroup updateCsvDefinition = CSVUtil.readStructureFile(uFis);
        int updateFilesCount = updateCsvDefinition.sizeTextFileList();
        TotalFile totalFileInfo = null;
        String keyColumns[] = null;
        for(int i = 0; i < totalFilesCount; i++)
        {
            String fileName = totalCsvDefinition.getTextFile(i).getName();
            totalFileInfo = context.getTotalFileInfo(fileName);
            if(totalFileInfo == null)
                throw new FileNotFoundException("File definition not found, please check the KeyDefinition.xml file.");
            CSVFile tFile = new CSVFile(context, logger, totalCsvDefinition, i, totalFileInfo);
            keyColumns = totalFileInfo.getKey();
            if(keyColumns == null)
                throw new ColumnNameNotFoundException("Key definition not found, please check the KeyDefinition.xml file.");
            totalFiles.add(tFile);
        }

        for(int i = 0; i < updateFilesCount; i++)
        {
            String fileName = updateCsvDefinition.getTextFile(i).getName();
            String totalFileName = context.getUpdateLink(fileName);
            if(totalFileName == null)
                throw new FileNotFoundException("File definition not found, please check the KeyDefinition.xml file.");
            totalFileInfo = context.getTotalFileInfo(totalFileName);
            FileInfo fileInfo = new FileInfo(totalFileInfo.getTableName(), fileName);
            for(int k = 0; k < totalFileInfo.getKey().length; k++)
                fileInfo.addKeyElement(totalFileInfo.getKey()[k]);

            CSVFileUpdate uFile = new CSVFileUpdate(updateCsvDefinition, i, context, fileInfo);
            updateFiles.add(uFile);
        }

    }

    public TotalFile[] getInfoTotalFiles()
    {
        TotalFile fileInfo[] = new TotalFile[totalFiles.size()];
        for(int i = 0; i < totalFiles.size(); i++)
            fileInfo[i] = ((CSVFile)totalFiles.get(i)).getFileInfo();

        return fileInfo;
    }

    public FileInfo[] getInfoUpdateFiles()
    {
        FileInfo fileInfo[] = new FileInfo[updateFiles.size()];
        for(int i = 0; i < updateFiles.size(); i++)
            fileInfo[i] = ((CSVFileUpdate)updateFiles.get(i)).getFileInfo();

        return fileInfo;
    }

    public CSVFile getTotalFile(String fileName)
    {
        boolean loop = true;
        CSVFile totalFile = null;
        for(int index = 0; index < totalFiles.size() && loop; index++)
            if(totalFiles.get(index).equals(new CSVFile(fileName)))
            {
                totalFile = (CSVFile)totalFiles.get(index);
                loop = false;
            }

        return totalFile;
    }

    private CSVFileUpdate getUpdateFile(String fileName)
    {
        boolean loop = true;
        CSVFileUpdate csvVFileUpdate = null;
        for(int index = 0; index < updateFiles.size() && loop; index++)
            if(updateFiles.get(index).equals(new CSVFileUpdate(fileName)))
            {
                csvVFileUpdate = (CSVFileUpdate)updateFiles.get(index);
                loop = false;
            }

        return csvVFileUpdate;
    }

    public void processFiles(List selectedFiles)
    {
        pSQL.setContext(context);
        pSQL.setPBar(pBar);
        pSQL.setActionLabel(actionLabel);
        pSQL.connect();
        if(context.isFatalError())
            return;
        ArrayList sortedFiles = sortSelectedFiles(selectedFiles);
        String progreeBarlLabel = actionLabel.getText();
        actionLabel.setText(progreeBarlLabel);
        pBar.setIndeterminate(true);
        Chronometer crono = new Chronometer();
        crono.start();
        if(!context.isError() && context.getTotalLoad())
        {
            for(int j = 0; j < sortedFiles.size(); j++)
            {
                String fileName = (String)sortedFiles.get(j);
                CSVFile fileToprocess = getTotalFile(fileName);
                pSQL.dropTable(fileToprocess.getTableName());
            }

            sortedFiles = sortFilesForModify(sortedFiles);
            for(int j = 0; j < sortedFiles.size(); j++)
            {
                String fileName = (String)sortedFiles.get(j);
                CSVFile fileToprocess = getTotalFile(fileName);
                pSQL.createTable(fileToprocess.getTableName());
            }

            for(int j = 0; j < sortedFiles.size() && context.isProcessing(); j++)
            {
                String fileName = (String)sortedFiles.get(j);
                CSVFile fileToprocess = getTotalFile(fileName);
                try
                {
                    fileToprocess.loadData(getRealPath(fileToprocess.getFileName()), pSQL, progreeBarlLabel);
                }
                catch(FileNotFoundException fnfe)
                {
                    context.setError(true);
                    logger.error("CSV File " + fileToprocess.getFileName() + " not found [" + fnfe.getMessage() + "]", fnfe);
                }
                catch(Exception e)
                {
                    context.setError(true);
                    logger.error("Error Processing files [" + e.getMessage() + "]", e);
                }
            }

        } else
        if(!context.isError())
        {
            sortedFiles = sortFilesForModify(sortedFiles);
            for(int j = 0; j < sortedFiles.size() && context.isProcessing(); j++)
            {
                String fileName = (String)sortedFiles.get(j);
                CSVFile fileToprocess = getTotalFile(fileName);
                CSVFileUpdate fileUpadate = getUpdateFile(fileToprocess.getUpdateFileName());
                loadForUpdate(fileToprocess, fileUpadate, false, progreeBarlLabel);
            }

            sortedFiles = sortSelectedFiles(selectedFiles);
            for(int j = 0; j < sortedFiles.size(); j++)
            {
                String fileName = (String)sortedFiles.get(j);
                CSVFile fileToprocess = getTotalFile(fileName);
                CSVFileUpdate fileUpadate = getUpdateFile(fileToprocess.getUpdateFileName());
                loadForUpdate(fileToprocess, fileUpadate, true, progreeBarlLabel);
            }

        }
        pSQL.disconnect();
        crono.stop();
        logger.info("[crono] total process time " + crono.mtime() + "minutes");
    }

    private void loadForUpdate(CSVFile fileToprocess, CSVFileUpdate fileUpadate, boolean isDelete, String progreeBarlLabel)
    {
        try
        {
            if(!isDelete)
                fileToprocess.loadDataForUpdate(getRealPath(fileToprocess.getFileName()), fileUpadate.loadUpdateData(getRealPath(fileUpadate.getFileName()), context.getDateIncrementalProcess(), context.getDateFomat(), isDelete), pSQL, progreeBarlLabel);
            else
                fileToprocess.loadDataForDelete(fileUpadate.loadUpdateData(getRealPath(fileUpadate.getFileName()), context.getDateIncrementalProcess(), context.getDateFomat(), true), pSQL, progreeBarlLabel);
        }
        catch(FileNotFoundException fnfe)
        {
            context.setError(true);
            logger.error("CSV File " + fileToprocess.getFileName() + " not found [" + fnfe.getMessage() + "]", fnfe);
        }
        catch(Exception e)
        {
            context.setError(true);
            logger.error("Error Processing the files " + fileToprocess.getUpdateFileName() + "[" + e.getMessage() + "]", e);
        }
    }

    private ArrayList sortFilesForModify(ArrayList sortedFiles)
    {
        ArrayList result = new ArrayList();
        for(int i = sortedFiles.size() - 1; i >= 0; i--)
            result.add(sortedFiles.get(i));

        return result;
    }

    private ArrayList sortSelectedFiles(List selectedFiles)
    {
        ArrayList result = new ArrayList();
        LinkedHashSet tempList = new LinkedHashSet();
        String fileName = null;
        for(int j = 0; j < selectedFiles.size(); j++)
        {
            fileName = (String)selectedFiles.get(j);
            CSVFile fileToprocess = getTotalFile(fileName);
            if(fileToprocess != null)
            {
                tempList.add(fileToprocess.getFileName());
            } else
            {
                context.setError(true);
                logger.error("File definition not found. [fileName= " + fileName + "], please check the CSVDefinitionFile.");
            }
        }

        ArrayList files = context.getSortedFilesName();
        Node tmpNode = null;
        for(int i = 0; i < files.size(); i++)
        {
            tmpNode = (Node)files.get(i);
            if(tempList.contains(tmpNode.getName()))
                result.add(tmpNode.getName());
        }

        return result;
    }

    private String getRealPath(String fileName)
    {
        String path = context.getStoragePath();
        File f = new File(path + fileName);
        if(!f.exists())
        {
            path = context.getStoragePath() + context.getFtpFileName().substring(0, context.getFtpFileName().indexOf(".zip")) + File.separator;
            File f1 = new File(path + fileName);
            if(!f1.exists())
                return "";
        }
        return path;
    }

    private Context context;
    private List totalFiles;
    private List updateFiles;
    private PULoaderSQL pSQL;
    private Logger logger;
    private JProgressBar pBar;
    private JLabel actionLabel;
}
