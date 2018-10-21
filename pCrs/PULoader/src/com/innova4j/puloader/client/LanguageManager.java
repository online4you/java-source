// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LanguageManager.java

package com.innova4j.puloader.client;

import com.innova4j.puloader.Context;
import com.innova4j.puloader.PULoaderUtil;
import java.io.File;
import java.net.URL;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.*;

public class LanguageManager
{

    public LanguageManager()
    {
        languageData = new Vector();
        logger = Logger.getLogger(com.innova4j.puloader.PULoader.class);
        
        context = null;
        File f = new File("Logs");
        if(!f.exists())
            f.mkdir();
        //DOMConfigurator.configure(PULoaderUtil.getFileUrl("com/innova4j/puloader/config/xmllog4jconfig.xml"));
    }

    public Logger getLogger()
    {
        return logger;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public Context getContext()
    {
        return context;
    }

    public Vector getAvailableLanguages()
    {
        return languageData;
    }

    public void readAvailableLanguages()
    {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);
            dbf.setCoalescing(true);
            dbf.setNamespaceAware(false);
            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();
            java.io.InputStream fis = PULoaderUtil.getFileUrl("com/innova4j/puloader/license/languages.xml").openStream();
            Document doc = db.parse(fis);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("LANGUAGE");
            languageData = new Vector();
            for(int s = 0; s < nodeLst.getLength(); s++)
            {
                String thisLang[] = new String[4];
                Node fstNode = nodeLst.item(s);
                if(fstNode.getNodeType() == 1)
                {
                    thisLang[0] = fstNode.getAttributes().getNamedItem("NAME").getNodeValue();
                    thisLang[1] = fstNode.getAttributes().getNamedItem("DEFAULT").getNodeValue();
                    Element fstElmnt = (Element)fstNode;
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("FILE");
                    Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    thisLang[2] = fstNm.item(0).getNodeValue();
                    NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("LICENSE");
                    Element lstNmElmnt = (Element)lstNmElmntLst.item(0);
                    NodeList lstNm = lstNmElmnt.getChildNodes();
                    thisLang[3] = lstNm.item(0).getNodeValue();
                    languageData.add(thisLang);
                    if(thisLang[1].equals("TRUE"))
                        setCurrentLanguage(s);
                }
            }

        }
        catch(Exception e)
        {
            logger.fatal("Could not load language data from file languages.xml [" + e.getMessage() + "]", e);
            context.setFatalError(true);
        }
    }

    public void loadLanguageData()
    {
        String cLangData[] = (String[])(String[])languageData.get(currentLang);
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);
            dbf.setCoalescing(true);
            dbf.setNamespaceAware(false);
            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();
            java.io.InputStream fis = PULoaderUtil.getFileUrl("com/innova4j/puloader/license/" + cLangData[2]).openStream();
            Document doc = db.parse(fis);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("LABEL");
            labels = new String[nodeLst.getLength()];
            for(int s = 0; s < nodeLst.getLength(); s++)
            {
                Node fstNode = nodeLst.item(s);
                if(fstNode.getNodeType() == 1)
                {
                    Element fstNmElmnt = (Element)fstNode;
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    labels[s] = fstNm.item(0).getNodeValue();
                }
            }

            nodeLst = doc.getElementsByTagName("BUTTON");
            buttons = new String[nodeLst.getLength()];
            for(int s = 0; s < nodeLst.getLength(); s++)
            {
                Node fstNode = nodeLst.item(s);
                if(fstNode.getNodeType() == 1)
                {
                    Element fstNmElmnt = (Element)fstNode;
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    buttons[s] = fstNm.item(0).getNodeValue();
                }
            }

            nodeLst = doc.getElementsByTagName("DIALOG");
            dialogs = new String[nodeLst.getLength()];
            for(int s = 0; s < nodeLst.getLength(); s++)
            {
                Node fstNode = nodeLst.item(s);
                if(fstNode.getNodeType() == 1)
                {
                    Element fstNmElmnt = (Element)fstNode;
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    dialogs[s] = fstNm.item(0).getNodeValue();
                }
            }

            nodeLst = doc.getElementsByTagName("TOOLTIP");
            toolTips = new String[nodeLst.getLength()];
            for(int s = 0; s < nodeLst.getLength(); s++)
            {
                Node fstNode = nodeLst.item(s);
                if(fstNode.getNodeType() == 1)
                {
                    Element fstNmElmnt = (Element)fstNode;
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    toolTips[s] = fstNm.item(0).getNodeValue();
                }
            }

        }
        catch(Exception e)
        {
            logger.fatal("Could not load language data from file " + cLangData[2] + " [" + e.getMessage() + "]", e);
            context.setFatalError(true);
        }
    }

    public String getElementCaption(String eType, int eId)
    {
        if(eType.equals("label"))
            return labels[eId];
        if(eType.equals("button"))
            return buttons[eId];
        if(eType.equals("dialog"))
            return dialogs[eId];
        if(eType.equals("toolTip"))
            return toolTips[eId];
        
        
        String cLangData[] = (String[])(String[])languageData.get(currentLang);
        //logger.fatal("Could not load language data from file " + cLangData[2] + " [" + e.getMessage() + "]", e);
        logger.fatal("Could not load language data from file " + cLangData[2] + " []");
        context.setFatalError(true);
        return "";
    }

    public void resetDefaults()
    {
        readAvailableLanguages();
        if(!context.isFatalError())
            loadLanguageData();
    }

    public Vector getLanguageData()
    {
        return languageData;
    }

    public void setCurrentLanguage(int langId)
    {
        currentLang = langId;
    }

    public String getLicense()
    {
        String cLangData[] = (String[])(String[])languageData.get(currentLang);
        String licenseText = "";
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);
            dbf.setCoalescing(true);
            dbf.setNamespaceAware(false);
            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();
            java.io.InputStream fis = PULoaderUtil.getFileUrl("com/innova4j/puloader/license/licenses.xml").openStream();
            Document doc = db.parse(fis);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName(cLangData[3]);
            for(int s = 0; s < nodeLst.getLength(); s++)
            {
                Node fstNode = nodeLst.item(s);
                if(fstNode.getNodeType() == 1)
                {
                    Element fstElmnt = (Element)fstNode;
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("TEXT");
                    Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    licenseText = fstNm.item(0).getNodeValue();
                }
            }

        }
        catch(Exception e)
        {
            logger.fatal("Could not load license text for language " + cLangData[3] + " [" + e.getMessage() + "]", e);
            context.setFatalError(true);
        }
        return licenseText;
    }

    private Vector languageData;
    private int currentLang;
    private String labels[];
    private String buttons[];
    private String dialogs[];
    private String toolTips[];
    private Logger logger;
    private Context context;
}
