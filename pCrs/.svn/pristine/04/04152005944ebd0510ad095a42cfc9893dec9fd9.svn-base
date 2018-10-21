// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Launcher.java

package com.innova4j.puloader.client;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyPink;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

// Referenced classes of package com.innova4j.puloader.client:
//            LicenseFrame

public class Launcher
{

    public Launcher()
    {
        initializeLookAndFeels();
        JFrame licenseframe = new LicenseFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = licenseframe.getSize();
        if(frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        if(frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;
        licenseframe.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        licenseframe.setDefaultCloseOperation(3);
        licenseframe.setVisible(true);
    }

    private static final void initializeLookAndFeels()
    {
        try
        {
            javax.swing.UIManager.LookAndFeelInfo lnfs[] = UIManager.getInstalledLookAndFeels();
            boolean found = false;
            for(int i = 0; i < lnfs.length; i++)
                if(lnfs[i].getName().equals("JGoodies Plastic 3D"))
                    found = true;

            if(!found)
                UIManager.installLookAndFeel("JGoodies Plastic 3D", "com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
            Plastic3DLookAndFeel theme = new Plastic3DLookAndFeel();
            Plastic3DLookAndFeel _tmp = theme;
            Plastic3DLookAndFeel.setCurrentTheme(new SkyPink());
            UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
        }
        catch(Throwable t)
        {
            try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[])
    {
        new Launcher();
    }
}
