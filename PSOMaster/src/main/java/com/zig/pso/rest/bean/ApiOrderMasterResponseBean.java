/************************************************************************************************************
 * Class Name :  ApiOrderMasterResponseBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 23, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.ArrayList;

/**
 * 
 */
public class ApiOrderMasterResponseBean extends BaseResponseBean 
{
    private ArrayList<OrderAPIDetailsBean> orderAPIList;

    /**
     * @return the orderAPIList
     */
    public ArrayList<OrderAPIDetailsBean> getOrderAPIList()
    {
        return orderAPIList;
    }

    /**
     * @param orderAPIList the orderAPIList to set
     */
    public void setOrderAPIList(ArrayList<OrderAPIDetailsBean> orderAPIList)
    {
        this.orderAPIList = orderAPIList;
    }
}
