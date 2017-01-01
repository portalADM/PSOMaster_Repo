/************************************************************************************************************
 * Class Name : EnsOrderMasterResponseBean.java Description:
 * 
 * Author : Ankita Mishra Date : Jul 18, 2016 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 */
public class EnsOrderMasterResponseBean extends BaseResponseBean implements Serializable
{
    private static final long serialVersionUID = -376635325830405795L;
    private java.lang.String ensOrderId;
    private java.lang.String orderStatus;
    private java.lang.String sys_creation_date;
    private java.lang.String sys_update_date;
    private java.lang.String ptnStatus;
    private java.lang.String applicationId;
    private java.lang.String ban;
    private java.lang.String ptn;
    
    private List<EnsembleLineItemInfoBean> ensLineItemList;


    public java.lang.String getensOrderId()
    {
        return ensOrderId;
    }

    public void setensOrderId(java.lang.String ensOrderId)
    {
        this.ensOrderId = ensOrderId;
    }

    public java.lang.String getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(java.lang.String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public java.lang.String getSys_creation_date()
    {
        return sys_creation_date;
    }

    public void setSys_creation_date(java.lang.String sys_creation_date)
    {
        this.sys_creation_date = sys_creation_date;
    }

    public java.lang.String getSys_update_date()
    {
        return sys_update_date;
    }

    public void setSys_update_date(java.lang.String sys_update_date)
    {
        this.sys_update_date = sys_update_date;
    }

    public java.lang.String getPtnStatus()
    {
        return ptnStatus;
    }

    public void setPtnStatus(java.lang.String ptnStatus)
    {
        this.ptnStatus = ptnStatus;
    }

    public java.lang.String getApplicationId()
    {
        return applicationId;
    }

    public void setApplicationId(java.lang.String applicationId)
    {
        this.applicationId = applicationId;
    }

    public java.lang.String getBan()
    {
        return ban;
    }

    public void setBan(java.lang.String ban)
    {
        this.ban = ban;
    }

    public java.lang.String getPtn()
    {
        return ptn;
    }

    public void setPtn(java.lang.String ptn)
    {
        this.ptn = ptn;
    }

    /**
     * @return the ensLineItemList
     */
    public List<EnsembleLineItemInfoBean> getEnsLineItemList()
    {
        return ensLineItemList;
    }

    /**
     * @param ensLineItemList the ensLineItemList to set
     */
    public void setEnsLineItemList(List<EnsembleLineItemInfoBean> ensLineItemList)
    {
        this.ensLineItemList = ensLineItemList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
        result = prime * result + ((ban == null) ? 0 : ban.hashCode());
        result = prime * result + ((ensLineItemList == null) ? 0 : ensLineItemList.hashCode());
        result = prime * result + ((ensOrderId == null) ? 0 : ensOrderId.hashCode());
        result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
        result = prime * result + ((ptn == null) ? 0 : ptn.hashCode());
        result = prime * result + ((ptnStatus == null) ? 0 : ptnStatus.hashCode());
        result = prime * result + ((sys_creation_date == null) ? 0 : sys_creation_date.hashCode());
        result = prime * result + ((sys_update_date == null) ? 0 : sys_update_date.hashCode());
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
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnsOrderMasterResponseBean other = (EnsOrderMasterResponseBean) obj;
        if (applicationId == null)
        {
            if (other.applicationId != null)
                return false;
        }
        else if (!applicationId.equals(other.applicationId))
            return false;
        if (ban == null)
        {
            if (other.ban != null)
                return false;
        }
        else if (!ban.equals(other.ban))
            return false;
        if (ensLineItemList == null)
        {
            if (other.ensLineItemList != null)
                return false;
        }
        else if (!ensLineItemList.equals(other.ensLineItemList))
            return false;
        if (ensOrderId == null)
        {
            if (other.ensOrderId != null)
                return false;
        }
        else if (!ensOrderId.equals(other.ensOrderId))
            return false;
        if (orderStatus == null)
        {
            if (other.orderStatus != null)
                return false;
        }
        else if (!orderStatus.equals(other.orderStatus))
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
        if (sys_creation_date == null)
        {
            if (other.sys_creation_date != null)
                return false;
        }
        else if (!sys_creation_date.equals(other.sys_creation_date))
            return false;
        if (sys_update_date == null)
        {
            if (other.sys_update_date != null)
                return false;
        }
        else if (!sys_update_date.equals(other.sys_update_date))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "EnsOrderMasterResponseBean [ensOrderId=" + ensOrderId + ", orderStatus=" + orderStatus + ", sys_creation_date=" + sys_creation_date + ", sys_update_date=" + sys_update_date
                + ", ptnStatus=" + ptnStatus + ", applicationId=" + applicationId + ", ban=" + ban + ", ptn=" + ptn + ", ensLineItemList=" + ensLineItemList + "]";
    }

}
