/************************************************************************************************************
 * Class Name : UpdateOrderRequestBean.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class UpdateOrderRequestBean implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -7471045337689570704L;
    private String orderId;
    private String newValue;
    private String lineId;
    private String type;


    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getNewValue()
    {
        return newValue;
    }

    public void setNewValue(String newValue)
    {
        this.newValue = newValue;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    /**
	 * @return the lineId
	 */
	public String getLineId() {
		return lineId;
	}

	/**
	 * @param lineId the lineId to set
	 */
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
		result = prime * result
				+ ((newValue == null) ? 0 : newValue.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateOrderRequestBean other = (UpdateOrderRequestBean) obj;
		if (lineId == null) {
			if (other.lineId != null)
				return false;
		} else if (!lineId.equals(other.lineId))
			return false;
		if (newValue == null) {
			if (other.newValue != null)
				return false;
		} else if (!newValue.equals(other.newValue))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateOrderRequestBean [orderId=" + orderId + ", newValue="
				+ newValue + ", lineId=" + lineId + ", type=" + type + "]";
	}
	
	

}
