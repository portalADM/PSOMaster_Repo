/************************************************************************************************************
 * Class Name : PSOConstants.java 
 * Description: This class contains application constants.
 * Author : Nilesh Patil 
 * Date : Jun 26, 2016 
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
    public final static String ORDER_UPDATE_SUCCESSFULL = "Order updated successfully.";
    public final static String ORDER_UPDATE_FAIL = "Order Updated fail.";
    public final static String NO_ORDER_UPDATED = "No Order updated.";
    public final static String NO_VALID_ORDERS = "No valid orders.";
    public final static String ORDER_INSERT_SUCCESSFULL = "Order inserted successfully.";
    public final static String ORDER_INSERT_FAIL = "Order insert fail.";
    public final static String NO_ORDER_INSERTED = "No Order inserted.";
    public final static String INVALID_STATUS_CODE = "Invalid Status Code";
    public final static String INVALID_IMEI = "Invalid IMEI number";
    public final static String INVALID_SIM = "Invalid SIM Number";
    public final static String INVALID_RETYR_COUNT = "Invalid Retry Count";
    public final static String INVALID_CREADENTIALS = "Invalid Credentials";
    public final static String Error_Occurred_While_sending_mail = "Some Error occurred while sending mail.Please try Again";
    public final static String Successfully_sent_mail = "mail is sent succesfully";
    public final static String Invalid_Request = "BAD Request";

    public final static String BACKEND_ERROR = "There is a backend Error. Please try after some time.";
    public final static String BULK_UPDATE_SUCCESS = "Bulk Updates done successfully";
    public final static String BULK_UPDATE_FAILURE = "Bulk Order Update failed";
    public final static String BULK_TEMP_INSERT_SUCCESS = "Bulk data insert done successfully";

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
    
    public final static String PSO_ADMIN_USER = "ADMIN";
    
    
    /*
     * Authentication and Authorization constants 
     * 
     */
    public final static int AUTH_FAILED = 401;
    public final static String AUTH_FAILED_MSG = "Authentication Failed";
    public final static String AUTH_SUCCESS_MSG = "Authentication Successfull";
    
    public final static String BULK_UPDATE_SUCCESS_CODE = "0";
    public final static String BULK_UPDATE_FAILURE_CODE = "-1";
}
