/************************************************************************************************************
 * Class Name : CommonUtility.java 
 * Description: This class contains common utility methods for various usefull operations.
 * 
 * Author : Nilesh Patil
 * Date : Jul 18, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.utility;

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
	 * This method returns Reference ID for Logs. 
	 * Reference ID is 20 char String combination of Numbers and Characters.
	 */
    public static String getLogRefID()
    {
    	return RandomStringUtils.random(20, true, true);
    }
}
