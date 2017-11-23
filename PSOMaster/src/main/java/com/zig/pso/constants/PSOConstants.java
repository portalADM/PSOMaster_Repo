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
    public final static String BULK_UPDATE_SUCCESS_CODE = "0";
    public final static String BULK_UPDATE_FAILURE_CODE = "-1";
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
    
    public final static String NO_DATA_INSERTED = "No data added.";
    public final static String NO_DATA_UPDATED = "No data updated.";
    public final static String NO_DATA_DELETED = "No data deleted.";
    public final static String DATA_INSERT_SUCCESSFULL = "Data added successfully.";
    public final static String DATA_UPDATE_SUCCESSFULL = "Data updated successfully.";
    public final static String DATA_DELETE_SUCCESSFULL = "Data deleted successfully.";
    public final static String GROUP_INSERT_SUCCESSFULL = "Group created successfully.";
    public final static String GROUP_UPDATE_SUCCESSFULL = "Group updated successfully.";
    public final static String GROUP_DELETE_SUCCESSFULL = "Group deleted successfully.";
    
    public final static String USER_PASSWORD_SETUP_SUCCESSFULL = "Your Password has been set. Please Login to continue.";
    public final static String USER_PASSWORD_SETUP_FAILURE = "There is some issue while setting up your password. Please try again later.";
    public static final String USER_PASSWORD_CHANGE_SUCCESSFULL = "Your Password has been changed.";
    public static final String USERNAME_ALREADY_PRESENT = "Username already present. Please try different Username.";
    public static final String VALID_USERNAME = "Username is valid";
    public static final String ALL_DATA_MANDATORY = "All data are mandatory for registration.";
    public static final String CURRENT_PASSWORD_WRONG = "Current Password does not match.";

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
     */
    public final static int AUTH_FAILED = 401;
    public final static String AUTH_FAILED_MSG = "Authentication Failed";
    public final static String AUTH_SUCCESS_MSG = "Authentication Successfull";
    
    /* User Sign-up Request Status */
    public final static String OPEN = "O";
    public final static String ACTIVE = "A";
    public final static String REJECTED = "R";
    
    /* User Status */
    public final static String USER_IN_PROGRESS = "I";
    public final static String USER_ACTIVE = "A";
    
    /* Encryption Logic Key */
    public static final String encrypterPassValue = "Unix11!";
    
    
    /*SEND Email Configurations*/
    public static final String EMAIL_SEND_FROM = "CricketPortalDevOGS@amdocs.com";
    public static final String SETUP_PASSWORD_EMAIL_SUBJECT = "PSO | Setup Password";
    public static final String REJECT_USER_EMAIL_SUBJECT = "PSO | Registration request rejected.";
    public static final String PSO_SETUP_PASSWORD_URL = "http://localhost:8081/PSOMaster/#/setupUserPassword";
    public static final String SETUP_PASSWORD_EMAIL_CONTENT = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'><meta name='viewport' content='width=device-width'><title></title></head><body> <span class='preheader'></span> <table class='body'>        <tr>            <td class='center' align='center' valign='top'>             <center data-parsed=''>                 <style type='text/css' align='center' class='float-center'>                 body, html, .body {                     background: #f3f3f3 !important;                 }                   </style>                    <table align='center' class='container float-center'>                       <tbody>                         <tr>                                <td>                                    <table class='spacer'>                                      <tbody>                                         <tr>                                                <td height='16px'                                                   style='font-size: 16px; line-height: 16px;'>&#xA0;</td>                                         </tr>                                       </tbody>                                    </table>                                    <table>                                     <tr>                                            <th>                                                <h1>PSO</h1>                                                <p>Congratulations! Your request has been approved. Please setup your                                                   password using below details which you used during                                                  Signup.</p>                                             <table class='spacer'>                                                  <tbody>                                                     <tr>                                                            <td height='16px'                                                               style='font-size: 16px; line-height: 16px;'>&#xA0;</td>                                                     </tr>                                                   </tbody>                                                </table>                                                <hr>                                            </th>                                       </tr>                                   </table>                                                                        <h4>User Details</h4>                                   <table>                                     <tbody>                                         <tr>                                                <td>Name : </td>                                                <td>#USER_NAME#</td>                                            </tr>                                           <tr>                                                <td>Employee ID : </td>                                             <td>#EMP_ID#</td>                                           </tr>                                           <tr>                                                <td>Email ID : </td>                                                <td>#EMAIL_ID#</td>                                         </tr>                                           <tr>                                                <td>Temporary Password : </td>                                              <td>#TEMP_PASSWORD#</td>                                            </tr>                                       </tbody>                                    </table>                                                                        <h4>User this link : <a href='#SETUP_PASSWORD_URL#' target='_blank'>Setup Password</a></h4>                             </td>                           </tr>                       </tbody>                    </table>                </center>           </td>       </tr>   </table>    </body></html>";
    public static final String REJECT_USER_EMAIL_CONTENT = "<html><head>    <meta http-equiv='Content-Type' content='text/html; charset=utf-8'>    <meta name='viewport' content='width=device-width'>    <title></title></head><body> <span class='preheader'></span>    <table class='body'>        <tr>            <td class='center' align='center' valign='top'>                <center data-parsed=''>                    <style type='text/css' align='center' class='float-center'>                        body,                        html,                        .body {                            background: #f3f3f3 !important;                        }                    </style>                    <table align='center' class='container float-center'>                        <tbody>                            <tr>                                <td>                                    <table class='spacer'>                                        <tbody>                                            <tr>                                                <td height='16px' style='font-size: 16px; line-height: 16px;'>&#xA0;</td>                                            </tr>                                        </tbody>                                    </table>                                    <table>                                        <tr>                                            <th>                                                <h1>PSO</h1>                                                <p>Your request has been rejected by #USER_NAME#</p>                                                <table class='spacer'>                                                    <tbody>                                                        <tr>                                                            <td height='16px' style='font-size: 16px; line-height: 16px;'>&#xA0;</td>                                                        </tr>                                                    </tbody>                                                </table>                                              </th>                                        </tr>                                    </table>                                    <table>                                        <tbody>                                            <tr>                                                <td>Reject Reason : </td>                                                <td>#REJECT_REASON#</td>                                            </tr>                                        </tbody>                                    </table>                            </tr>                        </tbody>                    </table>                </center>            </td>        </tr>    </table></body></html>";
    
    
    /*Email template Keys*/
    public static final String EMAIL_TEMPLATE_EMPID = "#EMP_ID#";
    public static final String EMAIL_TEMPLATE_EMAILID = "#EMAIL_ID#";
    public static final String EMAIL_TEMPLATE_TEMP_PASSWORD = "#TEMP_PASSWORD#";
    public static final String EMAIL_TEMPLATE_SETUP_PW_URL = "#SETUP_PASSWORD_URL#";
    public static final String EMAIL_TEMPLATE_USERNAME = "##USER_NAME#";

}
