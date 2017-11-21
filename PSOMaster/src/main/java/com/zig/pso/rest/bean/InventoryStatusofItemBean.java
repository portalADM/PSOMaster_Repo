/************************************************************************************************************
 * Class Name :  InventoryStatusofItem.java
 * Description:  Bean to store Inventory details for a particular sku
 * 
 * Author     :  Pankaj Chaudhary
 * Date       :  Oct 27, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class InventoryStatusofItemBean extends BaseResponseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2049020351574475512L;
	 private String displayName;
	 private String availStatus;
	 private String stockLevel;
	 private String stockThresh;
	 private String stockStatus;
	/**
	 * @return the stockStatus
	 */
	public String getStockStatus() {
		return stockStatus;
	}
	/**
	 * @param stockStatus the stockStatus to set
	 */
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the availStatus
	 */
	public String getAvailStatus() {
		return availStatus;
	}
	/**
	 * @param availStatus the availStatus to set
	 */
	public void setAvailStatus(String availStatus) {
		this.availStatus = availStatus;
	}
	/**
	 * @return the stockLevel
	 */
	public String getStockLevel() {
		return stockLevel;
	}
	/**
	 * @param stockLevel the stockLevel to set
	 */
	public void setStockLevel(String stockLevel) {
		this.stockLevel = stockLevel;
	}
	/**
	 * @return the stockThresh
	 */
	public String getStockThresh() {
		return stockThresh;
	}
	/**
	 * @param stockThresh the stockThresh to set
	 */
	public void setStockThresh(String stockThresh) {
		this.stockThresh = stockThresh;
	}
	
}
