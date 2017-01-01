/************************************************************************************************************
 * Class Name :  EnsOrderPortRequestBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jan 1, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class EnsOrderPortRequestBean implements Serializable
{
    private static final long serialVersionUID = -726346981378915529L;
    
    private String requestNo;
    private String accountNo;
    private String portType;
    private String requestStatus;
    private String externalReqNo;
    private String statusDesc;
    private String ptn;
    /**
     * 
     */
    public EnsOrderPortRequestBean()
    {
        super();
    }
    /**
     * @param requestNo
     * @param accountNo
     * @param portType
     * @param requestStatus
     * @param externalReqNo
     * @param statusDesc
     * @param ptn
     */
    public EnsOrderPortRequestBean(String requestNo, String accountNo, String portType, String requestStatus, String externalReqNo, String statusDesc, String ptn)
    {
        super();
        this.requestNo = requestNo;
        this.accountNo = accountNo;
        this.portType = portType;
        this.requestStatus = requestStatus;
        this.externalReqNo = externalReqNo;
        this.statusDesc = statusDesc;
        this.ptn = ptn;
    }
    /**
     * @return the requestNo
     */
    public String getRequestNo()
    {
        return requestNo;
    }
    /**
     * @param requestNo the requestNo to set
     */
    public void setRequestNo(String requestNo)
    {
        this.requestNo = requestNo;
    }
    /**
     * @return the accountNo
     */
    public String getAccountNo()
    {
        return accountNo;
    }
    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(String accountNo)
    {
        this.accountNo = accountNo;
    }
    /**
     * @return the portType
     */
    public String getPortType()
    {
        return portType;
    }
    /**
     * @param portType the portType to set
     */
    public void setPortType(String portType)
    {
        this.portType = portType;
    }
    /**
     * @return the requestStatus
     */
    public String getRequestStatus()
    {
        return requestStatus;
    }
    /**
     * @param requestStatus the requestStatus to set
     */
    public void setRequestStatus(String requestStatus)
    {
        this.requestStatus = requestStatus;
    }
    /**
     * @return the externalReqNo
     */
    public String getExternalReqNo()
    {
        return externalReqNo;
    }
    /**
     * @param externalReqNo the externalReqNo to set
     */
    public void setExternalReqNo(String externalReqNo)
    {
        this.externalReqNo = externalReqNo;
    }
    /**
     * @return the statusDesc
     */
    public String getStatusDesc()
    {
        return statusDesc;
    }
    /**
     * @param statusDesc the statusDesc to set
     */
    public void setStatusDesc(String statusDesc)
    {
        this.statusDesc = statusDesc;
    }
    /**
     * @return the ptn
     */
    public String getPtn()
    {
        return ptn;
    }
    /**
     * @param ptn the ptn to set
     */
    public void setPtn(String ptn)
    {
        this.ptn = ptn;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
        result = prime * result + ((externalReqNo == null) ? 0 : externalReqNo.hashCode());
        result = prime * result + ((portType == null) ? 0 : portType.hashCode());
        result = prime * result + ((ptn == null) ? 0 : ptn.hashCode());
        result = prime * result + ((requestNo == null) ? 0 : requestNo.hashCode());
        result = prime * result + ((requestStatus == null) ? 0 : requestStatus.hashCode());
        result = prime * result + ((statusDesc == null) ? 0 : statusDesc.hashCode());
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
        EnsOrderPortRequestBean other = (EnsOrderPortRequestBean) obj;
        if (accountNo == null)
        {
            if (other.accountNo != null)
                return false;
        }
        else if (!accountNo.equals(other.accountNo))
            return false;
        if (externalReqNo == null)
        {
            if (other.externalReqNo != null)
                return false;
        }
        else if (!externalReqNo.equals(other.externalReqNo))
            return false;
        if (portType == null)
        {
            if (other.portType != null)
                return false;
        }
        else if (!portType.equals(other.portType))
            return false;
        if (ptn == null)
        {
            if (other.ptn != null)
                return false;
        }
        else if (!ptn.equals(other.ptn))
            return false;
        if (requestNo == null)
        {
            if (other.requestNo != null)
                return false;
        }
        else if (!requestNo.equals(other.requestNo))
            return false;
        if (requestStatus == null)
        {
            if (other.requestStatus != null)
                return false;
        }
        else if (!requestStatus.equals(other.requestStatus))
            return false;
        if (statusDesc == null)
        {
            if (other.statusDesc != null)
                return false;
        }
        else if (!statusDesc.equals(other.statusDesc))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "EnsOrderPortRequestBean [requestNo=" + requestNo + ", accountNo=" + accountNo + ", portType=" + portType + ", requestStatus=" + requestStatus + ", externalReqNo=" + externalReqNo
                + ", statusDesc=" + statusDesc + ", ptn=" + ptn + "]";
    }
    
    

}
