/************************************************************************************************************
 * Class Name :  PortalOrderStatusResponseBean.java
 * Description:  
 * 
 * Author     :  Pankaj Chaudhary
 * Date       :  Jul 31, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
@SuppressWarnings("serial")
public class StuckOrdersCount  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5979003604712056315L;
	private String orderStatus;
	private int count;
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + count;
		result = prime * result
				+ ((orderStatus == null) ? 0 : orderStatus.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StuckOrdersCount other = (StuckOrdersCount) obj;
		if (count != other.count)
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StuckOrdersCount [orderStatus=" + orderStatus + ", count="
				+ count + "]";
	} 
	
	
	
	
}
