/************************************************************************************************************
 * Class Name :  UserMaster.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Apr 8, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class UserMaster implements Serializable
{
    private static final long serialVersionUID = 599983497115052464L;

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String userRole;
    /**
     * 
     */
    public UserMaster()
    {
        super();
    }
    /**
     * @param id
     * @param username
     * @param password
     * @param email
     * @param userRole
     */
    public UserMaster(Integer id, String username, String password, String email, String userRole)
    {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }
    /**
     * @return the id
     */
    public Integer getId()
    {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * @return the userRole
     */
    public String getUserRole()
    {
        return userRole;
    }
    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserMaster other = (UserMaster) obj;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (password == null)
        {
            if (other.password != null)
                return false;
        }
        else if (!password.equals(other.password))
            return false;
        if (userRole == null)
        {
            if (other.userRole != null)
                return false;
        }
        else if (!userRole.equals(other.userRole))
            return false;
        if (username == null)
        {
            if (other.username != null)
                return false;
        }
        else if (!username.equals(other.username))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "UserMaster [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", userRole=" + userRole + "]";
    }
    
    
    
}
