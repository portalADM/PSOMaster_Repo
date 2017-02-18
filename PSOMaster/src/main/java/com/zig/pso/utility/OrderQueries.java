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

    public static String getEnsembleOrderData()
    {
        return orderProp.getProperty("order.ensembleOrder");
    }

    public static String getApiOrderData()
    {
        return orderProp.getProperty("order.apiOrder");
    }

    public static String getstuckOrdersCount()
    {
        return orderProp.getProperty("order.stuckOrdersCount");
    }

    public static String getstuckOrdersbyStatus()
    {
        return orderProp.getProperty("order.stuckOrdersbyStatus");
    }

    public static String updateOrderStatus()
    {
        return orderProp.getProperty("order.updateOrderStatusQuerry");
    }

    public static String updateOrderSim()
    {
        return orderProp.getProperty("order.updateOrderSIMQuerry");
    }

    public static String updateOrderIMEI()
    {
        return orderProp.getProperty("order.updateOrderIMEIQuerry");
    }

    public static String updateOrderRetryCount()
    {
        return orderProp.getProperty("order.updateOrderRetryCountQuerry");
    }

    public static String updateOrderTrack()
    {
        return orderProp.getProperty("order.updateOrderTrackerQuerry");
    }

    public static String getUserDetails()
    {
        return orderProp.getProperty("order.getUserDetailsQuerry");
    }

    public static String getAPIRequest()
    {
        return orderProp.getProperty("order.getAPIRequest");
    }

    public static String getOrderHandled()
    {
        return orderProp.getProperty("order.handled");
    }

    public static String getstuckOrderStatusbyCount()
    {
        return orderProp.getProperty("order.stuckOrdersStatusbyCount");
    }

    public static String getPortalOrderDetails()
    {
        return orderProp.getProperty("order.getPortalOrderDetails");
    }

    public static String getOrderType()
    {
        return orderProp.getProperty("order.getOrderType");
    }

    public static String getOrderBANandCTN()
    {
        return orderProp.getProperty("order.getOrderBANandCTN");
    }

    public static String getEnrollment()
    {
        return orderProp.getProperty("order.getEnrollmentDetails");
    }
    
    public static String getPortalLineItemInfoSQL()
    {
        return orderProp.getProperty("order.getPortalLineItemInfo");
    }
    
    public static String getEnsLineItemInfoSQL()
    {
        return orderProp.getProperty("order.getEnsLineItemInfo");
    }
    
    public static String getPortalPortinInfoSQL()
    {
        return orderProp.getProperty("order.getPortalPortinDetails");
    }
    
    public static String getEnsPortinInfoSQL()
    {
        return orderProp.getProperty("order.getEnsPortinDetails");
    }
    
    public static String getPortalShipmentInfoSQL()
    {
        return orderProp.getProperty("order.getPortalShipmentDetails");
    }
    
    public static String getPortalStuckOrderBacklogInfoSQL()
    {
        return orderProp.getProperty("order.stuckOrderBacklogInLast10Days");
    }
    
    public static String getOrderLineSIMandIMEIDetailsSQL()
    {
        return orderProp.getProperty("order.getOrderLineSIMandIMEIDetails");
    }
    
    public static String getCreateTempTableForBulkUpdateSQL()
    {
        return orderProp.getProperty("order.createTempTableForBulkUpdate");
    }
    
    public static String getInsertBulkOrderInTempTableSQL()
    {
        return orderProp.getProperty("order.insertBulkOrderInTempTable");
    }
    
    public static String getReadTempTableforBulkOrderSQL()
    {
        return orderProp.getProperty("order.readTempTableforBulkOrder");
    }
    
}
