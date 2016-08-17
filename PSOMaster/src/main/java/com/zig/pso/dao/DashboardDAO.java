/************************************************************************************************************
 * Class Name :  DashboardDAO.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Aug 2, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.ArrayList;

import com.zig.pso.rest.bean.StuckOrdersCount;

/**
 * 
 */
public interface DashboardDAO {

	
	 public ArrayList<StuckOrdersCount> getStuckOrderList();
	 
	 //public ArrayList<String> getStuckOrderList1();

	/**
	 * @param status
	 * @return
	 */
	public ArrayList<String> getStuckOrderList1(String status);
}
