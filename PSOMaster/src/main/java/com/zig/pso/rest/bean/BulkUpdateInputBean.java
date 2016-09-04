/************************************************************************************************************
 * Class Name :  BulkUpdateInputBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Sep 4, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.ArrayList;

/**
 * 
 */
public class BulkUpdateInputBean
{
    private ArrayList<OrderUpdateInputData> orderUpdateData;
    private String updateType;

    /**
     * @return the orderUpdateData
     */
    public ArrayList<OrderUpdateInputData> getOrderUpdateData()
    {
        return orderUpdateData;
    }

    /**
     * @param orderUpdateData the orderUpdateData to set
     */
    public void setOrderUpdateData(ArrayList<OrderUpdateInputData> orderUpdateData)
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
