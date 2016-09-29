/************************************************************************************************************
 * Class Name : ApiOrderMasterResponseBean.java Description: Response Bean for GetApidetails Rest API Author : Ankita Mishra Date : Jul 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class ApiOrderMasterResponseBean extends BaseResponseBean implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 5613472145643671406L;
    private String OrderId;
    private String Source;
    private String APIName;
    private String SysCreationDate;
    private String OriginatorID;
    private String ErrorMessage;
    private String seqNumber;

    public String getOrderId()
    {
        return OrderId;
    }

    public void setOrderId(String orderId)
    {
        OrderId = orderId;
    }

    public String getSource()
    {
        return Source;
    }

    public void setSource(String source)
    {
        Source = source;
    }

    public String getAPIName()
    {
        return APIName;
    }

    public void setAPIName(String aPIName)
    {
        APIName = aPIName;
    }

    public String getSysCreationDate()
    {
        return SysCreationDate;
    }

    public void setSysCreationDate(String sysCreationDate)
    {
        SysCreationDate = sysCreationDate;
    }

    public String getOriginatorID()
    {
        return OriginatorID;
    }

    public void setOriginatorID(String originatorID)
    {
        OriginatorID = originatorID;
    }

    public String getErrorMessage()
    {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        ErrorMessage = errorMessage;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((APIName == null) ? 0 : APIName.hashCode());
        result = prime * result + ((ErrorMessage == null) ? 0 : ErrorMessage.hashCode());
        result = prime * result + ((OrderId == null) ? 0 : OrderId.hashCode());
        result = prime * result + ((OriginatorID == null) ? 0 : OriginatorID.hashCode());
        result = prime * result + ((Source == null) ? 0 : Source.hashCode());
        result = prime * result + ((SysCreationDate == null) ? 0 : SysCreationDate.hashCode());
        result = prime * result + ((seqNumber == null) ? 0 : seqNumber.hashCode());
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
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ApiOrderMasterResponseBean other = (ApiOrderMasterResponseBean) obj;
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
        if (seqNumber == null)
        {
            if (other.seqNumber != null)
                return false;
        }
        else if (!seqNumber.equals(other.seqNumber))
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
        return "ApiOrderMasterResponseBean [OrderId=" + OrderId + ", Source=" + Source + ", APIName=" + APIName + ", SysCreationDate=" + SysCreationDate + ", OriginatorID=" + OriginatorID
                + ", ErrorMessage=" + ErrorMessage + ", seqNumber=" + seqNumber + "]";
    }

}
