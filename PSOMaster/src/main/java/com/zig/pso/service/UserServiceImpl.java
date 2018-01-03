/************************************************************************************************************
 * Class Name :  UserServiceImpl.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Apr 8, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.dao.UserDAO;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;
import com.zig.pso.rest.bean.Mail;
import com.zig.pso.rest.bean.RejectPendingUserRequest;
import com.zig.pso.rest.bean.SetupUserPasswordRequestBean;
import com.zig.pso.rest.bean.UserMaster;
import com.zig.pso.rest.bean.UserSearchRequestBean;
import com.zig.pso.utility.CommonUtility;
import com.zig.pso.utility.PSOUserAuthenticator;

@Service
public class UserServiceImpl implements IUserService
{
    static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    public static final String CLASS_NAME = "UserServiceImpl";
    
	private static final boolean isLoginSimulated = false;
    
    /*@Autowired(required = true)*/
    private UserSessionBean sessionBean;
    
    @Autowired
    MailService emailService;
    
    @Autowired
    private UserDAO userDAO;
    

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#buildUserDetail(java.lang.String)
     */
    @Override
    public void buildUserDetail(String employeeId) throws Exception
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "buildUserDetail", "Emp ID :" +employeeId);
        if (employeeId != null)
        {
            UserMaster user = getUserDetailsByEmpId(employeeId);
            sessionBean.setLoggedInUserDetail(user);
        }
    }
    
    public UserMaster getUserByUsername(String employeeId)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserByUsername", "UserName :" +employeeId);
    	UserMaster user = new UserMaster();
    	if(isLoginSimulated){
    		 /*user.setUsername(username);
    	     user.setUserRole("admin".equals(username)?"ADMIN":"TEST");*/
    	}
    	else{
    	    user = getUserDetailsByEmpId(employeeId);
    	}
        
        return user;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#authenticateUser(com.zig.pso.rest.bean.LoginRequestBean)
     */
    @Override
    public UserMaster getUserByUsernameForAuthentication(LoginRequestBean loginRequest)
    {
        UserMaster userFromDb = null;
        /*Dummy Logic for Admin / General Employees */
        if(isLoginSimulated)
        {
           /* if("admin".equals(loginRequest.getUsername()) && "admin".equals(loginRequest.getPassword())){
                return true;
            }
            else if("test".equals(loginRequest.getUsername()) && "test".equals(loginRequest.getPassword())){
                return true;
            }*/
        }
        else
        {
            /*Add Logic to Authenticate Actual Users*/
            userFromDb = userDAO.getUserByUsernameForAuthentication(loginRequest);
        }
        
        return userFromDb;
    }

	/* (non-Javadoc)
	 * @see com.zig.pso.service.IUserService#getLoggedInUserDetails()
	 */
	@Override
	public UserMaster getLoggedInUserDetails() 
	{
		return sessionBean.getLoggedInUserDetail();
	}

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#addNewUserSignupRequest(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean registerUser(UserMaster user)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "registerUser", "UserName :" +user.getUsername());
        return userDAO.registerUser(user);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#getPendingApprovalUserList()
     */
    @Override
    public List<UserMaster> getPendingApprovalUserList()
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getPendingApprovalUserList", StringUtils.EMPTY);
        return userDAO.getUserPendingApprovalList();
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#rejectUser(java.lang.String)
     */
    @Override
    public BaseResponseBean rejectUser(RejectPendingUserRequest userReq, String rejectedBy)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "rejectUser", "Rejected Emp ID : "+userReq.getEmpId()+" ,Rejected By : "+rejectedBy);
        BaseResponseBean response = userDAO.rejectUser(userReq);
        if(response.getErrorCode() == 0)
        {
            Mail emailData = getEmailTemlateForRejectUser(userReq, rejectedBy);
            emailService.sendEmail(emailData);
        }

        return response;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#getPendingUserDataByEmpId(java.lang.String)
     */
    @Override
    public UserMaster getPendingUserDataByEmpId(String employeeId)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getPendingUserDataByEmpId", "Emp ID : "+employeeId);
        return userDAO.getPendingUserDataByEmpId(employeeId);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#createUserAssignments(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean createUserAssignments(UserMaster userData,String urlToSetupPassword)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getPendingUserDataByEmpId", "Emp ID : "+userData.getEmpId());
        String tempPassword = CommonUtility.getTempPasswordForUsers();
        
        userData.setTempPassword(tempPassword);
        
        BaseResponseBean response = userDAO.createUserAssignments(userData);
        if(response.getErrorCode()==PSOConstants.SUCCESS_CODE)
        {
            BaseResponseBean deletePendingReqResponse = userDAO.deletePendingUserRequest(userData.getEmpId());
            if(deletePendingReqResponse.getErrorCode()==PSOConstants.SUCCESS_CODE)
            {
                /* Send Email for Password setup */
                Mail emailData = getEmailTemlateForSetupPassword(userData,urlToSetupPassword);
                emailService.sendEmail(emailData);
            }
        }
        return response;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#updateUserAssignments(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean updateUserAssignments(UserMaster userData)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "updateUserAssignments", "Emp ID : "+userData.getEmpId());
        return userDAO.updateUserAssignments(userData);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#getUserList()
     */
    @Override
    public List<UserMaster> getUserList(UserSearchRequestBean userSearchReq)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "updateUserAssignments", StringUtils.EMPTY);
        return userDAO.getUserList(userSearchReq);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#getUserDetailsByEmpId(java.lang.String)
     */
    @Override
    public UserMaster getUserDetailsByEmpId(String employeeId)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserDetailsByEmpId", "Emp ID : "+employeeId);
        return userDAO.getUserDetailsByEmpId(employeeId);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#setupPasswordForUser(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean setupPasswordForUser(SetupUserPasswordRequestBean userPassword)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "setupPasswordForUser", "Emp ID : "+userPassword.getEmpId());
        String hashedPassword = PSOUserAuthenticator.getHashedPassword(userPassword.getPassword());
        userPassword.setPassword(hashedPassword);
        return userDAO.setupPasswordForUser(userPassword);
    }
    
    public Mail getEmailTemlateForSetupPassword(UserMaster user,String urlToSetupPassword)
    {
        String emailContent = PSOConstants.SETUP_PW_EMAIL_CONTENT;
        
        emailContent = emailContent.replace(PSOConstants.EMAIL_TEMPLATE_NAME, user.getFirstName() +" "+user.getLastName())
        .replace(PSOConstants.EMAIL_TEMPLATE_EMPID, user.getEmpId())
        .replace(PSOConstants.EMAIL_TEMPLATE_EMAILID, user.getEmail())
        .replace(PSOConstants.EMAIL_TEMPLATE_TEMP_PW, user.getTempPassword())
        .replace(PSOConstants.EMAIL_TEMPLATE_USERNAME, user.getUsername())
        .replace(PSOConstants.EMAIL_TEMPLATE_SETUP_PW_URL, urlToSetupPassword);
        
        
        
        List<String> mailList = new ArrayList<String>();
        mailList.add(user.getEmail());
        
        Mail mail = new Mail();
        mail.setMailFrom(PSOConstants.EMAIL_SEND_FROM);
        mail.setMailTo(mailList);
        mail.setMailSubject(PSOConstants.SETUP_PW_EMAIL_SUBJECT);
        mail.setMailContent(emailContent);
        
        return mail;
    }
    
    public Mail getEmailTemlateForRejectUser(RejectPendingUserRequest userReq,String rejectedBy)
    {
        String emailContent = PSOConstants.REJECT_USER_EMAIL_CONTENT;
        emailContent = emailContent.replace(PSOConstants.EMAIL_TEMPLATE_USERNAME, (new StringBuilder()).append(rejectedBy).toString()).replace("#REJECT_REASON#", userReq.getRejectComments());
        List<String> mailList = new ArrayList<String>();
        mailList.add(userReq.getEmailId());
        Mail mail = new Mail();
        mail.setMailFrom(PSOConstants.EMAIL_SEND_FROM);
        mail.setMailTo(mailList);
        mail.setMailSubject(PSOConstants.REJECT_USER_EMAIL_SUBJECT);
        mail.setMailContent(emailContent);
        return mail;
    }
    
    @Override
    public BaseResponseBean changeUserPassword(SetupUserPasswordRequestBean userPassword)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "changeUserPassword", "Emp ID : "+userPassword.getEmpId());
        BaseResponseBean response = new BaseResponseBean();
        String currentPasswordFromDB = userDAO.getUserCurrentPassword(userPassword.getEmpId());
        if(PSOUserAuthenticator.checkIfPasswordIsSame(userPassword.getCurrentPassword(), currentPasswordFromDB))
        {
            userPassword.setPassword(PSOUserAuthenticator.getHashedPassword(userPassword.getPassword()));
            userPassword.setCurrentPassword(currentPasswordFromDB);
            return userDAO.changeUserPassword(userPassword);
        } else
        {
            response.setErrorCode(PSOConstants.ERROR_CODE);
            response.setErrorMsg(PSOConstants.CURRENT_PW_WRONG);
            return response;
        }
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#checkUsername(java.lang.String)
     */
    @Override
    public BaseResponseBean checkUsername(String userName)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "checkUsername", "User Name : "+userName);
        return userDAO.checkUsername(userName);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#getUserDetailsByUserName(java.lang.String)
     */
    @Override
    public UserMaster getUserDetailsByUserName(String userName)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserDetailsByUserName", "User Name : "+userName);
        return userDAO.getUserByUserName(userName);
    }


}
