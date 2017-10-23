/************************************************************************************************************
 * Class Name : DynamicGraphRequestBean.java Description:
 * 
 * Author : Ankita Mishra Date : Mar 31, 2017 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class DynamicGraphRequestBean implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String fromDate;
    private String toDate;
    private String type;

    public String getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(String fromDate)
    {
        this.fromDate = fromDate;
    }

    public String getToDate()
    {
        return toDate;
    }

    public void setToDate(String toDate)
    {
        this.toDate = toDate;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    /**
     * 
     */
    public DynamicGraphRequestBean()
    {
        super();
    }

    /**
     * @param fromDate
     * @param toDate
     * @param type
     */
    public DynamicGraphRequestBean(String fromDate, String toDate, String type)
    {
        super();
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.type = type;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
        result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DynamicGraphRequestBean other = (DynamicGraphRequestBean) obj;
        if (fromDate == null)
        {
            if (other.fromDate != null)
                return false;
        }
        else if (!fromDate.equals(other.fromDate))
            return false;
        if (toDate == null)
        {
            if (other.toDate != null)
                return false;
        }
        else if (!toDate.equals(other.toDate))
            return false;
        if (type == null)
        {
            if (other.type != null)
                return false;
        }
        else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "DynamicGraphRequestBean [fromDate=" + fromDate + ", toDate=" + toDate + ", type=" + type + "]";
    }

}
