/************************************************************************************************************
 * Class Name :  StuckOrderDetailsResponse.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;



/**
 * 
 */
public class StuckOrderDetailsResponse {
	
	OSHFOrdersResponse oshfOrdersResponse;

	/**
	 * @return the oshfOrdersResponse
	 */
	public OSHFOrdersResponse getOshfOrdersResponse() {
		return oshfOrdersResponse;
	}

	/**
	 * @param oshfOrdersResponse the oshfOrdersResponse to set
	 */
	public void setOshfOrdersResponse(OSHFOrdersResponse oshfOrdersResponse) {
		this.oshfOrdersResponse = oshfOrdersResponse;
	}

	
}
