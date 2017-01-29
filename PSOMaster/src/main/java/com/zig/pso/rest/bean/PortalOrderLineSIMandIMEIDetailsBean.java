/************************************************************************************************************
 * Class Name :  PortalOrderLineSIMandIMEIDetailsBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jan 28, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.ArrayList;

/**
 * 
 */
public class PortalOrderLineSIMandIMEIDetailsBean extends BaseResponseBean{

	private ArrayList<PortalShipmentInfo> portalLineSimandImeiList;

	/**
	 * 
	 */
	public PortalOrderLineSIMandIMEIDetailsBean() {
		super();
	}

	/**
	 * @param portalLineSimandImeiList
	 */
	public PortalOrderLineSIMandIMEIDetailsBean(
			ArrayList<PortalShipmentInfo> portalLineSimandImeiList) {
		super();
		this.portalLineSimandImeiList = portalLineSimandImeiList;
	}

	/**
	 * @return the portalLineSimandImeiList
	 */
	public ArrayList<PortalShipmentInfo> getPortalLineSimandImeiList() {
		return portalLineSimandImeiList;
	}

	/**
	 * @param portalLineSimandImeiList the portalLineSimandImeiList to set
	 */
	public void setPortalLineSimandImeiList(
			ArrayList<PortalShipmentInfo> portalLineSimandImeiList) {
		this.portalLineSimandImeiList = portalLineSimandImeiList;
	}
	
	
	
}
