// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InsertBatch.java

package com.innova4j.puloader;

import java.sql.BatchUpdateException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import org.apache.log4j.Logger;

// Referenced classes of package com.innova4j.puloader:
//            PULoaderSQL, Context

public class InsertBatch
{

    public InsertBatch(Context context, Logger logger, List values, String tableName, PULoaderSQL statement)
    {
        threadList = null;
        this.tableName = null;
        this.values = null;
        this.statement = null;
        this.context = null;
        this.logger = null;
        threadList = Collections.synchronizedMap(new HashMap());
        this.context = context;
        this.logger = logger;
        this.tableName = tableName;
        this.values = values;
        this.statement = statement;
    }

    public void executeBatch()
    {
    	int initialBatchSize;
        boolean allStatementsTriedOnce= false;
        initialBatchSize = values.size();
        int countedRecords;
        int updateCounts[];
        
        countedRecords = statement.getRecords(tableName);
        for(int i = 0; i < values.size(); i++)
        {
            try{
            	statement.setBatch(tableName, (String[])(String[])values.get(i));
            	statement.addBatch();
                
			} catch (SQLException e1) {
				 logger.error("[Batch mode] Could not statement.addBatch(). [tableName= " + tableName + "]",e1 );
			}
        }
        
        	try{
        		updateCounts = statement.executeBatch();} 
        	catch(BatchUpdateException b) 
            {
                    updateCounts = b.getUpdateCounts();
                    for (int i = 0; i < updateCounts.length; i++) {
                            if (updateCounts[i]!=1 && values.get(i)!=null){
                            	String[] vals = (String[])values.get(i);
                            	String values="";
                            	for (int v=0;v<vals.length;v++){
                            		values+=vals[v] + " ";
                            	}
                            	values=values.trim();
                            	logger.error("[Batch mode] Error inserting record in [tableName= " + tableName + "] with values [" + values + "]",b);
                            }
                    }
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        	
        	
        statement.commit();
        if(values.size() != initialBatchSize)
            logger.error("[Batch mode] Could not insert record. [tableName= " + tableName + "]" );
    	int countedRecords2 = statement.getRecords(tableName);
        int insertedRecords = countedRecords2 - countedRecords;
        allStatementsTriedOnce = true;
       
    }

    private int getFailedUpdateCounts(int updateCounts[])
    {
        int failedUpdates = 0;
        for(int i = 0; i < updateCounts.length; i++)
            if(updateCounts[i] < 0 && updateCounts[i] != -2 && updateCounts[i] == -3)
                failedUpdates++;

        return failedUpdates;
    }

    private Map threadList;
    private String tableName;
    private List values;
    private PULoaderSQL statement;
    private Context context;
    private Logger logger;
}

