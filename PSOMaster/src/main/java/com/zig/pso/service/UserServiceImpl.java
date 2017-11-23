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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.dao.UserDAO;
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
	
	private static final boolean isLoginSimulated = false;
    
    @Autowired(required = true)
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
        if (employeeId != null)
        {
            UserMaster user = getUserDetailsByEmpId(employeeId);
            sessionBean.setLoggedInUserDetail(user);
        }
    }
    
    public UserMaster getUserByUsername(String employeeId)
    {
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
        //user.setPassword(PSOUserAuthenticator.getHashedPassword(user.getPassword()));
        return userDAO.registerUser(user);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#getPendingApprovalUserList()
     */
    @Override
    public ArrayList<UserMaster> getPendingApprovalUserList()
    {
        return userDAO.getUserPendingApprovalList();
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#rejectUser(java.lang.String)
     */
    @Override
    public BaseResponseBean rejectUser(RejectPendingUserRequest userReq)
    {
        BaseResponseBean response = userDAO.rejectUser(userReq);
        if(response.getErrorCode() == 0)
        {
            Mail emailData = getEmailTemlateForRejectUser(userReq);
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
        return userDAO.getPendingUserDataByEmpId(employeeId);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#createUserAssignments(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean createUserAssignments(UserMaster userData,String urlToSetupPassword)
    {
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
        return userDAO.updateUserAssignments(userData);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#getUserList()
     */
    @Override
    public ArrayList<UserMaster> getUserList(UserSearchRequestBean userSearchReq)
    {
        return userDAO.getUserList(userSearchReq);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#getUserDetailsByEmpId(java.lang.String)
     */
    @Override
    public UserMaster getUserDetailsByEmpId(String employeeId)
    {
        return userDAO.getUserDetailsByEmpId(employeeId);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#setupPasswordForUser(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean setupPasswordForUser(SetupUserPasswordRequestBean userPassword)
    {
        String hashedPassword = PSOUserAuthenticator.getHashedPassword(userPassword.getPassword());
        userPassword.setPassword(hashedPassword);
        return userDAO.setupPasswordForUser(userPassword);
    }
    
    public Mail getEmailTemlateForSetupPassword(UserMaster user,String urlToSetupPassword)
    {
        String emailContent = PSOConstants.SETUP_PASSWORD_EMAIL_CONTENT;
        
        emailContent = emailContent.replace(PSOConstants.EMAIL_TEMPLATE_USERNAME, user.getFirstName() +" "+user.getLastName())
        .replace(PSOConstants.EMAIL_TEMPLATE_EMPID, user.getEmpId())
        .replace(PSOConstants.EMAIL_TEMPLATE_EMAILID, user.getEmail())
        .replace(PSOConstants.EMAIL_TEMPLATE_TEMP_PASSWORD, user.getTempPassword())
        .replace(PSOConstants.EMAIL_TEMPLATE_SETUP_PW_URL, urlToSetupPassword);
        
        
        
        List<String> mailList = new ArrayList<String>();
        mailList.add(user.getEmail());
        
        Mail mail = new Mail();
        mail.setMailFrom(PSOConstants.EMAIL_SEND_FROM);
        mail.setMailTo(mailList);
        mail.setMailSubject(PSOConstants.SETUP_PASSWORD_EMAIL_SUBJECT);
        mail.setMailContent(emailContent);
        
        return mail;
    }
    
    public Mail getEmailTemlateForRejectUser(RejectPendingUserRequest userReq)
    {
        String emailContent = PSOConstants.REJECT_USER_EMAIL_CONTENT;
        UserMaster loggedInUserData = sessionBean.getLoggedInUserDetail();
        emailContent = emailContent.replace(PSOConstants.EMAIL_TEMPLATE_USERNAME, (new StringBuilder()).append(loggedInUserData.getFirstName()).append(" ").append(loggedInUserData.getLastName()).toString()).replace("#REJECT_REASON#", userReq.getRejectComments());
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
            response.setErrorMsg(PSOConstants.CURRENT_PASSWORD_WRONG);
            return response;
        }
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#checkUsername(java.lang.String)
     */
    @Override
    public BaseResponseBean checkUsername(String userName)
    {
        return userDAO.checkUsername(userName);
    }


}
