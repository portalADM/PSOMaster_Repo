/************************************************************************************************************
 * Class Name : DashboardDAO.java Description:
 * 
 * Author : Nilesh Patil Date : Aug 2, 2016 **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.ArrayList;

import com.zig.pso.rest.bean.RegularOrdersCount;
import com.zig.pso.rest.bean.StuckOrderBacklogDBResultsBean;
import com.zig.pso.rest.bean.StuckOrdersCount;

/**
 * 
 */
public interface DashboardDAO
{

    public ArrayList<StuckOrdersCount> getStuckOrderList();

    // public ArrayList<String> getStuckOrderList1();

    /**
     * @param status
     * @return
     */
    public ArrayList<String> getStuckOrderList1(String status);

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

    ArrayList<StuckOrderBacklogDBResultsBean> getStuckOrderBackloagDetails();

    /**
     * @return
     */
    public int getRegisteredOrdersCount(String type);

    public int getACTIorCNCLOrdersCount(String type);

    public int getPortinOrdersCount();

    public int getPrepurchaseOrdersCount();

    public int getByodOrdersCount();

    public int getSaveDeskOrdersCount();

    public ArrayList<RegularOrdersCount> getRegisteredOrdersCount(String fromDate, String toDate, String type);

    public ArrayList<RegularOrdersCount> getACTIorCNCLOrdersCount(String fromDate, String toDate, String type);

    public ArrayList<RegularOrdersCount> getSaveDeskOrdersCount(String fromDate, String toDate);

    public ArrayList<RegularOrdersCount> getPrepurchaseOrdersCount(String fromDate, String toDate);

    public ArrayList<RegularOrdersCount> getByodOrdersCount(String fromDate, String toDate);

    public ArrayList<RegularOrdersCount> getPortinOrdersCount(String fromDate, String toDate);
}
