/************************************************************************************************************
 * Class Name : CommonAppService.java Description:
 * 
 * Author : Ankita Mishra Date : Oct 5, 2016 **********************************************************************************************************
 */
package com.zig.pso.service;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.EmailRequestBean;

/**
 * 
 */
public interface CommonAppService
{

    public BaseResponseBean sendEmailService(EmailRequestBean emailRequest);
}
