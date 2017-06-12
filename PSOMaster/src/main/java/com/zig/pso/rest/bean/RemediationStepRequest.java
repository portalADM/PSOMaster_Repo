/************************************************************************************************************
 * Class Name : RemediationStepRequest.java Description:
 * 
 * Author : Ankita Mishra Date : Apr 10, 2017 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.ArrayList;

public class RemediationStepRequest
{
    String orderStatus;
    String type;
    ArrayList<String> remediationSteps;

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

    public ArrayList<String> getRemediationSteps()
    {
        return remediationSteps;
    }

    public void setRemediationSteps(ArrayList<String> remediationSteps)
    {
        this.remediationSteps = remediationSteps;
    }

}
