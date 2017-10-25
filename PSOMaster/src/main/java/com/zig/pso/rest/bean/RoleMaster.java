/************************************************************************************************************
 * Class Name :  RoleMaster.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 25, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;


/**
 * 
 */
public class RoleMaster implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -8502848341280749855L;
    private int roleId;
    private String roleName;
    private String roleDesc;
    /**
     * 
     */
    public RoleMaster()
    {
        super();
    }
    /**
     * @param roleId
     * @param roleName
     * @param roleDesc
     */
    public RoleMaster(int roleId, String roleName, String roleDesc)
    {
        super();
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
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
     * @return the roleName
     */
    public String getRoleName()
    {
        return roleName;
    }
    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    /**
     * @return the roleDesc
     */
    public String getRoleDesc()
    {
        return roleDesc;
    }
    /**
     * @param roleDesc the roleDesc to set
     */
    public void setRoleDesc(String roleDesc)
    {
        this.roleDesc = roleDesc;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((roleDesc == null) ? 0 : roleDesc.hashCode());
        result = prime * result + roleId;
        result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        RoleMaster other = (RoleMaster) obj;
        if (roleDesc == null)
        {
            if (other.roleDesc != null)
                return false;
        }
        else if (!roleDesc.equals(other.roleDesc))
            return false;
        if (roleId != other.roleId)
            return false;
        if (roleName == null)
        {
            if (other.roleName != null)
                return false;
        }
        else if (!roleName.equals(other.roleName))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "RoleMaster [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
    }
    
    
    
}
