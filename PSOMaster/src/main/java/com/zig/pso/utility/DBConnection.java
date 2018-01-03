/************************************************************************************************************
 * Class Name :  DBConnection.java
 * Description:  This class implements connection between application and Portal / Ensemble database.
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;

public class DBConnection
{
    public static final String CLASS_NAME = "DBConnection";
    
    static final Logger logger = Logger.getLogger(DBConnection.class);
    
    /* Portal DB Connection object */
    private static Connection portalDBConnection = null;

    /* Ensemble DB Connection object */
    private static Connection ensDBConnection = null;

    /*
     * This method returns Database connection for Portal Database.
     */
    public static Connection getPortalDBConnection()
    {
        PSOLoggerSrv.printINFO(logger, "getPortalDBConnection : Creating Portal DB Connection.");
        try
        {
            Properties prop = PropertyReader.getDbProperties();
            String driver = prop.getProperty(PSOConstants.PORTAL_DB_DRIVER);
            String url = prop.getProperty(PSOConstants.PORTAL_DB_URL);
            String user = prop.getProperty(PSOConstants.PORTAL_DB_USER);
            String password = PSOPropertyEncryptDecryptUtil.decryptValue(prop.getProperty(PSOConstants.PORTAL_DB_PW));
            Class.forName(driver);
            portalDBConnection = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalDBConnection", e);
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalDBConnection", e);
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalDBConnection", e);
        }
        return portalDBConnection;
    }

    /*
     * This method returns Database connection for Ensemble Database.
     */
    public static Connection getENSDBConnection()
    {
        PSOLoggerSrv.printINFO(logger, "getENSDBConnection : Creating ENS DB Connection.");
        try
        {
            Properties prop = PropertyReader.getDbProperties();
            String driver = prop.getProperty(PSOConstants.ENS_DB_DRIVER);
            String url = prop.getProperty(PSOConstants.ENS_DB_URL);
            String user = prop.getProperty(PSOConstants.ENS_DB_USER);
            String password = PSOPropertyEncryptDecryptUtil.decryptValue(prop.getProperty(PSOConstants.ENS_DB_PW));
            Class.forName(driver);
            ensDBConnection = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getENSDBConnection", e);
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getENSDBConnection", e);
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getENSDBConnection", e);
        }
        return ensDBConnection;
    }
}
