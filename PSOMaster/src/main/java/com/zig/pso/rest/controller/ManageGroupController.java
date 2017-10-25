/************************************************************************************************************
 * Class Name :  ManageGroupController.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 25, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import java.util.ArrayList;

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
import com.zig.pso.service.GroupService;
import com.zig.pso.service.UserSessionBean;

/**
 * 
 */
@Controller
public class ManageGroupController
{
    @Autowired
    GroupService groupService;
    
    @Autowired
    UserSessionBean userSession;

    /**
     * This Method provides list of Roles
     */
    @RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<RoleMaster>> getRoleList()
    {
        PSOLoggerSrv.printDEBUG("ManageGroupController", "getRoleList", "");
        ArrayList<RoleMaster> roleList = groupService.getRoleList();
        
        return new ResponseEntity<ArrayList<RoleMaster>>(roleList, HttpStatus.OK);
    }
    
    /**
     * This Method provides list of Groups
     */
    @RequestMapping(value = "/getGroupList", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<GroupMaster>> getGroupList()
    {
        PSOLoggerSrv.printDEBUG("ManageGroupController", "getRoleList", "");
        ArrayList<GroupMaster> groupList = groupService.getGroupList();
        
        return new ResponseEntity<ArrayList<GroupMaster>>(groupList, HttpStatus.OK);
    }
    
    /**
     * This Method will add new group
     */
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> addGroup(@RequestBody GroupMaster groupMaster)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        groupMaster.setCreatedBy("ADMIN");
        
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
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        groupMaster.setCreatedBy("ADMIN");
        
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
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        BaseResponseBean deleteGroupResponse = new BaseResponseBean();
        deleteGroupResponse = groupService.deleteGroup(groupId);
        return new ResponseEntity<BaseResponseBean>(deleteGroupResponse, HttpStatus.OK);
    }
    
}
