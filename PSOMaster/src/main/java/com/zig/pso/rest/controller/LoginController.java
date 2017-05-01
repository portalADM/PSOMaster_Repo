/************************************************************************************************************
 * Class Name : LoginController.java 
 * Description:
 * Author : Aniket Limaye 
 * Date : Aug 26, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;
import com.zig.pso.service.LoginService;


/**
 * 
 */
@RestController
public class LoginController
{
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView  doLogin(@RequestParam("username") String userName,@RequestParam("password") String password)
    {
        LoginRequestBean loginRequest = new LoginRequestBean();
        loginRequest.setUsername(userName);
        loginRequest.setPassword(password);
        
        String routeToPage = "";
        ModelAndView model = new ModelAndView();
        
        BaseResponseBean authConfirm = loginService.authenticateUser(loginRequest);
        if(authConfirm.getErrorCode()==PSOConstants.SUCCESS_CODE){
            routeToPage = "../Master";
            model.setViewName(routeToPage);
        }
        else{
            routeToPage = "../Login";
            model.setViewName(routeToPage);
            model.addObject("message_login", authConfirm.getErrorMsg());
        }
        
        return model;
    }

}
