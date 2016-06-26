/************************************************************************************************************
 * Class Name :  OrderInfoManagerServiceImpl.java
 * Description:  This class implements methods for order related operations.
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.OrderInfoManagerDAO;

@Service
public class OrderInfoManagerServiceImpl implements OrderInfoManagerService
{

    @Autowired
    OrderInfoManagerDAO orderDAO;

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getOrderIds()
     */
    @Override
    public ArrayList<String> getOrderIds()
    {
        ArrayList<String> orderList = new ArrayList<String>();
        orderList = orderDAO.getOrderIds();

        return orderList;
    }

}
