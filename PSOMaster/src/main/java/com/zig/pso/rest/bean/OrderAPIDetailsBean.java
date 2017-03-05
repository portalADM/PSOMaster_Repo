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
    private String OrderId;
    private String Source;
    private String APIName;
    private String SysCreationDate;
    private String OriginatorID;
    private String ErrorMessage;
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
        OrderId = orderId;
        Source = source;
        APIName = aPIName;
        SysCreationDate = sysCreationDate;
        OriginatorID = originatorID;
        ErrorMessage = errorMessage;
        this.seqNumber = seqNumber;
        this.errorInResponse = errorInResponse;
    }

    /**
     * @return the orderId
     */
    public String getOrderId()
    {
        return OrderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId)
    {
        OrderId = orderId;
    }

    /**
     * @return the source
     */
    public String getSource()
    {
        return Source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source)
    {
        Source = source;
    }

    /**
     * @return the aPIName
     */
    public String getAPIName()
    {
        return APIName;
    }

    /**
     * @param aPIName the aPIName to set
     */
    public void setAPIName(String aPIName)
    {
        APIName = aPIName;
    }

    /**
     * @return the sysCreationDate
     */
    public String getSysCreationDate()
    {
        return SysCreationDate;
    }

    /**
     * @param sysCreationDate the sysCreationDate to set
     */
    public void setSysCreationDate(String sysCreationDate)
    {
        SysCreationDate = sysCreationDate;
    }

    /**
     * @return the originatorID
     */
    public String getOriginatorID()
    {
        return OriginatorID;
    }

    /**
     * @param originatorID the originatorID to set
     */
    public void setOriginatorID(String originatorID)
    {
        OriginatorID = originatorID;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return ErrorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage)
    {
        ErrorMessage = errorMessage;
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
        result = prime * result + ((APIName == null) ? 0 : APIName.hashCode());
        result = prime * result + ((ErrorMessage == null) ? 0 : ErrorMessage.hashCode());
        result = prime * result + ((OrderId == null) ? 0 : OrderId.hashCode());
        result = prime * result + ((OriginatorID == null) ? 0 : OriginatorID.hashCode());
        result = prime * result + ((Source == null) ? 0 : Source.hashCode());
        result = prime * result + ((SysCreationDate == null) ? 0 : SysCreationDate.hashCode());
        result = prime * result + ((errorInResponse == null) ? 0 : errorInResponse.hashCode());
        result = prime * result + ((seqNumber == null) ? 0 : seqNumber.hashCode());
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
        if (APIName == null)
        {
            if (other.APIName != null)
                return false;
        }
        else if (!APIName.equals(other.APIName))
            return false;
        if (ErrorMessage == null)
        {
            if (other.ErrorMessage != null)
                return false;
        }
        else if (!ErrorMessage.equals(other.ErrorMessage))
            return false;
        if (OrderId == null)
        {
            if (other.OrderId != null)
                return false;
        }
        else if (!OrderId.equals(other.OrderId))
            return false;
        if (OriginatorID == null)
        {
            if (other.OriginatorID != null)
                return false;
        }
        else if (!OriginatorID.equals(other.OriginatorID))
            return false;
        if (Source == null)
        {
            if (other.Source != null)
                return false;
        }
        else if (!Source.equals(other.Source))
            return false;
        if (SysCreationDate == null)
        {
            if (other.SysCreationDate != null)
                return false;
        }
        else if (!SysCreationDate.equals(other.SysCreationDate))
            return false;
        if (errorInResponse == null)
        {
            if (other.errorInResponse != null)
                return false;
        }
        else if (!errorInResponse.equals(other.errorInResponse))
            return false;
        if (seqNumber == null)
        {
            if (other.seqNumber != null)
                return false;
        }
        else if (!seqNumber.equals(other.seqNumber))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "OrderAPIDetailsBean [OrderId=" + OrderId + ", Source=" + Source + ", APIName=" + APIName + ", SysCreationDate=" + SysCreationDate + ", OriginatorID=" + OriginatorID
                + ", ErrorMessage=" + ErrorMessage + ", seqNumber=" + seqNumber + ", errorInResponse=" + errorInResponse + "]";
    }
    
    
    

}
