/************************************************************************************************************
 * Class Name :  DashboardServiceImpl.java
 * Description:  
 * 
 * Author     :  Pankaj Chaudhary
 * Date       :  Aug 2, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.DashboardDAO;
import com.zig.pso.rest.bean.StuckOrdersCount;

/**
 * 
 */
@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	DashboardDAO dashboardDAO;
	
	
	
	/* (non-Javadoc)
	 * @see com.zig.pso.service.DashboardService#getStuckOrderList()
	 */
	@Override
	public ArrayList<StuckOrdersCount> getStuckOrderList() {
	        return dashboardDAO.getStuckOrderList();
	}



	/* (non-Javadoc)
	 * @see com.zig.pso.service.DashboardService#getStuckOrderList1(java.lang.String)
	 */
	@Override
	public ArrayList<String> getStuckOrderList1(String status) {
		// TODO Auto-generated method stub
		return dashboardDAO.getStuckOrderList1(status);
	}

}
