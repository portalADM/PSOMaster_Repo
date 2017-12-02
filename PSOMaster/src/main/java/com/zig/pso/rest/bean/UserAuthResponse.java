/************************************************************************************************************
 * Class Name :  UserAuthResponse.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 21, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

/**
 * 
 */
public class UserAuthResponse extends BaseResponseBean{
	
	private String PSO_SESSION_TOKEN;
	private UserMaster user;
	
	/**
	 * 
	 */
	public UserAuthResponse() {
		super();
	}
	
	/**
	 * @param pSO_SESSION_TOKEN
	 * @param user
	 */
	public UserAuthResponse(String pSO_SESSION_TOKEN, UserMaster user) {
		super();
		PSO_SESSION_TOKEN = pSO_SESSION_TOKEN;
		this.user = user;
	}
	
	/**
	 * @return the pSO_SESSION_TOKEN
	 */
	public String getPSO_SESSION_TOKEN() {
		return PSO_SESSION_TOKEN;
	}
	
	/**
	 * @param pSO_SESSION_TOKEN the pSO_SESSION_TOKEN to set
	 */
	public void setPSO_SESSION_TOKEN(String pSO_SESSION_TOKEN) {
		PSO_SESSION_TOKEN = pSO_SESSION_TOKEN;
	}
	
	/**
	 * @return the user
	 */
	public UserMaster getUser() {
		return user;
	}
	
	/**
	 * @param user the user to set
	 */
	public void setUser(UserMaster user) {
		this.user = user;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((PSO_SESSION_TOKEN == null) ? 0 : PSO_SESSION_TOKEN
						.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserAuthResponse other = (UserAuthResponse) obj;
		if (PSO_SESSION_TOKEN == null) {
			if (other.PSO_SESSION_TOKEN != null)
				return false;
		} else if (null!=other && !PSO_SESSION_TOKEN.equals(other.PSO_SESSION_TOKEN))
			return false;
		if (user == null) {
			if (null!=other && other.user != null)
				return false;
		} else if (null!=other && !user.equals(other.user))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserAuthResponse [PSO_SESSION_TOKEN=" + PSO_SESSION_TOKEN
				+ ", user=" + user + "]";
	}
	
	

}
