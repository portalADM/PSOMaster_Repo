/************************************************************************************************************
 * Class Name :  PortalShipmentInfoForUI.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jul 27, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class PortalShipmentInfoForUI implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 943314727681935242L;

    private String epc_sku_id;
    private String productType;
    private String sim;
    private String imei;
    private String esn;
    private String plan;
    private String shipmentDate;
    private boolean isPlanAvailable;
    private boolean isAccessoryAvailable;
    private ArrayList<String> accessoryList = new ArrayList<String>();
    private boolean isAddonAvailable;
    private ArrayList<String> addonList = new ArrayList<String>();

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
     * @return the esn
     */
    public String getEsn()
    {
        return esn;
    }

    /**
     * @param esn the esn to set
     */
    public void setEsn(String esn)
    {
        this.esn = esn;
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
     * @return the isPlanAvailable
     */
    public boolean isPlanAvailable()
    {
        return isPlanAvailable;
    }

    /**
     * @param isPlanAvailable the isPlanAvailable to set
     */
    public void setPlanAvailable(boolean isPlanAvailable)
    {
        this.isPlanAvailable = isPlanAvailable;
    }

    /**
     * @return the isAccessoryAvailable
     */
    public boolean isAccessoryAvailable()
    {
        return isAccessoryAvailable;
    }

    /**
     * @param isAccessoryAvailable the isAccessoryAvailable to set
     */
    public void setAccessoryAvailable(boolean isAccessoryAvailable)
    {
        this.isAccessoryAvailable = isAccessoryAvailable;
    }

    /**
     * @return the isAddonAvailable
     */
    public boolean isAddonAvailable()
    {
        return isAddonAvailable;
    }

    /**
     * @param isAddonAvailable the isAddonAvailable to set
     */
    public void setAddonAvailable(boolean isAddonAvailable)
    {
        this.isAddonAvailable = isAddonAvailable;
    }

    /**
     * @return the plan
     */
    public String getPlan()
    {
        return plan;
    }

    /**
     * @param plan the plan to set
     */
    public void setPlan(String plan)
    {
        this.plan = plan;
    }

    /**
     * @return the accessoryList
     */
    public ArrayList<String> getAccessoryList()
    {
        return accessoryList;
    }

    /**
     * @param accessoryList the accessoryList to set
     */
    public void setAccessoryList(ArrayList<String> accessoryList)
    {
        this.accessoryList = accessoryList;
    }

    /**
     * @return the addonList
     */
    public ArrayList<String> getAddonList()
    {
        return addonList;
    }

    /**
     * @param addonList the addonList to set
     */
    public void setAddonList(ArrayList<String> addonList)
    {
        this.addonList = addonList;
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
        int result = 1;
        result = prime * result + ((accessoryList == null) ? 0 : accessoryList.hashCode());
        result = prime * result + ((addonList == null) ? 0 : addonList.hashCode());
        result = prime * result + ((epc_sku_id == null) ? 0 : epc_sku_id.hashCode());
        result = prime * result + ((esn == null) ? 0 : esn.hashCode());
        result = prime * result + ((imei == null) ? 0 : imei.hashCode());
        result = prime * result + (isAccessoryAvailable ? 1231 : 1237);
        result = prime * result + (isAddonAvailable ? 1231 : 1237);
        result = prime * result + (isPlanAvailable ? 1231 : 1237);
        result = prime * result + ((plan == null) ? 0 : plan.hashCode());
        result = prime * result + ((productType == null) ? 0 : productType.hashCode());
        result = prime * result + ((shipmentDate == null) ? 0 : shipmentDate.hashCode());
        result = prime * result + ((sim == null) ? 0 : sim.hashCode());
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
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PortalShipmentInfoForUI other = (PortalShipmentInfoForUI) obj;
        if (accessoryList == null)
        {
            if (other.accessoryList != null)
                return false;
        }
        else if (!accessoryList.equals(other.accessoryList))
            return false;
        if (addonList == null)
        {
            if (other.addonList != null)
                return false;
        }
        else if (!addonList.equals(other.addonList))
            return false;
        if (epc_sku_id == null)
        {
            if (other.epc_sku_id != null)
                return false;
        }
        else if (!epc_sku_id.equals(other.epc_sku_id))
            return false;
        if (esn == null)
        {
            if (other.esn != null)
                return false;
        }
        else if (!esn.equals(other.esn))
            return false;
        if (imei == null)
        {
            if (other.imei != null)
                return false;
        }
        else if (!imei.equals(other.imei))
            return false;
        if (isAccessoryAvailable != other.isAccessoryAvailable)
            return false;
        if (isAddonAvailable != other.isAddonAvailable)
            return false;
        if (isPlanAvailable != other.isPlanAvailable)
            return false;
        if (plan == null)
        {
            if (other.plan != null)
                return false;
        }
        else if (!plan.equals(other.plan))
            return false;
        if (productType == null)
        {
            if (other.productType != null)
                return false;
        }
        else if (!productType.equals(other.productType))
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
        return "PortalShipmentInfoForUI [epc_sku_id=" + epc_sku_id + ", productType=" + productType + ", sim=" + sim + ", imei=" + imei + ", esn=" + esn + ", plan=" + plan + ", shipmentDate="
                + shipmentDate + ", isPlanAvailable=" + isPlanAvailable + ", isAccessoryAvailable=" + isAccessoryAvailable + ", accessoryList=" + accessoryList + ", isAddonAvailable="
                + isAddonAvailable + ", addonList=" + addonList + "]";
    }

}
