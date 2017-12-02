/************************************************************************************************************
 * Class Name :  ApiOrderMasterResponseBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 23, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.List;

/**
 * 
 */
public class ApiOrderMasterResponseBean extends BaseResponseBean 
{
    private List<OrderAPIDetailsBean> orderAPIList;

    /**
     * @return the orderAPIList
     */
    public List<OrderAPIDetailsBean> getOrderAPIList()
    {
        return orderAPIList;
    }

    /**
     * @param orderAPIList the orderAPIList to set
     */
    public void setOrderAPIList(List<OrderAPIDetailsBean> orderAPIList)
    {
        this.orderAPIList = orderAPIList;
    }
}
