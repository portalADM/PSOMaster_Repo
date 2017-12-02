/************************************************************************************************************
 * Class Name :  BulkUpdateInputBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Sep 4, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.List;

/**
 * 
 */
public class BulkUpdateInputBean
{
    private List<OrderUpdateInputData> orderUpdateData;
    private String updateType;

    /**
     * @return the orderUpdateData
     */
    public List<OrderUpdateInputData> getOrderUpdateData()
    {
        return orderUpdateData;
    }

    /**
     * @param orderUpdateData the orderUpdateData to set
     */
    public void setOrderUpdateData(List<OrderUpdateInputData> orderUpdateData)
    {
        this.orderUpdateData = orderUpdateData;
    }

    /**
     * @return the updateType
     */
    public String getUpdateType()
    {
        return updateType;
    }

    /**
     * @param updateType the updateType to set
     */
    public void setUpdateType(String updateType)
    {
        this.updateType = updateType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "BulkUpdateInputBean [orderUpdateData=" + orderUpdateData + ", updateType=" + updateType + "]";
    }

}
