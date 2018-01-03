/************************************************************************************************************
 * Class Name : CommonUtility.java 
 * Description: This class contains common utility methods for various usefull operations.
 * 
 * Author : Nilesh Patil
 * Date : Jul 18, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.utility;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.rest.bean.UserMaster;

/**
 * 
 */
@Service
public class CommonUtility
{

    private static final String[] ALLOWED_FILE_TYPES = {"application/excel","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"};
    
    /*
     * This method returns the Order Type
     */
    public String getOrderType(int type)
    {
        String orderType = null;

        if (type == 100)
        {
            orderType = "Device Order";
        }
        else if (type == 200)
        {
            orderType = "Accessory Order";
        }
        else if (type == 300)
        {
            orderType = "Byod Order";
        }
        else if (type == 400)
        {
            orderType = "SaveDesk Order";
        }
        else if (type == 500)
        {
            orderType = "MultiLine Order";
        }

        return orderType;
    }

    /*
     * This method returns Reference ID for Logs. Reference ID is 20 char String combination of Numbers and Characters.
     */
    public static String getLogRefID()
    {
        return RandomStringUtils.random(20, true, true);
    }

    /*
     * This method returns RANDOM name for temporary table for bulk update operation
     */
    public static String getTempTableName()
    {
        String tempTableName = "TEMP_BU_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
        return tempTableName;
    }

    /*
     * This method returns auto generated random numeric ID for Bulk update data. Reference ID is 10 char String combination of Numbers.
     */
    public static String getRandomBulkUpdateID()
    {
        // return RandomStringUtils.random(10, false, true);
        return RandomStringUtils.random(15, false, true);
    }

    /*
     * This method returns PSO_SESSION_TOKEN for Logs. PSO_SESSION_TOKEN is 25 char String combination of Numbers and Characters.
     */
    public static String getPSOSessionToken()
    {
        return RandomStringUtils.random(25, true, true);
    }

    /*
     * This method returns Temporary Password for Users. Temporary Password is 10 char String combination of Numbers and Characters.
     */
    public static String getTempPasswordForUsers()
    {
        return RandomStringUtils.random(10, true, true);
    }
    
    /*
     * This method will check if the uploaded file is valid type or not.
     */
    public static Boolean isValidContentType(String contentType) 
    {
        if (!Arrays.asList(ALLOWED_FILE_TYPES).contains(contentType)) {
            return false;
        }
        
        return true;
    }
    
    public static UserMaster getLoggedInUserDetails(HttpServletRequest request)
    {
        HttpSession sessoin = request.getSession();
        return ((sessoin.getAttribute(PSOConstants.SESSION_USER_DATA)!=null)?(UserMaster)sessoin.getAttribute(PSOConstants.SESSION_USER_DATA) : null);
    }
    
  
}
