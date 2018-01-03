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
    private PSOConstants() 
    {
        throw new IllegalStateException("Utility class");
    }
    
    /*
     * Portal DB Connection properties
     */
    public static final String PORTAL_DB_DRIVER = "portalDBDiverName";
    public static final String PORTAL_DB_URL = "portalDbUrl";
    public static final String PORTAL_DB_USER = "portalDBUsername";
    public static final String PORTAL_DB_PW = "portalDBPassword";

    /*
     * Ensemble DB Connection properties
     */
    public static final String ENS_DB_DRIVER = "ensDBDiverName";
    public static final String ENS_DB_URL = "ensDbUrl";
    public static final String ENS_DB_USER = "ensDBUsername";
    public static final String ENS_DB_PW = "ensDBPassword";

    public static final String DB_VALUE = "1";
    
    /*
     * Error Code & Message Constants
     */
    public static final int ERROR_CODE = -1;
    public static final int INFO_CODE = 1;
    public static final int SUCCESS_CODE = 0;
    public static final String BULK_UPDATE_SUCCESS_CODE = "0";
    public static final String BULK_UPDATE_FAILURE_CODE = "-1";
    public static final String NO_DATA = "No Data Found.";
    public static final String ORDER_UPDATE_SUCCESSFULL = "Order updated successfully.";
    public static final String ORDER_UPDATE_FAIL = "Order Updated fail.";
    public static final String NO_ORDER_UPDATED = "No Order updated.";
    public static final String NO_VALID_ORDERS = "No valid orders.";
    public static final String ORDER_INSERT_SUCCESSFULL = "Order inserted successfully.";
    public static final String ORDER_INSERT_FAIL = "Order insert fail.";
    public static final String NO_ORDER_INSERTED = "No Order inserted.";
    public static final String INVALID_STATUS_CODE = "Invalid Status Code";
    public static final String INVALID_IMEI = "Invalid IMEI number";
    public static final String INVALID_SIM = "Invalid SIM Number";
    public static final String INVALID_RETYR_COUNT = "Invalid Retry Count";
    public static final String INVALID_CREADENTIALS = "Invalid Credentials";
    public static final String ERROR_SENDING_EMAIL = "Some Error occurred while sending mail.Please try Again";
    public static final String SUCCESSFULLY_EMAIL_SENT = "mail is sent succesfully";
    public static final String INVALID_REQUEST = "BAD Request";
    public static final String INVALID_FILE_TYPE = "Invalid File Type. Please upload excel only.";

    public static final String BACKEND_ERROR = "There is a backend Error. Please try after some time.";
    public static final String BULK_UPDATE_SUCCESS = "Bulk Updates done successfully";
    public static final String BULK_UPDATE_FAILURE = "Bulk Order Update failed";
    public static final String BULK_TEMP_INSERT_SUCCESS = "Bulk data insert done successfully";
          
    public static final String NO_DATA_INSERTED = "No data added.";
    public static final String NO_DATA_UPDATED = "No data updated.";
    public static final String NO_DATA_DELETED = "No data deleted.";
    public static final String DATA_INSERT_SUCCESSFULL = "Data added successfully.";
    public static final String DATA_UPDATE_SUCCESSFULL = "Data updated successfully.";
    public static final String DATA_DELETE_SUCCESSFULL = "Data deleted successfully.";
    public static final String GROUP_INSERT_SUCCESSFULL = "Group created successfully.";
    public static final String GROUP_UPDATE_SUCCESSFULL = "Group updated successfully.";
    public static final String GROUP_DELETE_SUCCESSFULL = "Group deleted successfully.";
          
    public static final String USER_PW_SETUP_SUCCESSFULL = "Your Password has been set. Please Login to continue.";
    public static final String USER_PW_SETUP_FAILURE = "There is some issue while setting up your password. Please try again later.";
    public static final String USER_PW_CHANGE_SUCCESSFULL = "Your Password has been changed.";
    public static final String USERNAME_ALREADY_PRESENT = "Username already present. Please try different Username.";
    public static final String VALID_USERNAME = "Username is valid";
    public static final String ALL_DATA_MANDATORY = "All data are mandatory for registration.";
    public static final String CURRENT_PW_WRONG = "Current Password does not match.";
    public static final String FILE_NOT_EXISTS = "Sorry. The file you are looking for does not exist";

    /*
     * Update Order Contants
     */
    public static final String STATUS = "status";
    public static final String SIM = "sim";
    public static final String IMEI = "imei";
    public static final String RETRY_COUNT = "retry";
          
    public static final String UPDATE_STATUS_EXCEL = "UPDATE_STATUS.xlsx";
    public static final String UPDATE_SIM_EXCEL = "UPDATE_SIM.xlsx";
    public static final String UPDATE_IMEI_EXCEL = "UPDATE_IMEI.xlsx";
    public static final String UPDATE_RETRY_EXCEL = "UPDATE_RETRY.xlsx";
    public static final String BULK_UPDATE_EXCEL = "BULK_UPDATE.xlsx";
          
    public static final String EXCEL_CONT_TYPE = "application/octet-stream";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
          
    public static final String PSO_ADMIN_USER = "ADMIN";
    
    
    /*
     * Authentication and Authorization constants 
     */
    public static final int AUTH_FAILED = 401;
    public static final String AUTH_FAILED_MSG = "Authentication Failed";
    public static final String AUTH_SUCCESS_MSG = "Authentication Successfull";
    public static final String SESSION_USER_DATA = "SessionUserData";
    
    /* User Sign-up Request Status */
    public static final String OPEN = "O";
    public static final String ACTIVE = "A";
    public static final String REJECTED = "R";
    
    /* User Status */
    public static final String USER_IN_PROGRESS = "I";
    public static final String USER_ACTIVE = "A";
    
    /* Encryption Logic Key */
    public static final String ENCRYPETER_PW = "Unix11!";
    
    
    /*SEND Email Configurations*/
    public static final String EMAIL_SEND_FROM = "CricketPortalDevOGS@amdocs.com";
    public static final String SETUP_PW_EMAIL_SUBJECT = "PSO | Setup Password";
    public static final String REJECT_USER_EMAIL_SUBJECT = "PSO | Registration request rejected.";
    public static final String PSO_SETUP_PW_URL = "http://localhost:8081/PSOMaster/#/setupUserPassword";
    public static final String SETUP_PW_EMAIL_CONTENT = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'><meta name='viewport' content='width=device-width'><title></title></head><body><span class='preheader'></span><table class='body'><tr><td class='center' align='center' valign='top'><center data-parsed=''><style type='text/css' align='center' class='float-center'>                 body, html, .body {                     background: #f3f3f3 !important;                 }                   </style><table align='center' class='container float-center'><tbody><tr><td><table class='spacer'><tbody><tr><td height='16px'                                                   style='font-size: 16px; line-height: 16px;'>&#xA0;</td></tr></tbody></table><table><tr><th><h1>PSO Master</h1><p>Congratulations! Your request has been approved. Please setup your                                                   password using below details which you used during                                                  Signup.</p><table class='spacer'><tbody><tr><td height='16px'                                                               style='font-size: 16px; line-height: 16px;'>&#xA0;</td></tr></tbody></table><hr></th></tr></table><h4>User Details</h4><table><tbody><tr><td>Name : </td><td>#NAME#</td></tr><tr><td>Username : </td><td>#USER_NAME#</td></tr><tr><td>Employee ID : </td><td>#EMP_ID#</td></tr><tr><td>Email ID : </td><td>#EMAIL_ID#</td></tr><tr><td>Temporary Password : </td><td>#TEMP_PASSWORD#</td></tr></tbody></table><h4>User this link : <a href='#SETUP_PASSWORD_URL#' target='_blank'>Setup Password</a></h4></td></tr></tbody></table></center></td></tr></table></body></html>";
    public static final String REJECT_USER_EMAIL_CONTENT = "<html><head>    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'>    <meta name='viewport' content='width=device-width'>    <title></title></head><body> <span class='preheader'></span>    <table class='body'>        <tr>            <td class='center' align='center' valign='top'>                <center data-parsed=''>                    <style type='text/css' align='center' class='float-center'>                        body,                        html,                        .body {                            background: #f3f3f3 !important;                        }                    </style>                    <table align='center' class='container float-center'>                        <tbody>                            <tr>                                <td>                                    <table class='spacer'>                                        <tbody>                                            <tr>                                                <td height='16px' style='font-size: 16px; line-height: 16px;'>&#xA0;</td>                                            </tr>                                        </tbody>                                    </table>                                    <table>                                        <tr>                                            <th>                                                <h1>PSO Master</h1>                                                <p>Your request has been rejected by #USER_NAME#.</p>                                                <table class='spacer'>                                                    <tbody>                                                        <tr>                                                            <td height='16px' style='font-size: 16px; line-height: 16px;'>&#xA0;</td>                                                        </tr>                                                    </tbody>                                                </table>                                              </th>                                        </tr>                                    </table>                                    <table>                                        <tbody>                                            <tr>                                                <td>Reject Reason : </td>                                                <td>#REJECT_REASON#</td>                                            </tr>                                        </tbody>                                    </table>                            </tr>                        </tbody>                    </table>                </center>            </td>        </tr>    </table></body></html>";
    
    
    /*Email template Keys*/
    public static final String EMAIL_TEMPLATE_EMPID = "#EMP_ID#";
    public static final String EMAIL_TEMPLATE_EMAILID = "#EMAIL_ID#";
    public static final String EMAIL_TEMPLATE_TEMP_PW = "#TEMP_PASSWORD#";
    public static final String EMAIL_TEMPLATE_SETUP_PW_URL = "#SETUP_PASSWORD_URL#";
    public static final String EMAIL_TEMPLATE_NAME = "#NAME#";
    public static final String EMAIL_TEMPLATE_USERNAME = "#USER_NAME#";

}
