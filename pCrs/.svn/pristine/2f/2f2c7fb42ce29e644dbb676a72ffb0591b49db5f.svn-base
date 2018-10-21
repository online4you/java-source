// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TotalFile.java

package com.innova4j.puloader.file;


// Referenced classes of package com.innova4j.puloader.file:
//            FileInfo

public class TotalFile extends FileInfo
{

    public TotalFile(String tableName, String fileName, String updateFileName)
    {
        super(tableName, fileName);
        this.updateFileName = updateFileName;
    }

    public String getUpdateFileName()
    {
        return updateFileName;
    }

    public boolean hasUpdate()
    {
        boolean result = true;
        if(updateFileName == null)
            result = false;
        return result;
    }

    public void setLabelUpdateFile(String labelUpdateFile)
    {
        this.labelUpdateFile = labelUpdateFile;
    }

    public String getLabelUpdateFile()
    {
        return labelUpdateFile;
    }

    private String updateFileName;
    private String labelUpdateFile;
}
