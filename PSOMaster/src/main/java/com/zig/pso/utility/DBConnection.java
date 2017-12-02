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

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;

public class DBConnection
{
    /* Portal DB Connection object */
    private static Connection portalDBConnection = null;

    /* Ensemble DB Connection object */
    private static Connection ensDBConnection = null;

    /*
     * This method returns Database connection for Portal Database.
     */
    public static Connection getPortalDBConnection()
    {
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
            PSOLoggerSrv.printERROR(e.getMessage());
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(e.getMessage());
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(e.getMessage());
        }
        return portalDBConnection;
    }

    /*
     * This method returns Database connection for Ensemble Database.
     */
    public static Connection getENSDBConnection()
    {
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
            PSOLoggerSrv.printERROR(e.getMessage());
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(e.getMessage());
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(e.getMessage());
        }
        return ensDBConnection;
    }
}
