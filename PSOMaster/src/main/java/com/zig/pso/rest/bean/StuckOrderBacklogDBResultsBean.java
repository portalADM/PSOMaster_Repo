/************************************************************************************************************
 * Class Name :  StuckOrderBacklogDBResultsBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jan 18, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

/**
 * 
 */
public class StuckOrderBacklogDBResultsBean{

	private String orderCreationDate;
	private String statusCode;
	private int count;
	/**
	 * 
	 */
	public StuckOrderBacklogDBResultsBean() {
		super();
	}
	/**
	 * @param orderCreationDate
	 * @param statusCode
	 * @param count
	 */
	public StuckOrderBacklogDBResultsBean(String orderCreationDate,
			String statusCode, int count) {
		super();
		this.orderCreationDate = orderCreationDate;
		this.statusCode = statusCode;
		this.count = count;
	}
	/**
	 * @return the orderCreationDate
	 */
	public String getOrderCreationDate() {
		return orderCreationDate;
	}
	/**
	 * @param orderCreationDate the orderCreationDate to set
	 */
	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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
		int result = 1;
		result = prime * result + count;
		result = prime
				* result
				+ ((orderCreationDate == null) ? 0 : orderCreationDate
						.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
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
		StuckOrderBacklogDBResultsBean other = (StuckOrderBacklogDBResultsBean) obj;
		if (count != other.count)
			return false;
		if (orderCreationDate == null) {
			if (other.orderCreationDate != null)
				return false;
		} else if (!orderCreationDate.equals(other.orderCreationDate))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StuckOrderBacklogDBResultsBean [orderCreationDate="
				+ orderCreationDate + ", statusCode=" + statusCode + ", count="
				+ count + "]";
	}
	
	
	
}
