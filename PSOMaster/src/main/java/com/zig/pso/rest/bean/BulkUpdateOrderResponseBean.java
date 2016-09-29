/************************************************************************************************************
 * Class Name :  InvalidUploadedOrderResponseBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Sep 24, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.List;

/**
 * 
 */
public class BulkUpdateOrderResponseBean extends BaseResponseBean
{
    List<String> invalidOrders;

    /**
     * @return the invalidOrders
     */
    public List<String> getInvalidOrders()
    {
        return invalidOrders;
    }

    /**
     * @param invalidOrders the invalidOrders to set
     */
    public void setInvalidOrders(List<String> invalidOrders)
    {
        this.invalidOrders = invalidOrders;
    }

}
