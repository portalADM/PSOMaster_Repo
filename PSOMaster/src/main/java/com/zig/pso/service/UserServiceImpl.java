/************************************************************************************************************
 * Class Name :  UserServiceImpl.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Apr 8, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.rest.bean.LoginRequestBean;
import com.zig.pso.rest.bean.UserMaster;

@Service
public class UserServiceImpl implements IUserService
{
    
    @Autowired(required = true)
    private UserSessionBean sessionBean;

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#buildUserDetail(java.lang.String)
     */
    @Override
    public void buildUserDetail(String userLoginId) throws Exception
    {
        if (userLoginId != null)
        {
            UserMaster user = getUserByUsername(userLoginId);
            sessionBean.setLoggedInUserDetail(user);
        }
    }
    
    public UserMaster getUserByUsername(String username)
    {
        UserMaster user = new UserMaster();
        user.setUsername("admin");
        user.setUserRole("ADMIN");
        
        return user;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.IUserService#authenticateUser(com.zig.pso.rest.bean.LoginRequestBean)
     */
    @Override
    public boolean authenticateUser(LoginRequestBean loginRequest)
    {
        /*Add Logic to Authenticate Actual Users*/
        
        /*Dummy Logic for Admin / General Employees */
        
        if("admin".equals(loginRequest.getUsername()) && "admin".equals(loginRequest.getPassword())){
            return true;
        }        
        return false;
    }

}
