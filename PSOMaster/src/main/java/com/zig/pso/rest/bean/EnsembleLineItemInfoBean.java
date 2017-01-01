/************************************************************************************************************
 * Class Name :  EnsembleLineItemInfoBean.java
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
public class EnsembleLineItemInfoBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String orderid;
    private String applicationId;
    private String sublineStatus;
    private String ptn;
    private String subscriberNo;
    private String sim;
    private String imei;
    private String accountNo;
    private String ptnStatus;
    /**
     * 
     */
    public EnsembleLineItemInfoBean()
    {
        super();
    }
    /**
     * @param orderid
     * @param applicationId
     * @param sublineStatus
     * @param ptn
     * @param subscriberNo
     * @param sim
     * @param imei
     * @param accountNo
     * @param ptnStatus
     */
    public EnsembleLineItemInfoBean(String orderid, String applicationId, String sublineStatus, String ptn, String subscriberNo, String sim, String imei, String accountNo, String ptnStatus)
    {
        super();
        this.orderid = orderid;
        this.applicationId = applicationId;
        this.sublineStatus = sublineStatus;
        this.ptn = ptn;
        this.subscriberNo = subscriberNo;
        this.sim = sim;
        this.imei = imei;
        this.accountNo = accountNo;
        this.ptnStatus = ptnStatus;
    }
    /**
     * @return the orderid
     */
    public String getOrderid()
    {
        return orderid;
    }
    /**
     * @param orderid the orderid to set
     */
    public void setOrderid(String orderid)
    {
        this.orderid = orderid;
    }
    /**
     * @return the applicationId
     */
    public String getApplicationId()
    {
        return applicationId;
    }
    /**
     * @param applicationId the applicationId to set
     */
    public void setApplicationId(String applicationId)
    {
        this.applicationId = applicationId;
    }
    /**
     * @return the sublineStatus
     */
    public String getSublineStatus()
    {
        return sublineStatus;
    }
    /**
     * @param sublineStatus the sublineStatus to set
     */
    public void setSublineStatus(String sublineStatus)
    {
        this.sublineStatus = sublineStatus;
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
    /**
     * @return the subscriberNo
     */
    public String getSubscriberNo()
    {
        return subscriberNo;
    }
    /**
     * @param subscriberNo the subscriberNo to set
     */
    public void setSubscriberNo(String subscriberNo)
    {
        this.subscriberNo = subscriberNo;
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
     * @return the ptnStatus
     */
    public String getPtnStatus()
    {
        return ptnStatus;
    }
    /**
     * @param ptnStatus the ptnStatus to set
     */
    public void setPtnStatus(String ptnStatus)
    {
        this.ptnStatus = ptnStatus;
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
        result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
        result = prime * result + ((imei == null) ? 0 : imei.hashCode());
        result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
        result = prime * result + ((ptn == null) ? 0 : ptn.hashCode());
        result = prime * result + ((ptnStatus == null) ? 0 : ptnStatus.hashCode());
        result = prime * result + ((sim == null) ? 0 : sim.hashCode());
        result = prime * result + ((sublineStatus == null) ? 0 : sublineStatus.hashCode());
        result = prime * result + ((subscriberNo == null) ? 0 : subscriberNo.hashCode());
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
        EnsembleLineItemInfoBean other = (EnsembleLineItemInfoBean) obj;
        if (accountNo == null)
        {
            if (other.accountNo != null)
                return false;
        }
        else if (!accountNo.equals(other.accountNo))
            return false;
        if (applicationId == null)
        {
            if (other.applicationId != null)
                return false;
        }
        else if (!applicationId.equals(other.applicationId))
            return false;
        if (imei == null)
        {
            if (other.imei != null)
                return false;
        }
        else if (!imei.equals(other.imei))
            return false;
        if (orderid == null)
        {
            if (other.orderid != null)
                return false;
        }
        else if (!orderid.equals(other.orderid))
            return false;
        if (ptn == null)
        {
            if (other.ptn != null)
                return false;
        }
        else if (!ptn.equals(other.ptn))
            return false;
        if (ptnStatus == null)
        {
            if (other.ptnStatus != null)
                return false;
        }
        else if (!ptnStatus.equals(other.ptnStatus))
            return false;
        if (sim == null)
        {
            if (other.sim != null)
                return false;
        }
        else if (!sim.equals(other.sim))
            return false;
        if (sublineStatus == null)
        {
            if (other.sublineStatus != null)
                return false;
        }
        else if (!sublineStatus.equals(other.sublineStatus))
            return false;
        if (subscriberNo == null)
        {
            if (other.subscriberNo != null)
                return false;
        }
        else if (!subscriberNo.equals(other.subscriberNo))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "EnsembleLineItemInfoBean [orderid=" + orderid + ", applicationId=" + applicationId + ", sublineStatus=" + sublineStatus + ", ptn=" + ptn + ", subscriberNo=" + subscriberNo + ", sim="
                + sim + ", imei=" + imei + ", accountNo=" + accountNo + ", ptnStatus=" + ptnStatus + "]";
    }
    
    
    
}
