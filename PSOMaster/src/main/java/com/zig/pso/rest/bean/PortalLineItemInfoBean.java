/************************************************************************************************************
 * Class Name :  PortalLineItemInfoBean.java
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
public class PortalLineItemInfoBean implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String orderId;
    private String lineId;
    private String lineType;
    private String imei;
    private String subscriberId;
    private String subFlowType;
    private String zipCode;
    private boolean isUpdateSubCalled;
    private boolean isPurchseDeviceCalled;
    private String wirelessNumber;
    /**
     * 
     */
    public PortalLineItemInfoBean()
    {
        super();
    }
    /**
     * @param orderId
     * @param lineId
     * @param lineType
     * @param imei
     * @param subscriberId
     * @param subFlowType
     * @param zipCode
     * @param isUpdateSubCalled
     * @param isPurchseDeviceCalled
     * @param wirelessNumber
     */
    public PortalLineItemInfoBean(String orderId, String lineId, String lineType, String imei, String subscriberId, String subFlowType, String zipCode, boolean isUpdateSubCalled,
            boolean isPurchseDeviceCalled, String wirelessNumber)
    {
        super();
        this.orderId = orderId;
        this.lineId = lineId;
        this.lineType = lineType;
        this.imei = imei;
        this.subscriberId = subscriberId;
        this.subFlowType = subFlowType;
        this.zipCode = zipCode;
        this.isUpdateSubCalled = isUpdateSubCalled;
        this.isPurchseDeviceCalled = isPurchseDeviceCalled;
        this.wirelessNumber = wirelessNumber;
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
     * @return the lineType
     */
    public String getLineType()
    {
        return lineType;
    }
    /**
     * @param lineType the lineType to set
     */
    public void setLineType(String lineType)
    {
        this.lineType = lineType;
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
     * @return the subscriberId
     */
    public String getSubscriberId()
    {
        return subscriberId;
    }
    /**
     * @param subscriberId the subscriberId to set
     */
    public void setSubscriberId(String subscriberId)
    {
        this.subscriberId = subscriberId;
    }
    /**
     * @return the subFlowType
     */
    public String getSubFlowType()
    {
        return subFlowType;
    }
    /**
     * @param subFlowType the subFlowType to set
     */
    public void setSubFlowType(String subFlowType)
    {
        this.subFlowType = subFlowType;
    }
    /**
     * @return the zipCode
     */
    public String getZipCode()
    {
        return zipCode;
    }
    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
    /**
     * @return the isUpdateSubCalled
     */
    public boolean isUpdateSubCalled()
    {
        return isUpdateSubCalled;
    }
    /**
     * @param isUpdateSubCalled the isUpdateSubCalled to set
     */
    public void setUpdateSubCalled(boolean isUpdateSubCalled)
    {
        this.isUpdateSubCalled = isUpdateSubCalled;
    }
    /**
     * @return the isPurchseDeviceCalled
     */
    public boolean isPurchseDeviceCalled()
    {
        return isPurchseDeviceCalled;
    }
    /**
     * @param isPurchseDeviceCalled the isPurchseDeviceCalled to set
     */
    public void setPurchseDeviceCalled(boolean isPurchseDeviceCalled)
    {
        this.isPurchseDeviceCalled = isPurchseDeviceCalled;
    }
    /**
     * @return the wirelessNumber
     */
    public String getWirelessNumber()
    {
        return wirelessNumber;
    }
    /**
     * @param wirelessNumber the wirelessNumber to set
     */
    public void setWirelessNumber(String wirelessNumber)
    {
        this.wirelessNumber = wirelessNumber;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imei == null) ? 0 : imei.hashCode());
        result = prime * result + (isPurchseDeviceCalled ? 1231 : 1237);
        result = prime * result + (isUpdateSubCalled ? 1231 : 1237);
        result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
        result = prime * result + ((lineType == null) ? 0 : lineType.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((subFlowType == null) ? 0 : subFlowType.hashCode());
        result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
        result = prime * result + ((wirelessNumber == null) ? 0 : wirelessNumber.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
        PortalLineItemInfoBean other = (PortalLineItemInfoBean) obj;
        if (imei == null)
        {
            if (other.imei != null)
                return false;
        }
        else if (!imei.equals(other.imei))
            return false;
        if (isPurchseDeviceCalled != other.isPurchseDeviceCalled)
            return false;
        if (isUpdateSubCalled != other.isUpdateSubCalled)
            return false;
        if (lineId == null)
        {
            if (other.lineId != null)
                return false;
        }
        else if (!lineId.equals(other.lineId))
            return false;
        if (lineType == null)
        {
            if (other.lineType != null)
                return false;
        }
        else if (!lineType.equals(other.lineType))
            return false;
        if (orderId == null)
        {
            if (other.orderId != null)
                return false;
        }
        else if (!orderId.equals(other.orderId))
            return false;
        if (subFlowType == null)
        {
            if (other.subFlowType != null)
                return false;
        }
        else if (!subFlowType.equals(other.subFlowType))
            return false;
        if (subscriberId == null)
        {
            if (other.subscriberId != null)
                return false;
        }
        else if (!subscriberId.equals(other.subscriberId))
            return false;
        if (wirelessNumber == null)
        {
            if (other.wirelessNumber != null)
                return false;
        }
        else if (!wirelessNumber.equals(other.wirelessNumber))
            return false;
        if (zipCode == null)
        {
            if (other.zipCode != null)
                return false;
        }
        else if (!zipCode.equals(other.zipCode))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "PortalLineItemInfoBean [orderId=" + orderId + ", lineId=" + lineId + ", lineType=" + lineType + ", imei=" + imei + ", subscriberId=" + subscriberId + ", subFlowType=" + subFlowType
                + ", zipCode=" + zipCode + ", isUpdateSubCalled=" + isUpdateSubCalled + ", isPurchseDeviceCalled=" + isPurchseDeviceCalled + ", wirelessNumber=" + wirelessNumber + "]";
    }
    
    
    
}
