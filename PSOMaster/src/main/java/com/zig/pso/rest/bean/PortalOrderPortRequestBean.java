/************************************************************************************************************
 * Class Name :  PortalOrderPortRequestBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Dec 31, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class PortalOrderPortRequestBean implements Serializable
{

    private static final long serialVersionUID = -468760958064516495L;
    
    private String orderId;
    private String transberNumber;
    private String lineId;
    private String portStatus;
    private String spName;
    /**
     * 
     */
    public PortalOrderPortRequestBean()
    {
        super();
    }
    /**
     * @param orderId
     * @param transberNumber
     * @param lineId
     * @param portStatus
     * @param spName
     */
    public PortalOrderPortRequestBean(String orderId, String transberNumber, String lineId, String portStatus, String spName)
    {
        super();
        this.orderId = orderId;
        this.transberNumber = transberNumber;
        this.lineId = lineId;
        this.portStatus = portStatus;
        this.spName = spName;
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
     * @return the transberNumber
     */
    public String getTransberNumber()
    {
        return transberNumber;
    }
    /**
     * @param transberNumber the transberNumber to set
     */
    public void setTransberNumber(String transberNumber)
    {
        this.transberNumber = transberNumber;
    }
    /**
     * @return the lineId
     */
    public String getLineId()
    {
        return lineId;
    }
    /**
     * @param lineId the lineId to set
     */
    public void setLineId(String lineId)
    {
        this.lineId = lineId;
    }
    /**
     * @return the portStatus
     */
    public String getPortStatus()
    {
        return portStatus;
    }
    /**
     * @param portStatus the portStatus to set
     */
    public void setPortStatus(String portStatus)
    {
        this.portStatus = portStatus;
    }
    /**
     * @return the spName
     */
    public String getSpName()
    {
        return spName;
    }
    /**
     * @param spName the spName to set
     */
    public void setSpName(String spName)
    {
        this.spName = spName;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((portStatus == null) ? 0 : portStatus.hashCode());
        result = prime * result + ((spName == null) ? 0 : spName.hashCode());
        result = prime * result + ((transberNumber == null) ? 0 : transberNumber.hashCode());
        return result;
    }
    /* (non-Javadoc)
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
        PortalOrderPortRequestBean other = (PortalOrderPortRequestBean) obj;
        if (lineId == null)
        {
            if (other.lineId != null)
                return false;
        }
        else if (!lineId.equals(other.lineId))
            return false;
        if (orderId == null)
        {
            if (other.orderId != null)
                return false;
        }
        else if (!orderId.equals(other.orderId))
            return false;
        if (portStatus == null)
        {
            if (other.portStatus != null)
                return false;
        }
        else if (!portStatus.equals(other.portStatus))
            return false;
        if (spName == null)
        {
            if (other.spName != null)
                return false;
        }
        else if (!spName.equals(other.spName))
            return false;
        if (transberNumber == null)
        {
            if (other.transberNumber != null)
                return false;
        }
        else if (!transberNumber.equals(other.transberNumber))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "PortalOrderPortRequestBean [orderId=" + orderId + ", transberNumber=" + transberNumber + ", lineId=" + lineId + ", portStatus=" + portStatus + ", spName=" + spName + "]";
    }
    
    
    
}
