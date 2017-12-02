/************************************************************************************************************
 * Class Name :  GroupDAO.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 25, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.List;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.GroupMaster;
import com.zig.pso.rest.bean.RoleMaster;

/**
 * 
 */
public interface GroupDAO
{
    public List<RoleMaster> getRoleList();
    
    public List<GroupMaster> getGroupList();
    
    public BaseResponseBean addGroup(GroupMaster group);
    
    public BaseResponseBean updateGroup(GroupMaster group);
    
    public BaseResponseBean deleteGroup(int groupId);
}
