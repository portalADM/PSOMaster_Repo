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
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.DashboardDAO;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BasicDataBean;
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
			Map<String, ArrayList<BasicDataBean>> statusDayWiseCountMap = new HashMap<String, ArrayList<BasicDataBean>>();
			
			ArrayList<String> dateListTemp = new ArrayList<String>();
			ArrayList<String> statusCodeListTemp = new ArrayList<String>();
			statusCodeListTemp.add("OSHF");
			statusCodeListTemp.add("ORFI");
			statusCodeListTemp.add("ORLF");
			statusCodeListTemp.add("ACTF");
			statusCodeListTemp.add("OURF");
			statusCodeListTemp.add("PDRF");
			statusCodeListTemp.add("PRTF");
			
			for(StuckOrderBacklogDBResultsBean st : stuckOrderDbResults)
			{
				if(!dateListTemp.contains(st.getOrderCreationDate()) && statusDayWiseCountMap.get(st.getOrderCreationDate())==null)
				{
					dateListTemp.add(st.getOrderCreationDate());
					ArrayList<BasicDataBean> statusList = new ArrayList<BasicDataBean>();
					statusList.add( new BasicDataBean(st.getStatusCode(), String.valueOf(st.getCount())));
					statusDayWiseCountMap.put(st.getOrderCreationDate(),statusList);
				}
				else
				{
					ArrayList<BasicDataBean> statusList = statusDayWiseCountMap.get(st.getOrderCreationDate());
					statusList.add( new BasicDataBean(st.getStatusCode(), String.valueOf(st.getCount())));
				}
			}
			
			ArrayList<ArrayList<String>> finalDataList = new ArrayList<ArrayList<String>>();
			
			for(Map.Entry<String, ArrayList<BasicDataBean>> stMap :statusDayWiseCountMap.entrySet())
			{
				ArrayList<BasicDataBean> statusList = stMap.getValue();
				for(String stCode : statusCodeListTemp)
				{
					for(BasicDataBean countList : statusList)
					{
							
					}
					ArrayList<String> statusCountList = new ArrayList<String>();
				}
			}
			
		}
		
		return null;
	}

}
