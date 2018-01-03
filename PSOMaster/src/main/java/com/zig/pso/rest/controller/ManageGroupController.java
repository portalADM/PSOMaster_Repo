/************************************************************************************************************
 * Class Name :  ManageGroupController.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 25, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.GroupMaster;
import com.zig.pso.rest.bean.RoleMaster;
import com.zig.pso.security.SecurityUtils;
import com.zig.pso.service.GroupService;

/**
 * 
 */
@Controller
public class ManageGroupController
{
    static final Logger logger = Logger.getLogger(ManageGroupController.class);
    
    @Autowired
    GroupService groupService;
    
    /**
     * This Method provides list of Roles
     */
    @RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
    public ResponseEntity<List<RoleMaster>> getRoleList()
    {
        PSOLoggerSrv.printDEBUG(logger,"ManageGroupController", "getRoleList", "");
        List<RoleMaster> roleList = groupService.getRoleList();
        
        return new ResponseEntity<List<RoleMaster>>(roleList, HttpStatus.OK);
    }
    
    /**
     * This Method provides list of Groups
     */
    @RequestMapping(value = "/getGroupList", method = RequestMethod.GET)
    public ResponseEntity<List<GroupMaster>> getGroupList()
    {
        PSOLoggerSrv.printDEBUG(logger,"ManageGroupController", "getRoleList", "");
        List<GroupMaster> groupList = groupService.getGroupList();
        
        return new ResponseEntity<List<GroupMaster>>(groupList, HttpStatus.OK);
    }
    
    /**
     * This Method will add new group
     */
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> addGroup(@RequestBody GroupMaster groupMaster, HttpServletRequest request)
    {
        String updateDetails = "Group ID : "+groupMaster.getGroupId()+" \nGroup Name : "+groupMaster.getGroupName()+" \nGroup Desc : "+groupMaster.getGroupDesc()+" \nRole Id : "+groupMaster.getRoleId()+" \nRole Name : "+groupMaster.getRoleName();
        PSOLoggerSrv.printDEBUG(logger,"ManageGroupController", "addGroup", "New Group Details : "+updateDetails);

        groupMaster.setCreatedBy(SecurityUtils.getCurrentLogin());
        
        BaseResponseBean addGroupResponse = new BaseResponseBean();
        addGroupResponse = groupService.addGroup(groupMaster);
        return new ResponseEntity<BaseResponseBean>(addGroupResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will update group
     */
    @RequestMapping(value = "/updateGroup", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> updateGroup(@RequestBody GroupMaster groupMaster)
    {
        String updateDetails = "Group ID : "+groupMaster.getGroupId()+" \nGroup Name : "+groupMaster.getGroupName()+" \nGroup Desc : "+groupMaster.getGroupDesc()+" \nRole Id : "+groupMaster.getRoleId()+" \nRole Name : "+groupMaster.getRoleName();
        PSOLoggerSrv.printDEBUG(logger,"ManageGroupController", "updateGroup", "update Details : "+updateDetails);

        groupMaster.setCreatedBy(SecurityUtils.getCurrentLogin());
        
        BaseResponseBean updateGroupResponse = new BaseResponseBean();
        updateGroupResponse = groupService.updateGroup(groupMaster);
        return new ResponseEntity<BaseResponseBean>(updateGroupResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will update group
     */
    @RequestMapping(value = "/deleteGroup/{id}", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> deleteGroup(@PathVariable("id") int groupId)
    {
        PSOLoggerSrv.printDEBUG(logger,"ManageGroupController", "deleteGroup", "Group ID : "+groupId);

        BaseResponseBean deleteGroupResponse = new BaseResponseBean();
        deleteGroupResponse = groupService.deleteGroup(groupId);
        return new ResponseEntity<BaseResponseBean>(deleteGroupResponse, HttpStatus.OK);
    }
    
}
