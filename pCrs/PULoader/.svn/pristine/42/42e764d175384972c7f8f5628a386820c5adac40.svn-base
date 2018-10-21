// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CSVFileUpdate.java

package com.innova4j.puloader;

import com.innova4j.puloader.file.FileInfo;
import com.innova4j.util.CSVUtil;
import com.innova4j.util.filereaders.*;
import com.innova4j.util.filereaders.exception.ColumnNameNotFoundException;
import com.innova4j.util.filereaders.jibx.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Hashtable;
import org.jibx.runtime.JiBXException;

// Referenced classes of package com.innova4j.puloader:
//            PULoaderUtil, Context

public class CSVFileUpdate
{

    public CSVFileUpdate(String fileName)
    {
        fileInfo = new FileInfo(null, fileName);
    }

    public CSVFileUpdate(TextFileGroup csvDefinition, int fileIndex, Context context, FileInfo fileInfo)
    {
        this.csvDefinition = csvDefinition;
        this.fileIndex = fileIndex;
        this.context = context;
        this.fileInfo = fileInfo;
        if(fileInfo.getLabel() == null)
            this.fileInfo.setLabel(getLabel(this.fileInfo.getFileName()));
        Columns cols = csvDefinition.getTextFile(fileIndex).getColumns();
        columns = new String[cols.sizeColumnList()];
        int i;
        for(i = 0; i <= cols.sizeColumnList() - 3; i++)
            columns[i] = cols.getColumn(i).getName();

        modifyColumn = cols.getColumn(i).getName();
    }

    public Hashtable loadUpdateData(String storagePath, Date modifyDate, String dateFormat, boolean isDelete)
        throws FileNotFoundException, JiBXException, IOException, ColumnNameNotFoundException, ParseException
    {
        Hashtable data = new Hashtable();
        CSVFileReader fileCsvX = CSVUtil.openCSVFile(storagePath + fileInfo.getFileName(), csvDefinition.getDelimiter(), csvDefinition.getTextFile(fileIndex).getColumns(), csvDefinition.getTextFile(fileIndex).getCharsetName());
        String keyColumns[] = fileInfo.getKey();
        if(keyColumns == null)
            throw new ColumnNameNotFoundException("Key definition not found, please check the KeyDefinition.xml file.");
        String modify = null;
        String keyValues = null;
        String event = null;
        for(DataRow fileRecord = fileCsvX.getNextRow(); fileCsvX.hasMoreElements(); fileRecord = fileCsvX.getNextRow())
        {
            keyValues = "";
            event = fileRecord.get(columns.length);
            modify = fileRecord.get(fileCsvX.getHeaders().getPosition(modifyColumn));
            if((!isDelete || !"D".equals(event)) && (isDelete || "D".equals(event)) || modify == null)
                continue;
            modify = modify.substring(0, modify.indexOf(" "));
            Date modifyDate_ = PULoaderUtil.parseDate(dateFormat, modify);
            if(modifyDate != null && !modifyDate_.equals(modifyDate) && !modifyDate_.after(modifyDate))
                continue;
            for(int i = 0; i < keyColumns.length; i++)
            {
                if(!keyValues.equals(""))
                    keyValues = keyValues + "|";
                keyValues = keyValues + fileRecord.get(fileCsvX.getHeaders().getPosition(keyColumns[i]));
            }

            if(data.get(keyValues) != null)
            {
                String oldEvent = (String)data.get(keyValues);
                if(!"I".equals(oldEvent))
                    data.put(keyValues, event);
            } else
            {
                data.put(keyValues, event);
            }
        }

        return data;
    }

    public String getFileName()
    {
        return fileInfo.getFileName();
    }

    public String getFileLabel()
    {
        return fileInfo.getLabel();
    }

    public String getModifyColumn()
    {
        return modifyColumn;
    }

    public boolean equals(Object csvFileUpdate)
    {
        boolean result = false;
        if(csvFileUpdate != null && (csvFileUpdate instanceof CSVFileUpdate))
        {
            String name = ((CSVFileUpdate)csvFileUpdate).getFileName();
            if(getFileLabel().equals(name))
                result = true;
            else
            if(getFileName().equals(name))
                result = true;
        }
        return result;
    }

    public String getTotalFileName()
    {
        return fileInfo.getFileName();
    }

    public FileInfo getFileInfo()
    {
        return fileInfo;
    }

    public static String getLabel(String fileName)
    {
        return fileName.substring(0, fileName.indexOf("."));
    }

    private Context context;
    private TextFileGroup csvDefinition;
    private int fileIndex;
    private String columns[];
    private FileInfo fileInfo;
    private String modifyColumn;
}
