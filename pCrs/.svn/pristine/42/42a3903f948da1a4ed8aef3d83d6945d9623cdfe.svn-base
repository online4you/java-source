// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PUCommandModeConf.java

package com.innova4j.puloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PUCommandModeConf
{

    public PUCommandModeConf(String bundle)
        throws Exception
    {
        ResourceBundle rb = ResourceBundle.getBundle(bundle);
        
        storagePath = rb.getString("storagePath");
        if(storagePath == null)
            throw new Exception("Error getting storagePath from properties file");
        dbName = rb.getString("dbName");
        if(dbName == null)
            throw new Exception("Error getting dbName from properties file");
        dbPassword = rb.getString("dbPassword");
        if(dbPassword == null)
            throw new Exception("Error getting dbPassword from properties file");
        dbServerName = rb.getString("dbServerName");
        if(dbServerName == null)
            throw new Exception("Error getting dbServerName from properties file");
        dbTypeIdentifier = rb.getString("dbTypeIdentifier");
        if(dbTypeIdentifier == null)
            throw new Exception("Error getting dbTypeIdentifier from properties file");
        dbUser = rb.getString("dbUser");
        if(dbUser == null)
            throw new Exception("Error getting dbUser from properties file");
        doFTPDownload = rb.getString("doFTPDownload");
        if(doFTPDownload == null)
            throw new Exception("Error getting doFTPDownload from properties file");
        else
            return;
    }

    public void setStoragePath(String storagePath)
    {
        this.storagePath = storagePath;
    }

    public String getStoragePath()
    {
        return storagePath;
    }

    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    public String getDbName()
    {
        return dbName;
    }

    public void setDbPassword(String dbPassword)
    {
        this.dbPassword = dbPassword;
    }

    public String getDbPassword()
    {
        return dbPassword;
    }

    public void setDbServerName(String dbServerName)
    {
        this.dbServerName = dbServerName;
    }

    public String getDbServerName()
    {
        return dbServerName;
    }

    public void setDbTypeIdentifier(String dbTypeIdentifier)
    {
        this.dbTypeIdentifier = dbTypeIdentifier;
    }

    public String getDbTypeIdentifier()
    {
        return dbTypeIdentifier;
    }

    public void setDbUser(String dbUser)
    {
        this.dbUser = dbUser;
    }

    public String getDbUser()
    {
        return dbUser;
    }

    public void setDoFTPDownload(String doFTPDownload)
    {
        this.doFTPDownload = doFTPDownload;
    }

    public String getDoFTPDownload()
    {
        return doFTPDownload;
    }

    private String storagePath;
    private String dbName;
    private String dbPassword;
    private String dbServerName;
    private String dbTypeIdentifier;
    private String dbUser;
    private String doFTPDownload;
}
