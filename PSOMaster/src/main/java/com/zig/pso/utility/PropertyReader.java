/************************************************************************************************************
 * Class Name :  PropertyReader.java
 * Description:  This class reads the property file.
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.utility;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader
{
    /* Database properties */
    private static Properties dbProperties = null;

    /* Application properties */
    private static Properties appProperties = null;

    /* Administration properties */
    private static Properties adminProperties = null;

    /* Order SQL properties */
    private static Properties sqlProperties = null;

    static
    {

        /*
         * Load Database properties
         */
        try
        {
            dbProperties = new Properties();
            dbProperties.load(PropertyReader.class.getClassLoader().getResourceAsStream("/db.properties"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        /*
         * Load Application properties
         */
        try
        {
            appProperties = new Properties();
            appProperties.load(PropertyReader.class.getClassLoader().getResourceAsStream("/application.properties"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        /*
         * Load Admin properties
         */
        try
        {
            adminProperties = new Properties();
            adminProperties.load(PropertyReader.class.getClassLoader().getResourceAsStream("/administration.properties"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        /*
         * Load SQL properties
         */
        try
        {
            sqlProperties = new Properties();
            sqlProperties.load(PropertyReader.class.getClassLoader().getResourceAsStream("/orderSQL.properties"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @return the dbProperties
     */
    public static Properties getDbProperties()
    {
        return dbProperties;
    }

    /**
     * @return the appProperties
     */
    public static Properties getAppProperties()
    {
        return appProperties;
    }

    /**
     * @return the adminProperties
     */
    public static Properties getAdminProperties()
    {
        return adminProperties;
    }

    /**
     * @return the sqlProperties
     */
    public static Properties getSqlProperties()
    {
        return sqlProperties;
    }

}
