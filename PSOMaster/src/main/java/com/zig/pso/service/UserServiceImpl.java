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
	
	private static final boolean isLoginSimulated = true;
    
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
    	if(isLoginSimulated){
    		 user.setUsername(username);
    	     user.setUserRole("admin".equals(username)?"ADMIN":"TEST");
    	}
        
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
        else if("test".equals(loginRequest.getUsername()) && "test".equals(loginRequest.getPassword())){
            return true;
        }
        
        return false;
    }

	/* (non-Javadoc)
	 * @see com.zig.pso.service.IUserService#getLoggedInUserDetails()
	 */
	@Override
	public UserMaster getLoggedInUserDetails() 
	{
		return sessionBean.getLoggedInUserDetail();
	}
    
   

}
