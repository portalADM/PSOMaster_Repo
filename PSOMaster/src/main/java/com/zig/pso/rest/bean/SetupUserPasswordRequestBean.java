/************************************************************************************************************
 * Class Name :  SetupUserPasswordRequestBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 18, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class SetupUserPasswordRequestBean implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 2629254893573400943L;
    private String empId;
    private String password;
    private String tempPassword;
    private String emailId;
    private String currentPassword;

    /**
     * 
     */
    public SetupUserPasswordRequestBean()
    {
        super();
    }
    /**
     * @param empId
     * @param password
     * @param tempPassword
     * @param emailId
     * @param currentPassword
     */
    public SetupUserPasswordRequestBean(String empId, String password, String tempPassword, String emailId, String currentPassword)
    {
        super();
        this.empId = empId;
        this.password = password;
        this.tempPassword = tempPassword;
        this.emailId = emailId;
        this.currentPassword = currentPassword;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currentPassword == null) ? 0 : currentPassword.hashCode());
        result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
        result = prime * result + ((empId == null) ? 0 : empId.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((tempPassword == null) ? 0 : tempPassword.hashCode());
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
        SetupUserPasswordRequestBean other = (SetupUserPasswordRequestBean) obj;
        if (currentPassword == null)
        {
            if (other.currentPassword != null)
                return false;
        }
        else if (!currentPassword.equals(other.currentPassword))
            return false;
        if (emailId == null)
        {
            if (other.emailId != null)
                return false;
        }
        else if (!emailId.equals(other.emailId))
            return false;
        if (empId == null)
        {
            if (other.empId != null)
                return false;
        }
        else if (!empId.equals(other.empId))
            return false;
        if (password == null)
        {
            if (other.password != null)
                return false;
        }
        else if (!password.equals(other.password))
            return false;
        if (tempPassword == null)
        {
            if (other.tempPassword != null)
                return false;
        }
        else if (!tempPassword.equals(other.tempPassword))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "SetupUserPasswordRequestBean [empId=" + empId + ", password=" + password + ", tempPassword=" + tempPassword + ", emailId=" + emailId + ", currentPassword=" + currentPassword + "]";
    }

    /**
     * @return the empId
     */
    public String getEmpId()
    {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId)
    {
        this.empId = empId;
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
     * @return the tempPassword
     */
    public String getTempPassword()
    {
        return tempPassword;
    }

    /**
     * @param tempPassword the tempPassword to set
     */
    public void setTempPassword(String tempPassword)
    {
        this.tempPassword = tempPassword;
    }

    /**
     * @return the emailId
     */
    public String getEmailId()
    {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    /**
     * @return the currentPassword
     */
    public String getCurrentPassword()
    {
        return currentPassword;
    }

    /**
     * @param currentPassword the currentPassword to set
     */
    public void setCurrentPassword(String currentPassword)
    {
        this.currentPassword = currentPassword;
    }
    
    
    
}
