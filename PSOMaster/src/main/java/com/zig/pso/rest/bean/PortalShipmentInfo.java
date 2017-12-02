/************************************************************************************************************
 * Class Name :  PortalShipmentInfo.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jun 30, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class PortalShipmentInfo implements Serializable {
	
	private static final long serialVersionUID = 2877440920582859690L;
	private String epcSkuId;
    private String productType;
    private String sim;
    private String imei;
    private String esnNumber;
    private String shipmentDate;
    private String lineItemNo;
    private String deviceDisplayName;
    private String subscriberId;
    private String ptn;
    private String orderId;
    
    /**
     * 
     */
    public PortalShipmentInfo()
    {
        super();
    }

    /**
     * @param epcSkuId
     * @param productType
     * @param sim
     * @param imei
     * @param esnNumber
     * @param shipmentDate
     * @param lineItemNo
     * @param deviceDisplayName
     * @param subscriberId
     * @param ptn
     * @param orderId
     */
    public PortalShipmentInfo(String epcSkuId, String productType, String sim, String imei, String esnNumber, String shipmentDate, String lineItemNo, String deviceDisplayName, String subscriberId,
            String ptn, String orderId)
    {
        super();
        this.epcSkuId = epcSkuId;
        this.productType = productType;
        this.sim = sim;
        this.imei = imei;
        this.esnNumber = esnNumber;
        this.shipmentDate = shipmentDate;
        this.lineItemNo = lineItemNo;
        this.deviceDisplayName = deviceDisplayName;
        this.subscriberId = subscriberId;
        this.ptn = ptn;
        this.orderId = orderId;
    }

    /**
     * @return the epcSkuId
     */
    public String getEpcSkuId()
    {
        return epcSkuId;
    }

    /**
     * @param epcSkuId the epcSkuId to set
     */
    public void setEpcSkuId(String epcSkuId)
    {
        this.epcSkuId = epcSkuId;
    }

    /**
     * @return the productType
     */
    public String getProductType()
    {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType)
    {
        this.productType = productType;
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
     * @return the esnNumber
     */
    public String getEsnNumber()
    {
        return esnNumber;
    }

    /**
     * @param esnNumber the esnNumber to set
     */
    public void setEsnNumber(String esnNumber)
    {
        this.esnNumber = esnNumber;
    }

    /**
     * @return the shipmentDate
     */
    public String getShipmentDate()
    {
        return shipmentDate;
    }

    /**
     * @param shipmentDate the shipmentDate to set
     */
    public void setShipmentDate(String shipmentDate)
    {
        this.shipmentDate = shipmentDate;
    }

    /**
     * @return the lineItemNo
     */
    public String getLineItemNo()
    {
        return lineItemNo;
    }

    /**
     * @param lineItemNo the lineItemNo to set
     */
    public void setLineItemNo(String lineItemNo)
    {
        this.lineItemNo = lineItemNo;
    }

    /**
     * @return the deviceDisplayName
     */
    public String getDeviceDisplayName()
    {
        return deviceDisplayName;
    }

    /**
     * @param deviceDisplayName the deviceDisplayName to set
     */
    public void setDeviceDisplayName(String deviceDisplayName)
    {
        this.deviceDisplayName = deviceDisplayName;
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deviceDisplayName == null) ? 0 : deviceDisplayName.hashCode());
        result = prime * result + ((epcSkuId == null) ? 0 : epcSkuId.hashCode());
        result = prime * result + ((esnNumber == null) ? 0 : esnNumber.hashCode());
        result = prime * result + ((imei == null) ? 0 : imei.hashCode());
        result = prime * result + ((lineItemNo == null) ? 0 : lineItemNo.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((productType == null) ? 0 : productType.hashCode());
        result = prime * result + ((ptn == null) ? 0 : ptn.hashCode());
        result = prime * result + ((shipmentDate == null) ? 0 : shipmentDate.hashCode());
        result = prime * result + ((sim == null) ? 0 : sim.hashCode());
        result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
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
        PortalShipmentInfo other = (PortalShipmentInfo) obj;
        if (deviceDisplayName == null)
        {
            if (other.deviceDisplayName != null)
                return false;
        }
        else if (!deviceDisplayName.equals(other.deviceDisplayName))
            return false;
        if (epcSkuId == null)
        {
            if (other.epcSkuId != null)
                return false;
        }
        else if (!epcSkuId.equals(other.epcSkuId))
            return false;
        if (esnNumber == null)
        {
            if (other.esnNumber != null)
                return false;
        }
        else if (!esnNumber.equals(other.esnNumber))
            return false;
        if (imei == null)
        {
            if (other.imei != null)
                return false;
        }
        else if (!imei.equals(other.imei))
            return false;
        if (lineItemNo == null)
        {
            if (other.lineItemNo != null)
                return false;
        }
        else if (!lineItemNo.equals(other.lineItemNo))
            return false;
        if (orderId == null)
        {
            if (other.orderId != null)
                return false;
        }
        else if (!orderId.equals(other.orderId))
            return false;
        if (productType == null)
        {
            if (other.productType != null)
                return false;
        }
        else if (!productType.equals(other.productType))
            return false;
        if (ptn == null)
        {
            if (other.ptn != null)
                return false;
        }
        else if (!ptn.equals(other.ptn))
            return false;
        if (shipmentDate == null)
        {
            if (other.shipmentDate != null)
                return false;
        }
        else if (!shipmentDate.equals(other.shipmentDate))
            return false;
        if (sim == null)
        {
            if (other.sim != null)
                return false;
        }
        else if (!sim.equals(other.sim))
            return false;
        if (subscriberId == null)
        {
            if (other.subscriberId != null)
                return false;
        }
        else if (!subscriberId.equals(other.subscriberId))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "PortalShipmentInfo [epcSkuId=" + epcSkuId + ", productType=" + productType + ", sim=" + sim + ", imei=" + imei + ", esnNumber=" + esnNumber + ", shipmentDate=" + shipmentDate
                + ", lineItemNo=" + lineItemNo + ", deviceDisplayName=" + deviceDisplayName + ", subscriberId=" + subscriberId + ", ptn=" + ptn + ", orderId=" + orderId + "]";
    }
    
    
    


}
