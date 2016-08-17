/************************************************************************************************************
 * Class Name :  PSOConstants.java
 * Description:  This class contains application constants.
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.constants;

public class PSOConstants
{
    /*
     * Portal DB Connection properties
     */
    public final static String PORTAL_DB_DRIVER = "portalDBDiverName";
    public final static String PORTAL_DB_URL = "portalDbUrl";
    public final static String PORTAL_DB_USER = "portalDBUsername";
    public final static String PORTAL_DB_PASSWORD = "portalDBPassword";

    /*
     * Ensemble DB Connection properties
     */
    public final static String ENS_DB_DRIVER = "ensDBDiverName";
    public final static String ENS_DB_URL = "ensDbUrl";
    public final static String ENS_DB_USER = "ensDBUsername";
    public final static String ENS_DB_PASSWORD = "ensDBPassword";

    /*
     * Error Code & Message Constants
     */
    public final static int ERROR_CODE = -1;
    public final static int INFO_CODE = 1;
    public final static int SUCCESS_CODE = 0;
    public final static String NO_DATA = "No Data Found.";
}
