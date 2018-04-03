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
    private String updatedBy;

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
     * @return the updatedBy
     */
    public String getUpdatedBy()
    {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    /**
     * @param updateType the updateType to set
     */
    public void setUpdateType(String updateType)
    {
        this.updateType = updateType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "BulkUpdateInputBean [orderUpdateData=" + orderUpdateData + ", updateType=" + updateType + ", updatedBy=" + updatedBy + "]";
    }

   
}
