/************************************************************************************************************
 * Class Name : LoginService.java
 * Description: This interface contains methods for order related operations.
 * Author : Aniket Limaye 
 * Date : Aug 26, 2016
 ************************************************************************************************************/

package com.zig.pso.service;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;


public interface LoginService
{
	
    /**
     * @param loginRequest 
     * @param OrderId
     * @return
     */
    public BaseResponseBean authenticateUser(LoginRequestBean loginRequest);
	
}