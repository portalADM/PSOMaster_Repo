/************************************************************************************************************
 * Class Name : HomeController.java 
 * Description:  
 * Author : Ankita Mishra 
 * Date : Oct 05, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import org.apache.log4j.Logger;
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
    static final Logger logger = Logger.getLogger(HomeController.class);
    
    @Autowired
    CommonAppService commonAppService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> sendEmailMethod(@RequestBody EmailRequestBean emailRequest)
    {

        String emailDetails ="TO : "+emailRequest.getToEmailIdList() +" \n CC : "+emailRequest.getCcEmailIdList() + " \n Subject : "+emailRequest.getEmailSubject();
        PSOLoggerSrv.printDEBUG(logger,"OrderMasterController", "sendEmailMethod",  emailDetails);

        BaseResponseBean nameList = new BaseResponseBean();
        nameList = commonAppService.sendEmailService(emailRequest);
        return new ResponseEntity<BaseResponseBean>(nameList, HttpStatus.OK);
    }

}
