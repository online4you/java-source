// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PULoaderFrame.java

package com.innova4j.puloader.client;

import com.innova4j.puloader.CSVFile;
import com.innova4j.puloader.CSVManager;
import com.innova4j.puloader.Context;
import com.innova4j.puloader.PULoader;
import com.innova4j.puloader.PULoaderSQL;
import com.innova4j.puloader.PULoaderUtil;
import com.innova4j.puloader.file.TotalFile;
import com.innova4j.puloader.help.HelpPanel;
import com.innova4j.puloader.relationship.Node;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;

// Referenced classes of package com.innova4j.puloader.client:
//            LanguageManager, SpringUtilities

public class PULoaderFrame extends JFrame
{
    private class SaveOptionsAction extends AbstractAction
    {

        public void actionPerformed(ActionEvent event)
        {
            puloader.saveUserOptions();
        }

        private PULoaderFrame puloader;

        SaveOptionsAction(PULoaderFrame puloader)
        {
            super("Save options");
            this.puloader = puloader;
        }
    }

    private class HelpAction extends AbstractAction
    {

        public void actionPerformed(ActionEvent event)
        {
            Properties sprops = System.getProperties();
            String home = sprops.getProperty("puloader.home.help");
            if(home == null || home.length() == 0)
                home = System.getProperty("user.dir") + "/help/index.html";
            else
                home = home + "/index.html";
            if(helpPanel != null)
            {
                helpPanel.setVisible(false);
                helpPanel.dispose();
            }
            helpPanel = new HelpPanel("file:" + home);
        }

        private PULoaderFrame puloader;

        HelpAction(PULoaderFrame puloader)
        {
            super("Help");
            this.puloader = puloader;
        }
    }

    private class AboutAction extends AbstractAction
    {

        public void actionPerformed(ActionEvent event)
        {
            JOptionPane.showMessageDialog(puloader, loader.getLang().getElementCaption("dialog", 13), "About...", 1);
        }

        private PULoaderFrame puloader;

        AboutAction(PULoaderFrame puloader)
        {
            super("About...");
            this.puloader = puloader;
        }
    }


    public PULoaderFrame(PULoader loader)
    {
        this.loader = null;
        fc = new JFileChooser();
        dbLabel = new JLabel();
        databaseList = new JComboBox(dataBaseStrings);
        serverTextField = new JTextField(10);
        mdbFilePanel = new JPanel();
        dbFileTextField = new JTextField();
        dbFileButton = new JButton();
        dbTextField = new JTextField();
        portTextField = new JTextField(5);
        processAllTablesCheckBox = new JCheckBox();
        processTypeList = new JComboBox();
        tablesLoadPanel = new JPanel();
        downloadFilesCheckBox = new JCheckBox();
        availableTablesPanel = new JPanel();
        storagePanel = new JPanel();
        filePanel = new JPanel();
        filePanel2 = new JPanel();
        filePanel3 = new JPanel();
        storageButton = new JButton();
        storageTextField = new JTextField(25);
        startButton = new JButton();
        cancelButton = new JButton();
        userTextField = new JTextField(10);
        passwordPasswordField = new JPasswordField(10);
        dbConnection = new JPanel();
        dbParamsPanel = new JPanel();
        pBar = new JProgressBar();
        actionLabel = new JLabel();
        dateChooserPanel = new JPanel();
        helpPanel = null;
        try
        {
            this.loader = loader;
            jbInit();
            loadUserOptions();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jbInit()
        throws Exception
    {
        setSize(new Dimension(450, 665));
        setTitle(loader.getContext().getApplicationName());
        setDefaultCloseOperation(3);
        setResizable(false);
        setJMenuBar(createMenuBar());
        JPanel frameDConnection = new JPanel();
        frameDConnection.setLayout(new BoxLayout(frameDConnection, 1));
        dbConnection.setLayout(new BoxLayout(dbConnection, 1));
        dbConnection.setBorder(BorderFactory.createTitledBorder(loader.getLang().getElementCaption("label", 3)));
        frameDConnection.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        frameDConnection.add(dbConnection);
        dbParamsPanel.setLayout(new SpringLayout());
        databaseList.setAlignmentX(0.5F);
        databaseList.setSelectedIndex(0);
        JLabel dbLabel = new JLabel(loader.getLang().getElementCaption("label", 2));
        dbParamsPanel.add(dbLabel);
        dbLabel.setLabelFor(databaseList);
        databaseList.setToolTipText(loader.getLang().getElementCaption("toolTip", 0));
        databaseList.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                databaseListActionPerformed(e);
            }

        });
        dbParamsPanel.add(databaseList);
        dbNameLabel = new JLabel(loader.getLang().getElementCaption("label", 8), 11);
        dbParamsPanel.add(dbNameLabel);
        dbNameLabel.setLabelFor(dbTextField);
        dbTextField.setToolTipText(loader.getLang().getElementCaption("toolTip", 1));
        dbParamsPanel.add(dbTextField);
        userLabel = new JLabel(loader.getLang().getElementCaption("label", 4), 11);
        dbParamsPanel.add(userLabel);
        userLabel.setLabelFor(userTextField);
        userTextField.setToolTipText(loader.getLang().getElementCaption("toolTip", 2));
        dbParamsPanel.add(userTextField);
        passwordLabel = new JLabel(loader.getLang().getElementCaption("label", 5), 11);
        dbParamsPanel.add(passwordLabel);
        passwordLabel.setLabelFor(passwordPasswordField);
        passwordPasswordField.setToolTipText(loader.getLang().getElementCaption("toolTip", 3));
        dbParamsPanel.add(passwordPasswordField);
        serverLabel = new JLabel(loader.getLang().getElementCaption("label", 6), 11);
        dbParamsPanel.add(serverLabel);
        serverLabel.setLabelFor(serverTextField);
        serverTextField.setToolTipText(loader.getLang().getElementCaption("toolTip", 4));
        dbParamsPanel.add(serverTextField);
        portLabel = new JLabel(loader.getLang().getElementCaption("label", 7), 11);
        dbParamsPanel.add(portLabel);
        portLabel.setLabelFor(portTextField);
        portTextField.setText(loader.getContext().getMySqlPort());
        portTextField.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e)
            {
                char c = e.getKeyChar();
                if(!Character.isDigit(c) && c != '\b' && c != '\177')
                {
                    getToolkit().beep();
                    e.consume();
                }
            }

        });
        portTextField.setToolTipText(loader.getLang().getElementCaption("toolTip", 5));
        dbParamsPanel.add(portTextField);
        mdbFilePanel.setLayout(new FlowLayout());
        dbFileLabel = new JLabel(loader.getLang().getElementCaption("label", 9));
        dbFileLabel.setEnabled(false);
        mdbFilePanel.add(dbFileLabel);
        dbFileLabel.setLabelFor(dbFileTextField);
        dbFileTextField.setEnabled(false);
        dbFileTextField.setToolTipText(loader.getLang().getElementCaption("toolTip", 6));
        mdbFilePanel.add(dbFileTextField);
        dbFileButton.setText("...");
        dbFileButton.setEnabled(false);
        dbFileButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                dbFileButtonActionPerformed(e);
            }

        });
        mdbFilePanel.add(dbFileButton);
        dbConnection.add(dbParamsPanel);
        dbConnection.add(mdbFilePanel);
        SpringUtilities.makeCompactGrid(dbParamsPanel, 3, 4, 6, 6, 6, 6);
        JPanel frameStorage = new JPanel();
        frameStorage.setLayout(new BoxLayout(frameStorage, 1));
        storagePanel = new JPanel();
        storagePanel.setLayout(new BoxLayout(storagePanel, 1));
        storagePanel.setBorder(BorderFactory.createTitledBorder(loader.getLang().getElementCaption("label", 10)));
        frameStorage.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        frameStorage.add(storagePanel);
        JPanel _tmp = storagePanel;
        storagePanel.setAlignmentX(0.5F);
        filePanel.setLayout(new FlowLayout());
        filePanel.setAlignmentX(0.0F);
        filePanel2.setLayout(new BoxLayout(filePanel2, 1));
        JPanel _tmp1 = filePanel2;
        filePanel2.setAlignmentX(0.5F);
        filePanel3.setLayout(new FlowLayout());
        JPanel _tmp2 = filePanel3;
        filePanel3.setAlignmentX(0.5F);
        downloadFilesCheckBox.setText(loader.getLang().getElementCaption("button", 2));
        downloadFilesCheckBox.setToolTipText(loader.getLang().getElementCaption("toolTip", 7));
        downloadFilesCheckBox.setSelected(true);
        storagePanel.add(downloadFilesCheckBox);
        pathLabel = new JLabel(loader.getLang().getElementCaption("label", 14));
        filePanel2.add(pathLabel);
        filePanel3.add(storageTextField);
        storageTextField.setToolTipText(loader.getLang().getElementCaption("toolTip", 8));
        storageButton.setText("...");
        storageButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                storageButtonActionPerformed(e);
            }

        });
        filePanel3.add(storageButton);
        filePanel2.add(filePanel3);
        filePanel.add(filePanel2);
        storagePanel.add(filePanel);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, 1));
        northPanel.add(frameDConnection);
        northPanel.add(frameStorage);
        getContentPane().add(northPanel, "First");
        tablesLoadPanel.setLayout(new BorderLayout());
        tablesLoadPanel.setBorder(BorderFactory.createTitledBorder(loader.getLang().getElementCaption("label", 11)));
        JPanel frameTables = new JPanel();
        frameTables.setLayout(new BorderLayout());
        frameTables.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        frameTables.add(tablesLoadPanel, "Center");
        JPanel processTypePanel = new JPanel();
        processTypePanel.setLayout(new BoxLayout(processTypePanel, 0));
        JPanel _tmp3 = processTypePanel;
        processTypePanel.setAlignmentX(0.0F);
        JPanel filesNorthPanel = new JPanel();
        filesNorthPanel.setLayout(new BoxLayout(filesNorthPanel, 1));
        textprocessType = new JLabel(loader.getLang().getElementCaption("label", 12) + " ", 2);
        textprocessType.setLabelFor(processTypeList);
        processTypeList.setAlignmentX(0.5F);
        processTypeList.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                processTypeListActionPerformed(e);
            }

        });
        processTypeList.addItem(loader.getLang().getElementCaption("button", 3));
        processTypeList.addItem(loader.getLang().getElementCaption("button", 4));
        processTypeList.setMaximumSize(new Dimension(200, 100));
        processTypeList.setToolTipText(loader.getLang().getElementCaption("toolTip", 9));
        processTypePanel.add(textprocessType);
        processTypePanel.add(processTypeList);
        filesNorthPanel.add(processTypePanel);
        dateChooserPanel.setLayout(new BoxLayout(dateChooserPanel, 0));
        JPanel _tmp4 = processTypePanel;
        dateChooserPanel.setAlignmentX(0.0F);
        dateChooserPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        dateChooser = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        dateChooser.setToolTipText(loader.getLang().getElementCaption("toolTip", 10));
        dateChooser.setMaximumSize(new Dimension(120, 100));
        dateChooser.setEnabled(false);
        JLabel dateChooserLabel = new JLabel(loader.getLang().getElementCaption("label", 20) + " ", 2);
        dateChooserLabel.setLabelFor(dateChooser);
        dateChooserPanel.add(dateChooserLabel);
        dateChooserPanel.add(dateChooser);
        filesNorthPanel.add(dateChooserPanel);
        availableTablesPanel.setBackground(Color.white);
        availableTablesPanel.setLayout(new BoxLayout(availableTablesPanel, 1));
        availableTablesScrollPane = new JScrollPane(availableTablesPanel);
        JPanel processAllTablesPanel = new JPanel();
        tablesLabel = new JLabel(loader.getLang().getElementCaption("label", 13));
        Font f = tablesLabel.getFont();
        tablesLabel.setFont(f.deriveFont(f.getStyle() ^ 1));
        filesNorthPanel.add(tablesLabel);
        tablesLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        processAllTablesCheckBox.setText(loader.getLang().getElementCaption("button", 5));
        processAllTablesCheckBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                processAllTablesCheckBoxActionPerformed(e);
            }

        });
        processAllTablesCheckBox.setToolTipText(loader.getLang().getElementCaption("toolTip", 11));
        processAllTablesPanel.add(processAllTablesCheckBox);
        JPanel filesCenterPanel = new JPanel();
        filesCenterPanel.setLayout(new BorderLayout());
        filesCenterPanel.add(availableTablesScrollPane, "Center");
        filesCenterPanel.add(processAllTablesPanel, "South");
        filesCenterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        tablesLoadPanel.add(filesNorthPanel, "First");
        tablesLoadPanel.add(filesCenterPanel, "Center");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        startButton.setText(loader.getLang().getElementCaption("button", 0));
        startButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                startButtonActionPerformed(e);
            }

        });
        buttonsPanel.add(startButton);
        cancelButton.setText(loader.getLang().getElementCaption("button", 1));
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                cancelButtonActionPerformed(e);
            }

        });
        buttonsPanel.add(cancelButton);
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, 1));
        southPanel.add(buttonsPanel);
        JPanel barPanel = new JPanel();
        barPanel.setLayout(new BoxLayout(barPanel, 0));
        barPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 7, 5));
        actionLabel.setVisible(false);
        actionLabel.setForeground(new Color(255, 102, 255));
        barPanel.add(actionLabel);
        Font f1 = actionLabel.getFont();
        actionLabel.setFont(f1.deriveFont(f1.getStyle() ^ 1));
        actionLabel.setLabelFor(pBar);
        barPanel.add(pBar);
        pBar.setVisible(false);
        southPanel.add(barPanel);
        getContentPane().add(southPanel, "South");
        getContentPane().add(frameTables, "Center");
        initializeComponents();
    }

    private void storageButtonActionPerformed(ActionEvent e)
    {
        fc.setCurrentDirectory(new File(loader.getContext().getStoragePath()));
        fc.setDialogTitle(loader.getLang().getElementCaption("label", 15));
        fc.setFileSelectionMode(1);
        fc.setAcceptAllFileFilterUsed(false);
        if(fc.showOpenDialog(this) == 0)
            storageTextField.setText(fc.getSelectedFile().toString() + File.separator);
    }

    private void processAllTablesCheckBoxActionPerformed(ActionEvent e)
    {
        if(processAllTablesCheckBox.isSelected())
        {
            availableTablesScrollPane.setEnabled(false);
            for(int i = 0; i < availableTablesPanel.getComponentCount(); i++)
                ((JCheckBox)availableTablesPanel.getComponent(i)).setSelected(true);

        } else
        {
            availableTablesScrollPane.setEnabled(true);
            for(int i = 0; i < availableTablesPanel.getComponentCount(); i++)
                ((JCheckBox)availableTablesPanel.getComponent(i)).setSelected(false);

        }
    }

    private void initializeComponents()
    {
        if(loader.checkWindowsOS())
            databaseList.addItem("Access");
        storageTextField.setText(loader.getContext().getStoragePath());
        dbFileTextField.setText(loader.getContext().getAccessDBFilePath());
        if(loader.getContext().isFatalError())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Error loading the configuration information, please contact your application provider. ");
            System.exit(0);
        }
    }

    private void setFileName(int loadType)
    {
        if(loadType == 0)
        {
            TotalFile totalFiles[] = loader.getFileInfoList();
            availableTablesPanel.removeAll();
            for(int i = 0; i < totalFiles.length; i++)
            {
                JCheckBox temp = new JCheckBox(totalFiles[i].getLabel());
                temp.setName(totalFiles[i].getFileName());
                temp.setBackground(Color.white);
                temp.setActionCommand("total");
                temp.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e)
                    {
                        checkFileActionPerformed(e);
                    }

                });
                availableTablesPanel.add(temp);
            }

        } else
        if(loadType == 1)
        {
            TotalFile totalFiles[] = loader.getFileInfoList();
            availableTablesPanel.removeAll();
            for(int i = 0; i < totalFiles.length; i++)
                if(totalFiles[i].getUpdateFileName() != null)
                {
                    JCheckBox temp = new JCheckBox(totalFiles[i].getLabelUpdateFile());
                    temp.setName(totalFiles[i].getFileName());
                    temp.setBackground(Color.white);
                    temp.setActionCommand("incremental");
                    temp.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e)
                        {
                            checkFileActionPerformed(e);
                        }

                    });
                    availableTablesPanel.add(temp);
                }

        }
    }

    private void dbFileButtonActionPerformed(ActionEvent e)
    {
        fc.setDialogTitle(loader.getLang().getElementCaption("label", 16));
        fc.setFileSelectionMode(2);
        fc.setAcceptAllFileFilterUsed(true);
        if(fc.showOpenDialog(this) == 0)
            dbFileTextField.setText(fc.getSelectedFile().toString());
    }

    private void databaseListActionPerformed(ActionEvent e)
    {
        resetDBFields();
    }

    private void processTypeListActionPerformed(ActionEvent e)
    {
        JComboBox cb = (JComboBox)e.getSource();
        if(cb.getSelectedIndex() == 0)
            dateChooserPanel.setVisible(false);
        else
            dateChooserPanel.setVisible(true);
        setFileName(cb.getSelectedIndex());
        processAllTablesCheckBox.setSelected(false);
    }

    private void resetDBFields()
    {
        if(!databaseList.getSelectedItem().equals("Access"))
        {
            userTextField.setEnabled(true);
            userLabel.setEnabled(true);
            userTextField.setText("");
            passwordPasswordField.setEnabled(true);
            passwordLabel.setEnabled(true);
            passwordPasswordField.setText("");
            serverTextField.setEnabled(true);
            serverLabel.setEnabled(true);
            serverTextField.setText("");
            portTextField.setEnabled(true);
            portLabel.setEnabled(true);
            portTextField.setText("");
            dbTextField.setEnabled(true);
            dbLabel.setEnabled(true);
            dbTextField.setText("");
            dbFileTextField.setEnabled(false);
            dbFileLabel.setEnabled(false);
            dbFileButton.setEnabled(false);
        } else
        {
            userTextField.setEnabled(false);
            userLabel.setEnabled(false);
            userTextField.setText("");
            passwordPasswordField.setEnabled(false);
            passwordLabel.setEnabled(false);
            passwordPasswordField.setText("");
            serverTextField.setEnabled(false);
            serverLabel.setEnabled(false);
            serverTextField.setText("");
            portTextField.setEnabled(false);
            portLabel.setEnabled(false);
            portTextField.setText("");
            dbTextField.setEnabled(false);
            dbLabel.setEnabled(false);
            dbTextField.setText("");
            dbFileTextField.setEnabled(true);
            dbFileLabel.setEnabled(true);
            dbFileButton.setEnabled(true);
        }
        if(databaseList.getSelectedItem().equals("Oracle"))
            portTextField.setText(loader.getContext().getOraclePort());
        if(databaseList.getSelectedItem().equals("SQL Server"))
            portTextField.setText(loader.getContext().getSqlServerPort());
        if(databaseList.getSelectedItem().equals("MySQL"))
            portTextField.setText(loader.getContext().getMySqlPort());
    }

    private void disableControls()
    {
        databaseList.setEnabled(false);
        userTextField.setEnabled(false);
        passwordPasswordField.setEnabled(false);
        serverTextField.setEnabled(false);
        portTextField.setEnabled(false);
        dbTextField.setEnabled(false);
        dbFileTextField.setEnabled(false);
        dbFileButton.setEnabled(false);
        downloadFilesCheckBox.setEnabled(false);
        storageTextField.setEnabled(false);
        storageButton.setEnabled(false);
        processTypeList.setEnabled(false);
        availableTablesScrollPane.setEnabled(false);
        processAllTablesCheckBox.setEnabled(false);
    }

    private void enableControls()
    {
        if(!databaseList.getSelectedItem().equals("Access"))
        {
            userTextField.setEnabled(true);
            passwordPasswordField.setEnabled(true);
            serverTextField.setEnabled(true);
            dbTextField.setEnabled(true);
            portTextField.setEnabled(true);
        } else
        {
            dbFileTextField.setEnabled(true);
            dbFileButton.setEnabled(true);
        }
        databaseList.setEnabled(true);
        downloadFilesCheckBox.setEnabled(true);
        storageTextField.setEnabled(true);
        storageButton.setEnabled(true);
        processTypeList.setEnabled(true);
        availableTablesScrollPane.setEnabled(true);
        processAllTablesCheckBox.setEnabled(true);
    }

    private void startButtonActionPerformed(ActionEvent e)
    {
        Runnable myRunnable = new Runnable() {

            public void run()
            {
                disableControls();
                startButton.setEnabled(false);
                actionLabel.setVisible(true);
                pBar.setVisible(true);
                loader.getContext().processing(true);
                try
                {
                    loader.importData(getSelectedFiles());
                    if(!loader.getContext().isProcessing())
                        JOptionPane.showMessageDialog(new JFrame(), loader.getLang().getElementCaption("dialog", 12));
                    else
                    if(loader.getContext().isFatalError())
                        JOptionPane.showMessageDialog(new JFrame(), loader.getLang().getElementCaption("dialog", 7));
                    else
                    if(loader.getContext().isError())
                        JOptionPane.showMessageDialog(new JFrame(), loader.getLang().getElementCaption("dialog", 10));
                    else
                        JOptionPane.showMessageDialog(new JFrame(), loader.getLang().getElementCaption("dialog", 9));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                loader.getContext().processing(false);
                enableControls();
                actionLabel.setVisible(false);
                pBar.setVisible(false);
                startButton.setEnabled(true);
            }

        };
        boolean isTotalLoad = true;
        if(processTypeList.getSelectedIndex() != 0)
            isTotalLoad = false;
        if(validateFields() && setDBValues() && (!isTotalLoad || isTotalLoad && checkRelationships()))
        {
            loader.getContext().setFatalError(false);
            loader.getContext().setError(false);
            loader.getContext().setStoragePath(storageTextField.getText());
            if(!isTotalLoad)
                loader.getContext().setDateIncrementalProcess(dateChooser.getDate());
            loader.getContext().setTotalLoad(isTotalLoad);
            loader.setPBar(pBar);
            loader.setActionLabel(actionLabel);
            loader.getContext().setStoragePath(storageTextField.getText());
            loader.getContext().setDoFTPDownload(downloadFilesCheckBox.isSelected());
            Thread t = new Thread(myRunnable);
            t.start();
        }
    }

    private boolean validateFields()
    {
        File f;
        if(!databaseList.getSelectedItem().equals("Access"))
        {
            if(userTextField.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 0));
                return false;
            }
            if(String.valueOf(passwordPasswordField.getPassword()).trim().equals("") && !databaseList.getSelectedItem().equals("MySQL"))
            {
                JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 1));
                return false;
            }
            if(serverTextField.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 2));
                return false;
            }
            if(dbTextField.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 3));
                return false;
            }
        } else
        {
            f = new File(dbFileTextField.getText().trim());
            if(!f.exists())
            {
                JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 4));
                return false;
            }
        }
        if(databaseList.getSelectedItem().equals("Oracle") && portTextField.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 5));
            return false;
        }
        if(databaseList.getSelectedItem().equals("SQL Server") && portTextField.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 5));
            return false;
        }
        if(databaseList.getSelectedItem().equals("MySQL") && portTextField.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 5));
            return false;
        }
        f = new File(storageTextField.getText().trim());
        if(!f.exists())
        {
            JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 8));
            return false;
        }
        if(!processAllTablesCheckBox.isSelected())
        {
            boolean none = true;
            int i = 0;
            do
            {
                if(i >= availableTablesPanel.getComponentCount())
                    break;
                JCheckBox thisCheck = (JCheckBox)availableTablesPanel.getComponent(i);
                if(thisCheck.isSelected())
                {
                    none = false;
                    break;
                }
                i++;
            } while(true);
            if(none)
            {
                JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 6));
                return false;
            }
        }
        return true;
    }

    private boolean setDBValues()
    {
        if(!databaseList.getSelectedItem().equals("Access"))
        {
            loader.getContext().setDbServerName(serverTextField.getText().trim());
            loader.getContext().setDbName(dbTextField.getText().trim());
            loader.getContext().setDbUser(userTextField.getText().trim());
            loader.getContext().setDbPassword(String.valueOf(passwordPasswordField.getPassword()).trim());
        }
        if(databaseList.getSelectedItem().equals("MySQL"))
        {
            loader.getContext().setDbTypeIdentifier(0);
            loader.getContext().setMySqlPort(portTextField.getText().trim());
        }
        if(databaseList.getSelectedItem().equals("Oracle"))
        {
            loader.getContext().setDbTypeIdentifier(1);
            loader.getContext().setOraclePort(portTextField.getText().trim());
        } else
        if(databaseList.getSelectedItem().equals("SQL Server"))
        {
            loader.getContext().setDbTypeIdentifier(2);
            loader.getContext().setSqlServerPort(portTextField.getText().trim());
        }
        if(databaseList.getSelectedItem().equals("Access"))
        {
            loader.getContext().setDbTypeIdentifier(3);
            loader.getContext().setAccessDBFilePath(dbFileTextField.getText());
        }
        PULoaderSQL pul = new PULoaderSQL(loader.getContext(), null);
        if(!pul.testConnection())
        {
            JOptionPane.showMessageDialog(this, loader.getLang().getElementCaption("dialog", 11));
            pul = null;
            return false;
        } else
        {
            pul = null;
            return true;
        }
    }

    private void cancelButtonActionPerformed(ActionEvent e)
    {
        if(loader.getContext().isProcessing())
        {
            loader.getContext().processing(false);
        } else
        {
            int option = JOptionPane.showConfirmDialog(this, loader.getLang().getElementCaption("dialog", 16), loader.getLang().getElementCaption("dialog", 15), 0);
            if(option == 0)
                System.exit(0);
        }
    }

    private ArrayList getSelectedFiles()
    {
        ArrayList selectedFiles = new ArrayList();
        for(int i = 0; i < availableTablesPanel.getComponentCount(); i++)
        {
            JCheckBox thisCheck = (JCheckBox)availableTablesPanel.getComponent(i);
            if(thisCheck.isSelected())
                selectedFiles.add(thisCheck.getName());
        }

        return selectedFiles;
    }

    private JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        JMenuItem saveOptions = fileMenu.add(new SaveOptionsAction(this));
        saveOptions.setMnemonic('O');
        saveOptions.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        menuBar.add(fileMenu);
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        JMenuItem helpItem = helpMenu.add(new HelpAction(this));
        helpItem.setMnemonic('H');
        helpItem.setAccelerator(KeyStroke.getKeyStroke(72, 2));
        JMenuItem aboutItem = helpMenu.add(new AboutAction(this));
        aboutItem.setMnemonic('A');
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(65, 2));
        menuBar.add(helpMenu);
        return menuBar;
    }

    private void saveUserOptions()
    {
        String fileName = "userOptions";
        Properties userOptions = new Properties();
        userOptions.setProperty("db.type", String.valueOf(databaseList.getSelectedIndex()));
        userOptions.setProperty("db.name", dbTextField.getText());
        userOptions.setProperty("db.user", userTextField.getText());
        userOptions.setProperty("db.server", serverTextField.getText());
        userOptions.setProperty("db.port", portTextField.getText());
        userOptions.setProperty("db.access.path", dbFileTextField.getText());
        if(downloadFilesCheckBox.isSelected())
            userOptions.setProperty("file.download", "1");
        else
            userOptions.setProperty("file.download", "0");
        userOptions.setProperty("file.path", storageTextField.getText());
        SimpleDateFormat sdf = new SimpleDateFormat(dateChooser.getDateFormatString());
        String modifyDate = null;
        if(dateChooser.getDate() != null)
        {
            modifyDate = sdf.format(dateChooser.getDate());
            userOptions.setProperty("load.modify", modifyDate);
        }
        try
        {
            OutputStream propsFile = new FileOutputStream(fileName);
            userOptions.store(propsFile, "Properties File to the PULoader Application");
            propsFile.close();
        }
        catch(IOException ioe)
        {
            System.out.println("I/O Exception.");
            ioe.printStackTrace();
        }
    }

    private void loadUserOptions()
    {
        Properties userOptions = new Properties();
        if((new File("userOptions")).exists())
        {
            try
            {
                FileInputStream in = new FileInputStream("userOptions");
                userOptions.load(in);
                in.close();
            }
            catch(FileNotFoundException e) { }
            catch(IOException e) { }
            databaseList.setSelectedIndex(Integer.parseInt(userOptions.getProperty("db.type")));
            serverTextField.setText(userOptions.getProperty("db.server"));
            dbTextField.setText(userOptions.getProperty("db.name"));
            portTextField.setText(userOptions.getProperty("db.port"));
            userTextField.setText(userOptions.getProperty("db.user"));
            dbFileTextField.setText(userOptions.getProperty("db.access.path"));
            if("1".equals(userOptions.getProperty("file.download")))
                downloadFilesCheckBox.setSelected(true);
            else
                downloadFilesCheckBox.setSelected(false);
            storageTextField.setText(userOptions.getProperty("file.path"));
            String modifyDate = userOptions.getProperty("load.modify");
            if(modifyDate != null)
                try
                {
                    dateChooser.setDate(PULoaderUtil.parseDate(dateChooser.getDateFormatString(), modifyDate));
                }
                catch(ParseException e) { }
        }
    }

    private void checkFileActionPerformed(ActionEvent e)
    {
        JCheckBox temp = (JCheckBox)e.getSource();
        if(temp.isSelected())
        {
            ArrayList dependences = loader.getContext().getFileDependences(temp.getName());
            for(int i = 0; i < dependences.size(); i++)
                setSelectFile(((Node)dependences.get(i)).getName(), true);

        } else
        {
            ArrayList relationships = loader.getContext().getFileRelationships(temp.getName());
            for(int i = 0; i < relationships.size(); i++)
                setSelectFile(((Node)relationships.get(i)).getName(), false);

        }
    }

    private void setSelectFile(String fileName, boolean select)
    {
        Component fileList[] = availableTablesPanel.getComponents();
        boolean loop = true;
        for(int j = 0; j < fileList.length && loop; j++)
            if(fileName.equalsIgnoreCase(fileList[j].getName()))
            {
                ((JCheckBox)fileList[j]).setSelected(select);
                loop = false;
            }

    }

    private boolean checkRelationships()
    {
        boolean result = true;
        ArrayList seletedFiles = getSelectedFiles();
        String fileName = null;
        String relFile = null;
        java.util.List relationships = null;
        ArrayList tables = new ArrayList();
        LinkedHashMap totalRelations = new LinkedHashMap();
        for(int j = 0; j < seletedFiles.size(); j++)
        {
            fileName = (String)seletedFiles.get(j);
            relationships = loader.getContext().getFileRelationships(fileName);
            for(int k = 0; k < relationships.size(); k++)
            {
                relFile = ((Node)relationships.get(k)).getName();
                totalRelations.put(loader.getCsvM().getTotalFile(relFile).getFileName(), loader.getCsvM().getTotalFile(relFile).getTableName());
            }

        }

        for(int p = 0; p < seletedFiles.size(); p++)
        {
            fileName = (String)seletedFiles.get(p);
            totalRelations.remove(fileName);
        }

        for(Iterator loop = totalRelations.values().iterator(); loop.hasNext(); tables.add(loop.next()));
        if(tables.size() != 0)
        {
            PULoaderSQL pul = new PULoaderSQL(loader.getContext(), null);
            result = !pul.checkTableCount(tables, 0);
        }
        if(!result)
        {
            String msg = loader.getLang().getElementCaption("dialog", 17);
            for(Iterator loop = totalRelations.keySet().iterator(); loop.hasNext();)
                msg = msg + (String)loop.next() + "\n";

            msg = msg + loader.getLang().getElementCaption("dialog", 18);
            JOptionPane.showMessageDialog(new JFrame(), msg);
        }
        return result;
    }

    private PULoader loader;
    private JFileChooser fc;
    private final String MYSQL = "MySQL";
    private final String ORACLE = "Oracle";
    private final String SQLSERVER = "SQL Server";
    private final String ACCESS = "Access";
    private String dataBaseStrings[] = {
        "MySQL", "Oracle", "SQL Server"
    };
    private JLabel dbLabel;
    private JComboBox databaseList;
    private JLabel serverLabel;
    private JTextField serverTextField;
    private JPanel mdbFilePanel;
    private JLabel dbFileLabel;
    private JTextField dbFileTextField;
    private JButton dbFileButton;
    private JLabel dbNameLabel;
    private JTextField dbTextField;
    private JLabel portLabel;
    private JTextField portTextField;
    private JCheckBox processAllTablesCheckBox;
    private JComboBox processTypeList;
    private JLabel textprocessType;
    private JPanel tablesLoadPanel;
    private JCheckBox downloadFilesCheckBox;
    private JLabel tablesLabel;
    private JScrollPane availableTablesScrollPane;
    private JPanel availableTablesPanel;
    private JPanel storagePanel;
    private JPanel filePanel;
    private JPanel filePanel2;
    private JPanel filePanel3;
    private JButton storageButton;
    private JLabel pathLabel;
    private JTextField storageTextField;
    private JButton startButton;
    private JButton cancelButton;
    private JTextField userTextField;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordPasswordField;
    private JPanel dbConnection;
    private JPanel dbParamsPanel;
    private JProgressBar pBar;
    private JLabel actionLabel;
    private JDateChooser dateChooser;
    private JPanel dateChooserPanel;
    private final String DB_TYPE = "db.type";
    private final String DB_NAME = "db.name";
    private final String DB_USER = "db.user";
    private final String DB_SERVER = "db.server";
    private final String DB_PORT = "db.port";
    private final String DB_ACCESS_PATH = "db.access.path";
    private final String FILE_DOWNLOAD = "file.download";
    private final String FILE_PATH = "file.path";
    private final String LOAD_MODIFY = "load.modify";
    private HelpPanel helpPanel;


















}
