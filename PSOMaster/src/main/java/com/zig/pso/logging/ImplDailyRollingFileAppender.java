/**
 * 
 */
package com.zig.pso.logging;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;

import com.zig.pso.utility.PropertyReader;

/**
 * @author Nilesh Patil
 */
public class ImplDailyRollingFileAppender extends DailyRollingFileAppender
{
    static final Logger logger = Logger.getLogger(ImplDailyRollingFileAppender.class);
    
    /** Hold the logger that print to the file. */
    private static Logger psoLogger = null;
    /** Hold the logger name in the log4j.properties flie. */
    protected static final String PSO_LOGGER_NAME = "impl.integration.log";
    
    private static Properties log4jProperty = null;
    
    /** the system property that defines the path to the log4j logs */
    public static final String FILE_APPENDER_PATH_SYSTEM_PROPERTY = "log4j.implFileAppender.path";
    /** Holds the path of the log file */
    public static  String FILEPATH = null;
    /** Holds the name of the log file */
    public static final String SLA_LOG_FILE_NAME = "/PSOMaster.";
    
    
    static
    {
        try
        {
            log4jProperty = PropertyReader.getlog4jProperties();

            FILEPATH = log4jProperty.getProperty("log4j.implFileAppender.path");
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(logger, "ImplDailyRollingFileAppender", "getStuckOrderList", e);
        }
    }
    

    /**
     * Overwrites the way the path for the log4j log file calculated.<br>
     * Instead of creating the file directly as it is defined at the properties file, use a system property to calculate the full path.
     *
     * @param fileName The name of the file that need to be created (relative path to the logs directory).
     * @param append see super implementation
     * @param bufferedIO see super implementation
     * @param bufferSize see super implementation
     * @throws IOException see super implementation
     * @see org.apache.log4j.RollingFileAppender#setFile(java.lang.String, boolean, boolean, int)
     */

    public synchronized void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException
    {
    	String logFileName = new SimpleDateFormat("yyyyMMdd_HHmmss'.log'").format(new Date());
    	
        super.setFile(FILEPATH + SLA_LOG_FILE_NAME+logFileName, append, bufferedIO, bufferSize);
        //super.setFile("C:\\Users\\nilesp\\Documents\\Softwares\\eclipse-jee-luna-SR2-win32-x86_64\\logs"+ SLA_LOG_FILE_NAME+logFileName, append, bufferedIO, bufferSize);
    }
    
}
