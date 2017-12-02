/************************************************************************************************************
 * Class Name : OrderQueries.java 
 * Description: This class provides the SQL queries for database operations.
 * 
 * Author : Nilesh Patil 
 * Date : Jun 26, 2016 
 ---------------------------------
 * Modified by : Pankaj Chaudhary
 * Date : Nov 21, 2017 
 * **********************************************************************************************************
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

    // segregationOfOrders
    public static String getstuckOrdersbySingleLine()
    {
        return orderProp.getProperty("order.stuckOrdersbySingleLine");
    }

    public static String getstuckOrdersbyMultiLine()
    {
        return orderProp.getProperty("order.stuckOrdersbyMultiLine");
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

    public static String getAPIResponse()
    {
        return orderProp.getProperty("order.getAPIResponse");
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

    public static String getCurrentStatusSQL()
    {
        return orderProp.getProperty("order.getCurrentStatus");
    }

    public static String getCurrentSIMSQL()
    {
        return orderProp.getProperty("order.getCurrentSIMValue");
    }

    public static String getCurrentIMEISQL()
    {
        return orderProp.getProperty("order.getCurrentIMEIValue");
    }

    public static String getCurrentRetrySQL()
    {
        return orderProp.getProperty("order.getCurrentRetryCount");
    }

    public static String getRegisteredOrderCount()
    {
        return orderProp.getProperty("order.registeredOrderCount");
    }

    public static String getRegOrderCount()
    {
        return orderProp.getProperty("order.regOrderCount");
    }

    public static String getPrepurchaseOrderCount()
    {
        return orderProp.getProperty("order.regPrepurchaseOrderCount");
    }

    public static String getByodOrderCount()
    {
        return orderProp.getProperty("order.regByodOrderCount");
    }

    public static String getSaveDeskOrderCount()
    {
        return orderProp.getProperty("order.regSaveDeskOrderCount");
    }

    public static String getACTIorCNCLOrderCount()
    {
        return orderProp.getProperty("order.getACTIorCNCLOrderCount");
    }

    public static String getDynRegisteredOrderCount()
    {
        return orderProp.getProperty("order.dynRegOrderCount");
    }

    public static String getDynOrderCount()
    {
        return orderProp.getProperty("order.dynOrderCount");
    }

    public static String getDynPrepurchaseOrderCount()
    {
        return orderProp.getProperty("order.dynPrepurchaseOrderCount");
    }

    public static String getDynByodOrderCount()
    {
        return orderProp.getProperty("order.dynByodOrderCount");
    }

    public static String getDynSaveDeskOrderCount()
    {
        return orderProp.getProperty("order.dynSaveDeskOrderCount");
    }

    public static String getDynACTIorCNCLOrderCount()
    {
        return orderProp.getProperty("order.dynACTIorCNCLOrderCount");
    }

    public static String getDeleteRemediationStep()
    {
        return orderProp.getProperty("order.deleteRemediationStep");
    }

    public static String getInsertRemediationStep()
    {
        return orderProp.getProperty("order.insertRemediationStep");
    }

    public static String getOrderStatusList()
    {
        return orderProp.getProperty("order.getOrderStatusList");
    }
    
    public static String getRoleList()
    {
        return orderProp.getProperty("order.getRoleList");
    }
    
    public static String getGroupList()
    {
        return orderProp.getProperty("order.getGroupList");
    }
    
    public static String addNewGroup()
    {
        return orderProp.getProperty("order.addGroup");
    }
    
    public static String updateGroup()
    {
        return orderProp.getProperty("order.updateGroup");
    }
    
    public static String deleteGroup()
    {
        return orderProp.getProperty("order.deleteGroup");
    }
    
    public static String addNewUserSignUpQuery()
    {
        return orderProp.getProperty("user.addNewUserSignUpRequest");
    }
    
    public static String pendingUserList()
    {
        return orderProp.getProperty("user.pendingUserList");
    }
    
    public static String rejectUser()
    {
        return orderProp.getProperty("user.rejectUserRequest");
    }
    
    public static String getPendingUserDataByEmpId()
    {
        return orderProp.getProperty("user.getPendingUserDataByEmpId");
    }
    
    public static String doUserAssignmentsQuery()
    {
        return orderProp.getProperty("user.doUserAssigment");
    }
    
    public static String updateUserAssignmentsQuery()
    {
        return orderProp.getProperty("user.updateUserAssignment");
    }

    public static String getUserListQuery()
    {
        return orderProp.getProperty("user.getUserList");
    }

    public static String getUserDataByEmpId()
    {
        return orderProp.getProperty("user.getUserDataByEmpId");
    }

    public static String getDeletePendingUserReqQuery()
    {
        return orderProp.getProperty("user.deletePendingUserReqQuery");
    }

    public static String getauthenticateUserQuery()
    {
        return orderProp.getProperty("user.authenticateUser");
    }

    public static String getUserByUsernameForAuthentication()
    {
        return orderProp.getProperty("user.getUserByUsernameForAuthentication");
    }

    public static String getSetupPasswordQuery()
    {
        return orderProp.getProperty("user.setupUserPassword");
    }

    public static String getInventoryStatus()
    {
        return orderProp.getProperty("order.getInventoryStatus");
    }

    public static String getESNReuseData()
    {
        return orderProp.getProperty("order.getESNReuseData");
    }

    public static String getUpholdLevel()
    {
        return orderProp.getProperty("order.getUpholdLevel");
    }

    public static String getCheckUsername()
    {
        return orderProp.getProperty("user.checkUsername");
    }

    public static String getChangePasswordQuery()
    {
        return orderProp.getProperty("user.changePassword");
    }

    public static String getCurrentPasswordQuery()
    {
        return orderProp.getProperty("user.getCurrentPassword");
    }
    
    public static String getNameOfCustomerQuery()
    {
        return orderProp.getProperty("order.getNameOfCustomer");
    }
    
    public static String getNameForCustomerQuery()
    {
        return orderProp.getProperty("order.getNameForCustomer");
    }

}
