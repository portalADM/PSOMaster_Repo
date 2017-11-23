/************************************************************************************************************
 * Class Name :  IUserService.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Apr 8, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;
import com.zig.pso.rest.bean.RejectPendingUserRequest;
import com.zig.pso.rest.bean.SetupUserPasswordRequestBean;
import com.zig.pso.rest.bean.UserMaster;
import com.zig.pso.rest.bean.UserSearchRequestBean;

/**
 * 
 */
public interface IUserService
{
    public void buildUserDetail(String userLoginId) throws Exception;
    
    public UserMaster getUserByUsernameForAuthentication(LoginRequestBean loginRequest);
    
    public UserMaster getLoggedInUserDetails();
    
    public BaseResponseBean registerUser(UserMaster user);
    
    public ArrayList<UserMaster> getPendingApprovalUserList();
    
    public BaseResponseBean rejectUser(RejectPendingUserRequest userReq);
    
    public UserMaster getPendingUserDataByEmpId(String employeeId);
    
    public UserMaster getUserDetailsByEmpId(String employeeId);
    
    public BaseResponseBean createUserAssignments(UserMaster userData,String urlForSetupPassword);
    
    public BaseResponseBean updateUserAssignments(UserMaster userData);
    
    public ArrayList<UserMaster> getUserList(UserSearchRequestBean userSearchReq);
    
    public BaseResponseBean setupPasswordForUser(SetupUserPasswordRequestBean userPassword);
    
    public abstract BaseResponseBean checkUsername(String s);

    public abstract BaseResponseBean changeUserPassword(SetupUserPasswordRequestBean setupuserpasswordrequestbean);

}
