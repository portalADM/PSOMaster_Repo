/**
 * 
 */
package com.zig.pso.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zig.pso.logging.PSOLoggerSrv;

/**
 * @author Nilesh Patil
 */
public class DBConnection  
{

    private static Connection portalDBConnection = null;
    private static Connection ensDBConnection = null;

    /*
     * Portal DB Connection properties
     */
    private static String PORTAL_DB_DRIVER = "portalDBDiverName";
    private static String PORTAL_DB_URL = "portalDbUrl";
    private static String PORTAL_DB_USER = "portalDBUsername";
    private static String PORTAL_DB_PASSWORD = "portalDBPassword";

    /*
     * Ensemble DB Connection properties
     */
    private static String ENS_DB_DRIVER = "ensDBDiverName";
    private static String ENS_DB_URL = "ensDbUrl";
    private static String ENS_DB_USER = "ensDBUsername";
    private static String ENS_DB_PASSWORD = "ensDBPassword";

    /*
     * This method returns Database connection for Ensemble Database.
     */
    public static Connection getPortalDBConnection()
    {
        if (portalDBConnection != null)
            return portalDBConnection;
        else
        {
            try
            {
                Properties prop = new Properties();
                InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty(PORTAL_DB_DRIVER);
                String url = prop.getProperty(PORTAL_DB_URL);
                String user = prop.getProperty(PORTAL_DB_USER);
                String password = prop.getProperty(PORTAL_DB_PASSWORD);
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
            catch (FileNotFoundException e)
            {
                PSOLoggerSrv.printERROR(e.getMessage());
            }
            catch (IOException e)
            {
                PSOLoggerSrv.printERROR(e.getMessage());
            }
            return portalDBConnection;
        }
    }

    /*
     * This method returns Database connection for Ensemble Database.
     */
    public static Connection getENSDBConnection()
    {
        if (ensDBConnection != null)
            return ensDBConnection;
        else
        {
            try
            {
                Properties prop = new Properties();
                InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty(ENS_DB_DRIVER);
                String url = prop.getProperty(ENS_DB_URL);
                String user = prop.getProperty(ENS_DB_USER);
                String password = prop.getProperty(ENS_DB_PASSWORD);
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
            catch (FileNotFoundException e)
            {
                PSOLoggerSrv.printERROR(e.getMessage());
            }
            catch (IOException e)
            {
                PSOLoggerSrv.printERROR(e.getMessage());
            }
            return ensDBConnection;
        }
    }
}
