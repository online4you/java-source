// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LicenseFrame.java

package com.innova4j.puloader.client;

import com.innova4j.puloader.Context;
import com.innova4j.puloader.PULoader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import org.apache.log4j.Logger;

// Referenced classes of package com.innova4j.puloader.client:
//            LanguageManager, PULoaderFrame, ChangeLogFrame

public class LicenseFrame extends JFrame
{

    public LicenseFrame()
    {
        lm = new LanguageManager();
        loader = null;
        languageLabel = new JLabel();
        languagesComboBox = new JComboBox();
        termsLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        licenseTextArea = new JTextPane();
        acceptButton = new JButton();
        cancelButton = new JButton();
        context = null;
        try
        {
            context = new Context();
        }
        catch(Exception e)
        {
            context.setError(true);
            lm.getLogger().error("Loading configuration data from file parameters.xml [" + e.getMessage() + "]", e);
        }
        try
        {
            lm.setContext(context);
            lm.resetDefaults();
            loader = new PULoader(lm);
            jbInit();
        }
        catch(Exception e)
        {
            context.setError(true);
            lm.getLogger().error("Initializing License Frame [" + e.getMessage() + "]", e);
        }
    }

    private void jbInit()
        throws Exception
    {
        getContentPane().setLayout(new BorderLayout());
        setSize(new Dimension(522, 365));
        setTitle(context.getApplicationName());
        setResizable(false);
        licenseTextArea.setEditable(false);
        licenseTextArea.setContentType("text/html");
        languagesComboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                languagesComboBoxActionPerformed(e);
            }

        });
        Font f = termsLabel.getFont();
        termsLabel.setFont(f.deriveFont(f.getStyle() ^ 1));
        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                aceptarActionPerformed(e);
            }

        });
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                cancelButton_actionPerformed(e);
            }

        });
        jScrollPane1.getViewport().add(licenseTextArea, null);
        licenseTextArea.setCaretPosition(0);
        Vector languages = lm.getAvailableLanguages();
        if(context.isFatalError())
            System.exit(0);
        for(int i = 0; i < languages.size(); i++)
        {
            String lang = ((String[])(String[])languages.get(i))[0];
            languagesComboBox.addItem(lang);
        }

        JPanel langueagePanel = new JPanel();
        langueagePanel.setLayout(new FlowLayout());
        JPanel _tmp = langueagePanel;
        langueagePanel.setAlignmentX(0.0F);
        langueagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        langueagePanel.add(languageLabel);
        langueagePanel.add(languagesComboBox);
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, 0));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        titlePanel.add(termsLabel);
        JPanel _tmp1 = titlePanel;
        titlePanel.setAlignmentX(0.0F);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, 1));
        JPanel _tmp2 = northPanel;
        northPanel.setAlignmentX(0.0F);
        northPanel.add(langueagePanel);
        northPanel.add(titlePanel);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, 1));
        JPanel _tmp3 = centerPanel;
        centerPanel.setAlignmentX(0.0F);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        centerPanel.add(jScrollPane1);
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        southPanel.add(acceptButton);
        southPanel.add(cancelButton);
        getContentPane().add(northPanel, "North");
        getContentPane().add(centerPanel, "Center");
        getContentPane().add(southPanel, "South");
    }

    private void aceptarActionPerformed(ActionEvent e)
    {
        lm.setCurrentLanguage(languagesComboBox.getSelectedIndex());
        licenseTextArea.setText(lm.getLicense());
        lm.loadLanguageData();
        if(context.getChangeLog() == null || context.getChangeLog().length() == 0)
        {
            frame = new PULoaderFrame(loader);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = frame.getSize();
            if(frameSize.height > screenSize.height)
                frameSize.height = screenSize.height;
            if(frameSize.width > screenSize.width)
                frameSize.width = screenSize.width;
            frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
            frame.setDefaultCloseOperation(3);
            setVisible(false);
            frame.setVisible(true);
        } else
        {
            JFrame changeLogFrame = new ChangeLogFrame(loader);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = changeLogFrame.getSize();
            if(frameSize.height > screenSize.height)
                frameSize.height = screenSize.height;
            if(frameSize.width > screenSize.width)
                frameSize.width = screenSize.width;
            changeLogFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
            changeLogFrame.setDefaultCloseOperation(3);
            setVisible(false);
            changeLogFrame.setVisible(true);
        }
    }

    private void languagesComboBoxActionPerformed(ActionEvent e)
    {
        lm.setCurrentLanguage(languagesComboBox.getSelectedIndex());
        licenseTextArea.setText(lm.getLicense());
        lm.loadLanguageData();
        languageLabel.setText(lm.getElementCaption("label", 0));
        termsLabel.setText(lm.getElementCaption("label", 1));
        acceptButton.setText(lm.getElementCaption("button", 0));
        cancelButton.setText(lm.getElementCaption("button", 1));
        if(context.isFatalError())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Error cargando datos de idiomas. Para mas informaci\324\370\u03A9n consulte el fichero Logs.txt");
            frame.dispose();
            dispose();
            System.exit(0);
        }
    }

    private void cancelButton_actionPerformed(ActionEvent e)
    {
        dispose();
        System.exit(0);
    }

    private LanguageManager lm;
    private PULoader loader;
    private JLabel languageLabel;
    private JComboBox languagesComboBox;
    private JLabel termsLabel;
    private JScrollPane jScrollPane1;
    private JTextPane licenseTextArea;
    private JButton acceptButton;
    private JButton cancelButton;
    private Context context;
    JFrame frame;



}
