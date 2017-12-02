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
    private java.lang.String sysCreationDate;
    private java.lang.String sysUpdateDate;
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
        return sysCreationDate;
    }

    public void setSys_creation_date(java.lang.String sysCreationDate)
    {
        this.sysCreationDate = sysCreationDate;
    }

    public java.lang.String getSys_update_date()
    {
        return sysCreationDate;
    }

    public void setSys_update_date(java.lang.String sysUpdateDate)
    {
        this.sysUpdateDate = sysUpdateDate;
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "EnsOrderMasterResponseBean [ensOrderId=" + ensOrderId + ", orderStatus=" + orderStatus + ", sys_creation_date=" + sysCreationDate + ", sys_update_date=" + sysUpdateDate
                + ", ptnStatus=" + ptnStatus + ", applicationId=" + applicationId + ", ban=" + ban + ", ptn=" + ptn + ", ensLineItemList=" + ensLineItemList + "]";
    }

}
