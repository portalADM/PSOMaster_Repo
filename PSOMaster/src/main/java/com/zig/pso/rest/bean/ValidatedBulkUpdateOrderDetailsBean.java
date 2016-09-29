/************************************************************************************************************
 * Class Name :  ValidatedBulkUpdateOrderDetailsBean.java
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
public class ValidatedBulkUpdateOrderDetailsBean
{
    private ArrayList<OrderUpdateInputData> validOrderData;

    private List<String> invalidOrders;

    /**
     * @return the orderUpdateData
     */
    public ArrayList<OrderUpdateInputData> getValidOrderData()
    {
        return validOrderData;
    }

    /**
     * @param orderUpdateData the orderUpdateData to set
     */
    public void setOrderUpdateData(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        this.validOrderData = orderUpdateData;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((invalidOrders == null) ? 0 : invalidOrders.hashCode());
        result = prime * result + ((validOrderData == null) ? 0 : validOrderData.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ValidatedBulkUpdateOrderDetailsBean other = (ValidatedBulkUpdateOrderDetailsBean) obj;
        if (invalidOrders == null)
        {
            if (other.invalidOrders != null)
                return false;
        }
        else if (!invalidOrders.equals(other.invalidOrders))
            return false;
        if (validOrderData == null)
        {
            if (other.validOrderData != null)
                return false;
        }
        else if (!validOrderData.equals(other.validOrderData))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "ValidatedBulkUpdateOrderDetailsBean [validOrderData=" + validOrderData + ", invalidOrders=" + invalidOrders + "]";
    }

}
