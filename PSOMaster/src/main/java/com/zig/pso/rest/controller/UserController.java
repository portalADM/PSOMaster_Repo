/************************************************************************************************************
 * Class Name :  UserController.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 26, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.RejectPendingUserRequest;
import com.zig.pso.rest.bean.SetupUserPasswordRequestBean;
import com.zig.pso.rest.bean.UserMaster;
import com.zig.pso.rest.bean.UserSearchRequestBean;
import com.zig.pso.service.IUserService;

/**
 * 
 */
@Controller
public class UserController
{
    @Autowired
    IUserService userService;
    
    /**
     * This Method will add new user request
     */
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> registerUser(@RequestBody UserMaster user)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        BaseResponseBean addGroupResponse = new BaseResponseBean();
        addGroupResponse = userService.registerUser(user);
        return new ResponseEntity<BaseResponseBean>(addGroupResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will add get list of pending approval users list
     */
    @RequestMapping(value = "/pendingApprovalUserList", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<UserMaster>> getPendingApprovalUserList()
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        ArrayList<UserMaster> pendingUserList = new ArrayList<UserMaster>();
        pendingUserList = userService.getPendingApprovalUserList();
        return new ResponseEntity<ArrayList<UserMaster>>(pendingUserList, HttpStatus.OK);
    }
    
    /**
     * This Method will reject user request
     */
    @RequestMapping(value = "/rejectUser", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> deleteGroup(@RequestBody RejectPendingUserRequest rejectUserReq)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        BaseResponseBean rejectUserResponse = new BaseResponseBean();
        rejectUserResponse = userService.rejectUser(rejectUserReq);
        return new ResponseEntity<BaseResponseBean>(rejectUserResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will get user details by employee Id
     */
    @RequestMapping(value = "/getPendingUserDetailsByEmpId/{empId}", method = RequestMethod.GET)
    public ResponseEntity<UserMaster> getPendingUserDetailsByEmpId(@PathVariable("empId") String employeeId)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        UserMaster userData = new UserMaster();
        userData = userService.getPendingUserDataByEmpId(employeeId);
        return new ResponseEntity<UserMaster>(userData, HttpStatus.OK);
    }
    
    /**
     * This Method will get user details by employee Id
     */
    @RequestMapping(value = "/getUserDetailsByEmpId/{empId}", method = RequestMethod.GET)
    public ResponseEntity<UserMaster> getUserDetailsByEmpId(@PathVariable("empId") String employeeId)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        UserMaster userData = new UserMaster();
        userData = userService.getUserDetailsByEmpId(employeeId);
        return new ResponseEntity<UserMaster>(userData, HttpStatus.OK);
    }
    
    /**
     * This Method will add User Assignment
     */
    @RequestMapping(value = "/createUserAssigments", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> createUserAssigments(@RequestBody UserMaster user,HttpServletRequest request)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/
    	
    	  String urlForSetupPassword = StringUtils.EMPTY;
          
          try
          {
              StringBuffer asdasd = request.getRequestURL();
              String protocolName = asdasd.substring(0, asdasd.indexOf(":"));
              String hostName = java.net.InetAddress.getLocalHost().getHostName();
              String contextPathName = request.getContextPath();
              urlForSetupPassword = protocolName+"://"+hostName+":"+request.getServerPort()+contextPathName+"/#setupUserPassword";
          }
          catch (UnknownHostException e)
          {
              e.printStackTrace();
          }
          

        BaseResponseBean createUserAssignmentResponse = new BaseResponseBean();
        createUserAssignmentResponse = userService.createUserAssignments(user,urlForSetupPassword);
        return new ResponseEntity<BaseResponseBean>(createUserAssignmentResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will add User Assignment
     */
    @RequestMapping(value = "/updateUserAssigments", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> updateUserAssigments(@RequestBody UserMaster user)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        BaseResponseBean updateUserAssignmentResponse = new BaseResponseBean();
        updateUserAssignmentResponse = userService.updateUserAssignments(user);
        return new ResponseEntity<BaseResponseBean>(updateUserAssignmentResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will add get list of users list
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<UserMaster>> getUserList(@RequestBody UserSearchRequestBean userSearchReq)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/

        ArrayList<UserMaster> userList = new ArrayList<UserMaster>();
        userList = userService.getUserList(userSearchReq);
        return new ResponseEntity<ArrayList<UserMaster>>(userList, HttpStatus.OK);
    }
    
    /**
     * This Method will add get list of users list
     */
    @RequestMapping(value = "/setupPassword", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> setupPassword(@RequestBody SetupUserPasswordRequestBean userPasswordSetup)
    {
       /* String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);*/
        
      
        BaseResponseBean response = userService.setupPasswordForUser(userPasswordSetup);
        return new ResponseEntity<BaseResponseBean>(response, HttpStatus.OK);
    }
    
}
