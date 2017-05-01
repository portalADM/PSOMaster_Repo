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
    private String Username;
    private String Password;

    
    public String getUsername()
    {
        return Username;
    }

    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
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
				+ ((Password == null) ? 0 : Password.hashCode());
		result = prime * result
				+ ((Username == null) ? 0 : Username.hashCode());
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
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginRequestBean [Username=" + Username + ", Password="
				+ Password + "]";
	}
    
    

}
