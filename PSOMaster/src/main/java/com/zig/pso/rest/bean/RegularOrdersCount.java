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
    private String typeOfOrder;
    private String date;
    private int count;
    private String group;

    public String getTypeOfOrder()
    {
        return typeOfOrder;
    }

    public void setTypeOfOrder(String typeOfOrder)
    {
        this.typeOfOrder = typeOfOrder;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + count;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((group == null) ? 0 : group.hashCode());
        result = prime * result + ((typeOfOrder == null) ? 0 : typeOfOrder.hashCode());
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
        if (count != other.count)
            return false;
        if (date == null)
        {
            if (other.date != null)
                return false;
        }
        else if (!date.equals(other.date))
            return false;
        if (group == null)
        {
            if (other.group != null)
                return false;
        }
        else if (!group.equals(other.group))
            return false;
        if (typeOfOrder == null)
        {
            if (other.typeOfOrder != null)
                return false;
        }
        else if (!typeOfOrder.equals(other.typeOfOrder))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "RegularOrdersCount [typeOfOrder=" + typeOfOrder + ", date=" + date + ", count=" + count + ", group=" + group + "]";
    }

    /**
     * @param typeOfOrder
     * @param count
     * @param group
     */
    public RegularOrdersCount(String typeOfOrder, int count, String group)
    {
        super();
        this.typeOfOrder = typeOfOrder;
        this.count = count;
        this.group = group;
    }

    /**
     * 
     */
    public RegularOrdersCount()
    {
        super();
    }

}
