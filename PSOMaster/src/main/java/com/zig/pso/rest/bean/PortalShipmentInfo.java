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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2877440920582859690L;
	/**
	 * 
	 */
	
	private java.lang.String epc_sku_id;
    private java.lang.String product_type;
    private java.lang.String sim;
    private java.lang.String imei;
    private java.lang.String esn_number;
    private java.lang.String shipment_date;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epc_sku_id == null) ? 0 : epc_sku_id.hashCode());
		result = prime * result + ((esn_number == null) ? 0 : esn_number.hashCode());
		result = prime * result + ((imei == null) ? 0 : imei.hashCode());
		result = prime * result + ((product_type == null) ? 0 : product_type.hashCode());
		result = prime * result + ((shipment_date == null) ? 0 : shipment_date.hashCode());
		result = prime * result + ((sim == null) ? 0 : sim.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortalShipmentInfo other = (PortalShipmentInfo) obj;
		if (epc_sku_id == null) {
			if (other.epc_sku_id != null)
				return false;
		} else if (!epc_sku_id.equals(other.epc_sku_id))
			return false;
		if (esn_number == null) {
			if (other.esn_number != null)
				return false;
		} else if (!esn_number.equals(other.esn_number))
			return false;
		if (imei == null) {
			if (other.imei != null)
				return false;
		} else if (!imei.equals(other.imei))
			return false;
		if (product_type == null) {
			if (other.product_type != null)
				return false;
		} else if (!product_type.equals(other.product_type))
			return false;
		if (shipment_date == null) {
			if (other.shipment_date != null)
				return false;
		} else if (!shipment_date.equals(other.shipment_date))
			return false;
		if (sim == null) {
			if (other.sim != null)
				return false;
		} else if (!sim.equals(other.sim))
			return false;
		return true;
	}
	public java.lang.String getEpc_sku_id() {
		return epc_sku_id;
	}
	public void setEpc_sku_id(java.lang.String epc_sku_id) {
		this.epc_sku_id = epc_sku_id;
	}
	public java.lang.String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(java.lang.String product_type) {
		this.product_type = product_type;
	}
	public java.lang.String getSim() {
		return sim;
	}
	public void setSim(java.lang.String sim) {
		this.sim = sim;
	}
	public java.lang.String getImei() {
		return imei;
	}
	public void setImei(java.lang.String imei) {
		this.imei = imei;
	}
	public java.lang.String getEsn_number() {
		return esn_number;
	}
	public void setEsn_number(java.lang.String esn_number) {
		this.esn_number = esn_number;
	}
	public java.lang.String getShipment_date() {
		return shipment_date;
	}
	public void setShipment_date(java.lang.String shipment_date) {
		this.shipment_date = shipment_date;
	}
	@Override
	public String toString() {
		return "PortalShipmentInfo [epc_sku_id=" + epc_sku_id + ", product_type=" + product_type + ", sim=" + sim
				+ ", imei=" + imei + ", esn_number=" + esn_number + ", shipment_date=" + shipment_date + "]";
	}

    
    
}
