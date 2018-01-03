/************************************************************************************************************
 * Class Name : PSOLoggerSrv.java 
 * Description: This class prints Info,Errors and Debug messages in log files. 
 * Author : Nilesh Patil 
 * Date : Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.logging;

import java.util.Properties;

import org.apache.log4j.Logger;

public class PSOLoggerSrv
{
    static final Logger logger = Logger.getLogger(PSOLoggerSrv.class);
    /** Hold the logger that print to the file. */
    private static Logger psoLogger = null;

    /** Hold the logger name in the log4j.properties flie. */
    protected static final String PSO_LOGGER_NAME = "impl.integration.log";

    /** Hold the log4j.properties flie key in the system. */
    protected static final String LOG4J_CONFIGURATION_FILE_SYS_PROP = "log4j.configuration";

    static
    {

        Properties props = new Properties();
        //props.load(PSOLoggerSrv.class.getResourceAsStream("/log4j.properties"));
        //PropertyConfigurator.configure("/log4j.properties");
        //PropertyConfigurator.configure(props);
        //psoLogger = Logger.getLogger(PSO_LOGGER_NAME);


        initLoggerFile();
    }

    public static void initLoggerFile()
    {
        String logHeader = "\n" + "###############################################################################" + "\n"
                            + " \n   ###### ###### ######     ###   ### ####### ###### ###### ###### ######       " 
                            + " \n   ##  ## ##     ##  ##     ## # # ## ##   ## ##       ##   ##     ##  ##       "
                            + " \n   ###### ###### ##  ##     ##  #  ## ####### ######   ##   ###### ######       " 
                            + " \n   ##         ## ##  ##     ##     ## ##   ##     ##   ##   ##     ## #         "
                            + " \n   ##     ###### ######     ##     ## ##   ## ######   ##   ###### ##  ##       " + " \n" + " \n"
                                + "###############################################################################";
        
        StringBuffer strMessage = new StringBuffer();
        strMessage.append("\n");
        strMessage.append(logHeader);
        strMessage.append("\n");
        strMessage.append("============================================================================================================================");
        logger.info(strMessage);
        
    }

    public static void printINFO(Logger logger, String infoMessage)
    {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append(infoMessage);
            strMessage.append("\n");
            strMessage.append("============================================================================================================================");
            logger.info(strMessage);
    }

    public static void printSQL_DEBUG(Logger logger,String ClassName, String MethodName, String logRefID,String sqlQuery, Object InputParams ,String updateStatus)
    {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append("Class Name  : " + ClassName + "  , Method Name : " + MethodName);
            strMessage.append("\n");
            strMessage.append("LOG_REF_ID  : " + logRefID);
            strMessage.append("\n");
            strMessage.append("Query       : " + sqlQuery);
            strMessage.append("\n");
            strMessage.append("Input Params  : "+InputParams);
            strMessage.append("\n");
            strMessage.append("Message : " + updateStatus);
            strMessage.append("\n");
            strMessage.append("============================================================================================================================");
            logger.debug(strMessage);
    }

    public static void printDEBUG(Logger logger,String ClassName, String MethodName, String debugMessage)
    {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append("Class Name  : " + ClassName + "  , Method Name : " + MethodName);
            strMessage.append("\n");
            strMessage.append(debugMessage);
            strMessage.append("\n");
            strMessage.append("============================================================================================================================");
            logger.debug(strMessage);
    }

    public static void printERROR(Logger logger,String infoMessage)
    {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append(infoMessage); 
            strMessage.append("\n");
            strMessage.append("============================================================================================================================");
            logger.error(infoMessage);
    }

    public static void printERROR(Logger logger,String ClassName, String MethodName, String logRefID,String sqlQuery, Object InputParams ,Exception exe)
    {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append("Class Name  : " + ClassName + "  , Method Name : " + MethodName);
            strMessage.append("\n");
            strMessage.append("LOG_REF_ID  : " + logRefID);
            strMessage.append("\n");
            strMessage.append("Query       : " + sqlQuery);
            strMessage.append("\n");
            strMessage.append("Input Params : "+InputParams);
            strMessage.append("\n");
            strMessage.append("============================================================================================================================");
            logger.error(strMessage, exe);
    }

    public static void printERROR(Logger logger,String ClassName, String MethodName, Exception exe)
    {
            StringBuffer strMessage = new StringBuffer();
            strMessage.append("\n");
            strMessage.append("Class Name  : " + ClassName + "  , Method Name : " + MethodName);
            strMessage.append("\n");
            strMessage.append("============================================================================================================================");
            logger.error(strMessage, exe);
    }

}
