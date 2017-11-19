/************************************************************************************************************
 * Class Name :  OSHFMultiLineResponse.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class OSHFMultiLineResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2302612452312189102L;
	private String orderId;
	private String imei;
	private String sim;
	private String scac;
	private String esn;
	private String order_track_no;
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	/**
	 * @return the sim
	 */
	public String getSim() {
		return sim;
	}
	/**
	 * @param sim the sim to set
	 */
	public void setSim(String sim) {
		this.sim = sim;
	}
	/**
	 * @return the scac
	 */
	public String getScac() {
		return scac;
	}
	/**
	 * @param scac the scac to set
	 */
	public void setScac(String scac) {
		this.scac = scac;
	}
	/**
	 * @return the esn
	 */
	public String getEsn() {
		return esn;
	}
	/**
	 * @param esn the esn to set
	 */
	public void setEsn(String esn) {
		this.esn = esn;
	}
	/**
	 * @return the order_track_no
	 */
	public String getOrder_track_no() {
		return order_track_no;
	}
	/**
	 * @param order_track_no the order_track_no to set
	 */
	public void setOrder_track_no(String order_track_no) {
		this.order_track_no = order_track_no;
	}
	
	
	

}
