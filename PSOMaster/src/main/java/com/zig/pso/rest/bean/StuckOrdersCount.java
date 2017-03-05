/************************************************************************************************************
 * Class Name :  PortalOrderStatusResponseBean.java
 * Description:  
 * 
 * Author     :  Pankaj Chaudhary
 * Date       :  Jul 31, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class StuckOrdersCount  implements Serializable {

	private static final long serialVersionUID = -5979003604712056315L;
	private String orderStatus;
	private int count;
	private String dateOfHandlingl;
    /**
     * 
     */
    public StuckOrdersCount()
    {
        super();
    }
    /**
     * @param orderStatus
     * @param count
     * @param dateOfHandlingl
     */
    public StuckOrdersCount(String orderStatus, int count, String dateOfHandlingl)
    {
        super();
        this.orderStatus = orderStatus;
        this.count = count;
        this.dateOfHandlingl = dateOfHandlingl;
    }
    /**
     * @return the orderStatus
     */
    public String getOrderStatus()
    {
        return orderStatus;
    }
    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }
    /**
     * @return the count
     */
    public int getCount()
    {
        return count;
    }
    /**
     * @param count the count to set
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    /**
     * @return the dateOfHandlingl
     */
    public String getDateOfHandlingl()
    {
        return dateOfHandlingl;
    }
    /**
     * @param dateOfHandlingl the dateOfHandlingl to set
     */
    public void setDateOfHandlingl(String dateOfHandlingl)
    {
        this.dateOfHandlingl = dateOfHandlingl;
    }
    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + count;
        result = prime * result + ((dateOfHandlingl == null) ? 0 : dateOfHandlingl.hashCode());
        result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
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
        StuckOrdersCount other = (StuckOrdersCount) obj;
        if (count != other.count)
            return false;
        if (dateOfHandlingl == null)
        {
            if (other.dateOfHandlingl != null)
                return false;
        }
        else if (!dateOfHandlingl.equals(other.dateOfHandlingl))
            return false;
        if (orderStatus == null)
        {
            if (other.orderStatus != null)
                return false;
        }
        else if (!orderStatus.equals(other.orderStatus))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "StuckOrdersCount [orderStatus=" + orderStatus + ", count=" + count + ", dateOfHandlingl=" + dateOfHandlingl + "]";
    }
	
	
	
	
}
