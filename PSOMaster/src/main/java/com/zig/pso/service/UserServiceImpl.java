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
        user.setPassword(PSOUserAuthenticator.getHashedPassword(user.getPassword()));
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
        return userDAO.rejectUser(userReq);
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
    public BaseResponseBean createUserAssignments(UserMaster userData)
    {
        String tempPassword = CommonUtility.getTempPasswordForUsers();
        
        userData.setTempPassword(tempPassword);
        
        BaseResponseBean response = userDAO.createUserAssignments(userData);
        if(response.getErrorCode()==PSOConstants.SUCCESS_CODE)
        {
            /* Send Email for Password setup */
            Mail emailData = getEmailTemlateForSetupPassword(userData);
            emailService.sendEmail(emailData);
            
            return userDAO.deletePendingUserRequest(userData.getEmpId());
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
    public BaseResponseBean setupPasswordForUser(SetupUserPasswordRequestBean userPassword,String urlToSetupPassword)
    {
        String hashedPassword = PSOUserAuthenticator.getHashedPassword(userPassword.getPassword());
        userPassword.setPassword(hashedPassword);
        return userDAO.setupPasswordForUser(userPassword);
    }
    
    public Mail getEmailTemlateForSetupPassword(UserMaster user)
    {
        String emailContent = PSOConstants.SETUP_PASSWORD_EMAIL_CONTENT;
        
        emailContent = emailContent.replace("#USER_NAME#", user.getFirstName() +" "+user.getLastName())
        .replace("#EMP_ID#", user.getEmpId())
        .replace("#EMAIL_ID#", user.getEmail())
        .replace("#TEMP_PASSWORD#", user.getTempPassword())
        .replace("#SETUP_PASSWORD_URL#", PSOConstants.PSO_SETUP_PASSWORD_URL);
        
        
        
        List<String> mailList = new ArrayList<String>();
        mailList.add(user.getEmail());
        
        Mail mail = new Mail();
        mail.setMailFrom(PSOConstants.EMAIL_SEND_FROM);
        mail.setMailTo(mailList);
        mail.setMailSubject(PSOConstants.SETUP_PASSWORD_EMAIL_SUBJECT);
        mail.setMailContent(emailContent);
        
        return mail;
    }
}
