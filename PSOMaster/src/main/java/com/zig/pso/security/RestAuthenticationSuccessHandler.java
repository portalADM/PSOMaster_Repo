/************************************************************************************************************
 * Class Name :  RestAuthenticationSuccessHandler.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Dec 3, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.rest.bean.UserAuthResponse;
import com.zig.pso.rest.bean.UserMaster;
import com.zig.pso.service.IUserService;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private IUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws ServletException, IOException {
        
        UserAuthResponse authResponse = new UserAuthResponse();
        
        try
        {
            UserMaster user = userService.getUserDetailsByEmpId(authentication.getName());
            
            /*Save USER in session*/
            HttpSession sessoin = request.getSession(true);
            sessoin.setAttribute("UserDetails", user);
            
            authResponse.setUser(user);
            authResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
            authResponse.setErrorMsg(PSOConstants.AUTH_SUCCESS_MSG);
            
            SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, authResponse);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            SecurityUtils.sendResponse(response, HttpServletResponse.SC_UNAUTHORIZED, PSOConstants.AUTH_FAILED_MSG);
        }
    }
}
