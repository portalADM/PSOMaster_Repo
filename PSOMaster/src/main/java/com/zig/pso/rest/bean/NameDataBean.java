/************************************************************************************************************
 * Class Name :  NameDataBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 8, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class NameDataBean extends BaseResponseBean implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 6522539828242991471L;
	private String firstName;
	 private String lastName;
	 private String custId;
	 private String nameId;
	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * @return the nameId
	 */
	public String getNameId() {
		return nameId;
	}
	/**
	 * @param nameId the nameId to set
	 */
	public void setNameId(String nameId) {
		this.nameId = nameId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
