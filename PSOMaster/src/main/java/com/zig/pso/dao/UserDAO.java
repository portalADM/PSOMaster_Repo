/************************************************************************************************************
 * Class Name :  UserDAO.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 26, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

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
public interface UserDAO
{
    public BaseResponseBean registerUser(UserMaster user);
    
    public ArrayList<UserMaster> getUserPendingApprovalList();
    
    public BaseResponseBean rejectUser(RejectPendingUserRequest rejectUserreq);

    public UserMaster getPendingUserDataByEmpId(String employeeId);
    
    public UserMaster getUserDetailsByEmpId(String employeeId);
    
    public BaseResponseBean createUserAssignments(UserMaster userData);
    
    public BaseResponseBean updateUserAssignments(UserMaster userData);
    
    public ArrayList<UserMaster> getUserList(UserSearchRequestBean userSearchReq);
    
    public BaseResponseBean deletePendingUserRequest(String employeeId);
    
    public UserMaster getUserByUsernameForAuthentication(LoginRequestBean loginRequest);
    
    public BaseResponseBean setupPasswordForUser(SetupUserPasswordRequestBean userPassword);

    public abstract BaseResponseBean checkUsername(String s);

    public abstract BaseResponseBean changeUserPassword(SetupUserPasswordRequestBean setupuserpasswordrequestbean);

    public abstract String getUserCurrentPassword(String s);

}
