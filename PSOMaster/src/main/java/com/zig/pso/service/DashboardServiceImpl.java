/************************************************************************************************************
 * Class Name : DashboardServiceImpl.java 
 * Description: This service provided response for Dashboard REST calls
 * Author : Pankaj Chaudhary 
 * Date : Aug 2, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.DashboardDAO;
import com.zig.pso.logging.PSOLoggerSrv;
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
    
    /* (non-Javadoc)
	 * @see com.zig.pso.service.OrderInfoManagerService#getStuckOrderBacklogData()
	 */
	@Override
	public StuckOrderBacklogUiResponseBean getStuckOrderBacklogData() {
		
		ArrayList<StuckOrderBacklogDBResultsBean> stuckOrderDbResults = dashboardDAO.getStuckOrderBackloagDetails();
		
		if(stuckOrderDbResults.size()>0){
			
			String[] dateList = null;
			String[] statusCodes = null;
			String[][] stuckOrderCounts = null;
			HashMap<String, ArrayList<Integer>> statusDayWiseCount = new HashMap<String, ArrayList<Integer>>();
			
			ArrayList<String> dateListTemp = new ArrayList<String>();
			ArrayList<String> statusCodeListTemp = new ArrayList<String>();
			statusCodeListTemp.add("OSHF");
			statusCodeListTemp.add("ORFI");
			statusCodeListTemp.add("ORLF");
			statusCodeListTemp.add("ACTF");
			statusCodeListTemp.add("OURF");
			statusCodeListTemp.add("PDRF");
			statusCodeListTemp.add("PRTF");
			
			int dateIndex=0;
			for(StuckOrderBacklogDBResultsBean st : stuckOrderDbResults)
			{
				if(!dateListTemp.contains(st.getOrderCreationDate()))
					dateListTemp.add(st.getOrderCreationDate());
			}
			
			
			for(StuckOrderBacklogDBResultsBean st : stuckOrderDbResults)
			{
				for(String code :statusCodeListTemp)
				{
					if(statusDayWiseCount.get(code)!=null){
						statusDayWiseCount.get(code).add(st.getCount());
					}
					else{
						statusDayWiseCount.put(code, new ArrayList<Integer>());
						statusDayWiseCount.get(code).add(st.getCount());
					}
				}
			}
			
			
				
			
			
			System.out.println("test");
			
		}
		
		return null;
	}

}
