// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ChangeLogFrame.java

package com.innova4j.puloader.client;

import com.innova4j.puloader.Context;
import com.innova4j.puloader.PULoader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.apache.log4j.Logger;

// Referenced classes of package com.innova4j.puloader.client:
//            PULoaderFrame, LanguageManager

public class ChangeLogFrame extends JFrame
{

    public ChangeLogFrame(PULoader loader)
    {
        logger = Logger.getLogger(com.innova4j.puloader.PULoader.class);
        this.loader = null;
        title = new JLabel();
        jScrollPane1 = new JScrollPane();
        changeLogtArea = new JTextPane();
        acceptButton = new JButton();
        cancelButton = new JButton();
        context = null;
        this.loader = loader;
        context = loader.getContext();
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            context.setError(true);
            logger.error("Initializing ChangeLogFrame Frame [" + e.getMessage() + "]", e);
        }
    }

    private void jbInit()
        throws Exception
    {
        getContentPane().setLayout(new BorderLayout());
        setSize(new Dimension(522, 365));
        setTitle(context.getApplicationName());
        setResizable(false);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, 0));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        Font f = title.getFont();
        title.setFont(f.deriveFont(f.getStyle() ^ 1));
        title.setText(loader.getLang().getElementCaption("label", 21));
        northPanel.add(title);
        changeLogtArea.setEditable(false);
        changeLogtArea.setContentType("text/html");
        changeLogtArea.setText(loader.getLang().getElementCaption("label", 22));
        acceptButton.setText(loader.getLang().getElementCaption("button", 0));
        acceptButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                aceptarActionPerformed(e);
            }

        });
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        centerPanel.add(jScrollPane1, "Center");
        cancelButton.setText(loader.getLang().getElementCaption("button", 1));
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                cancelButton_actionPerformed(e);
            }

        });
        jScrollPane1.getViewport().add(changeLogtArea, null);
        changeLogtArea.setCaretPosition(0);
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
    }

    private void cancelButton_actionPerformed(ActionEvent e)
    {
        dispose();
        System.exit(0);
    }

    private Logger logger;
    private PULoader loader;
    private JLabel title;
    private JScrollPane jScrollPane1;
    private JTextPane changeLogtArea;
    private JButton acceptButton;
    private JButton cancelButton;
    private Context context;
    JFrame frame;


}
