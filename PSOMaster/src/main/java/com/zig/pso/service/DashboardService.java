/************************************************************************************************************
 * Class Name : DashboardService.java Description: This interface contains methods for order related statistics for Dashboard page. Author : Nilesh Patil Date : July 31, 2016
 ************************************************************************************************************/

package com.zig.pso.service;

import java.util.List;

import com.zig.pso.rest.bean.DynamicGraphRequestBean;
import com.zig.pso.rest.bean.RegularOrdersCount;
import com.zig.pso.rest.bean.RegularOrdersCountList;
import com.zig.pso.rest.bean.StuckOrderBacklogUiResponseBean;
import com.zig.pso.rest.bean.StuckOrdersCount;

public interface DashboardService
{

    /**
     * @param OrderId
     * @return
     */
    public List<StuckOrdersCount> getStuckOrderList();

    public List<String> getStuckOrders(String status);

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

    public StuckOrderBacklogUiResponseBean getStuckOrderBacklogData();

    public List<RegularOrdersCount> getRegularOrderListData();

    public RegularOrdersCountList getDynamicOrderListData(DynamicGraphRequestBean dynamicGraphRequest);

}