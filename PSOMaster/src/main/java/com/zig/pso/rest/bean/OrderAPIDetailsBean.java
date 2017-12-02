/************************************************************************************************************
 * Class Name : ApiOrderMasterResponseBean.java 
 * Description: Response Bean for GetApidetails Rest API 
 * Author : Ankita Mishra 
 * Date : Jul 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class OrderAPIDetailsBean implements Serializable
{
    private static final long serialVersionUID = 5613472145643671406L;
    private String orderId;
    private String source;
    private String aPIName;
    private String sysCreationDate;
    private String originatorID;
    private String errorMessage;
    private String seqNumber;
    private String errorInResponse;
    
    /**
     * 
     */
    public OrderAPIDetailsBean()
    {
        super();
    }
    /**
     * @param orderId
     * @param source
     * @param aPIName
     * @param sysCreationDate
     * @param originatorID
     * @param errorMessage
     * @param seqNumber
     * @param errorInResponse
     */
    public OrderAPIDetailsBean(String orderId, String source, String aPIName, String sysCreationDate, String originatorID, String errorMessage, String seqNumber, String errorInResponse)
    {
        super();
        this.orderId = orderId;
        this.source = source;
        this.aPIName = aPIName;
        this.sysCreationDate = sysCreationDate;
        this.originatorID = originatorID;
        this.errorMessage = errorMessage;
        this.seqNumber = seqNumber;
        this.errorInResponse = errorInResponse;
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
     * @return the source
     */
    public String getSource()
    {
        return source;
    }
    /**
     * @param source the source to set
     */
    public void setSource(String source)
    {
        this.source = source;
    }
    /**
     * @return the aPIName
     */
    public String getaPIName()
    {
        return aPIName;
    }
    /**
     * @param aPIName the aPIName to set
     */
    public void setaPIName(String aPIName)
    {
        this.aPIName = aPIName;
    }
    /**
     * @return the sysCreationDate
     */
    public String getSysCreationDate()
    {
        return sysCreationDate;
    }
    /**
     * @param sysCreationDate the sysCreationDate to set
     */
    public void setSysCreationDate(String sysCreationDate)
    {
        this.sysCreationDate = sysCreationDate;
    }
    /**
     * @return the originatorID
     */
    public String getOriginatorID()
    {
        return originatorID;
    }
    /**
     * @param originatorID the originatorID to set
     */
    public void setOriginatorID(String originatorID)
    {
        this.originatorID = originatorID;
    }
    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return errorMessage;
    }
    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    /**
     * @return the seqNumber
     */
    public String getSeqNumber()
    {
        return seqNumber;
    }
    /**
     * @param seqNumber the seqNumber to set
     */
    public void setSeqNumber(String seqNumber)
    {
        this.seqNumber = seqNumber;
    }
    /**
     * @return the errorInResponse
     */
    public String getErrorInResponse()
    {
        return errorInResponse;
    }
    /**
     * @param errorInResponse the errorInResponse to set
     */
    public void setErrorInResponse(String errorInResponse)
    {
        this.errorInResponse = errorInResponse;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aPIName == null) ? 0 : aPIName.hashCode());
        result = prime * result + ((errorInResponse == null) ? 0 : errorInResponse.hashCode());
        result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((originatorID == null) ? 0 : originatorID.hashCode());
        result = prime * result + ((seqNumber == null) ? 0 : seqNumber.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result + ((sysCreationDate == null) ? 0 : sysCreationDate.hashCode());
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
        OrderAPIDetailsBean other = (OrderAPIDetailsBean) obj;
        if (aPIName == null)
        {
            if (other.aPIName != null)
                return false;
        }
        else if (!aPIName.equals(other.aPIName))
            return false;
        if (errorInResponse == null)
        {
            if (other.errorInResponse != null)
                return false;
        }
        else if (!errorInResponse.equals(other.errorInResponse))
            return false;
        if (errorMessage == null)
        {
            if (other.errorMessage != null)
                return false;
        }
        else if (!errorMessage.equals(other.errorMessage))
            return false;
        if (orderId == null)
        {
            if (other.orderId != null)
                return false;
        }
        else if (!orderId.equals(other.orderId))
            return false;
        if (originatorID == null)
        {
            if (other.originatorID != null)
                return false;
        }
        else if (!originatorID.equals(other.originatorID))
            return false;
        if (seqNumber == null)
        {
            if (other.seqNumber != null)
                return false;
        }
        else if (!seqNumber.equals(other.seqNumber))
            return false;
        if (source == null)
        {
            if (other.source != null)
                return false;
        }
        else if (!source.equals(other.source))
            return false;
        if (sysCreationDate == null)
        {
            if (other.sysCreationDate != null)
                return false;
        }
        else if (!sysCreationDate.equals(other.sysCreationDate))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "OrderAPIDetailsBean [orderId=" + orderId + ", source=" + source + ", aPIName=" + aPIName + ", sysCreationDate=" + sysCreationDate + ", originatorID=" + originatorID
                + ", errorMessage=" + errorMessage + ", seqNumber=" + seqNumber + ", errorInResponse=" + errorInResponse + "]";
    }
    
}
