/************************************************************************************************************
 * Class Name :  UserController.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 26, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
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
    static final Logger logger = Logger.getLogger(UserController.class);
    
    @Autowired
    IUserService userService;
    
    /**
     * This Method will add new user request
     */
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> registerUser(@RequestBody UserMaster user)
    {
        String userData = (new StringBuilder()).append("User Name ").append(user.getCompany()).append(" \nFirest Name : ").append(user.getFirstName()).append(" \nLast Name : ").append(user.getLastName()).append(" \nEmail ID : ").append(user.getEmail()).append(" \nEmployee ID : ").append(user.getEmpId()).append(" \nCompany : ").append(user.getCompany()).toString();
        PSOLoggerSrv.printDEBUG(logger, "UserController", "registerUser", user.toString());
        
        BaseResponseBean regUserResponse = new BaseResponseBean();
        if(StringUtils.isEmpty(user.getCompany()) || StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getEmpId()) 
                || StringUtils.isEmpty(user.getFirstName()) || StringUtils.isEmpty(user.getLastName()) 
                || StringUtils.isEmpty(user.getUsername()))
        {
            regUserResponse.setErrorCode(PSOConstants.ERROR_CODE);
            regUserResponse.setErrorMsg(PSOConstants.ALL_DATA_MANDATORY);
        } 
        else
        {
            regUserResponse = userService.registerUser(user);
        }

        return new ResponseEntity<BaseResponseBean>(regUserResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will add get list of pending approval users list
     */
    @RequestMapping(value = "/pendingApprovalUserList", method = RequestMethod.GET)
    public ResponseEntity<List<UserMaster>> getPendingApprovalUserList()
    {
        PSOLoggerSrv.printDEBUG(logger, "UserController", "getPendingApprovalUserList", null);

        List<UserMaster> pendingUserList = new ArrayList<UserMaster>();
        pendingUserList = userService.getPendingApprovalUserList();
        return new ResponseEntity<List<UserMaster>>(pendingUserList, HttpStatus.OK);
    }
    
    /**
     * This Method will reject user request
     */
    @RequestMapping(value = "/rejectUser", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> rejectUser(@RequestBody RejectPendingUserRequest rejectUserReq,HttpServletRequest request)
    {
        String rejectUserData = (new StringBuilder()).append("Employee Id : ").append(rejectUserReq.getEmpId()).append(" \nReject Commnets : ").append(rejectUserReq.getRejectComments()).toString();
        PSOLoggerSrv.printDEBUG(logger, "UserController", "rejectUser", rejectUserData);
        
        HttpSession sessoin = request.getSession();
        UserMaster loggedInUserData = (sessoin.getAttribute(PSOConstants.SESSION_USER_DATA)!=null)?(UserMaster)sessoin.getAttribute(PSOConstants.SESSION_USER_DATA):null;

        String rejectedBy = (loggedInUserData!=null)?loggedInUserData.getFirstName() + " " + loggedInUserData.getLastName() : StringUtils.EMPTY;
        
        BaseResponseBean rejectUserResponse = new BaseResponseBean();
        rejectUserResponse = userService.rejectUser(rejectUserReq,rejectedBy);
        return new ResponseEntity<BaseResponseBean>(rejectUserResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will get user details by employee Id
     */
    @RequestMapping(value = "/getPendingUserDetailsByEmpId/{empId}", method = RequestMethod.GET)
    public ResponseEntity<UserMaster> getPendingUserDetailsByEmpId(@PathVariable("empId") String employeeId)
    {
        PSOLoggerSrv.printDEBUG(logger, "UserController", "getPendingUserDetailsByEmpId", (new StringBuilder()).append("Emaployee ID : ").append(employeeId).toString());

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
        PSOLoggerSrv.printDEBUG(logger, "UserController", "getUserDetailsByEmpId", (new StringBuilder()).append("Emaployee ID : ").append(employeeId).toString());

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
        String userData = (new StringBuilder()).append("User Name ").append(user.getCompany()).append(" \nFirest Name : ").append(user.getFirstName()).append(" \nLast Name : ").append(user.getLastName()).append(" \nEmail ID : ").append(user.getEmail()).append(" \nEmployee ID : ").append(user.getEmpId()).append(" \nCompany : ").append(user.getCompany()).append(" \nGroup ID : ").append(user.getGroupId()).toString();
        PSOLoggerSrv.printDEBUG(logger, "UserController", "createUserAssigments", userData);
        
        UserMaster loggedInUserData = getLoggedInUserDetails(request);
        if(null!=loggedInUserData){
            user.setUpdatedBy(loggedInUserData.getUsername());
        }
        
        String urlForSetupPassword = generateURLForNextStep(request, "setupPassword");

        BaseResponseBean createUserAssignmentResponse = new BaseResponseBean();
        createUserAssignmentResponse = userService.createUserAssignments(user,urlForSetupPassword);
        return new ResponseEntity<BaseResponseBean>(createUserAssignmentResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will add User Assignment
     */
    @RequestMapping(value = "/updateUserAssigments", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> updateUserAssigments(@RequestBody UserMaster user,HttpServletRequest request)
    {
        String userData = (new StringBuilder()).append("User Name ").append(user.getCompany()).append(" \nFirest Name : ").append(user.getFirstName()).append(" \nLast Name : ").append(user.getLastName()).append(" \nEmail ID : ").append(user.getEmail()).append(" \nEmployee ID : ").append(user.getEmpId()).append(" \nCompany : ").append(user.getCompany()).append(" \nGroup ID : ").append(user.getGroupId()).toString();
        PSOLoggerSrv.printDEBUG(logger, "UserController", "updateUserAssigments", userData);

        UserMaster loggedInUserData = getLoggedInUserDetails(request);
        if(null!=loggedInUserData){
            user.setUpdatedBy(loggedInUserData.getUsername());
        }
        
        
        BaseResponseBean updateUserAssignmentResponse = new BaseResponseBean();
        updateUserAssignmentResponse = userService.updateUserAssignments(user);
        return new ResponseEntity<BaseResponseBean>(updateUserAssignmentResponse, HttpStatus.OK);
    }
    
    /**
     * This Method will add get list of users list
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public ResponseEntity<List<UserMaster>> getUserList(@RequestBody UserSearchRequestBean userSearchReq)
    {
       //String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG(logger, "UpdateOrderController", "getUserList", userSearchReq.toString());

        List<UserMaster> userList = new ArrayList<UserMaster>();
        userList = userService.getUserList(userSearchReq);
        return new ResponseEntity<List<UserMaster>>(userList, HttpStatus.OK);
    }
    
    /**
     * This Method will add get list of users list
     */
    @RequestMapping(value = "/setupPassword", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> setupPassword(@RequestBody SetupUserPasswordRequestBean userPasswordSetup)
    {
       // String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG(logger, "UpdateOrderController", "setupPassword", userPasswordSetup.toString());
        
      
        BaseResponseBean response = userService.setupPasswordForUser(userPasswordSetup);
        return new ResponseEntity<BaseResponseBean>(response, HttpStatus.OK);
    }
    
    /**
     * This Method will check if the username is already present or not
     */
    @RequestMapping(value={"/checkUsername/{userName}"}, method = RequestMethod.GET)
    public ResponseEntity<BaseResponseBean> checkUsername(@PathVariable("userName") String userName)
    {
        PSOLoggerSrv.printDEBUG(logger, "UserController", "checkUsername", "userName : "+userName);
        
        BaseResponseBean userData = new BaseResponseBean();
        userData = userService.checkUsername(userName);
        return new ResponseEntity<BaseResponseBean>(userData, HttpStatus.OK);
    }

    /**
     * This Method will change the user password
     */
    @RequestMapping(value={"/changePassword"}, method={RequestMethod.POST})
    public ResponseEntity<BaseResponseBean> changePassword(@RequestBody SetupUserPasswordRequestBean changePasswordRequest)
    {
        PSOLoggerSrv.printDEBUG(logger, "UserController", "changePassword", "EmpID : "+changePasswordRequest.getEmpId());
        
        BaseResponseBean response = userService.changeUserPassword(changePasswordRequest);
        return new ResponseEntity<BaseResponseBean>(response, HttpStatus.OK);
    }
    
    /**
     * This Method will generate URL for emails for further operations
     */
    private String generateURLForNextStep(HttpServletRequest request, String stepName)
    {
        String urlForSetupPW = "";
        String stepURLPart = "";
        if("setupPassword".equals(stepName))
            stepURLPart = "/#setupUserPassword";
        try
        {
            StringBuffer asdasd = request.getRequestURL();
            String protocolName = asdasd.substring(0, asdasd.indexOf(":"));
            String hostName = InetAddress.getLocalHost().getHostName();
            String contextPathName = request.getContextPath();
            urlForSetupPW = (new StringBuilder()).append(protocolName).append("://").append(hostName).append(":").append(request.getServerPort()).append(contextPathName).append(stepURLPart).toString();
            PSOLoggerSrv.printDEBUG(logger, "UserController", "generateURLForNextStep", urlForSetupPW);
        }
        catch(UnknownHostException e)
        {
            PSOLoggerSrv.printERROR(logger, "UserController", "generateURLForNextStep - Generate Setup Password URL ", e);
        }
        return urlForSetupPW;
    }

    private UserMaster getLoggedInUserDetails(HttpServletRequest request){
        HttpSession sessoin = request.getSession();
        UserMaster loggedInUserData = (sessoin.getAttribute(PSOConstants.SESSION_USER_DATA)!=null)?(UserMaster)sessoin.getAttribute(PSOConstants.SESSION_USER_DATA):null;
        
        return loggedInUserData;
    }
    
}
