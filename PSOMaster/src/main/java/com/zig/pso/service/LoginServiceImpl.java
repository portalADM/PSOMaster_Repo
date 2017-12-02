/************************************************************************************************************
 * Class Name :  LoginServiceImpl.java
 * Description:  
 * Author     :  Nilesh Patil
 * Date       :  Aug 25, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.LoginRequestBean;
import com.zig.pso.rest.bean.UserAuthResponse;
import com.zig.pso.rest.bean.UserMaster;
import com.zig.pso.utility.CommonUtility;
import com.zig.pso.utility.PSOUserAuthenticator;

/**
 * 
 */
@Service
public class LoginServiceImpl implements LoginService 
{
    @Autowired
    IUserService userService;
	
	@Override
	public UserAuthResponse authenticateUser(LoginRequestBean loginRequest) 
	{
		UserAuthResponse authResponse = new UserAuthResponse();
	    UserMaster userFromDb = userService.getUserByUsernameForAuthentication(loginRequest);
	    
	    if(null!=userFromDb)
	    {
	        boolean ifUserAuthenticate = PSOUserAuthenticator.isUserAuthenticated(loginRequest.getPassword(), userFromDb.getPassword());
	        
	        if(ifUserAuthenticate)
	        {
	            try
	            {
	                /*Save USER in session*/
	                userService.buildUserDetail(userFromDb.getEmpId());
	                authResponse.setPSO_SESSION_TOKEN(CommonUtility.getPSOSessionToken());
	                authResponse.setUser(userService.getLoggedInUserDetails());
	                authResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
	                authResponse.setErrorMsg(PSOConstants.AUTH_SUCCESS_MSG);
	            }
	            catch (Exception e)
	            {
	                PSOLoggerSrv.printERROR("LoginServiceImpl", "authenticateUser", e);
	            }
	        }
	        else{
	            authResponse.setErrorCode(PSOConstants.AUTH_FAILED);
	            authResponse.setErrorMsg(PSOConstants.AUTH_FAILED_MSG);
	        }
	    }
	    
	    return authResponse;
	}
	
	
}
