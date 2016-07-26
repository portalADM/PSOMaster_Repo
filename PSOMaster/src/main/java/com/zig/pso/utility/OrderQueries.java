/************************************************************************************************************
 * Class Name : OrderQueries.java Description: This class provides the SQL queries for database operations.
 * 
 * Author : Nilesh Patil Date : Jun 26, 2016 **********************************************************************************************************
 */
package com.zig.pso.utility;

import java.util.Properties;

public class OrderQueries
{
    private static Properties orderProp = null;

    static
    {
        orderProp = PropertyReader.getSqlProperties();
    }

    /**
     * @return the orderList
     */
    public static String getOrderList()
    {
        return orderProp.getProperty("order.orderlist");
    }

    public static String getPortalOrderData()
    {
        return orderProp.getProperty("order.portalOrder");
    }

    public static String getShipmentOrderData()
    {
        return orderProp.getProperty("order.shipOrder");
    }

    public static String getEnsembleOrderData()
    {
        return orderProp.getProperty("order.ensembleOrder");
    }
}
