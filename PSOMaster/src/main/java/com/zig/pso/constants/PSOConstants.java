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
    public final static String Successfully_updated_status = "Successfully updated status- inside DAO.";
    public final static String Unsuccessful_while_updating_Info = "Unsuccessful while updating Info.";
    public final static String Invalid_Status_Code = "Invalid Status Code";
    public final static String Invalid_IMEI_Number = "Invalid IMEI number";
    public final static String Invalid_Sim_Number = "Invalid SIM Number";
    public final static String Invalid_Retry_Count = "Invalid Retry Count";
    public final static String Invalid_Credentials = "Invalid Credentials";

    public final static String BACKEND_ERROR = "There is a backend Error. Please try after some time.";
    public final static String BULK_UPDATE_SUCCESS = "Updates done successfully";

    /*
     * Update Order Contants
     */
    public final static String STATUS = "status";
    public final static String SIM = "sim";
    public final static String IMEI = "imei";
    public final static String RETRY_COUNT = "retry";

    public final static String UPDATE_STATUS_EXCEL = "UPDATE_STATUS.xlsx";
    public final static String UPDATE_SIM_EXCEL = "UPDATE_SIM.xlsx";
    public final static String UPDATE_IMEI_EXCEL = "UPDATE_IMEI.xlsx";
    public final static String UPDATE_RETRY_EXCEL = "UPDATE_RETRY.xlsx";

    public final static String EXCEL_CONT_TYPE = "application/octet-stream";
    public final static String CONTENT_DISPOSITION = "Content-Disposition";

}
