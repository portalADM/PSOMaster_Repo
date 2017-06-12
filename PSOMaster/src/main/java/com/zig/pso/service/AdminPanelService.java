/************************************************************************************************************
 * Class Name : AdminPanelService.java Description:
 * 
 * Author : Ankita Mishra Date : Apr 11, 2017 **********************************************************************************************************
 */
package com.zig.pso.service;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.RemediationStepRequest;

/**
 * 
 */
public interface AdminPanelService
{
    public BaseResponseBean addRemediationStep(RemediationStepRequest remediationRequest);
}
