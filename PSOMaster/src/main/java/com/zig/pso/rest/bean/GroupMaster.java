/************************************************************************************************************
 * Class Name :  GroupMaster.java
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
public class GroupMaster implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 3914336893361238450L;
    
    private int groupId;
    private String groupName;
    private String groupDesc;
    private int roleId;
    private String roleName;
    private String createdBy;
    /**
     * 
     */
    public GroupMaster()
    {
        super();
    }
    /**
     * @param groupId
     * @param groupName
     * @param groupDesc
     * @param roleId
     * @param roleName
     */
    public GroupMaster(int groupId, String groupName, String groupDesc, int roleId, String roleName)
    {
        super();
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDesc = groupDesc;
        this.roleId = roleId;
        this.roleName = roleName;
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
     * @return the groupName
     */
    public String getGroupName()
    {
        return groupName;
    }
    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }
    /**
     * @return the groupDesc
     */
    public String getGroupDesc()
    {
        return groupDesc;
    }
    /**
     * @param groupDesc the groupDesc to set
     */
    public void setGroupDesc(String groupDesc)
    {
        this.groupDesc = groupDesc;
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
     * @return the createdBy
     */
    public String getCreatedBy()
    {
        return createdBy;
    }
    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groupDesc == null) ? 0 : groupDesc.hashCode());
        result = prime * result + groupId;
        result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
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
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GroupMaster other = (GroupMaster) obj;
        if (groupDesc == null)
        {
            if (other.groupDesc != null)
                return false;
        }
        else if (!groupDesc.equals(other.groupDesc))
            return false;
        if (groupId != other.groupId)
            return false;
        if (groupName == null)
        {
            if (other.groupName != null)
                return false;
        }
        else if (!groupName.equals(other.groupName))
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
        return "GroupMaster [groupId=" + groupId + ", groupName=" + groupName + ", groupDesc=" + groupDesc + ", roleId=" + roleId + ", roleName=" + roleName + "]";
    }
    
    
    
    

}
