/************************************************************************************************************
 * Class Name :  OSHFSingleLineResponse.java
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
public class OSHFSingleLineResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8308322656746353429L;
	private String orderId;
	private String imei;
	private String scac;
	private String billOfLading;
	private String sim;
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
	 * @return the billOfLading
	 */
	public String getBillOfLading() {
		return billOfLading;
	}
	/**
	 * @param billOfLading the billOfLading to set
	 */
	public void setBillOfLading(String billOfLading) {
		this.billOfLading = billOfLading;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OSHFSingleLineResponse [orderId=" + orderId + ", imei=" + imei + ", scac=" + scac + ", billOfLading="
				+ billOfLading + ", sim=" + sim + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billOfLading == null) ? 0 : billOfLading.hashCode());
		result = prime * result + ((imei == null) ? 0 : imei.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((scac == null) ? 0 : scac.hashCode());
		result = prime * result + ((sim == null) ? 0 : sim.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OSHFSingleLineResponse other = (OSHFSingleLineResponse) obj;
		if (billOfLading == null) {
			if (other.billOfLading != null)
				return false;
		} else if (!billOfLading.equals(other.billOfLading))
			return false;
		if (imei == null) {
			if (other.imei != null)
				return false;
		} else if (!imei.equals(other.imei))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (scac == null) {
			if (other.scac != null)
				return false;
		} else if (!scac.equals(other.scac))
			return false;
		if (sim == null) {
			if (other.sim != null)
				return false;
		} else if (!sim.equals(other.sim))
			return false;
		return true;
	}
	
	
	
	
}
