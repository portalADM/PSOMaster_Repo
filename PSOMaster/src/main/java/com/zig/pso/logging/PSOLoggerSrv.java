/************************************************************************************************************
 * Class Name : PSOLoggerSrv.java 
 * Description: This class prints Info,Errors and Debug messages in log files. 
 * Author : Nilesh Patil 
 * Date : Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.logging;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.zig.pso.utility.PropertyReader;

public class PSOLoggerSrv
{

    /** Hold the logger that print to the file. */
    private static Logger psoLogger = null;

    /** Hold the logger name in the log4j.properties flie. */
    protected static final String PSO_LOGGER_NAME = "impl.integration.log";

    /** Hold the log4j.properties flie key in the system. */
    protected static final String LOG4J_CONFIGURATION_FILE_SYS_PROP = "log4j.configuration";

    private static Properties appProperty = null;

    private static boolean isInfoEnabled = false;
    private static boolean isDebugEnabled = false;
    private static boolean isErrorEnabled = false;

    static
    {

        Properties props = new Properties();
        try
        {
            props.load(PSOLoggerSrv.class.getResourceAsStream("/log4j.properties"));
            PropertyConfigurator.configure(props);
            psoLogger = Logger.getLogger(PSO_LOGGER_NAME);

            appProperty = PropertyReader.getAppProperties();

            isInfoEnabled = Boolean.parseBoolean(appProperty.getProperty("infoLogEnable"));
            isDebugEnabled = Boolean.parseBoolean(appProperty.getProperty("debugLogEnable"));
            isErrorEnabled = Boolean.parseBoolean(appProperty.getProperty("errorLogEnable"));

            initLoggerFile();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initLoggerFile()
    {
        PSOLoggerSrv.printINFO("\n" + "###############################################################################" + "\n"
                + " \n   ###### ###### ######     ###   ### ####### ###### ###### ###### ######       " + " \n   ##  ## ##     ##  ##     ## # # ## ##   ## ##       ##   ##     ##  ##       "
                + " \n   ###### ###### ##  ##     ##  #  ## ####### ######   ##   ###### ######       " + " \n   ##         ## ##  ##     ##     ## ##   ##     ##   ##   ##     ## #         "
                + " \n   ##     ###### ######     ##     ## ##   ## ######   ##   ###### ##  ##       " + " \n" + " \n"
                + "###############################################################################");
    }

    public static void printINFO(String infoMessage)
    {
        if (isInfoEnabled)
        {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append(infoMessage);
            strMessage.append("\n");
            strMessage.append("-----------------------------------------------------------------------------------------------------");
            psoLogger.info(strMessage);
        }
    }

    public static void printDEBUG(String infoMessage)
    {
        if (isDebugEnabled)
        {
            psoLogger.debug(infoMessage);
        }
    }

    public static void printDEBUG(String ClassName, String MethodName, String debugMessage)
    {
        if (isDebugEnabled)
        {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append("Class Name  : " + ClassName + "  , Method Name : " + MethodName);
            strMessage.append("\n");
            strMessage.append(debugMessage);
            strMessage.append("\n");
            strMessage.append("-----------------------------------------------------------------------------------------------------");
            psoLogger.debug(strMessage);
        }
    }

    public static void printERROR(String infoMessage)
    {
        if (isErrorEnabled)
        {
            psoLogger.error(infoMessage);
        }
    }

    public static void printERROR(Exception exe, String logRefID)
    {
        if (isErrorEnabled)
        {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append("LOG_REF_ID : " + logRefID);
            strMessage.append("\n");
            strMessage.append("-----------------------------------------------------------------------------------------------------");
            psoLogger.error(strMessage, exe);
        }
    }

    public static void printERROR(String ClassName, String MethodName, Exception exe)
    {
        if (isErrorEnabled)
        {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append("Class Name  : " + ClassName + "  , Method Name : " + MethodName);
            strMessage.append("\n");
            psoLogger.error(strMessage, exe);
        }
    }

}
