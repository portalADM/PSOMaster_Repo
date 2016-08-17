/************************************************************************************************************
 * Class Name :  StuckOrderDetailResponse.java
 * Description:  
 * 
 * Author     :  Pankaj Chaudhary
 * Date       :  Aug 2, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.ArrayList;

/**
 * 
 */
public class StuckOrderDetailResponse extends BaseResponseBean{

	
	public ArrayList<StuckOrdersCount> stuckOrderList;

	/**
	 * @return the stuckOrderList
	 */
	public ArrayList<StuckOrdersCount> getStuckOrderList() {
		return stuckOrderList;
	}

	/**
	 * @param stuckOrderList the stuckOrderList to set
	 */
	public void setStuckOrderList(ArrayList<StuckOrdersCount> stuckOrderList) {
		this.stuckOrderList = stuckOrderList;
	}
	
	
}
