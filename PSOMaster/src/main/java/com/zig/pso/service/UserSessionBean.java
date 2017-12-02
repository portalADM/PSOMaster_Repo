/************************************************************************************************************
 * Class Name :  UserSessionBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Apr 8, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.UserMaster;

@Component(value = "sessionBean")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionBean implements Serializable
{
    private static final long serialVersionUID = -3364120758157904154L;
    
    /** The logged in user detail. */
    private UserMaster loggedInUserDetail;
    
    /** The user login id. */
    private String userLoginId;
    
    @Autowired(required = true)
    public IUserService userService;
    
    private HttpServletRequest request;

    public UserSessionBean()
    {
        super();
    }

    public UserMaster getUserDetail()
    {
        if (loggedInUserDetail == null)
        {
            try
            {
                userService.buildUserDetail(userLoginId);
            }
            catch (Exception e)
            {
                PSOLoggerSrv.printERROR("UserSessionBean", "getUserDetail", e);
            }
            return loggedInUserDetail;
        }
        else
        {
            return loggedInUserDetail;
        }
    }

    public UserMaster getLoggedInUserDetail()
    {
        return loggedInUserDetail;
    }

    public void setLoggedInUserDetail(UserMaster loggedInUserDetail)
    {
        this.loggedInUserDetail = loggedInUserDetail;
    }
    
    public void setUserLoginId(String userLoginId)
    {
        this.userLoginId = userLoginId;
    }

    public HttpServletRequest getRequest()
    {
        return request;
    }

    public void setRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    
}
