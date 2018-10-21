// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Context.java

package com.innova4j.puloader;

import com.innova4j.puloader.file.TotalFile;
import com.innova4j.puloader.relationship.Relationships;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

// Referenced classes of package com.innova4j.puloader:
//            PULoaderUtil

public class Context
{

    public URL getCsvTotalFileDefinition()
    {
        return csvTotalFileDefinition;
    }

    public void setCsvTotalFileDefinition(URL csvTotalFileDefinition)
    {
        this.csvTotalFileDefinition = csvTotalFileDefinition;
    }

    public URL getCsvUpdateFileDefinition()
    {
        return csvUpdateFileDefinition;
    }

    public void setCsvUpdateFileDefinition(URL csvUpdateFileDefinition)
    {
        this.csvUpdateFileDefinition = csvUpdateFileDefinition;
    }

    public String getStoragePath()
    {
        return storagePath;
    }

    public void setStoragePath(String storagePath)
    {
        this.storagePath = storagePath;
    }

    public boolean getDoFTPDownload()
    {
        return doFTPDownload;
    }

    public void setDoFTPDownload(boolean doFTPDownload)
    {
        this.doFTPDownload = doFTPDownload;
    }

    public boolean getTotalLoad()
    {
        return totalLoad;
    }

    public void setTotalLoad(boolean totalLoad)
    {
        this.totalLoad = totalLoad;
    }

    public boolean getRecreateTables()
    {
        return recreateTables;
    }

    public String getFtpLogin()
    {
        return ftpLogin;
    }

    public void setFtpLogin(String ftpLogin)
    {
        this.ftpLogin = ftpLogin;
    }

    public String getFtpPassword()
    {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword)
    {
        this.ftpPassword = ftpPassword;
    }

    public String getFtpUrl()
    {
        return ftpUrl;
    }

    public void setFtpUrl(String ftpUrl)
    {
        this.ftpUrl = ftpUrl;
    }

    public String getWorkingDirectory()
    {
        return workingDirectory;
    }

    public String getFtpFileName()
    {
        return ftpFileName;
    }

    public void setFtpFileName(String ftpFileName)
    {
        this.ftpFileName = ftpFileName;
    }

    public int getDbTypeIdentifier()
    {
        return dbTypeIdentifier;
    }

    public void setDbTypeIdentifier(int dbTypeIdentifier)
    {
        this.dbTypeIdentifier = dbTypeIdentifier;
    }

    public String getDbServerName()
    {
        return dbServerName;
    }

    public void setDbServerName(String dbServerName)
    {
        this.dbServerName = dbServerName;
    }

    public String getDbName()
    {
        return dbName;
    }

    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    public String getDbUser()
    {
        return dbUser;
    }

    public void setDbUser(String dbUser)
    {
        this.dbUser = dbUser;
    }

    public String getDbPassword()
    {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword)
    {
        this.dbPassword = dbPassword;
    }

    public String getAccessDBFilePath()
    {
        return accessDBFilePath;
    }

    public void setAccessDBFilePath(String accessDBFilePath)
    {
        this.accessDBFilePath = accessDBFilePath;
    }

    public String getSqlServerPort()
    {
        return sqlServerPort;
    }

    public void setSqlServerPort(String sqlServerPort)
    {
        this.sqlServerPort = sqlServerPort;
    }

    public String getOraclePort()
    {
        return oraclePort;
    }

    public void setOraclePort(String oraclePort)
    {
        this.oraclePort = oraclePort;
    }

    public String getMySqlPort()
    {
        return mysqlPort;
    }

    public void setMySqlPort(String mysqlPort)
    {
        this.mysqlPort = mysqlPort;
    }

    public boolean isFatalError()
    {
        return fatalError;
    }

    public void setFatalError(boolean fatalError)
    {
        this.fatalError = fatalError;
    }

    public boolean isError()
    {
        return error;
    }

    public void setError(boolean error)
    {
        this.error = error;
    }

    public boolean isProcessing()
    {
        return processing;
    }

    public void processing(boolean processing)
    {
        this.processing = processing;
    }

    public Context()
        throws Exception
    {
        csvTotalFileDefinition = PULoaderUtil.getFileUrl("com/innova4j/puloader/config/CSVDefinition.xml");
        csvUpdateFileDefinition = PULoaderUtil.getFileUrl("com/innova4j/puloader/config/CSVUpdateDefinition.xml");
        filesInfo = null;
        updateLink = null;
        fileRelationships = null;
        storagePath = "";
        doFTPDownload = true;
        totalLoad = true;
        recreateTables = true;
        ftpLogin = "";
        ftpPassword = "";
        ftpUrl = "";
        workingDirectory = null;
        ftpFileName = "";
        dbTypeIdentifier = 0;
        dbServerName = "";
        dbName = "";
        dbUser = "";
        dbPassword = "";
        accessDBFilePath = "";
        sqlServerPort = "1433";
        oraclePort = "1521";
        mysqlPort = "3306";
        applicationName = "PULoader";
        fatalError = false;
        error = false;
        processing = false;
        loadConfiguration();
        filesInfo = loadKeyDefinition();
        updateLink = loadupdateLink();
        fileRelationships = loadRelationships();
    }

    private void loadConfiguration()
        throws Exception
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setCoalescing(true);
        dbf.setNamespaceAware(false);
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        java.io.InputStream fis = PULoaderUtil.getFileUrl("com/innova4j/puloader/config/Parameters.xml").openStream();
        Document doc = db.parse(fis);
        doc.getDocumentElement().normalize();
        NodeList nodeLst = doc.getElementsByTagName("FTP");
        Node fstNode = nodeLst.item(0);
        Element fstElmnt;
        NodeList fstNmElmntLst;
        Element fstNmElmnt;
        NodeList fstNm;
        if(fstNode.getNodeType() == 1)
        {
            fstElmnt = (Element)fstNode;
            fstNmElmntLst = fstElmnt.getElementsByTagName("SERVERURL");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                ftpUrl = fstNm.item(0).getNodeValue();
            fstNmElmntLst = fstElmnt.getElementsByTagName("LOGIN");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                ftpLogin = fstNm.item(0).getNodeValue();
            fstNmElmntLst = fstElmnt.getElementsByTagName("PASSWORD");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                ftpPassword = fstNm.item(0).getNodeValue();
            fstNmElmntLst = fstElmnt.getElementsByTagName("WORKINGDIRECTORY");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                workingDirectory = fstNm.item(0).getNodeValue();
            fstNmElmntLst = fstElmnt.getElementsByTagName("FILENAME");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                ftpFileName = fstNm.item(0).getNodeValue();
        }
        nodeLst = doc.getElementsByTagName("DATABASE");
        fstNode = nodeLst.item(0);
        if(fstNode.getNodeType() == 1)
        {
            fstElmnt = (Element)fstNode;
            fstNmElmntLst = fstElmnt.getElementsByTagName("RECREATETABLES");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                recreateTables = Boolean.valueOf(fstNm.item(0).getNodeValue()).booleanValue();
            fstNmElmntLst = fstElmnt.getElementsByTagName("MYSQLPORT");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                mysqlPort = fstNm.item(0).getNodeValue();
            fstNmElmntLst = fstElmnt.getElementsByTagName("ORACLEPORT");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                oraclePort = fstNm.item(0).getNodeValue();
            fstNmElmntLst = fstElmnt.getElementsByTagName("MSSQLPORT");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                sqlServerPort = fstNm.item(0).getNodeValue();
            fstNmElmntLst = fstElmnt.getElementsByTagName("MSACCESSFILE");
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null)
                accessDBFilePath = fstNm.item(0).getNodeValue();
        }
        nodeLst = doc.getElementsByTagName("PARAMS");
        fstNode = nodeLst.item(0);
        fstElmnt = (Element)fstNode;
        fstNmElmntLst = fstElmnt.getElementsByTagName("dateFormat");
        fstNmElmnt = (Element)fstNmElmntLst.item(0);
        fstNm = fstNmElmnt.getChildNodes();
        dateFormat = fstNm.item(0).getNodeValue();
        fstNmElmntLst = fstElmnt.getElementsByTagName("applicationName");
        fstNmElmnt = (Element)fstNmElmntLst.item(0);
        fstNm = fstNmElmnt.getChildNodes();
        if(fstNm.item(0) != null)
            applicationName = fstNm.item(0).getNodeValue();
        fstNmElmntLst = fstElmnt.getElementsByTagName("changeLog");
        if(fstNmElmntLst != null && fstNmElmntLst.getLength() != 0)
        {
            fstNmElmnt = (Element)fstNmElmntLst.item(0);
            fstNm = fstNmElmnt.getChildNodes();
            if(fstNm.item(0) != null && fstNm.item(0).getNodeValue().length() != 0)
                changeLog = fstNm.item(0).getNodeValue();
        }
    }

    private HashMap loadKeyDefinition()
        throws ParserConfigurationException, IOException, SAXException
    {
        HashMap result = new HashMap();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setCoalescing(true);
        dbf.setNamespaceAware(false);
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        java.io.InputStream fis = PULoaderUtil.getFileUrl("com/innova4j/puloader/config/KeyDefinition.xml").openStream();
        Document doc = db.parse(fis);
        doc.getDocumentElement().normalize();
        NodeList fileList = doc.getElementsByTagName("file");
        Element fstNode = null;
        NamedNodeMap att = null;
        NodeList columnList = null;
        Element column = null;
        String name = null;
        String updateFileName = null;
        String tableName = null;
        TotalFile fileInfo = null;
        for(int j = 0; j < fileList.getLength(); j++)
        {
            fstNode = (Element)fileList.item(j);
            att = fstNode.getAttributes();
            name = att.getNamedItem("name").getNodeValue();
            tableName = att.getNamedItem("tableName").getNodeValue();
            if(att.getNamedItem("updateFileName") != null)
                updateFileName = att.getNamedItem("updateFileName").getNodeValue();
            else
                updateFileName = null;
            fileInfo = new TotalFile(tableName, name, updateFileName);
            columnList = fstNode.getElementsByTagName("column");
            for(int k = 0; k < columnList.getLength(); k++)
            {
                column = (Element)columnList.item(k);
                fileInfo.addKeyElement(column.getFirstChild().getNodeValue());
            }

            result.put(fileInfo.getFileName(), fileInfo);
        }

        return result;
    }

    private HashMap loadupdateLink()
        throws ParserConfigurationException, IOException, SAXException
    {
        HashMap result = new HashMap();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setCoalescing(true);
        dbf.setNamespaceAware(false);
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        java.io.InputStream fis = PULoaderUtil.getFileUrl("com/innova4j/puloader/config/KeyDefinition.xml").openStream();
        Document doc = db.parse(fis);
        doc.getDocumentElement().normalize();
        NodeList fileList = doc.getElementsByTagName("file");
        Element fstNode = null;
        NamedNodeMap att = null;
        String name = null;
        String updateFileName = null;
        for(int j = 0; j < fileList.getLength(); j++)
        {
            fstNode = (Element)fileList.item(j);
            att = fstNode.getAttributes();
            name = att.getNamedItem("name").getNodeValue();
            if(att.getNamedItem("updateFileName") != null)
            {
                updateFileName = att.getNamedItem("updateFileName").getNodeValue();
                result.put(updateFileName, name);
            }
        }

        return result;
    }

    private Relationships loadRelationships()
        throws ParserConfigurationException, IOException, SAXException
    {
        Relationships relationships = new Relationships();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setCoalescing(true);
        dbf.setNamespaceAware(false);
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        java.io.InputStream fis = PULoaderUtil.getFileUrl("com/innova4j/puloader/config/KeyDefinition.xml").openStream();
        Document doc = db.parse(fis);
        doc.getDocumentElement().normalize();
        NodeList fileList = doc.getElementsByTagName("file");
        NodeList relationList = null;
        Element fstNode = null;
        NamedNodeMap att = null;
        Element relation = null;
        String name = null;
        for(int j = 0; j < fileList.getLength(); j++)
        {
            fstNode = (Element)fileList.item(j);
            att = fstNode.getAttributes();
            name = att.getNamedItem("name").getNodeValue();
            relationships.addNode(name);
            relationList = fstNode.getElementsByTagName("detail-relation");
            for(int k = 0; relationList != null && k < relationList.getLength(); k++)
            {
                relation = (Element)relationList.item(k);
                if(relation != null && relation.getFirstChild() != null && relation.getFirstChild().getNodeValue() != null)
                    relationships.addRelationship(name, relation.getFirstChild().getNodeValue());
            }

        }

        return relationships;
    }

    public void setDateIncrementalProcess(Date dateIncrementalProcess)
    {
        this.dateIncrementalProcess = dateIncrementalProcess;
    }

    public Date getDateIncrementalProcess()
    {
        return dateIncrementalProcess;
    }

    public String getDateFomat()
    {
        return dateFormat;
    }

    public String getChangeLog()
    {
        return changeLog;
    }

    public String getApplicationName()
    {
        return applicationName;
    }

    public String getUpdateLink(String name)
    {
        Object temp = updateLink.get(name);
        if(temp != null)
            return (String)temp;
        else
            return null;
    }

    public TotalFile getTotalFileInfo(String fileName)
    {
        Object temp = filesInfo.get(fileName);
        if(temp != null)
            return (TotalFile)temp;
        else
            return null;
    }

    public ArrayList getSortedFilesName()
    {
        return fileRelationships.sortNodes();
    }

    public ArrayList getFileDependences(String fileName)
    {
        return fileRelationships.getDependences(fileName);
    }

    public ArrayList getFileRelationships(String fileName)
    {
        return fileRelationships.getRelationships(fileName);
    }

    private URL csvTotalFileDefinition;
    private URL csvUpdateFileDefinition;
    HashMap filesInfo;
    HashMap updateLink;
    Relationships fileRelationships;
    private String storagePath;
    private boolean doFTPDownload;
    private boolean totalLoad;
    private boolean recreateTables;
    private String ftpLogin;
    private String ftpPassword;
    private String ftpUrl;
    private String workingDirectory;
    private String ftpFileName;
    private int dbTypeIdentifier;
    private String dbServerName;
    private String dbName;
    private String dbUser;
    private String dbPassword;
    private String accessDBFilePath;
    private String sqlServerPort;
    private String oraclePort;
    private String mysqlPort;
    private String applicationName;
    private String dateFormat;
    private String changeLog;
    private boolean fatalError;
    private boolean error;
    private boolean processing;
    private Date dateIncrementalProcess;
}
