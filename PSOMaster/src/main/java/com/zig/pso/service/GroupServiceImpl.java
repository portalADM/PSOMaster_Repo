/************************************************************************************************************
 * Class Name :  GroupServiceImpl.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 25, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.GroupDAO;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.GroupMaster;
import com.zig.pso.rest.bean.RoleMaster;

/**
 * 
 */
@Service
public class GroupServiceImpl implements GroupService
{
    @Autowired
    GroupDAO groupDAO;
    
    /* (non-Javadoc)
     * @see com.zig.pso.service.GroupService#getRoleList()
     */
    @Override
    public ArrayList<RoleMaster> getRoleList()
    {
        return groupDAO.getRoleList();
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.GroupService#addGroup(com.zig.pso.rest.bean.GroupMaster)
     */
    @Override
    public BaseResponseBean addGroup(GroupMaster group)
    {
        return groupDAO.addGroup(group);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.GroupService#updateGroup(com.zig.pso.rest.bean.GroupMaster)
     */
    @Override
    public BaseResponseBean updateGroup(GroupMaster group)
    {
        return groupDAO.updateGroup(group);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.GroupService#getGroupList()
     */
    @Override
    public ArrayList<GroupMaster> getGroupList()
    {
        return groupDAO.getGroupList();
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.GroupService#deleteGroup(int)
     */
    @Override
    public BaseResponseBean deleteGroup(int groupId)
    {
        return groupDAO.deleteGroup(groupId);
    }

}
