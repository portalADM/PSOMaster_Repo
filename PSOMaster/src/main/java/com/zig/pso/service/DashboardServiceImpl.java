/************************************************************************************************************
 * Class Name : DashboardServiceImpl.java Description: This service provided response for Dashboard REST calls Author : Pankaj Chaudhary Date : Aug 2, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.DashboardDAO;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.DynamicGraphRequestBean;
import com.zig.pso.rest.bean.RegularOrdersCount;
import com.zig.pso.rest.bean.RegularOrdersCountList;
import com.zig.pso.rest.bean.StuckOrderBacklogDBResultsBean;
import com.zig.pso.rest.bean.StuckOrderBacklogUiResponseBean;
import com.zig.pso.rest.bean.StuckOrdersCount;

/**
 * 
 */
@Service
public class DashboardServiceImpl implements DashboardService
{
    @Autowired
    DashboardDAO dashboardDAO;

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getStuckOrderList()
     */
    @Override
    public ArrayList<StuckOrdersCount> getStuckOrderList()
    {
        PSOLoggerSrv.printDEBUG("DashboardServiceImpl", "getStuckOrderList", "");
        return dashboardDAO.getStuckOrderList();
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getStuckOrderList1(java.lang.String)
     */
    @Override
    public ArrayList<String> getStuckOrders(String status)
    {
        PSOLoggerSrv.printDEBUG("DashboardServiceImpl", "getStuckOrders", "status : " + "");
        return dashboardDAO.getStuckOrderList1(status);
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getStuckOrderList1(java.lang.String)
     */
    @Override
    public ArrayList<StuckOrdersCount> getStuckOrderhandled()
    {
        PSOLoggerSrv.printDEBUG("DashboardServiceImpl", "getStuckOrderhandled", "");
        return dashboardDAO.getStuckOrderhandled();
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getStuckOrderList1(java.lang.String)
     */
    @Override
    public ArrayList<StuckOrdersCount> getStuckOrderallStatus()
    {
        PSOLoggerSrv.printDEBUG("DashboardServiceImpl", "getStuckOrderallStatus", "");
        return dashboardDAO.getStuckOrderallStatus();
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.OrderInfoManagerService#getStuckOrderBacklogData()
     */
    @Override
    public StuckOrderBacklogUiResponseBean getStuckOrderBacklogData()
    {

        StuckOrderBacklogUiResponseBean response = new StuckOrderBacklogUiResponseBean();
        ArrayList<StuckOrderBacklogDBResultsBean> stuckOrderDbResults = dashboardDAO.getStuckOrderBackloagDetails();

        if (stuckOrderDbResults.size() > 0)
        {
            LinkedHashMap<String, List<StuckOrderBacklogDBResultsBean>> hashMap = new LinkedHashMap<String, List<StuckOrderBacklogDBResultsBean>>();
            List<String> dateList = new ArrayList<String>();
            for (StuckOrderBacklogDBResultsBean st : stuckOrderDbResults)
            {
                if (hashMap.containsKey(st.getOrderCreationDate()))
                    hashMap.get(st.getOrderCreationDate()).add(st);
                else
                {
                    List<StuckOrderBacklogDBResultsBean> listOfStatuses = new ArrayList<StuckOrderBacklogDBResultsBean>();
                    listOfStatuses.add(st);
                    dateList.add(st.getOrderCreationDate());
                    hashMap.put(st.getOrderCreationDate(), listOfStatuses);
                }
            }
            response.setBackLogList(hashMap);
            response.setDateList(dateList);
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getRegularOrderListData()
     */
    @Override
    public ArrayList<RegularOrdersCount> getRegularOrderListData()
    {
        PSOLoggerSrv.printDEBUG("DashboardServiceImpl", "getRegularOrderListData", "");
        ArrayList<RegularOrdersCount> regOrderCountList = new ArrayList<RegularOrdersCount>();

        int portInCount = dashboardDAO.getPortinOrdersCount();
        regOrderCountList.add(new RegularOrdersCount("PORTIN", portInCount));

        int byodCount = dashboardDAO.getByodOrdersCount();
        regOrderCountList.add(new RegularOrdersCount("BYOD", byodCount));

        int prepurchaseCount = dashboardDAO.getPrepurchaseOrdersCount();
        regOrderCountList.add(new RegularOrdersCount("PRE-PURCHASE", prepurchaseCount));

        int saveDeskCount = dashboardDAO.getSaveDeskOrdersCount();
        regOrderCountList.add(new RegularOrdersCount("SAVEDESK", saveDeskCount));

        int activeCount = dashboardDAO.getACTIorCNCLOrdersCount("ACTIVE");
        regOrderCountList.add(new RegularOrdersCount("ACTIVATION", activeCount));

        int cancelCount = dashboardDAO.getACTIorCNCLOrdersCount("CANCEL");
        regOrderCountList.add(new RegularOrdersCount("CANCELLATION", cancelCount));

        int addlineCount = dashboardDAO.getRegisteredOrdersCount("ADDLINE");
        regOrderCountList.add(new RegularOrdersCount("ADDLINE", addlineCount));

        int upgradeCount = dashboardDAO.getRegisteredOrdersCount("UPGRADE");
        regOrderCountList.add(new RegularOrdersCount("UPGRADE", upgradeCount));

        int simSwapCount = dashboardDAO.getRegisteredOrdersCount("SIMSWAP");
        regOrderCountList.add(new RegularOrdersCount("SIM_SWAP", simSwapCount));
        return regOrderCountList;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getDynamicOrderListData()
     */
    @Override
    public RegularOrdersCountList getDynamicOrderListData(DynamicGraphRequestBean dynamicGraphRequest)
    {
        PSOLoggerSrv.printDEBUG("DashboardServiceImpl", "getDynamicOrderListData", "");
        RegularOrdersCountList dynOrderCountList = new RegularOrdersCountList();
        ArrayList<RegularOrdersCount> dynamicOrdersCountList = new ArrayList<RegularOrdersCount>();

        if ("PORTIN".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getPortinOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate());
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("BYOD".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getByodOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate());
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("PRE-PURCHASE".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getPrepurchaseOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate());
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("SAVEDESK".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getSaveDeskOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate());
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("ACTIVATION".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getACTIorCNCLOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate(), "ACTI");
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("CANCELLATION".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getACTIorCNCLOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate(), "CNCL");
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("ADDLINE".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getRegisteredOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate(), "100");
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("UPGRADE".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getRegisteredOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate(), "200");
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("SIMSWAP".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getRegisteredOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate(), "300");
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }

        /*
         * int byodCount = dashboardDAO.getByodOrdersCount(); dynOrderCountList.add(new RegularOrdersCount("BYOD", byodCount)); int prepurchaseCount = dashboardDAO.getPrepurchaseOrdersCount();
         * dynOrderCountList.add(new RegularOrdersCount("PRE-PURCHASE", prepurchaseCount)); int saveDeskCount = dashboardDAO.getSaveDeskOrdersCount(); dynOrderCountList.add(new
         * RegularOrdersCount("SAVEDESK", saveDeskCount)); int activeCount = dashboardDAO.getACTIorCNCLOrdersCount("ACTIVE"); dynOrderCountList.add(new RegularOrdersCount("ACTIVATION", activeCount));
         * int cancelCount = dashboardDAO.getACTIorCNCLOrdersCount("CANCEL"); dynOrderCountList.add(new RegularOrdersCount("CANCELLATION", cancelCount)); int addlineCount =
         * dashboardDAO.getRegisteredOrdersCount("ADDLINE"); dynOrderCountList.add(new RegularOrdersCount("ADDLINE", addlineCount)); int upgradeCount =
         * dashboardDAO.getRegisteredOrdersCount("UPGRADE"); dynOrderCountList.add(new RegularOrdersCount("UPGRADE", upgradeCount)); int simSwapCount =
         * dashboardDAO.getRegisteredOrdersCount("SIMSWAP"); dynOrderCountList.add(new RegularOrdersCount("SIM_SWAP", simSwapCount));
         */
        return dynOrderCountList;
    }

}
