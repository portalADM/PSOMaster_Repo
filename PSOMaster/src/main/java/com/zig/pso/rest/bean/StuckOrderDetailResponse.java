/************************************************************************************************************
 * Class Name :  StuckOrderDetailResponse.java
 * Description:  
 * 
 * Author     :  Pankaj Chaudhary
 * Date       :  Aug 2, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.List;

/**
 * 
 */
public class StuckOrderDetailResponse extends BaseResponseBean{

	
	private List<StuckOrdersCount> stuckOrderList;

	/**
	 * @return the stuckOrderList
	 */
	public List<StuckOrdersCount> getStuckOrderList() {
		return stuckOrderList;
	}

	/**
	 * @param stuckOrderList the stuckOrderList to set
	 */
	public void setStuckOrderList(List<StuckOrdersCount> stuckOrderList) {
		this.stuckOrderList = stuckOrderList;
	}
	
	
}
