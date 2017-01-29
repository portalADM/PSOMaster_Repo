/************************************************************************************************************
 * Class Name :  BasicDataBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jan 21, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

/**
 * 
 */
public class BasicDataBean {
	
	private String code;
	private String value;
	/**
	 * 
	 */
	public BasicDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param code
	 * @param value
	 */
	public BasicDataBean(String code, String value) {
		super();
		this.code = code;
		this.value = value;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		BasicDataBean other = (BasicDataBean) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BasicDataBean [code=" + code + ", value=" + value + "]";
	}
	
	
	
}
