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
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class CommonUtility
{
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
    
  
}
