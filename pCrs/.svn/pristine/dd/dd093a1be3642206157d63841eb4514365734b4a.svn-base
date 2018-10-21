// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Relationships.java

package com.innova4j.puloader.relationship;

import java.util.*;

// Referenced classes of package com.innova4j.puloader.relationship:
//            Node, RelationshipException

public class Relationships
{

    public Relationships()
    {
        nodeList = new LinkedHashMap();
    }

    public void addNode(String nodeName)
    {
        if(nodeList.get(nodeName) == null)
            nodeList.put(nodeName, new Node(nodeName));
    }

    public void addRelationship(String master, String detail)
        throws RelationshipException
    {
        if(master.equals(detail))
            throw new RelationshipException("Invalid relationship, the master and detail are the same.[master= " + master + ", detail= " + detail + "]");
        if(nodeList.get(master) == null)
            nodeList.put(master, new Node(master));
        Node tmpNode = null;
        if(nodeList.get(detail) == null)
            nodeList.put(detail, new Node(detail));
        tmpNode = (Node)nodeList.get(detail);
        tmpNode.addDependence((Node)nodeList.get(master));
        nodeList.put(tmpNode.getName(), tmpNode);
        ((Node)nodeList.get(master)).addRelationship(tmpNode);
    }

    private void activeNodes()
    {
        Iterator loop = nodeList.keySet().iterator();
        String key = null;
        for(; loop.hasNext(); updateRelationships(key, true))
            key = (String)loop.next();

    }

    private ArrayList sort()
    {
        boolean sorted = false;
        ArrayList result = new ArrayList();
        Node node = null;
        while(!sorted) 
        {
            node = getUnlinkedNode();
            if(node == null)
            {
                sorted = true;
            } else
            {
                result.add(node);
                updateRelationships(node.getName(), false);
            }
        }
        return result;
    }

    private void updateRelationships(String nodeName, boolean active)
    {
        Iterator loop = nodeList.keySet().iterator();
        Node tmpNode = null;
        String key = null;
        ((Node)nodeList.get(nodeName)).setActive(active);
        for(; loop.hasNext(); tmpNode.updateRelationship(nodeName, active))
        {
            key = (String)loop.next();
            tmpNode = (Node)nodeList.get(key);
        }

    }

    private Node getUnlinkedNode()
    {
        boolean found = false;
        Iterator loop = nodeList.keySet().iterator();
        Node tmpNode = null;
        while(loop.hasNext() && !found) 
        {
            String key = (String)loop.next();
            tmpNode = (Node)nodeList.get(key);
            if(tmpNode.isActive() && !tmpNode.hasActiveRelationships())
                found = true;
            else
                tmpNode = null;
        }
        return tmpNode;
    }

    public ArrayList sortNodes()
    {
        activeNodes();
        return sort();
    }

    private ArrayList getDependences(String nodeName, ArrayList dependences)
    {
        Node backNode = null;
        ArrayList result = dependences;
        if(nodeList.get(nodeName) != null)
        {
            backNode = (Node)nodeList.get(nodeName);
            Map nodeDependences = backNode.getDependences();
            Node depNode;
            for(Iterator loop = nodeDependences.values().iterator(); loop.hasNext(); getDependences(depNode.getName(), result))
            {
                depNode = (Node)loop.next();
                result.add(depNode);
            }

        }
        return result;
    }

    public ArrayList getDependences(String nodeName)
    {
        ArrayList result = new ArrayList();
        return getDependences(nodeName, result);
    }

    private LinkedHashMap getRelationships(String nodeName, LinkedHashMap relationships)
    {
        Node backNode = null;
        LinkedHashMap result = relationships;
        if(nodeList.get(nodeName) != null)
        {
            backNode = (Node)nodeList.get(nodeName);
            Map nodeRelationships = backNode.getRelationships();
            Node relNode;
            for(Iterator loop = nodeRelationships.values().iterator(); loop.hasNext(); getRelationships(relNode.getName(), result))
            {
                relNode = (Node)loop.next();
                result.put(relNode.getName(), relNode);
            }

        }
        return result;
    }

    public ArrayList getRelationships(String nodeName)
    {
        LinkedHashMap tmpResult = new LinkedHashMap();
        tmpResult = getRelationships(nodeName, tmpResult);
        ArrayList result = new ArrayList();
        for(Iterator loop = tmpResult.values().iterator(); loop.hasNext(); result.add(loop.next()));
        return result;
    }

    private Map nodeList;
}
