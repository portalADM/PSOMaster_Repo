/************************************************************************************************************
 * Class Name : CommonAppService.java Description:
 * 
 * Author : Ankita Mishra Date : Oct 5, 2016 **********************************************************************************************************
 */
package com.zig.pso.service;

import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.EmailRequestBean;
import com.zig.pso.utility.SendMailUtility;

/**
 * 
 */

@Service
public class CommonAppServiceImpl implements CommonAppService
{
    // SendMailUtility sendMailUtility = new SendMailUtility();

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.CommonAppService#sendEmailService(com.zig.pso.rest.bean.EmailRequestBean)
     */
    @Override
    public BaseResponseBean sendEmailService(EmailRequestBean emailRequest)
    {
        BaseResponseBean sentMailResponse = new BaseResponseBean();
        if (Validate(emailRequest))
        {

            sentMailResponse = SendMailUtility.sendMail(emailRequest);
            return sentMailResponse;
        }
        else
        {
            sentMailResponse.setErrorCode(PSOConstants.ERROR_CODE);
            sentMailResponse.setErrorMsg(PSOConstants.INVALID_REQUEST);
            return sentMailResponse;
        }

    }

    boolean Validate(EmailRequestBean emailRequest)
    {

        if ((null != emailRequest.getFromEmailId()) && (null != emailRequest.getEmailContent()) && (null != emailRequest.getEmailSubject()) && (null != emailRequest.getToEmailIdList())
                && (null != emailRequest.getCcEmailIdList()))
            return true;
        else
            return false;
    }
}
