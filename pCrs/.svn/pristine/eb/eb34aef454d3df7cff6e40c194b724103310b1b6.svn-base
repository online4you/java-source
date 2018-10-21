// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileInfo.java

package com.innova4j.puloader.file;

import java.util.ArrayList;

// Referenced classes of package com.innova4j.puloader.file:
//            File

public class FileInfo extends File
{

    public FileInfo(String tableName, String fileName)
    {
        super(fileName);
        key = new ArrayList();
        this.tableName = tableName;
    }

    public void addKeyElement(String column)
    {
        key.add(column);
    }

    public String[] getKey()
    {
        Object columns[] = key.toArray();
        String result[] = new String[columns.length];
        for(int i = 0; i < columns.length; i++)
            result[i] = (String)columns[i];

        return result;
    }

    public String getTableName()
    {
        return tableName;
    }

    private String tableName;
    private ArrayList key;
}
