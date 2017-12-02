/************************************************************************************************************
 * Class Name : RemediationStepRequest.java Description:
 * 
 * Author : Ankita Mishra Date : Apr 10, 2017 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

public class RemediationStepRequest
{
    private String orderStatus;
    private String type;
    private String remediationSteps;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public String getRemediationSteps()
    {
        return remediationSteps;
    }

    public void setRemediationSteps(String remediationSteps)
    {
        this.remediationSteps = remediationSteps;
    }

}
