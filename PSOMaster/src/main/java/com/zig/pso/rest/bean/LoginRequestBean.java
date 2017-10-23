/************************************************************************************************************
 * Class Name : UpdateOrderRequestBean.java 
 * Description:
 * Author : Aniket Limaye 
 * Date : Aug 26, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class LoginRequestBean implements Serializable
{

    private static final long serialVersionUID = -7471045337689570704L;
    private String username;
    private String password;

    
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String Username)
    {
        this.username = Username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String Password)
    {
        this.password = Password;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		LoginRequestBean other = (LoginRequestBean) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginRequestBean [Username=" + username + ", Password="
				+ password + "]";
	}
    
    

}
