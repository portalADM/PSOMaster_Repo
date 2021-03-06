/************************************************************************************************************
 * Class Name : DashboardServiceImpl.java Description: This service provided response for Dashboard REST calls Author : Pankaj Chaudhary Date : Aug 2, 2016
 * *****************************************************************************************************************************************************************************************************
 * Description: added regular order count and dynamic graph Author : Ankita Mishra Date : Apr 08, 2017
 * *************************************************************************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.DashboardDAO;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.DynamicGraphRequestBean;
import com.zig.pso.rest.bean.RegOrderStatisticsDetailsOutput;
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
    static final Logger logger = Logger.getLogger(DashboardServiceImpl.class);
    
    @Autowired
    DashboardDAO dashboardDAO;

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getStuckOrderList()
     */
    @Override
    public List<StuckOrdersCount> getStuckOrderList()
    {
        PSOLoggerSrv.printDEBUG(logger, "DashboardServiceImpl", "getStuckOrderList", "");
        return dashboardDAO.getStuckOrderList();
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getStuckOrderList1(java.lang.String)
     */
    @Override
    public List<String> getStuckOrders(String status)
    {
        PSOLoggerSrv.printDEBUG(logger, "DashboardServiceImpl", "getStuckOrders", "status : " + status);
        return dashboardDAO.getStuckOrderList1(status);
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getStuckOrderList1(java.lang.String)
     */
    @Override
    public List<StuckOrdersCount> getStuckOrderhandled()
    {
        PSOLoggerSrv.printDEBUG(logger, "DashboardServiceImpl", "getStuckOrderhandled", "");
        return dashboardDAO.getStuckOrderhandled();
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getStuckOrderList1(java.lang.String)
     */
    @Override
    public List<StuckOrdersCount> getStuckOrderallStatus()
    {
        PSOLoggerSrv.printDEBUG(logger, "DashboardServiceImpl", "getStuckOrderallStatus", "");
        return dashboardDAO.getStuckOrderallStatus();
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.OrderInfoManagerService#getStuckOrderBacklogData()
     */
    @Override
    public StuckOrderBacklogUiResponseBean getStuckOrderBacklogData()
    {
        PSOLoggerSrv.printDEBUG(logger, "DashboardServiceImpl", "getStuckOrderBacklogData", "");
        StuckOrderBacklogUiResponseBean response = new StuckOrderBacklogUiResponseBean();
        List<StuckOrderBacklogDBResultsBean> stuckOrderDbResults = dashboardDAO.getStuckOrderBackloagDetails();

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
        PSOLoggerSrv.printDEBUG(logger, "DashboardServiceImpl", "getRegularOrderListData", "");
        ArrayList<RegularOrdersCount> regOrderCountList = new ArrayList<RegularOrdersCount>();

        int portInCount = dashboardDAO.getOrdersCount("PORTIN");
        regOrderCountList.add(new RegularOrdersCount("PORTIN", portInCount, "Order_Type"));

        int regularCount = dashboardDAO.getOrdersCount("REGULAR");
        regOrderCountList.add(new RegularOrdersCount("REGULAR", regularCount, "Order_Type"));

        int AccessoryCount = dashboardDAO.getOrdersCount("ACCESSORY");
        regOrderCountList.add(new RegularOrdersCount("ACCESSORY", AccessoryCount, "Order_Type"));

        int byodCount = dashboardDAO.getByodOrdersCount();
        regOrderCountList.add(new RegularOrdersCount("BYOD", byodCount, "FLOW_Type"));

        int prepurchaseCount = dashboardDAO.getPrepurchaseOrdersCount();
        regOrderCountList.add(new RegularOrdersCount("PRE-PURCHASE", prepurchaseCount, "FLOW_Type"));

        int saveDeskCount = dashboardDAO.getSaveDeskOrdersCount();
        regOrderCountList.add(new RegularOrdersCount("SAVEDESK", saveDeskCount, "FLOW_Type"));

        int activeCount = dashboardDAO.getACTIorCNCLOrdersCount("ACTIVE");
        regOrderCountList.add(new RegularOrdersCount("ACTIVATION", activeCount, "STATUS"));

        int cancelCount = dashboardDAO.getACTIorCNCLOrdersCount("CANCEL");
        regOrderCountList.add(new RegularOrdersCount("CANCELLATION", cancelCount, "STATUS"));

        int addlineCount = dashboardDAO.getRegisteredOrdersCount("ADDLINE");
        regOrderCountList.add(new RegularOrdersCount("ADDLINE", addlineCount, "SUB_FLOW"));

        int upgradeCount = dashboardDAO.getRegisteredOrdersCount("UPGRADE");
        regOrderCountList.add(new RegularOrdersCount("UPGRADE", upgradeCount, "SUB_FLOW"));

        int simSwapCount = dashboardDAO.getRegisteredOrdersCount("SIMSWAP");
        regOrderCountList.add(new RegularOrdersCount("SIM_SWAP", simSwapCount, "SUB_FLOW"));
        return regOrderCountList;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getDynamicOrderListData()
     */
    @Override
    public RegularOrdersCountList getDynamicOrderListData(DynamicGraphRequestBean dynamicGraphRequest)
    {
        PSOLoggerSrv.printDEBUG(logger, "DashboardServiceImpl", "getDynamicOrderListData", "");
        RegularOrdersCountList dynOrderCountList = new RegularOrdersCountList();
        List<RegularOrdersCount> dynamicOrdersCountList = new ArrayList<RegularOrdersCount>();

        if ("PORTIN".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate(), "100");
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("REGULAR".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate(), "200");
            dynOrderCountList.setRegularOrderList(dynamicOrdersCountList); // (new RegularOrdersCount("PORTIN", portInCount));
            dynOrderCountList.setType(dynamicGraphRequest.getType());
        }
        else if ("ACCESSORY".equals(dynamicGraphRequest.getType()))
        {
            dynamicOrdersCountList = dashboardDAO.getOrdersCount(dynamicGraphRequest.getFromDate(), dynamicGraphRequest.getToDate(), "300");
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
        return dynOrderCountList;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.DashboardService#getRegOrderStatistics()
     */
    @Override
    public ArrayList<RegularOrdersCount> getRegOrderStatistics()
    {
        
        ArrayList<RegularOrdersCount> regOrderCountList = new ArrayList<RegularOrdersCount>();
        
        RegOrderStatisticsDetailsOutput data = dashboardDAO.getRegOrderStatistics();
        regOrderCountList.add(new RegularOrdersCount("PORTIN", data.getPortinCount(), "Order_Type"));
        regOrderCountList.add(new RegularOrdersCount("REGULAR", data.getRegularCount(), "Order_Type"));
        regOrderCountList.add(new RegularOrdersCount("ACCESSORY", data.getAccessoryCount(), "Order_Type"));
        regOrderCountList.add(new RegularOrdersCount("BYOD", data.getByodCount(), "FLOW_Type"));
        regOrderCountList.add(new RegularOrdersCount("PRE-PURCHASE", data.getPrepurchaseCount(), "FLOW_Type"));
        regOrderCountList.add(new RegularOrdersCount("SAVEDESK", data.getSavedeskCount(), "FLOW_Type"));
        regOrderCountList.add(new RegularOrdersCount("ACTIVATION", data.getActivationCount(), "STATUS"));
        regOrderCountList.add(new RegularOrdersCount("CANCELLATION", data.getCancellationCount(), "STATUS"));
        regOrderCountList.add(new RegularOrdersCount("ADDLINE", data.getAddlineCount(), "SUB_FLOW"));
        regOrderCountList.add(new RegularOrdersCount("UPGRADE", data.getUpgradeCount(), "SUB_FLOW"));
        regOrderCountList.add(new RegularOrdersCount("SIM_SWAP", data.getSimswapCount(), "SUB_FLOW"));
        
        return regOrderCountList;
    }

}
