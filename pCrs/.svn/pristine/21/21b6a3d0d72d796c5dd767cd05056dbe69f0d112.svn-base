// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PUCommandMode.java

package com.innova4j.puloader.client;

import com.innova4j.puloader.*;
import com.innova4j.puloader.relationship.Node;
import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import org.apache.log4j.Logger;

// Referenced classes of package com.innova4j.puloader.client:
//            LanguageManager

public class PUCommandMode
{

    public PUCommandMode(String bundle)
    {
        lm = new LanguageManager();
        loader = null;
        context = null;
        selectedFiles = null;
        PUCommandModeConf configuration = null;
        
        try
        {
            configuration = new PUCommandModeConf(bundle);
        }
        catch(Exception e)
        {
            lm.getLogger().error("Loading PUCommandMode configuration data from file " + CONFIG_FILE_NAME + " [" + e.getMessage() + "]", e);
            System.exit(1);
        }
        try
        {
            context = new Context();
        }
        catch(Exception e)
        {
            context.setError(true);
            lm.getLogger().error("Loading configuration data from file parameters.xml [" + e.getMessage() + "]", e);
            System.exit(1);
        }
        try
        {
            lm.setContext(context);
            lm.resetDefaults();
            loader = new PULoader(lm);
        }
        catch(Exception e)
        {
            context.setError(true);
            lm.getLogger().error("Initializing License Frame [" + e.getMessage() + "]", e);
        }
        loader.setActionLabel(new JLabel());
        loader.setPBar(new JProgressBar());
        try
        {
            loader.getContext().setStoragePath(configuration.getStoragePath());
            if(!(new File(configuration.getStoragePath())).exists())
                throw new Exception("Storage path is not valid.");
            loader.getContext().setDbName(configuration.getDbName());
            loader.getContext().setDbPassword(configuration.getDbPassword());
            loader.getContext().setDbServerName(configuration.getDbServerName());
            loader.getContext().setDbTypeIdentifier(Integer.valueOf(configuration.getDbTypeIdentifier()).intValue());
            loader.getContext().setDbUser(configuration.getDbUser());
            loader.getContext().setDoFTPDownload(Boolean.valueOf(configuration.getDoFTPDownload()).booleanValue());
            loader.getContext().setTotalLoad(true);
        }
        catch(Exception e)
        {
            context.setError(true);
            lm.getLogger().error("Error reading CommandMode configuration.", e);
            System.exit(1);
        }
        selectedFiles = new ArrayList();
        Node file = null;
        for(int i = 0; i < loader.getContext().getSortedFilesName().size(); i++)
        {
            file = (Node)loader.getContext().getSortedFilesName().get(i);
            selectedFiles.add(i, file.getName());
        }

        loader.getContext().processing(true);
        loader.importData(selectedFiles);
    }

    public static void main(String args[])
    {
        PUCommandMode command = new PUCommandMode("PUCommandModeConf");
    }

    private LanguageManager lm;
    private PULoader loader;
    private Context context;
    private ArrayList selectedFiles;
    private static String CONFIG_FILE_NAME = "PUCommandModeConf.properties";

}
