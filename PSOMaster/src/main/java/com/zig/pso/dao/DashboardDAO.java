/************************************************************************************************************
 * Class Name : DashboardDAO.java Description:
 * 
 * Author : Nilesh Patil Date : Aug 2, 2016 **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.List;

import com.zig.pso.rest.bean.RegOrderStatisticsDetailsOutput;
import com.zig.pso.rest.bean.RegularOrdersCount;
import com.zig.pso.rest.bean.StuckOrderBacklogDBResultsBean;
import com.zig.pso.rest.bean.StuckOrdersCount;

/**
 * 
 */
public interface DashboardDAO
{

    public List<StuckOrdersCount> getStuckOrderList();

    // public ArrayList<String> getStuckOrderList1();

    /**
     * @param status
     * @return
     */
    public List<String> getStuckOrderList1(String status);

    /**
     * @param status
     * @return
     */
    public List<StuckOrdersCount> getStuckOrderhandled();

    /**
     * @param status
     * @return
     */
    public List<StuckOrdersCount> getStuckOrderallStatus();

    public List<StuckOrderBacklogDBResultsBean> getStuckOrderBackloagDetails();

    /**
     * @return
     */
    public int getRegisteredOrdersCount(String type);

    public int getACTIorCNCLOrdersCount(String type);

    public int getOrdersCount(String type);

    public int getPrepurchaseOrdersCount();

    public int getByodOrdersCount();

    public int getSaveDeskOrdersCount();

    public List<RegularOrdersCount> getRegisteredOrdersCount(String fromDate, String toDate, String type);

    public List<RegularOrdersCount> getACTIorCNCLOrdersCount(String fromDate, String toDate, String type);

    public List<RegularOrdersCount> getSaveDeskOrdersCount(String fromDate, String toDate);

    public List<RegularOrdersCount> getPrepurchaseOrdersCount(String fromDate, String toDate);

    public List<RegularOrdersCount> getByodOrdersCount(String fromDate, String toDate);

    public List<RegularOrdersCount> getOrdersCount(String fromDate, String toDate, String type);
    
    public RegOrderStatisticsDetailsOutput getRegOrderStatistics();
}
