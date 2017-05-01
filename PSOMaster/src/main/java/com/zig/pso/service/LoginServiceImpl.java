/************************************************************************************************************
 * Class Name :  LoginServiceImpl.java
 * Description:  
 * Author     :  Aniket Limaye
 * Date       :  Aug 25, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;

/**
 * 
 */
@Service
public class LoginServiceImpl implements LoginService 
{
    @Autowired
    IUserService userService;
	
	@Override
	public BaseResponseBean authenticateUser(LoginRequestBean loginRequest) 
	{
	    BaseResponseBean authResponse = new BaseResponseBean();
	    boolean isUserAuthenticated = userService.authenticateUser(loginRequest);
	    
	    if(isUserAuthenticated)
	    {
	        try
            {
	            /*Save USER in session*/
                userService.buildUserDetail(loginRequest.getUsername());
                authResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                authResponse.setErrorMsg(PSOConstants.AUTH_SUCCESS_MSG);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
	    }
	    else{
	        authResponse.setErrorCode(PSOConstants.AUTH_FAILED);
	        authResponse.setErrorMsg(PSOConstants.AUTH_FAILED_MSG);
	    }
	    
	    return authResponse;
	}
	
	
}
