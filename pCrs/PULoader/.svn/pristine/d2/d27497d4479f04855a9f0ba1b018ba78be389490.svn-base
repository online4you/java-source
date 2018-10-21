// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Node.java

package com.innova4j.puloader.relationship;

import java.util.*;

// Referenced classes of package com.innova4j.puloader.relationship:
//            RelationshipException

public class Node
{

    Node(String name)
    {
        isActive = true;
        relationships = new LinkedHashMap();
        dependences = new LinkedHashMap();
        this.name = name;
    }

    void addRelationship(Node relationship)
        throws RelationshipException
    {
        if(name.equals(relationship.getName()))
        {
            throw new RelationshipException("Invalid relationship, the master and detail are the same.[master= " + name + ", detail= " + relationship.getName() + "]");
        } else
        {
            relationships.put(relationship.getName(), relationship);
            return;
        }
    }

    public String getName()
    {
        return name;
    }

    void setActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    boolean isActive()
    {
        return isActive;
    }

    boolean hasActiveRelationships()
    {
        boolean result = false;
        Iterator loop = relationships.keySet().iterator();
        Node relationship = null;
        String key = null;
        do
        {
            if(!loop.hasNext() || result)
                break;
            key = (String)loop.next();
            relationship = (Node)relationships.get(key);
            if(relationship.isActive)
                result = true;
        } while(true);
        return result;
    }

    void updateRelationship(String nodeName, boolean active)
    {
        if(relationships.get(nodeName) != null)
            ((Node)relationships.get(nodeName)).setActive(active);
    }

    void addDependence(Node dependence)
    {
        dependences.put(dependence.getName(), dependence);
    }

    Map getRelationships()
    {
        return relationships;
    }

    Map getDependences()
    {
        return dependences;
    }

    private String name;
    private boolean isActive;
    private Map relationships;
    private Map dependences;
}
