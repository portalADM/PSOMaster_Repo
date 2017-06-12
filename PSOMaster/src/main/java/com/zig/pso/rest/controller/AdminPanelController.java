/************************************************************************************************************
 * Class Name : AdminPanelController.java Description:Contains functionalities for Admin level updates
 * 
 * Author : Ankita Mishra Date : Apr 10, 2017 **********************************************************************************************************
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
import com.zig.pso.rest.bean.RemediationStepRequest;
import com.zig.pso.service.AdminPanelService;

/**
 * 
 */

@RestController
public class AdminPanelController
{
    @Autowired
    AdminPanelService adminPanelServ;

    @RequestMapping(value = "/addStep", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> addRemediationSteps(@RequestBody RemediationStepRequest remediationRequest)
    {

        PSOLoggerSrv.printDEBUG("AdminPanelController", "addRemediationSteps ", "adding remediation step");

        BaseResponseBean nameList = new BaseResponseBean();
        nameList = adminPanelServ.addRemediationStep(remediationRequest);
        return new ResponseEntity<BaseResponseBean>(nameList, HttpStatus.OK);

    }
}
