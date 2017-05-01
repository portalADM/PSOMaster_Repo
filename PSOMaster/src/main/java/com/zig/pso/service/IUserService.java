/************************************************************************************************************
 * Class Name :  IUserService.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Apr 8, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import com.zig.pso.rest.bean.LoginRequestBean;

/**
 * 
 */
public interface IUserService
{
    public void buildUserDetail(String userLoginId) throws Exception;
    
    public boolean authenticateUser(LoginRequestBean loginRequest);
    
}
