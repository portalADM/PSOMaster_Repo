/************************************************************************************************************
 * Class Name :  OrderUpdateInputData.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Sep 4, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class OrderUpdateInputData implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -8676915922829518246L;

    private String orderId;
    private String status;
    private String sim;
    private String imei;
    private String retryCount;

    /**
     * 
     */
    public OrderUpdateInputData()
    {
        super();
    }

    /**
     * @param orderId
     * @param status
     * @param sim
     * @param imei
     * @param retryCount
     */
    public OrderUpdateInputData(String orderId, String status, String sim, String imei, String retryCount)
    {
        super();
        this.orderId = orderId;
        this.status = status;
        this.sim = sim;
        this.imei = imei;
        this.retryCount = retryCount;
    }

    /**
     * @return the orderId
     */
    public String getOrderId()
    {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the sim
     */
    public String getSim()
    {
        return sim;
    }

    /**
     * @param sim the sim to set
     */
    public void setSim(String sim)
    {
        this.sim = sim;
    }

    /**
     * @return the imei
     */
    public String getImei()
    {
        return imei;
    }

    /**
     * @param imei the imei to set
     */
    public void setImei(String imei)
    {
        this.imei = imei;
    }

    /**
     * @return the retryCount
     */
    public String getRetryCount()
    {
        return retryCount;
    }

    /**
     * @param retryCount the retryCount to set
     */
    public void setRetryCount(String retryCount)
    {
        this.retryCount = retryCount;
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
        result = prime * result + ((imei == null) ? 0 : imei.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((retryCount == null) ? 0 : retryCount.hashCode());
        result = prime * result + ((sim == null) ? 0 : sim.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        OrderUpdateInputData other = (OrderUpdateInputData) obj;
        if (imei == null)
        {
            if (other.imei != null)
                return false;
        }
        else if (!imei.equals(other.imei))
            return false;
        if (orderId == null)
        {
            if (other.orderId != null)
                return false;
        }
        else if (!orderId.equals(other.orderId))
            return false;
        if (retryCount == null)
        {
            if (other.retryCount != null)
                return false;
        }
        else if (!retryCount.equals(other.retryCount))
            return false;
        if (sim == null)
        {
            if (other.sim != null)
                return false;
        }
        else if (!sim.equals(other.sim))
            return false;
        if (status == null)
        {
            if (other.status != null)
                return false;
        }
        else if (!status.equals(other.status))
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
        return "OrderUpdateInputData [orderId=" + orderId + ", status=" + status + ", sim=" + sim + ", imei=" + imei + ", retryCount=" + retryCount + "]";
    }

}
