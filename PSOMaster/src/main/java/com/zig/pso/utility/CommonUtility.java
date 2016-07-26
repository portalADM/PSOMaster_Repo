/************************************************************************************************************
 * Class Name : CommonUtility.java Description:
 * 
 * Author : Ankita Mishra Date : Jul 18, 2016 **********************************************************************************************************
 */
package com.zig.pso.utility;

import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class CommonUtility
{

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

        return orderType;
    }
}
