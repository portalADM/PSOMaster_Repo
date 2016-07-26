/************************************************************************************************************
 * Class Name : OrderInfoManagerServiceImpl.java Description: This class implements methods for order related operations.
 * 
 * Author : Ankita Mishra Date : Jun 26, 2016 **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.OrderInfoManagerDAO;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.utility.CommonUtility;

@Service
public class OrderInfoManagerServiceImpl implements OrderInfoManagerService
{

    @Autowired
    OrderInfoManagerDAO orderDAO;

    @Autowired
    CommonUtility commonUtil;

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.OrderInfoManagerService#getOrderIds()
     */
    @Override
    public ArrayList<String> getOrderIds()
    {
        ArrayList<String> orderList = new ArrayList<String>();
        orderList = orderDAO.getOrderIds();

        return orderList;
    }

    @Override
    public PortalOrderMasterResponseBean getPortalOrderDataInfo(String OrderId)
    {
        PortalOrderMasterResponseBean portalOrderDetail = new PortalOrderMasterResponseBean();
        portalOrderDetail = orderDAO.getPortalDataInfo(OrderId);
        int type = Integer.parseInt(portalOrderDetail.getOrderType());
        String orderType = commonUtil.getOrderType(type);
        portalOrderDetail.setOrderType(orderType);

        return portalOrderDetail;

    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.OrderInfoManagerService#getEnsOrderDataInfo(java.lang.String)
     */
    @Override
    public EnsOrderMasterResponseBean getEnsOrderDataInfo(String OrderId)
    {
        EnsOrderMasterResponseBean ensOrderDetail = new EnsOrderMasterResponseBean();
        ensOrderDetail = orderDAO.getEnsembleDataInfo(OrderId);

        return ensOrderDetail;
    }

}
