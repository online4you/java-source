// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PULoaderUtil.java

package com.innova4j.puloader;

import java.net.URL;
import java.text.*;
import java.util.Date;

public class PULoaderUtil
{

    public PULoaderUtil()
    {
    }

    public static Date parseDate(String dateFormat, String date)
        throws ParseException
    {
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        Date result = formatter.parse(date);
        return result;
    }

    public static URL getFileUrl(String fileName)
    {
        URL url = (com.innova4j.puloader.PULoaderUtil.class).getClassLoader().getResource(fileName);
        return url;
    }
}
