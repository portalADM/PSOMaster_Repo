/************************************************************************************************************
 * Class Name :  AllowdedUpdatesResponseBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jan 28, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.List;

/**
 * 
 */
public class AllowedUpdatesResponseBean extends BaseResponseBean{

	private List<String> availableUpdates;
	private List<String> restrictedUpdates;
	/**
	 * 
	 */
	public AllowedUpdatesResponseBean() {
		super();
	}
	/**
	 * @param availableUpdates
	 * @param restrictedUpdates
	 */
	public AllowedUpdatesResponseBean(List<String> availableUpdates,
			List<String> restrictedUpdates) {
		super();
		this.availableUpdates = availableUpdates;
		this.restrictedUpdates = restrictedUpdates;
	}
	/**
	 * @return the availableUpdates
	 */
	public List<String> getAvailableUpdates() {
		return availableUpdates;
	}
	/**
	 * @param availableUpdates the availableUpdates to set
	 */
	public void setAvailableUpdates(List<String> availableUpdates) {
		this.availableUpdates = availableUpdates;
	}
	/**
	 * @return the restrictedUpdates
	 */
	public List<String> getRestrictedUpdates() {
		return restrictedUpdates;
	}
	/**
	 * @param restrictedUpdates the restrictedUpdates to set
	 */
	public void setRestrictedUpdates(List<String> restrictedUpdates) {
		this.restrictedUpdates = restrictedUpdates;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((availableUpdates == null) ? 0 : availableUpdates.hashCode());
		result = prime
				* result
				+ ((restrictedUpdates == null) ? 0 : restrictedUpdates
						.hashCode());
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
		if (null!=obj && getClass() != obj.getClass())
			return false;
		AllowedUpdatesResponseBean other = (AllowedUpdatesResponseBean) obj;
		if (availableUpdates == null) {
			if (null!=other && other.availableUpdates != null)
				return false;
		} else if (null!=other && !availableUpdates.equals(other.availableUpdates))
			return false;
		if (restrictedUpdates == null) {
			if (null!=other && other.restrictedUpdates != null)
				return false;
		} else if (!restrictedUpdates.equals(other.restrictedUpdates))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AllowdedUpdatesResponseBean [availableUpdates="
				+ availableUpdates + ", restrictedUpdates=" + restrictedUpdates
				+ "]";
	}
	
	
	
	
}
