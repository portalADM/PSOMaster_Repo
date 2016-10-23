/************************************************************************************************************
 * Class Name : DashboardServiceImpl.java 
 * Description: This service provided response for Dashboard REST calls
 * Author : Pankaj Chaudhary 
 * Date : Aug 2, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.DashboardDAO;
import com.zig.pso.logging.PSOLoggerSrv;
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

}
