/************************************************************************************************************
 * Class Name : LoginController.java 
 * Description:
 * Author : Aniket Limaye 
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
import org.springframework.web.bind.annotation.RestController;

import com.zig.pso.logging.PSOLoggerSrv;
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

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean>  doLogin(@RequestBody LoginRequestBean loginRequest)
    {
    	BaseResponseBean AuthConfirm = new BaseResponseBean();
        PSOLoggerSrv.printINFO("############### Login Flow ###########################");
        AuthConfirm = loginService.doLogin(loginRequest);
        return new ResponseEntity<BaseResponseBean>(AuthConfirm, HttpStatus.OK);
    }

}
