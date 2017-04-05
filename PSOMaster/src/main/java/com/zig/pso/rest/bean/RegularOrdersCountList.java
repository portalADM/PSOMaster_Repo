/************************************************************************************************************
 * Class Name : RegularOrdersCountList.java Description:
 * 
 * Author : Ankita Mishra Date : Apr 3, 2017 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class RegularOrdersCountList implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 4312992109535781242L;
    public ArrayList<RegularOrdersCount> regularOrderList;
    public String type;

    public ArrayList<RegularOrdersCount> getRegularOrderList()
    {
        return regularOrderList;
    }

    public void setRegularOrderList(ArrayList<RegularOrdersCount> regularOrderList)
    {
        this.regularOrderList = regularOrderList;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
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
     * @param regularOrderList
     * @param type
     */
    public RegularOrdersCountList(ArrayList<RegularOrdersCount> regularOrderList, String type)
    {
        super();
        this.regularOrderList = regularOrderList;
        this.type = type;
    }

    /**
     * 
     */
    public RegularOrdersCountList()
    {
        super();
        // TODO Auto-generated constructor stub
    }

}
