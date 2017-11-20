/************************************************************************************************************
 * Class Name : LoginController.java 
 * Description:
 * Author : Nilesh Patil
 * Date : Aug 26, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;
import com.zig.pso.rest.bean.UserAuthResponse;
import com.zig.pso.service.LoginService;
import com.zig.pso.service.MailService;


/**
 * 
 */
@RestController
public class LoginController
{
    @Autowired
    LoginService loginService;
    
    @Autowired
    MailService emailService;

    @RequestMapping(value = "/loginTest", method = RequestMethod.POST)
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
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserAuthResponse> authenticateUser(@RequestBody LoginRequestBean loginRequest)
    {
      /*  LoginRequestBean loginRequest = new LoginRequestBean();
        loginRequest.setUsername(userName);
        loginRequest.setPassword(password);*/
        
        UserAuthResponse authConfirm = loginService.authenticateUser(loginRequest);
        
        return new ResponseEntity<UserAuthResponse>(authConfirm, HttpStatus.OK);
    }

}
