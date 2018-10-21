// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PULoader.java

package com.innova4j.puloader;

import com.innova4j.puloader.client.LanguageManager;
import com.innova4j.puloader.file.FileInfo;
import com.innova4j.puloader.file.TotalFile;
import com.innova4j.util.compress.UnZip;
import java.io.File;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import org.apache.log4j.Logger;

// Referenced classes of package com.innova4j.puloader:
//            CSVManager, Context

public class PULoader
{

    public Context getContext()
    {
        return context;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public LanguageManager getLang()
    {
        return lang;
    }

    public void setLang(LanguageManager lang)
    {
        this.lang = lang;
    }

    public CSVManager getCsvM()
    {
        return csvM;
    }

    public void setCsvM(CSVManager csvM)
    {
        this.csvM = csvM;
    }

    public JProgressBar getPBar()
    {
        return pBar;
    }

    public void setPBar(JProgressBar pBar)
    {
        this.pBar = pBar;
    }

    public JLabel getActionLabel()
    {
        return actionLabel;
    }

    public void setActionLabel(JLabel actionLabel)
    {
        this.actionLabel = actionLabel;
    }

    public PULoader(LanguageManager lang)
    {
        context = null;
        this.lang = null;
        this.lang = lang;
        context = lang.getContext();
        logger = lang.getLogger();
        csvM = new CSVManager(context, logger);
        try
        {
            csvM.loadStructures();
        }
        catch(Exception e)
        {
            context.setFatalError(true);
            logger.fatal("Could not load CSV structures [" + e.getMessage() + "]", e);
        }
    }

    public void setCurrentLanguage(int langId)
    {
        lang.setCurrentLanguage(langId);
    }

    public boolean checkWindowsOS()
    {
        return System.getProperty("os.name").toLowerCase().indexOf("windows") > -1;
    }

    public void importData(List selectedFiles)
    {
        context.setStoragePath(correctPathName(context.getStoragePath()));
        if(context.getDoFTPDownload())
        {
           
            if(context.isFatalError() || !context.isProcessing())
                return;
            logger.debug("Ftp download successfully done.");
            uncompressZipFile();
            if(context.isFatalError())
                return;
            logger.debug("Uncompressing successfully done.");
        } else
        {
            File zipFile = new File(context.getStoragePath() + context.getFtpFileName());
            if(zipFile.exists())
            {
                zipFile = null;
                uncompressZipFile();
                if(context.isFatalError())
                    return;
                logger.debug("Uncompressing successfully done.");
            }
        }
        csvM.setPBar(pBar);
        csvM.setActionLabel(actionLabel);
        if(context.getTotalLoad())
            actionLabel.setText(lang.getElementCaption("label", 17));
        else
            actionLabel.setText(lang.getElementCaption("label", 18));
        csvM.setContext(context);
        csvM.processFiles(selectedFiles);
    }

    private String correctPathName(String oldName)
    {
        if(oldName == null)
            return null;
        if(!oldName.endsWith("/") && !oldName.endsWith("\\"))
            oldName = oldName + "/";
        return oldName;
    }

    private void uncompressZipFile()
    {
        File zipDir = new File(context.getStoragePath() + context.getFtpFileName().substring(0, context.getFtpFileName().toLowerCase().indexOf(".zip")));
        zipDir.delete();
        zipDir = null;
        UnZip uz = new UnZip(null, context.getStoragePath());
        try
        {
            uz.setMode(1);
            uz.unZip(context.getStoragePath() + context.getFtpFileName());
        }
        catch(Exception e)
        {
            context.setFatalError(true);
            logger.fatal("Uncompressing zipped File [" + e.getMessage() + "]", e);
        }
    }

    

    public TotalFile[] getFileInfoList()
    {
        return csvM.getInfoTotalFiles();
    }

    public FileInfo[] getUpdateFileInfoList()
    {
        return csvM.getInfoUpdateFiles();
    }

    private Context context;
    private LanguageManager lang;
    private CSVManager csvM;
    private Logger logger;
    private JProgressBar pBar;
    private JLabel actionLabel;
}
