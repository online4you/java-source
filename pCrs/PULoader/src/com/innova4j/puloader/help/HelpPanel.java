// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HelpPanel.java

package com.innova4j.puloader.help;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class HelpPanel extends JFrame
    implements HyperlinkListener, ActionListener
{
    private class ExitListener extends WindowAdapter
    {

        public void windowClosing(WindowEvent event)
        {
            helpPanel.setVisible(false);
            helpPanel.dispose();
        }

        HelpPanel helpPanel;

        ExitListener(HelpPanel helpPanel)
        {
            this.helpPanel = null;
            this.helpPanel = helpPanel;
        }
    }


    public HelpPanel(String initialURL)
    {
        super("HelpPanel");
        this.initialURL = initialURL;
        addWindowListener(new ExitListener(this));
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.lightGray);
        urlField = new JTextField();
        urlField.setText(initialURL);
        urlField.addActionListener(this);
        getContentPane().add(topPanel, "North");
        try
        {
            htmlPane = new JEditorPane(initialURL);
            htmlPane.setEditable(false);
            htmlPane.addHyperlinkListener(this);
            JScrollPane scrollPane = new JScrollPane(htmlPane);
            getContentPane().add(scrollPane, "Center");
        }
        catch(IOException ioe)
        {
            warnUser("Can't build HTML pane for " + initialURL + ": " + ioe);
        }
        int width = 522;
        int height = 365;
        setSize(new Dimension(width, height));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if(frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        if(frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        String url;
        if(event.getSource() == urlField)
            url = urlField.getText();
        else
            url = initialURL;
        try
        {
            htmlPane.setPage(new URL(url));
            urlField.setText(url);
        }
        catch(IOException ioe)
        {
            warnUser("Can't follow link to " + url + ": " + ioe);
        }
    }

    public void hyperlinkUpdate(HyperlinkEvent event)
    {
        if(event.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED)
            try
            {
                htmlPane.setPage(event.getURL());
                urlField.setText(event.getURL().toExternalForm());
            }
            catch(IOException ioe)
            {
                warnUser("Can't follow link to " + event.getURL().toExternalForm() + ": " + ioe);
            }
    }

    private void warnUser(String message)
    {
        JOptionPane.showMessageDialog(this, message, "Error", 0);
    }

    private JTextField urlField;
    private JEditorPane htmlPane;
    private String initialURL;
}
