/************************************************************************************************************
 * Class Name :  OrderInfoManagerDAO.java
 * Description:  This interface provides methods for order related operations.
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.ArrayList;

import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;

/**
 * 
 */
public interface OrderInfoManagerDAO
{
    public ArrayList<String> getOrderIds();
    
    public PortalOrderMasterResponseBean getPortalDataInfo(String OrderId);
}
