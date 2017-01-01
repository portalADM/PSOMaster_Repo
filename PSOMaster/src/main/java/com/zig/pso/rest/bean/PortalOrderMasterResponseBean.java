/************************************************************************************************************
 * Class Name : PortalOrderMasterResponseBean.java 
 * Description: 
 * Author : Ankita Mishra 
 * Date : Jun 29, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PortalOrderMasterResponseBean extends BaseResponseBean implements Serializable
{
    private static final long serialVersionUID = -9173854076277065361L;
    private java.lang.String orderId;
    private java.lang.String status;
    private java.lang.String sys_creation_date;
    private java.lang.String sys_update_date;
    private java.lang.String originatorId;
    private java.lang.String retry;
    private java.lang.String OrderType;
    private java.lang.String ban;
    private java.lang.String ptn;
    private PortalEnrollmentInfo enrollInfo;

    //private PortalShipmentInfoForUI portalShipmentInfo;
    
    private ArrayList<PortalShipmentInfo> portalShipmentInfo;
    
    /**
     * @return the portalShipmentInfo
     */
    public ArrayList<PortalShipmentInfo> getPortalShipmentInfo()
    {
        return portalShipmentInfo;
    }

    /**
     * @param portalShipmentInfo the portalShipmentInfo to set
     */
    public void setPortalShipmentInfo(ArrayList<PortalShipmentInfo> portalShipmentInfo)
    {
        this.portalShipmentInfo = portalShipmentInfo;
    }

    private List<PortalLineItemInfoBean> portalLineItemList;

    public java.lang.String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(java.lang.String orderId)
    {
        this.orderId = orderId;
    }

    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
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

    public java.lang.String getOriginatorId()
    {
        return originatorId;
    }

    public void setOriginatorId(java.lang.String originatorId)
    {
        this.originatorId = originatorId;
    }

    public java.lang.String getRetry()
    {
        return retry;
    }

    public void setRetry(java.lang.String retry)
    {
        this.retry = retry;
    }

    public java.lang.String getOrderType()
    {
        return OrderType;
    }

    public void setOrderType(java.lang.String orderType)
    {
        OrderType = orderType;
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

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

//    public PortalShipmentInfoForUI getPortalShipmentInfo()
//    {
//        return portalShipmentInfo;
//    }
//
//    public void setPortalShipmentInfo(PortalShipmentInfoForUI portalShipmentInfo)
//    {
//        this.portalShipmentInfo = portalShipmentInfo;
//    }

    public PortalEnrollmentInfo getEnrollInfo()
    {
        return enrollInfo;
    }

    public void setEnrollInfo(PortalEnrollmentInfo enrollInfo)
    {
        this.enrollInfo = enrollInfo;
    }

    /**
     * @return the portalLineItemList
     */
    public List<PortalLineItemInfoBean> getPortalLineItemList()
    {
        return portalLineItemList;
    }

    /**
     * @param portalLineItemList the portalLineItemList to set
     */
    public void setPortalLineItemList(List<PortalLineItemInfoBean> portalLineItemList)
    {
        this.portalLineItemList = portalLineItemList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((OrderType == null) ? 0 : OrderType.hashCode());
        result = prime * result + ((ban == null) ? 0 : ban.hashCode());
        result = prime * result + ((enrollInfo == null) ? 0 : enrollInfo.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((originatorId == null) ? 0 : originatorId.hashCode());
        result = prime * result + ((portalLineItemList == null) ? 0 : portalLineItemList.hashCode());
        result = prime * result + ((portalShipmentInfo == null) ? 0 : portalShipmentInfo.hashCode());
        result = prime * result + ((ptn == null) ? 0 : ptn.hashCode());
        result = prime * result + ((retry == null) ? 0 : retry.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        PortalOrderMasterResponseBean other = (PortalOrderMasterResponseBean) obj;
        if (OrderType == null)
        {
            if (other.OrderType != null)
                return false;
        }
        else if (!OrderType.equals(other.OrderType))
            return false;
        if (ban == null)
        {
            if (other.ban != null)
                return false;
        }
        else if (!ban.equals(other.ban))
            return false;
        if (enrollInfo == null)
        {
            if (other.enrollInfo != null)
                return false;
        }
        else if (!enrollInfo.equals(other.enrollInfo))
            return false;
        if (orderId == null)
        {
            if (other.orderId != null)
                return false;
        }
        else if (!orderId.equals(other.orderId))
            return false;
        if (originatorId == null)
        {
            if (other.originatorId != null)
                return false;
        }
        else if (!originatorId.equals(other.originatorId))
            return false;
        if (portalLineItemList == null)
        {
            if (other.portalLineItemList != null)
                return false;
        }
        else if (!portalLineItemList.equals(other.portalLineItemList))
            return false;
        if (portalShipmentInfo == null)
        {
            if (other.portalShipmentInfo != null)
                return false;
        }
        else if (!portalShipmentInfo.equals(other.portalShipmentInfo))
            return false;
        if (ptn == null)
        {
            if (other.ptn != null)
                return false;
        }
        else if (!ptn.equals(other.ptn))
            return false;
        if (retry == null)
        {
            if (other.retry != null)
                return false;
        }
        else if (!retry.equals(other.retry))
            return false;
        if (status == null)
        {
            if (other.status != null)
                return false;
        }
        else if (!status.equals(other.status))
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
        return "PortalOrderMasterResponseBean [orderId=" + orderId + ", status=" + status + ", sys_creation_date=" + sys_creation_date + ", sys_update_date=" + sys_update_date + ", originatorId="
                + originatorId + ", retry=" + retry + ", OrderType=" + OrderType + ", ban=" + ban + ", ptn=" + ptn + ", enrollInfo=" + enrollInfo + ", portalShipmentInfo=" + portalShipmentInfo
                + ", portalLineItemList=" + portalLineItemList + "]";
    }

  
   

}
