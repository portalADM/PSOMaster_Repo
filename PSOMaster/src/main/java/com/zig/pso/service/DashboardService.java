/************************************************************************************************************
 * Class Name : DashboardService.java 
 * Description: This interface contains methods for order related statistics for Dashboard page. 
 * Author : Nilesh Patil
 * Date : July 31, 2016
 ************************************************************************************************************/

package com.zig.pso.service;

import java.util.ArrayList;

import com.zig.pso.rest.bean.StuckOrdersCount;

public interface DashboardService
{

    /**
     * @param OrderId
     * @return
     */
    public ArrayList<StuckOrdersCount> getStuckOrderList();

    public ArrayList<String> getStuckOrders(String status);

    /**
     * @param status
     * @return
     */
    ArrayList<StuckOrdersCount> getStuckOrderhandled();

    /**
     * @param status
     * @return
     */
    ArrayList<StuckOrdersCount> getStuckOrderallStatus();

}