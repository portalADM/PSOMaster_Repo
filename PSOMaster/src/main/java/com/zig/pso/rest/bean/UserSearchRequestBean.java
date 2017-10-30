/************************************************************************************************************
 * Class Name :  UserSearchRequestBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 29, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class UserSearchRequestBean implements Serializable
{
    private static final long serialVersionUID = 3089461506488436618L;
    
    private int groupId;
    private int roleId;
    private String company;
    private String empId;
    /**
     * 
     */
    public UserSearchRequestBean()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @param groupId
     * @param roleId
     * @param company
     * @param empId
     */
    public UserSearchRequestBean(int groupId, int roleId, String company, String empId)
    {
        super();
        this.groupId = groupId;
        this.roleId = roleId;
        this.company = company;
        this.empId = empId;
    }
    /**
     * @return the groupId
     */
    public int getGroupId()
    {
        return groupId;
    }
    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }
    /**
     * @return the roleId
     */
    public int getRoleId()
    {
        return roleId;
    }
    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }
    /**
     * @return the company
     */
    public String getCompany()
    {
        return company;
    }
    /**
     * @param company the company to set
     */
    public void setCompany(String company)
    {
        this.company = company;
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
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((empId == null) ? 0 : empId.hashCode());
        result = prime * result + groupId;
        result = prime * result + roleId;
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
        UserSearchRequestBean other = (UserSearchRequestBean) obj;
        if (company == null)
        {
            if (other.company != null)
                return false;
        }
        else if (!company.equals(other.company))
            return false;
        if (empId == null)
        {
            if (other.empId != null)
                return false;
        }
        else if (!empId.equals(other.empId))
            return false;
        if (groupId != other.groupId)
            return false;
        if (roleId != other.roleId)
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "UserSearchRequestBean [groupId=" + groupId + ", roleId=" + roleId + ", company=" + company + ", empId=" + empId + "]";
    }
    
    

}
