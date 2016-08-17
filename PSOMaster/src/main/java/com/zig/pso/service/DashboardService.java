/************************************************************************************************************
 * Class Name : StuckOrderDisplayManager.java Description: This interface contains methods for order related operations.
 * 
 * Author :  Date : July 31, 2016 
 ************************************************************************************************************/

package com.zig.pso.service;

import java.util.ArrayList;

import com.zig.pso.rest.bean.StuckOrdersCount;


public interface DashboardService
{
	
/**
 * @param OrderId
 * @return
 */
public ArrayList<StuckOrdersCount> getStuckOrderList();

public ArrayList<String> getStuckOrderList1(String status);
	
}