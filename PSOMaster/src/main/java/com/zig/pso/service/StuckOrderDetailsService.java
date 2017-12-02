/************************************************************************************************************
 * Class Name :  StuckOrderDetailsService.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;


import com.zig.pso.rest.bean.StuckOrderDetailsResponse;

/**
 * 
 */
public interface StuckOrderDetailsService {
	
	public StuckOrderDetailsResponse getSegregatedOrders(String type);

}
