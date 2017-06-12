/************************************************************************************************************
 * Class Name : AdminPanelService.java Description:
 * 
 * Author : Ankita Mishra Date : Apr 10, 2017 **********************************************************************************************************
 */
package com.zig.pso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.AdminPanelDAO;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.RemediationStepRequest;

/**
 * 
 */
@Service
public class AdminPanelServiceImpl implements AdminPanelService
{
    @Autowired
    AdminPanelDAO adminPanelDAO;

    @Override
    public BaseResponseBean addRemediationStep(RemediationStepRequest remediationRequest)
    {

        PSOLoggerSrv.printDEBUG("AdminPanelServiceImpl", "addRemediationStep", "Steps status to update: " + remediationRequest.getOrderStatus());
        return adminPanelDAO.addRemediationSteps(remediationRequest);
    }
}
