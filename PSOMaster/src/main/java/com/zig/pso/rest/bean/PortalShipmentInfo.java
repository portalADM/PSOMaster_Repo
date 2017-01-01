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
	private String epc_sku_id;
    private String product_type;
    private String sim;
    private String imei;
    private String esn_number;
    private String shipment_date;
    private String lineItemNo;
    private String deviceDisplayName;
    
    /**
     * 
     */
    public PortalShipmentInfo()
    {
        super();
    }
    
    
    
    /**
     * @param epc_sku_id
     * @param product_type
     * @param sim
     * @param imei
     * @param esn_number
     * @param shipment_date
     * @param lineItemNo
     * @param deviceDisplayName
     */
    public PortalShipmentInfo(String epc_sku_id, String product_type, String sim, String imei, String esn_number, String shipment_date, String lineItemNo, String deviceDisplayName)
    {
        super();
        this.epc_sku_id = epc_sku_id;
        this.product_type = product_type;
        this.sim = sim;
        this.imei = imei;
        this.esn_number = esn_number;
        this.shipment_date = shipment_date;
        this.lineItemNo = lineItemNo;
        this.deviceDisplayName = deviceDisplayName;
    }



    /**
     * @return the epc_sku_id
     */
    public String getEpc_sku_id()
    {
        return epc_sku_id;
    }
    /**
     * @param epc_sku_id the epc_sku_id to set
     */
    public void setEpc_sku_id(String epc_sku_id)
    {
        this.epc_sku_id = epc_sku_id;
    }
    /**
     * @return the product_type
     */
    public String getProduct_type()
    {
        return product_type;
    }
    /**
     * @param product_type the product_type to set
     */
    public void setProduct_type(String product_type)
    {
        this.product_type = product_type;
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
     * @return the esn_number
     */
    public String getEsn_number()
    {
        return esn_number;
    }
    /**
     * @param esn_number the esn_number to set
     */
    public void setEsn_number(String esn_number)
    {
        this.esn_number = esn_number;
    }
    /**
     * @return the shipment_date
     */
    public String getShipment_date()
    {
        return shipment_date;
    }
    /**
     * @param shipment_date the shipment_date to set
     */
    public void setShipment_date(String shipment_date)
    {
        this.shipment_date = shipment_date;
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



    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deviceDisplayName == null) ? 0 : deviceDisplayName.hashCode());
        result = prime * result + ((epc_sku_id == null) ? 0 : epc_sku_id.hashCode());
        result = prime * result + ((esn_number == null) ? 0 : esn_number.hashCode());
        result = prime * result + ((imei == null) ? 0 : imei.hashCode());
        result = prime * result + ((lineItemNo == null) ? 0 : lineItemNo.hashCode());
        result = prime * result + ((product_type == null) ? 0 : product_type.hashCode());
        result = prime * result + ((shipment_date == null) ? 0 : shipment_date.hashCode());
        result = prime * result + ((sim == null) ? 0 : sim.hashCode());
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
        if (epc_sku_id == null)
        {
            if (other.epc_sku_id != null)
                return false;
        }
        else if (!epc_sku_id.equals(other.epc_sku_id))
            return false;
        if (esn_number == null)
        {
            if (other.esn_number != null)
                return false;
        }
        else if (!esn_number.equals(other.esn_number))
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
        if (product_type == null)
        {
            if (other.product_type != null)
                return false;
        }
        else if (!product_type.equals(other.product_type))
            return false;
        if (shipment_date == null)
        {
            if (other.shipment_date != null)
                return false;
        }
        else if (!shipment_date.equals(other.shipment_date))
            return false;
        if (sim == null)
        {
            if (other.sim != null)
                return false;
        }
        else if (!sim.equals(other.sim))
            return false;
        return true;
    }



    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "PortalShipmentInfo [epc_sku_id=" + epc_sku_id + ", product_type=" + product_type + ", sim=" + sim + ", imei=" + imei + ", esn_number=" + esn_number + ", shipment_date="
                + shipment_date + ", lineItemNo=" + lineItemNo + ", deviceDisplayName=" + deviceDisplayName + "]";
    }
    
    
    
}
