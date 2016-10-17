/************************************************************************************************************
 * Class Name : OrderMasterController.java Description:
 * 
 * Author : Ankita Mishra Date : Oct 05, 2016 **********************************************************************************************************
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
import com.zig.pso.rest.bean.EmailRequestBean;
import com.zig.pso.service.CommonAppService;

@RestController
public class HomeController
{
    /*
     * Order Service injection
     */

    @Autowired
    CommonAppService commonAppService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> sendEmailMethod(@RequestBody EmailRequestBean emailRequest)
    {

        PSOLoggerSrv.printINFO("############### send email Rest ###########################");

        BaseResponseBean nameList = new BaseResponseBean();
        nameList = commonAppService.sendEmailService(emailRequest);
        return new ResponseEntity<BaseResponseBean>(nameList, HttpStatus.OK);
    }

}
