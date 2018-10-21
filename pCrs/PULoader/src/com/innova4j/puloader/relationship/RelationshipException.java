// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RelationshipException.java

package com.innova4j.puloader.relationship;


public class RelationshipException extends RuntimeException
{

    public RelationshipException()
    {
    }

    public RelationshipException(String message)
    {
        super(message);
    }

    public RelationshipException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public RelationshipException(Throwable cause)
    {
        super(cause);
    }

    /**
     * @deprecated Method getInitialCause is deprecated
     */

    public final Throwable getInitialCause()
    {
        return super.getCause();
    }
}
