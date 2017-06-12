/************************************************************************************************************
 * Class Name : AdminPanelDAO.java Description:
 * 
 * Author : Ankita Mishra Date : Apr 12, 2017 **********************************************************************************************************
 */
package com.zig.pso.dao;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.RemediationStepRequest;

/**
 * 
 */
public interface AdminPanelDAO
{
    public BaseResponseBean addRemediationSteps(RemediationStepRequest remediationRequest);
}
