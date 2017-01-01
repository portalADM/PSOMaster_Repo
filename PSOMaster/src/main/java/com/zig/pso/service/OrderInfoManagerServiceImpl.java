/************************************************************************************************************
 * Class Name : OrderInfoManagerServiceImpl.java 
 * Description: This class implements methods for order related operations.
 * Author : Ankita Mishra 
 * Date : Jun 26, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.dao.OrderInfoManagerDAO;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderPortRequestBean;
import com.zig.pso.rest.bean.EnsembleLineItemInfoBean;
import com.zig.pso.rest.bean.OrderPortInDetailsResponseBean;
import com.zig.pso.rest.bean.PortalEnrollmentInfo;
import com.zig.pso.rest.bean.PortalLineItemInfoBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderPortRequestBean;
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
    
    private static final String ADDON = "addon";
    private static final String ACCESSORY = "accessory";
    private static final String PLAN = "plan";

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

    /*
     * Returns Portal order details
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getPortalOrderDataInfo()
     */
    @Override
    public PortalOrderMasterResponseBean getPortalOrderDataInfo(String OrderId)
    {

        PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getPortalOrderDataInfo", "Order ID : " + OrderId);

        PortalOrderMasterResponseBean portalOrderDetail = new PortalOrderMasterResponseBean();

        /* ZIG AUTO MASTER */
        PortalOrderMasterResponseBean autoMasterData = orderDAO.getZigAutoMasterData(OrderId);
        if (autoMasterData != null && autoMasterData.getOrderId()!=null)
        {
            portalOrderDetail.setOrderId(autoMasterData.getOrderId());
            portalOrderDetail.setStatus(autoMasterData.getStatus());
            portalOrderDetail.setRetry(autoMasterData.getRetry());
            portalOrderDetail.setSys_creation_date(autoMasterData.getSys_creation_date());
            portalOrderDetail.setSys_update_date(autoMasterData.getSys_update_date());
            portalOrderDetail.setOriginatorId(autoMasterData.getOriginatorId());
        }
        else
        {
            portalOrderDetail.setErrorCode(PSOConstants.INFO_CODE);
            portalOrderDetail.setErrorMsg(PSOConstants.NO_DATA);
            PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getPortalOrderDataInfo", "No Data found in ZIG_AUTO_MASTER for Order ID : " + OrderId);
        }

        /* ZIG ENROLLMENT */
        PortalEnrollmentInfo enrollmentInfo = orderDAO.getOrderEnrollmentInfo(OrderId);
        if (enrollmentInfo != null)
        {
            portalOrderDetail.setEnrollInfo(enrollmentInfo);
        }

        /* ZIG CUSTOMER BACKEND INFO */
        PortalOrderMasterResponseBean orderBanAndCtn = orderDAO.getCustomerBANandCTN(OrderId);
        if (orderBanAndCtn != null)
        {
            portalOrderDetail.setPtn(orderBanAndCtn.getPtn());
            portalOrderDetail.setBan(orderBanAndCtn.getBan());
        }

        /* ZIG EXTRA ORDER */
        String orderType = orderDAO.getOrderTypeFromExtraOrder(OrderId);
        if (orderType != null)
        {
            int type = Integer.parseInt(orderType);
            String orderTypeString = commonUtil.getOrderType(type);
            portalOrderDetail.setOrderType(orderTypeString);
        }
        
        /* ZIG LINEITEM INFO */
        ArrayList<PortalLineItemInfoBean> lineItemList = orderDAO.getPortalLineItemInfo(OrderId);
        if(lineItemList!=null && lineItemList.size()>0){
            portalOrderDetail.setPortalLineItemList(lineItemList);
        }

        /* ZIG SHIPMENT INFO */
        if (portalOrderDetail.getOrderId() != null)
        {
            //PortalShipmentInfoForUI shipmentInfoFromDb = getPortalShipmentInfo(OrderId);
            //portalOrderDetail.setPortalShipmentInfo(shipmentInfoFromDb);
            
            ArrayList<PortalShipmentInfo> shipmentInfoFromDb = orderDAO.getPortalShipmentInfoFromDB(OrderId);
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
    public EnsOrderMasterResponseBean getEnsOrderDataInfo(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getEnsOrderDataInfo - Start", "Order ID : " + orderId);

        EnsOrderMasterResponseBean ensOrderDetail = new EnsOrderMasterResponseBean();
        ensOrderDetail = orderDAO.getEnsembleDataInfo(orderId);
        if (ensOrderDetail.getensOrderId()==null && ensOrderDetail.getErrorCode()!=PSOConstants.ERROR_CODE)
        {
            ensOrderDetail.setErrorCode(PSOConstants.INFO_CODE);
            ensOrderDetail.setErrorMsg(PSOConstants.NO_DATA);
            PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getEnsOrderDataInfo - End", PSOConstants.NO_DATA);
        }
        else
        {
            ArrayList<EnsembleLineItemInfoBean> ensLineItemList = orderDAO.getEnsLineItemInfo(orderId);
            if(ensLineItemList!=null && ensLineItemList.size()>0)
            {
                ensOrderDetail.setEnsLineItemList(ensLineItemList);
            }
        }

        return ensOrderDetail;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getAPIOrderDataInfo(java.lang.String)
     */
    @Override
    public ApiOrderMasterResponseBean getAPIOrderDataInfo(String OrderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getAPIOrderDataInfo - Start", "Order ID : " + OrderId);
        ApiOrderMasterResponseBean apiResponse = new ApiOrderMasterResponseBean();
        apiResponse = orderDAO.getAPIDataInfo(OrderId);
        if(apiResponse!=null && apiResponse.getErrorCode()!=PSOConstants.ERROR_CODE)
        {
            if(apiResponse.getOrderAPIList().size()>0)
            {
                apiResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getAPIOrderDataInfo", "Num of API in response : " +apiResponse.getOrderAPIList().size());
            }
            else
            {
                apiResponse.setErrorCode(PSOConstants.INFO_CODE);
                apiResponse.setErrorMsg(PSOConstants.NO_DATA);
                PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getAPIOrderDataInfo - End", PSOConstants.NO_DATA);
            }
        }
        
        return apiResponse;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getPortalShipmentInfo(java.lang.String)
     */
    @Override
    public PortalShipmentInfoForUI getPortalShipmentInfo(String OrderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getPortalShipmentInfo", "Order ID : " + OrderId);

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
        PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getPortalShipmentInfo", "Shipment Details : " + shipmentInfFromDb.size());

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
            if (ADDON.equalsIgnoreCase(ship.getProduct_type()))
            {
                shipInfoForUi.setAddonAvailable(true);
                shipInfoForUi.getAddonList().add(ship.getEpc_sku_id());
            }
            if (ACCESSORY.equalsIgnoreCase(ship.getProduct_type()))
            {
                shipInfoForUi.setAccessoryAvailable(true);
                shipInfoForUi.getAccessoryList().add(ship.getEpc_sku_id());
            }
            if (PLAN.equalsIgnoreCase(ship.getProduct_type()))
            {
                shipInfoForUi.setPlanAvailable(true);
                shipInfoForUi.setPlan(ship.getEpc_sku_id());
            }
        }

        return shipInfoForUi;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.OrderInfoManagerService#getAPIRequestBody(java.lang.String)
     */
    @Override
    public String getAPIRequestBody(String seq_number)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getAPIRequestBody", "Seq_number : " + seq_number);

        return orderDAO.getAPIRequestBody(seq_number);
    }

    /* (non-Javadoc)
     * @see com.zig.pso.service.OrderInfoManagerService#getPortalOrderPortDetails(java.lang.String)
     */
    @Override
    public OrderPortInDetailsResponseBean getPortalOrderPortDetails(String OrderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getPortalOrderPortDetails - Start", "Order ID : " + OrderId);
        OrderPortInDetailsResponseBean portDetails = new OrderPortInDetailsResponseBean();
        
        /*Portal Port-in Details*/
        ArrayList<PortalOrderPortRequestBean> portData = orderDAO.getPortalOrderPortDetails(OrderId);
        if(portData!=null && portData.size()>0)
        {
            portDetails.setErrorCode(PSOConstants.SUCCESS_CODE);
            portDetails.setPortalPortReqDetailsList(portData);
        }
        else
        {
            portDetails.setErrorCode(PSOConstants.INFO_CODE);
            portDetails.setErrorMsg(PSOConstants.NO_DATA);
            PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getPortalOrderPortDetails - End", PSOConstants.NO_DATA);
        }
        
        
        /*Ensemble Port-in Details*/
        ArrayList<EnsOrderPortRequestBean> ensPortDetails = orderDAO.getEnsOrderPortDetails(OrderId);
        if(ensPortDetails!=null && ensPortDetails.size()>0)
        {
            portDetails.setErrorCode(PSOConstants.SUCCESS_CODE);
            portDetails.setEnsPortReqDetailsList(ensPortDetails);
        }
        else
        {
            portDetails.setErrorCode(PSOConstants.INFO_CODE);
            portDetails.setErrorMsg(PSOConstants.NO_DATA);
            PSOLoggerSrv.printDEBUG("OrderInfoManagerServiceImpl", "getPortalOrderPortDetails - End", PSOConstants.NO_DATA);
        }
        
        return portDetails;
    }
}
