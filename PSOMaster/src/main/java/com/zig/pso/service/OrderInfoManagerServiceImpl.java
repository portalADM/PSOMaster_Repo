/************************************************************************************************************
 * Class Name : OrderInfoManagerServiceImpl.java Description: This class implements methods for order related operations.
 * 
 * Author : Ankita Mishra Date : Jun 26, 2016 **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.dao.OrderInfoManagerDAO;
import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalShipmentInfo;
import com.zig.pso.rest.bean.PortalShipmentInfoForUI;
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

    @Override
    public PortalOrderMasterResponseBean getPortalOrderDataInfo(String OrderId)
    {
        PortalOrderMasterResponseBean portalOrderDetail = new PortalOrderMasterResponseBean();
        portalOrderDetail = orderDAO.getPortalDataInfo(OrderId);
        if (portalOrderDetail.getErrorCode() == PSOConstants.SUCCESS_CODE)
        {
            int type = Integer.parseInt(portalOrderDetail.getOrderType());
            String orderType = commonUtil.getOrderType(type);
            portalOrderDetail.setOrderType(orderType);

            PortalShipmentInfoForUI shipmentInfoFromDb = getPortalShipmentInfo(OrderId);
            portalOrderDetail.setPortalShipmentInfo(shipmentInfoFromDb);
        }

        return portalOrderDetail;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getEnsOrderDataInfo(java.lang.String)
     */
    @Override
    public EnsOrderMasterResponseBean getEnsOrderDataInfo(String OrderId)
    {
        EnsOrderMasterResponseBean ensOrderDetail = new EnsOrderMasterResponseBean();
        ensOrderDetail = orderDAO.getEnsembleDataInfo(OrderId);

        return ensOrderDetail;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getAPIOrderDataInfo(java.lang.String)
     */
    @Override
    public ArrayList<ApiOrderMasterResponseBean> getAPIOrderDataInfo(String OrderId)
    {
        ArrayList<ApiOrderMasterResponseBean> apiOrderDetail = new ArrayList<ApiOrderMasterResponseBean>();
        apiOrderDetail = orderDAO.getAPIDataInfo(OrderId);

        return apiOrderDetail;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getPortalShipmentInfo(java.lang.String)
     */
    @Override
    public PortalShipmentInfoForUI getPortalShipmentInfo(String OrderId)
    {
        ArrayList<PortalShipmentInfo> shipmentInfoFromDb = orderDAO.getPortalShipmentInfoFromDB(OrderId);

        return getShipmentInfoForUI(shipmentInfoFromDb);
    }

    /*
     * Converts DB Shipment Info output to UI Shipment format.
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getShipmentInfoForUI
     */
    public PortalShipmentInfoForUI getShipmentInfoForUI(ArrayList<PortalShipmentInfo> shipmentInfFromDb)
    {
        PortalShipmentInfoForUI shipInfoForUi = new PortalShipmentInfoForUI();

        for (PortalShipmentInfo ship : shipmentInfFromDb)
        {
            if (ship.getSim() != null && shipInfoForUi.getSim() == null)
            {
                shipInfoForUi.setSim(ship.getSim());
            }
            if (ship.getImei() != null && shipInfoForUi.getImei() == null)
            {
                shipInfoForUi.setImei(ship.getImei());
            }
            if (ship.getEsn_number() != null && shipInfoForUi.getEsn() == null)
            {
                shipInfoForUi.setEsn(ship.getEsn_number());
            }
            if (ship.getShipment_date() != null && shipInfoForUi.getShipmentDate() == null)
            {
                shipInfoForUi.setShipmentDate(ship.getShipment_date());
            }
            if (ship.getEpc_sku_id() != null && shipInfoForUi.getEpc_sku_id() == null)
            {
                shipInfoForUi.setEpc_sku_id(ship.getEpc_sku_id());
            }
            if ("addon".equalsIgnoreCase(ship.getProduct_type()))
            {
                shipInfoForUi.setAddonAvailable(true);
                shipInfoForUi.getAddonList().add(ship.getEpc_sku_id());
            }
            if ("accessory".equalsIgnoreCase(ship.getProduct_type()))
            {
                shipInfoForUi.setAccessoryAvailable(true);
                shipInfoForUi.getAccessoryList().add(ship.getEpc_sku_id());
            }
            if ("plan".equalsIgnoreCase(ship.getProduct_type()))
            {
                shipInfoForUi.setPlanAvailable(true);
                shipInfoForUi.setPlan(ship.getEpc_sku_id());
            }
        }

        return shipInfoForUi;
    }
}
