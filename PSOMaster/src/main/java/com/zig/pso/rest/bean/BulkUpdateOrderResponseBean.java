/************************************************************************************************************
 * Class Name :  InvalidUploadedOrderResponseBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Sep 24, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class BulkUpdateOrderResponseBean extends BaseResponseBean
{
    private ArrayList<OrderUpdateInputData> tempTableDataList;
    
    private List<String> invalidOrders;
    
    private String updateType;
    
    private String bulkUpdateId;

    /**
     * @return the tempTableDataList
     */
    public ArrayList<OrderUpdateInputData> getTempTableDataList()
    {
        return tempTableDataList;
    }

    /**
     * @param tempTableDataList the tempTableDataList to set
     */
    public void setTempTableDataList(ArrayList<OrderUpdateInputData> tempTableDataList)
    {
        this.tempTableDataList = tempTableDataList;
    }

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

    /**
     * @return the bulkUpdateId
     */
    public String getBulkUpdateId()
    {
        return bulkUpdateId;
    }

    /**
     * @param bulkUpdateId the bulkUpdateId to set
     */
    public void setBulkUpdateId(String bulkUpdateId)
    {
        this.bulkUpdateId = bulkUpdateId;
    }
    
}
