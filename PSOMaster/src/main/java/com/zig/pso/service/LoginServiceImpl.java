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

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;

/**
 * 
 */
@Service
public class LoginServiceImpl implements LoginService {

	
	@Override
	public BaseResponseBean doLogin(LoginRequestBean loginRequest) {
		BaseResponseBean AuthConfirm = null;
		//AuthConfirm = loginDAO.doLogin(loginRequest);
		return AuthConfirm;
	}
	
	
}
