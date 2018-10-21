// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PULoaderSQL.java

package com.innova4j.puloader;

import java.net.URL;
import java.sql.*;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.Logger;
import org.w3c.dom.*;

// Referenced classes of package com.innova4j.puloader:
//            Context, PULoaderUtil

public class PULoaderSQL
{

    public Context getContext()
    {
        return context;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public JProgressBar getPBar()
    {
        return pBar;
    }

    public void setPBar(JProgressBar pBar)
    {
        this.pBar = pBar;
    }

    public void setActionLabel(JLabel actionLabel)
    {
        this.actionLabel = actionLabel;
    }

    public JLabel getActionLabel()
    {
        return actionLabel;
    }

    public PULoaderSQL(Context context, Logger logger)
    {
        conn = null;
        preparedDeleteStmt = null;
        stmt = null;
        this.logger = null;
        this.context = context;
        this.logger = logger;
    }

    public boolean testConnection()
    {
        boolean done = true;
       
        return done;
    }

    public int getUpdateCount() throws SQLException {
		return stmt.getUpdateCount();
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return stmt.getGeneratedKeys();
	}

	public boolean connect()
    {
        if(!loadDriver())
            return false;
        try
        {
            switch(context.getDbTypeIdentifier())
            {
            case 0: // '\0'
                conn = getMySQLConnection();
                break;

            case 1: // '\001'
                conn = getOracleConnection();
                break;

            case 2: // '\002'
                conn = getSQLServerConnection();
                break;

            case 3: // '\003'
                conn = getAccessConnection();
                break;
            }
            conn.setAutoCommit(false);
            if(context.getDbTypeIdentifier() != 3)
                conn.setTransactionIsolation(2);
        }
        catch(Exception e)
        {
            logger.fatal("Could not connect to specified database [" + e.getMessage() + "]", e);
            context.setFatalError(true);
            return false;
        }
        return true;
    }

    private Connection getAccessConnection()
        throws SQLException
    {
        String accessDBURLPrefix = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
        String accessDBURLSuffix = ";DriverID=22;READONLY=true}";
        String databaseURL = accessDBURLPrefix + context.getAccessDBFilePath() + accessDBURLSuffix;
        return DriverManager.getConnection(databaseURL, "", "");
    }

    private Connection getMySQLConnection()
        throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://" + context.getDbServerName() + ":" + context.getMySqlPort() + "/" + context.getDbName() + "?" + "user=" + context.getDbUser() + "&password=" + context.getDbPassword() + "&useUnicode=true&characterEncoding=utf-8&connectionCollation=utf8_general_ci");
    }

    private Connection getOracleConnection()
        throws SQLException
    {
        return DriverManager.getConnection("jdbc:oracle:thin:@" + context.getDbServerName() + ":" + context.getOraclePort() + ":" + context.getDbName(), context.getDbUser(), context.getDbPassword());
    }

    private Connection getSQLServerConnection()
        throws SQLException
    {
        return DriverManager.getConnection("jdbc:sqlserver://" + context.getDbServerName() + ":" + context.getSqlServerPort() + ";" + "databaseName=" + context.getDbName() + ";user=" + context.getDbUser() + ";password=" + context.getDbPassword());
    }

    private boolean loadDriver()
    {
        try
        {
            switch(context.getDbTypeIdentifier())
            {
            case 0: // '\0'
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                break;

            case 1: // '\001'
                Class.forName("oracle.jdbc.driver.OracleDriver");
                break;

            case 2: // '\002'
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                break;

            case 3: // '\003'
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                break;
            }
        }
        catch(Exception ex)
        {
            context.setFatalError(true);
            logger.fatal("Could not load database driver [" + ex.getMessage() + "]", ex);
            return false;
        }
        return true;
    }

    public void disconnect()
    {
        if(conn != null)
            try
            {
                conn.close();
                conn = null;
            }
            catch(SQLException e)
            {
                context.setError(true);
                logger.error("Could not close the active connection [" + e.getMessage() + "]", e);
            }
    }

    public void createTable(String tableName)
    {
        try {
        	if(context.getRecreateTables() || !checkTableCount(tableName, -1)){
		    	doCreateTable(tableName);
        	}
            
        }catch(Exception e)
        {
            logger.error("Could not create a table [tableName= " + tableName , e);
        }

       
    }

    public void dropTable(String tableName)
    {
        try {
			stmt = conn.createStatement();
			if(context.getRecreateTables()){
				stmt.execute("DROP TABLE " + tableName);
				logger.debug("Table " + tableName + " successfully dropped.");
			}else{
				if(checkTableCount(tableName, -1)){
					stmt.execute("DROP TABLE " + tableName);
					logger.debug("Table " + tableName + " successfully dropped.");
				}else{
					stmt.execute("DELETE FROM " + tableName);
					logger.debug("Rercords form  " + tableName + " successfully deleted.");
				}
			}
			conn.commit();
			
		} catch (SQLException e) {
			context.setError(true);
	        logger.error("Could not delete or drop table " + tableName + ", table may not exists []",e);
		}
    }

    private void doCreateTable(String tableName)
    {
        try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        ArrayList statementList = readCreateTableStatement(tableName);
        for(int i = 0; i < statementList.size(); i++)
        {
            try {
				stmt.execute((String)statementList.get(i));
				logger.debug("Table " + tableName + " successfully created.");
			} catch (SQLException ex) {
				context.setError(true);
	            logger.error("Could not create table " + tableName + " [" + ex.getMessage() + "]", ex);
			}
            
        }
        try{
            if(!stmt.equals(null))
            {
                stmt.close();
                stmt = null;
            }
        }catch(SQLException ex){
            context.setError(true);
            logger.error("Could not close statement [" + ex.getMessage() + "]", ex);
        }
        
    }

    public ArrayList readCreateTableStatement(String tableName)
    {
        String sqlStatement = "";
        String dbType = "";
        switch(context.getDbTypeIdentifier())
        {
        case 0: // '\0'
            dbType = "MYSQL";
            break;

        case 1: // '\001'
            dbType = "ORACLE";
            break;

        case 2: // '\002'
            dbType = "MSSQL";
            break;

        case 3: // '\003'
            dbType = "MSACCESS";
            break;
        }
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setIgnoringComments(true);
            dbf.setCoalescing(true);
            dbf.setNamespaceAware(false);
            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();
            java.io.InputStream fis = PULoaderUtil.getFileUrl("com/innova4j/puloader/config/CreateTable.xml").openStream();
            Document doc = db.parse(fis);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName(dbType);
            for(int s = 0; s < nodeLst.getLength(); s++)
            {
                Node fstNode = nodeLst.item(s);
                if(fstNode.getNodeType() == 1)
                {
                    Element fstElmnt = (Element)fstNode;
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(tableName);
                    Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    sqlStatement = fstNm.item(0).getNodeValue();
                }
            }

        }
        catch(Exception e)
        {
            logger.fatal("Could not load SQL Statement from file CREATE TABLE.xml [" + e.getMessage() + "]", e);
            context.setFatalError(true);
        }
        ArrayList result = new ArrayList();
        for(StringTokenizer tok = new StringTokenizer(sqlStatement, ";"); tok.hasMoreElements(); result.add(tok.nextElement()));
        return result;
    }

    public void createPreparedInsertStament(String pstmtSql)
    {
        try
        {
            preparedInsertStmt = conn.prepareStatement(pstmtSql);
        }
        catch(SQLException ex)
        {
            context.setFatalError(true);
            logger.fatal("Could not create prepared statement [" + ex.getMessage() + "]", ex);
        }
    }

    public void createPreparedUpdateStament(String pstmtSql)
    {
        try
        {
            preparedUpdateStmt = conn.prepareStatement(pstmtSql);
        }
        catch(SQLException ex)
        {
            context.setFatalError(true);
            logger.fatal("Could not create prepared statement [" + ex.getMessage() + "]", ex);
        }
    }

    public void createPreparedDeleteStament(String pstmtSql)
    {
        try
        {
            preparedDeleteStmt = conn.prepareStatement(pstmtSql);
        }
        catch(SQLException ex)
        {
            context.setFatalError(true);
            logger.fatal("Could not create prepared statement [" + ex.getMessage() + "]", ex);
        }
    }

    public void destroyPreparedStaments()
    {
        if(preparedInsertStmt != null)
            try
            {
                preparedInsertStmt.close();
            }
            catch(SQLException ex)
            {
                context.setError(true);
                logger.error("Could not close insert statement [" + ex.getMessage() + "]", ex);
            }
        if(preparedUpdateStmt != null)
            try
            {
                preparedUpdateStmt.close();
            }
            catch(SQLException ex)
            {
                context.setError(true);
                logger.error("Could not close update statement [" + ex.getMessage() + "]", ex);
            }
        if(preparedDeleteStmt != null)
            try
            {
                preparedDeleteStmt.close();
            }
            catch(SQLException ex)
            {
                context.setError(true);
                logger.error("Could not close delete statement [" + ex.getMessage() + "]", ex);
            }
    }

    public void writeTotalData(String tableName, String columnValues[])
    {
        int result = 0;
        try
        {
            for(int i = 0; i < columnValues.length; i++)
                preparedInsertStmt.setString(i + 1, columnValues[i]);

            result = preparedInsertStmt.executeUpdate();
            if(result == 0)
            {
                context.setError(true);
                logger.error("Could not insert record to " + tableName);
            }
        }
        catch(Exception e)
        {
            context.setError(true);
            logger.error("Could not insert record to " + tableName + " [" + e.getMessage() + "]", e);
        }
    }

    public void setBatch(String tableName, String columnValues[])
    {
        try
        {
            for(int i = 0; i < columnValues.length; i++)
                preparedInsertStmt.setString(i + 1, columnValues[i]);

        }
        catch(Exception e)
        {
            context.setError(true);
            logger.error("[batch mode] Could not add record to " + tableName + " [" + e.getMessage() + "]", e);
        }
    }

    public void writeUpdatedData(String tableName, String dataValues[], String keyValues[], String event)
    {
        int result = 0;
        String keyStr = "";
        for(int i = 0; i < keyValues.length; i++)
            if(!keyStr.equals(""))
                keyStr = keyStr + "|" + keyValues[i];
            else
                keyStr = keyValues[i];

        if(event.toLowerCase().equals("u"))
            try
            {
                int keyCounter = 0;
                for(int i = 0; i < dataValues.length; i++)
                    if(i + keyValues.length < dataValues.length)
                    {
                        preparedUpdateStmt.setString(i + 1, dataValues[i + keyValues.length]);
                    } else
                    {
                        preparedUpdateStmt.setString(i + 1, dataValues[keyCounter]);
                        keyCounter++;
                    }

                result = preparedUpdateStmt.executeUpdate();
                if(result == 0)
                {
                    context.setError(true);
                    logger.error("Could not update record on table: " + tableName + " with keys: " + keyStr);
                }
            }
            catch(Exception e)
            {
                context.setError(true);
                logger.error("Could not update record on table: " + tableName + " with keys: " + keyStr + " [" + e.getMessage() + "]", e);
            }
        else
        if(event.toLowerCase().equals("i"))
            try
            {
                for(int i = 0; i < dataValues.length; i++)
                    preparedInsertStmt.setString(i + 1, dataValues[i]);

                result = preparedInsertStmt.executeUpdate();
                if(result == 0)
                {
                    context.setError(true);
                    logger.error("Could not insert record on table: " + tableName + " with keys: " + keyStr);
                }
            }
            catch(Exception e)
            {
                context.setError(true);
                logger.error("Could not insert record on table: " + tableName + " with keys: " + keyStr + " [" + e.getMessage() + "]", e);
            }
        else
            try
            {
                for(int i = 0; i < keyValues.length; i++)
                    preparedDeleteStmt.setString(i + 1, keyValues[i]);

                result = preparedDeleteStmt.executeUpdate();
                if(result == 0)
                {
                    context.setError(true);
                    logger.error("Could not delete record on table: " + tableName + " with keys: " + keyStr);
                }
            }
            catch(Exception e)
            {
                context.setError(true);
                logger.error("Could not delete record on table: " + tableName + " with keys: " + keyStr + " [" + e.getMessage() + "]", e);
            }
    }

    public boolean checkTableCount(List tables, int morethan)
    {
        boolean result = true;
        connect();
        String tableName = null;
        for(int l = 0; l < tables.size() && result; l++)
        {
            tableName = (String)tables.get(l);
            result = checkTableCount(tableName, morethan);
        }

        disconnect();
        context.setError(true);
        //logger.error(e.getMessage(), e);
        disconnect();
        return result;
    }

    private boolean checkTableCount(String tableName, int morethan)
    {
        boolean result = false;
        if(getRecords(tableName) > morethan)
            result = true;
        return result;
    }

    public int getRecords(String tableName)
    {
        int count;
label0:
        {
            count = -1;
            PreparedStatement st = null;
            ResultSet rs = null;
            try
            {
                st = conn.prepareStatement("SELECT COUNT(*) FROM " + tableName);
                rs = st.executeQuery();
                rs.next();
                count = rs.getInt(1);
                rs.close();
                st.close();
            }
            catch(SQLException e)
            {
                if(st != null)
                    try
                    {
                        st.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch(SQLException ex) { }
                break label0;
            }
            finally
            {
                if(st != null)
                    try
                    {
                        st.close();
                    }
                    catch(Exception ex) { }
                
            }
            if(st != null)
                try
                {
                    st.close();
                }
                catch(Exception e) { }
            break label0;
        }
        return count;
    }

    public void commit()
    {
        try
        {
            conn.commit();
        }
        catch(Exception e)
        {
            context.setError(true);
            logger.error(e.getMessage(), e);
        }
    }

    public void addBatch()
        throws SQLException
    {
        preparedInsertStmt.addBatch();
    }

    public int[] executeBatch()
        throws SQLException
    {
        return preparedInsertStmt.executeBatch();
    }

    private Connection conn;
    private PreparedStatement preparedInsertStmt;
    private PreparedStatement preparedUpdateStmt;
    private PreparedStatement preparedDeleteStmt;
    private Statement stmt;
    private Context context;
    private Logger logger;
    private JProgressBar pBar;
    private JLabel actionLabel;
}
