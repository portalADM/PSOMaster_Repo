/************************************************************************************************************
 * Class Name : RegularOrdersCount.java Description:
 * 
 * Author : Ankita Mishra Patil Date : Apr 3, 2017 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class RegularOrdersCount implements Serializable
{

    private static final long serialVersionUID = -3541229139251787885L;
    private String TypeOfOrder;
    private String date;
    private int count;

    @Override
    public String toString()
    {
        return "RegularOrdersCount [TypeOfOrder=" + TypeOfOrder + ", date=" + date + ", count=" + count + "]";
    }

    /**
     * @param date
     * @param count
     */

    /**
     * @param typeOfOrder
     * @param count
     */

    /**
     * 
     */

    public String getTypeOfOrder()
    {
        return TypeOfOrder;
    }

    /**
     * @param typeOfOrder
     * @param count
     */
    public RegularOrdersCount(String typeOfOrder, int count)
    {
        super();
        TypeOfOrder = typeOfOrder;
        this.count = count;
    }

    /**
     * 
     */
    public RegularOrdersCount()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setTypeOfOrder(String typeOfOrder)
    {
        TypeOfOrder = typeOfOrder;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((TypeOfOrder == null) ? 0 : TypeOfOrder.hashCode());
        result = prime * result + count;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        RegularOrdersCount other = (RegularOrdersCount) obj;
        if (TypeOfOrder == null)
        {
            if (other.TypeOfOrder != null)
                return false;
        }
        else if (!TypeOfOrder.equals(other.TypeOfOrder))
            return false;
        if (count != other.count)
            return false;
        if (date == null)
        {
            if (other.date != null)
                return false;
        }
        else if (!date.equals(other.date))
            return false;
        return true;
    }

}
