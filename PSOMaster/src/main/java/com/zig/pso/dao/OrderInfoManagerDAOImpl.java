/************************************************************************************************************
 * Class Name : OrderInfoManagerDAOImpl.java 
 * Description: This class implements methods for order related operations. 
 * Author : Ankita Mishra 
 * Date : Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderPortRequestBean;
import com.zig.pso.rest.bean.EnsembleLineItemInfoBean;
import com.zig.pso.rest.bean.OrderAPIDetailsBean;
import com.zig.pso.rest.bean.PortalEnrollmentInfo;
import com.zig.pso.rest.bean.PortalLineItemInfoBean;
import com.zig.pso.rest.bean.PortalOrderLineSIMandIMEIDetailsBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderPortRequestBean;
import com.zig.pso.rest.bean.PortalShipmentInfo;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

@Repository
public class OrderInfoManagerDAOImpl implements OrderInfoManagerDAO
{

    private Connection portalDBConnection = null;

    private Connection ensDBConnection = null;

    public OrderInfoManagerDAOImpl()
    {
        portalDBConnection = DBConnection.getPortalDBConnection();
        ensDBConnection = DBConnection.getENSDBConnection();
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getOrderIds()
     */
    @Override
    public ArrayList<String> getOrderIds()
    {
        ArrayList<String> orderlist = new ArrayList<String>();
        String sql = OrderQueries.getOrderList();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                orderlist.add(rs.getString("USERNAME"));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getOrderIds", e);
        }

        return orderlist;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getPortalDataInfo()
     */
    @Override
    public PortalOrderMasterResponseBean getPortalDataInfo(String OrderId)
    {
        PortalOrderMasterResponseBean portalOrderlist = null;
        String sql = OrderQueries.getPortalOrderData();

        try
        {
            portalOrderlist = new PortalOrderMasterResponseBean();

            PreparedStatement pstm2 = portalDBConnection.prepareStatement(sql);
            pstm2.setString(1, OrderId);
            ResultSet rs2 = pstm2.executeQuery();
            while (rs2.next())
            {
                PortalEnrollmentInfo enrollInfo = new PortalEnrollmentInfo();

                enrollInfo.setFirst_name(rs2.getString("first_name"));
                enrollInfo.setLast_name(rs2.getString("last_name"));
                enrollInfo.setEmail(rs2.getString("email"));
                enrollInfo.setPhone_number(rs2.getString("phone_number"));
                enrollInfo.setAddress1(rs2.getString("address1"));
                enrollInfo.setAddress2(rs2.getString("address2"));
                enrollInfo.setCity(rs2.getString("city"));
                enrollInfo.setState(rs2.getString("state"));
                enrollInfo.setZip_code(rs2.getString("zip_code"));

                portalOrderlist.setEnrollInfo(enrollInfo);

                portalOrderlist.setOrderId(rs2.getString("order_id"));
                portalOrderlist.setStatus(rs2.getString("status_code"));
                portalOrderlist.setRetry(rs2.getString("retry"));
                portalOrderlist.setSys_creation_date(rs2.getString("sys_creation_date"));
                portalOrderlist.setSys_update_date(rs2.getString("sys_update_date"));
                portalOrderlist.setOriginatorId(rs2.getString("Originator_id"));
                portalOrderlist.setOrderType(rs2.getString("ORDER_TYPE"));
                portalOrderlist.setBan(rs2.getString("BAN_NUMBER"));
                portalOrderlist.setPtn(rs2.getString("CTN_NUMBER"));
                portalOrderlist.setErrorCode(0);
                portalOrderlist.setErrorMsg("Success");
            }
        }
        catch (SQLException e)
        {
            portalOrderlist.setErrorCode(PSOConstants.ERROR_CODE);
            portalOrderlist.setErrorMsg(e.getMessage());

            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getPortalDataInfo", e);
        }

        if (portalOrderlist.getOrderId() == null)
        {
            portalOrderlist.setErrorCode(PSOConstants.INFO_CODE);
            portalOrderlist.setErrorMsg(PSOConstants.NO_DATA);
        }

        return portalOrderlist;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getEnsembleDataInfo(java.lang.String)
     */
    @Override
    public EnsOrderMasterResponseBean getEnsembleDataInfo(String orderId)
    {

        EnsOrderMasterResponseBean ensOrderlist = null;

        String sql = OrderQueries.getEnsembleOrderData();

        try
        {
            ensOrderlist = new EnsOrderMasterResponseBean();
            PreparedStatement pstm = ensDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                ensOrderlist.setensOrderId(rs.getString("ENS_ORDER_OID"));
                ensOrderlist.setOrderStatus(rs.getString("ORDER_STATUS"));
                ensOrderlist.setBan(rs.getString("BAN"));
                ensOrderlist.setApplicationId(rs.getString("APPLICATION_ID"));
                ensOrderlist.setSys_creation_date(rs.getString("SYS_CREATION_DATE"));
                ensOrderlist.setSys_update_date(rs.getString("SYS_UPDATE_DATE"));
                ensOrderlist.setErrorCode(0);
                ensOrderlist.setErrorMsg("Success");
            }
        }
        catch (SQLException e)
        {
            ensOrderlist.setErrorCode(PSOConstants.ERROR_CODE);
            ensOrderlist.setErrorMsg(PSOConstants.BACKEND_ERROR);
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getEnsembleDataInfo", e);
        }

        return ensOrderlist;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getPortalShipmentInfoFromDB(java.lang.String)
     */
    @Override
    public ArrayList<PortalShipmentInfo> getPortalShipmentInfoFromDB(String orderId)
    {
        ArrayList<PortalShipmentInfo> portalShipArrlist = new ArrayList<PortalShipmentInfo>();

        String shipSql = OrderQueries.getPortalShipmentInfoSQL();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(shipSql);
            pstm.setString(1, orderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                PortalShipmentInfo portalShiplist = new PortalShipmentInfo();
                portalShiplist.setEpc_sku_id(rs.getString("EPC_SKU_ID"));
                portalShiplist.setImei(rs.getString("IMEI"));
                portalShiplist.setProduct_type(rs.getString("PRODUCT_TYPE"));
                portalShiplist.setEsn_number(rs.getString("ESN_NO"));
                portalShiplist.setShipment_date(rs.getString("SHIPMENT_DATE"));
                portalShiplist.setSim(rs.getString("SIM"));
                portalShiplist.setLineItemNo(rs.getString("LINE_ITEM_NO"));
                portalShiplist.setDeviceDisplayName(rs.getString("DISPLAY_NAME"));
                portalShipArrlist.add(portalShiplist);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getPortalShipmentInfoFromDB", e);
        }

        return portalShipArrlist;
    }

    @Override
    public ApiOrderMasterResponseBean getAPIDataInfo(String orderId)
    {

        OrderAPIDetailsBean apiOutput = null;

        String sql = OrderQueries.getApiOrderData();
        ApiOrderMasterResponseBean orderApiRsponse = new ApiOrderMasterResponseBean();
        ArrayList<OrderAPIDetailsBean> apiList = new ArrayList<OrderAPIDetailsBean>();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs = pstm.executeQuery();

            while (rs.next())
            {
                apiOutput = new OrderAPIDetailsBean();
                apiOutput.setOrderId(rs.getString("ORDER_ID"));
                apiOutput.setErrorMessage(rs.getString("ERROR_MESSAGE"));
                apiOutput.setSource(rs.getString("SOURCE"));
                apiOutput.setAPIName(rs.getString("API_NAME"));
                apiOutput.setSysCreationDate(rs.getString("SYS_CREATION_DATE"));
                apiOutput.setOriginatorID(rs.getString("ORIGINATOR_ID"));
                apiOutput.setSeqNumber(rs.getString("SEQ_NUM"));

                apiList.add(apiOutput);
            }
            orderApiRsponse.setOrderAPIList(apiList);

        }
        catch (Exception e)
        {
            orderApiRsponse.setErrorCode(PSOConstants.ERROR_CODE);
            orderApiRsponse.setErrorMsg(PSOConstants.BACKEND_ERROR);;
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getAPIDataInfo", e);
        }

        return orderApiRsponse;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getAPIRequestBody(java.lang.String)
     */
    @Override
    public String getAPIRequestBody(String seq_number)
    {
        String sql = OrderQueries.getAPIRequest();

        String apiReqBody = null;

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, seq_number);
            ResultSet rs = pstm.executeQuery();

            while (rs.next())
            {
                apiReqBody = rs.getString("REQUEST");
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getAPIRequestBody", e);
        }

        return apiReqBody;
    }

    /*
     * ZIG_AUTO_MASTER
     */
    public PortalOrderMasterResponseBean getZigAutoMasterData(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getZigAutoMasterData", "Order ID : " + orderId);

        PortalOrderMasterResponseBean portalOrderlist = null;

        String sql = OrderQueries.getPortalOrderDetails();

        try
        {
            portalOrderlist = new PortalOrderMasterResponseBean();

            PreparedStatement pstm2 = portalDBConnection.prepareStatement(sql);
            pstm2.setString(1, orderId);
            ResultSet rs2 = pstm2.executeQuery();
            while (rs2.next())
            {
                portalOrderlist.setOrderId(rs2.getString("order_id"));
                portalOrderlist.setStatus(rs2.getString("status_code"));
                portalOrderlist.setRetry(rs2.getString("retry"));
                portalOrderlist.setSys_creation_date(rs2.getString("sys_creation_date"));
                portalOrderlist.setSys_update_date(rs2.getString("sys_update_date"));
                portalOrderlist.setOriginatorId(rs2.getString("Originator_id"));
                portalOrderlist.setErrorCode(0);
                portalOrderlist.setErrorMsg("Success");
            }
        }
        catch (SQLException e)
        {
            portalOrderlist.setErrorCode(PSOConstants.ERROR_CODE);
            portalOrderlist.setErrorMsg(e.getMessage());
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getZigAutoMasterData", e);
        }

        if (portalOrderlist.getOrderId() == null)
        {
            portalOrderlist.setErrorCode(PSOConstants.INFO_CODE);
            portalOrderlist.setErrorMsg(PSOConstants.NO_DATA);

            PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getZigAutoMasterData", PSOConstants.NO_DATA);
        }

        return portalOrderlist;
    }

    /*
     * ZIG_EXTRA_ORDER - ORDER_TYPE
     */
    public String getOrderTypeFromExtraOrder(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getOrderTypeFromExtraOrder", "Order ID : " + orderId);

        String sql = OrderQueries.getOrderType();

        String orderStatus = null;
        try
        {

            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs2 = pstm.executeQuery();
            while (rs2.next())
            {
                orderStatus = rs2.getString("order_type");
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getOrderTypeFromExtraOrder", e);
        }

        if (orderStatus == null)
        {
            PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getOrderTypeFromExtraOrder", PSOConstants.NO_DATA);
        }

        return orderStatus;
    }

    /*
     * ZIG_CUSTOMER_BACKEND_INFO - BAN & CTN
     */
    public PortalOrderMasterResponseBean getCustomerBANandCTN(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getCustomerBANandCTN", "Order ID : " + orderId);

        PortalOrderMasterResponseBean portalOrderlist = null;

        String sql = OrderQueries.getOrderBANandCTN();

        try
        {
            portalOrderlist = new PortalOrderMasterResponseBean();

            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs2 = pstm.executeQuery();
            while (rs2.next())
            {
                portalOrderlist.setBan(rs2.getString("BAN_NUMBER"));
                portalOrderlist.setPtn(rs2.getString("CTN_NUMBER"));
            }
        }
        catch (SQLException e)
        {
            portalOrderlist.setErrorCode(PSOConstants.ERROR_CODE);
            portalOrderlist.setErrorMsg(e.getMessage());
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getCustomerBANandCTN", e);
        }

        return portalOrderlist;
    }

    /*
     * ZIG_ENROLLMENT
     */
    public PortalEnrollmentInfo getOrderEnrollmentInfo(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getOrderEnrollmentInfo", "Order ID : " + orderId);

        PortalEnrollmentInfo enrollInfo = null;

        String sql = OrderQueries.getEnrollment();

        try
        {
            enrollInfo = new PortalEnrollmentInfo();

            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs2 = pstm.executeQuery();
            while (rs2.next())
            {
                enrollInfo.setFirst_name(rs2.getString("first_name"));
                enrollInfo.setLast_name(rs2.getString("last_name"));
                enrollInfo.setEmail(rs2.getString("email"));
                enrollInfo.setPhone_number(rs2.getString("phone_number"));
                enrollInfo.setAddress1(rs2.getString("address1"));
                enrollInfo.setAddress2(rs2.getString("address2"));
                enrollInfo.setCity(rs2.getString("city"));
                enrollInfo.setState(rs2.getString("state"));
                enrollInfo.setZip_code(rs2.getString("zip_code"));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getOrderEnrollmentInfo", e);
        }

        if (enrollInfo == null)
        {
            PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getOrderEnrollmentInfo", PSOConstants.NO_DATA);
        }

        return enrollInfo;
    }

    /* 
     * ZIG_LINEITEM_INFO
     */
    @Override
    public ArrayList<PortalLineItemInfoBean> getPortalLineItemInfo(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getPortalLineItemInfo", "Order ID : " + orderId);

        ArrayList<PortalLineItemInfoBean> lineItemsList = new ArrayList<PortalLineItemInfoBean>(); 
        PortalLineItemInfoBean lineItem = null;

        String sql = OrderQueries.getPortalLineItemInfoSQL();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                lineItem = new PortalLineItemInfoBean();
                lineItem.setImei(rs.getString("IMEI"));
                lineItem.setLineId(rs.getString("LINE_ID"));
                lineItem.setLineType(rs.getString("LINE_TYPE"));
                lineItem.setOrderId(rs.getString("ORDER_ID"));
                lineItem.setPurchseDeviceCalled(getBooleanForServiceCall(rs.getString("PURCHASE_DEVICE_CALLED")));
                lineItem.setSubFlowType(rs.getString("SUB_FLOW_TYPE"));
                lineItem.setSubscriberId(rs.getString("SUBSCRIBER_ID"));
                lineItem.setUpdateSubCalled(getBooleanForServiceCall(rs.getString("UPDATE_SUB_CALLED")));
                lineItem.setWirelessNumber(rs.getString("WIRELESS_NUMBER"));
                lineItem.setZipCode(rs.getString("ZIP_CODE"));
                lineItemsList.add(lineItem);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getPortalLineItemInfo", e);
        }

        if (lineItemsList == null || lineItemsList.size()==0)
        {
            PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getPortalLineItemInfo", PSOConstants.NO_DATA);
        }

        return lineItemsList;
    }
    
    
    public boolean getBooleanForServiceCall(String value)
    {
        if("1".equals(value))
            return true;
        else 
            return false;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getEnsLineItemInfo(java.lang.String)
     */
    @Override
    public ArrayList<EnsembleLineItemInfoBean> getEnsLineItemInfo(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getEnsLineItemInfo", "Order ID : " + orderId);

        ArrayList<EnsembleLineItemInfoBean> enslineItemsList = new ArrayList<EnsembleLineItemInfoBean>(); 
        EnsembleLineItemInfoBean lineItem = null;

        String sql = OrderQueries.getEnsLineItemInfoSQL();
        
        try
        {
            PreparedStatement pstm = ensDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                lineItem = new EnsembleLineItemInfoBean();
                lineItem.setAccountNo(rs.getString("BAN"));
                lineItem.setApplicationId(rs.getString("APPLICATION_ID"));
                lineItem.setImei(rs.getString("IMEI_SIM"));
                lineItem.setOrderid(rs.getString("ORDER_OID"));
                lineItem.setPtn(rs.getString("PTN"));
                lineItem.setPtnStatus(rs.getString("PTN_STATUS"));
                lineItem.setSim(rs.getString("ICC_ID"));
                lineItem.setSublineStatus(rs.getString("SUBLINE_STATUS"));
                lineItem.setSubscriberNo(rs.getString("SUBSCRIBER_NO"));
                enslineItemsList.add(lineItem);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getEnsLineItemInfo", e);
        }

        if (enslineItemsList == null || enslineItemsList.size()==0)
        {
            PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getEnsLineItemInfo", PSOConstants.NO_DATA);
        }

        return enslineItemsList;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getPortalOrderPortDetails(java.lang.String)
     */
    @Override
    public ArrayList<PortalOrderPortRequestBean> getPortalOrderPortDetails(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getPortalOrderPortDetails", "Order ID : " + orderId);

        ArrayList<PortalOrderPortRequestBean> portItemList = new ArrayList<PortalOrderPortRequestBean>(); 
        PortalOrderPortRequestBean portLine = null;

        String sql = OrderQueries.getPortalPortinInfoSQL();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                portLine = new PortalOrderPortRequestBean();
                portLine.setLineId(rs.getString("LINE_ID"));
                portLine.setOrderId(rs.getString("ORDER_ID"));
                portLine.setPortStatus(rs.getString("PORTIN_STATUS"));
                portLine.setSpName(rs.getString("SPNAME"));
                portLine.setTransberNumber(rs.getString("NUMBER_TO_TRANSFER"));
                portItemList.add(portLine);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getPortalOrderPortDetails", e);
        }

        if (portItemList == null || portItemList.size()==0)
        {
            PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getPortalOrderPortDetails", PSOConstants.NO_DATA);
        }

        return portItemList;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getEnsOrderPortDetails(java.lang.String)
     */
    @Override
    public ArrayList<EnsOrderPortRequestBean> getEnsOrderPortDetails(String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getEnsOrderPortDetails", "Order ID : " + orderId);

        ArrayList<EnsOrderPortRequestBean> portItemList = new ArrayList<EnsOrderPortRequestBean>(); 
        EnsOrderPortRequestBean portLine = null;

        String sql = OrderQueries.getEnsPortinInfoSQL();

        try
        {
            PreparedStatement pstm = ensDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                portLine = new EnsOrderPortRequestBean();
                portLine.setAccountNo(rs.getString("BAN"));
                portLine.setExternalReqNo(rs.getString("EXTERNAL_REQ_NO"));
                portLine.setPortType(rs.getString("PORT_PATH"));
                portLine.setPtn(rs.getString("PTN_NO"));
                portLine.setRequestNo(rs.getString("REQUEST_NO"));
                portLine.setRequestStatus(rs.getString("REQUEST_STS"));
                portLine.setStatusDesc(rs.getString("STATUS_DESC"));
                portItemList.add(portLine);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getEnsOrderPortDetails", e);
        }

        if (portItemList == null || portItemList.size()==0)
        {
            PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getEnsOrderPortDetails", PSOConstants.NO_DATA);
        }

        return portItemList;
    }

	/* (non-Javadoc)
	 * @see com.zig.pso.dao.OrderInfoManagerDAO#getPortalLineSimAndImeiDetails(java.lang.String)
	 */
	@Override
	public ArrayList<PortalShipmentInfo> getPortalLineSimAndImeiDetails(String orderId) {
		PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getPortalLineSimAndImeiDetails", "Order ID : " + orderId);
		
        ArrayList<PortalShipmentInfo> portLineList = new ArrayList<PortalShipmentInfo>(); 
        PortalShipmentInfo portLine = null;

        String sql = OrderQueries.getOrderLineSIMandIMEIDetailsSQL();
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, orderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                portLine = new PortalShipmentInfo();
                portLine.setImei(rs.getString("IMEI"));
                portLine.setLineItemNo(rs.getString("LINE_ID"));
                portLine.setOrderId(rs.getString("ORDER_ID"));
                portLine.setPtn(rs.getString("WIRELESS_NUMBER"));
                portLine.setSim(rs.getString("SIM"));
                portLine.setSubscriberId(rs.getString("SUBSCRIBER_ID"));
                portLineList.add(portLine);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("OrderInfoManagerDAOImpl", "getPortalLineSimAndImeiDetails", e);
        }

        if (portLineList == null || portLineList.size()==0)
        {
            PSOLoggerSrv.printDEBUG("OrderInfoManagerDAOImpl", "getPortalLineSimAndImeiDetails", PSOConstants.NO_DATA);
        }

        return portLineList;
	}
}
