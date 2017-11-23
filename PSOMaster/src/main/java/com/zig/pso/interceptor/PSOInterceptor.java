/************************************************************************************************************
 * Class Name :  PSOInterceptor.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 23, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zig.pso.service.UserSessionBean;

/**
 * 
 */
public class PSOInterceptor extends HandlerInterceptorAdapter
{
    public PSOInterceptor()
    {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception
    {
        super.postHandle(request, response, handler, modelAndView);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception
    {
        boolean accessAllowed = false;
        if(null == sessionBean)
            response.sendError(401, "unauthorized");
        else
            accessAllowed = true;
        return accessAllowed;
    }

    private UserSessionBean sessionBean;

}
