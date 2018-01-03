/************************************************************************************************************
 * Class Name : OrderInfoManagerDAOImpl.java 
 * Description: This class implements methods for order related operations. 
 * Author : Ankita Mishra 
 * Date : Jun 26, 2016
  --------------------------------
 * Modified by : Pankaj Chaudhary
 * Date : Nov 21, 2017 
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderPortRequestBean;
import com.zig.pso.rest.bean.EnsembleLineItemInfoBean;
import com.zig.pso.rest.bean.InventoryStatusofItemBean;
import com.zig.pso.rest.bean.NameDataBean;
import com.zig.pso.rest.bean.OrderAPIDetailsBean;
import com.zig.pso.rest.bean.PortalEnrollmentInfo;
import com.zig.pso.rest.bean.PortalLineItemInfoBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderPortRequestBean;
import com.zig.pso.rest.bean.PortalShipmentInfo;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

@Repository
public class OrderInfoManagerDAOImpl implements OrderInfoManagerDAO
{
    static final Logger logger = Logger.getLogger(OrderInfoManagerDAOImpl.class);
    
    public static final String CLASS_NAME = "OrderInfoManagerDAOImpl";
    
    public OrderInfoManagerDAOImpl()
    {
        super();
    }

    private Connection getPortalDbConnction()
    {
        return DBConnection.getPortalDBConnection();
    }

    private Connection getENSDbConnction()
    {
        return DBConnection.getENSDBConnection();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getOrderIds()
     */
    @Override
    public List<String> getOrderIds()
    {
        ArrayList<String> orderlist = new ArrayList<String>();
        String sql = OrderQueries.getOrderList();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                orderlist.add(rs.getString("USERNAME"));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderIds", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderIds", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderIds", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderIds", e);
                }
            }
        }

        return orderlist;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getPortalDataInfo()
     */
    @Override
    public PortalOrderMasterResponseBean getPortalDataInfo(String OrderId)
    {
        PortalOrderMasterResponseBean portalOrderlist = null;
        String sql = OrderQueries.getPortalOrderData();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            portalOrderlist = new PortalOrderMasterResponseBean();

            pstm = con.prepareStatement(sql);
            pstm.setString(1, OrderId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                PortalEnrollmentInfo enrollInfo = new PortalEnrollmentInfo();

                enrollInfo.setFirstName(rs.getString("first_name"));
                enrollInfo.setLastName(rs.getString("last_name"));
                enrollInfo.setEmail(rs.getString("email"));
                enrollInfo.setPhoneNumber(rs.getString("phone_number"));
                enrollInfo.setAddress1(rs.getString("address1"));
                enrollInfo.setAddress2(rs.getString("address2"));
                enrollInfo.setCity(rs.getString("city"));
                enrollInfo.setState(rs.getString("state"));
                enrollInfo.setZipCode(rs.getString("zip_code"));

                portalOrderlist.setEnrollInfo(enrollInfo);

                portalOrderlist.setOrderId(rs.getString("order_id"));
                portalOrderlist.setStatus(rs.getString("status_code"));
                portalOrderlist.setRetry(rs.getString("retry"));
                portalOrderlist.setSys_creation_date(rs.getString("sys_creation_date"));
                portalOrderlist.setSys_update_date(rs.getString("sys_update_date"));
                portalOrderlist.setOriginatorId(rs.getString("Originator_id"));
                portalOrderlist.setOrderType(rs.getString("ORDER_TYPE"));
                portalOrderlist.setBan(rs.getString("BAN_NUMBER"));
                portalOrderlist.setPtn(rs.getString("CTN_NUMBER"));
                portalOrderlist.setErrorCode(0);
                portalOrderlist.setErrorMsg("Success");
            }
        }
        catch (SQLException e)
        {
            portalOrderlist.setErrorCode(PSOConstants.ERROR_CODE);
            portalOrderlist.setErrorMsg(e.getMessage());

            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalDataInfo", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalDataInfo", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalDataInfo", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalDataInfo", e);
                }
            }
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
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getEnsembleDataInfo(java.lang.String)
     */
    @Override
    public EnsOrderMasterResponseBean getEnsembleDataInfo(String orderId)
    {

        EnsOrderMasterResponseBean ensOrderlist = null;

        String sql = OrderQueries.getEnsembleOrderData();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getENSDbConnction();

        try
        {
            ensOrderlist = new EnsOrderMasterResponseBean();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
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
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsembleDataInfo", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsembleDataInfo", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsembleDataInfo", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsembleDataInfo", e);
                }
            }
        }

        return ensOrderlist;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getPortalShipmentInfoFromDB(java.lang.String)
     */
    @Override
    public List<PortalShipmentInfo> getPortalShipmentInfoFromDB(String orderId)
    {
        ArrayList<PortalShipmentInfo> portalShipArrlist = new ArrayList<PortalShipmentInfo>();

        String shipSql = OrderQueries.getPortalShipmentInfoSQL();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(shipSql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                PortalShipmentInfo portalShiplist = new PortalShipmentInfo();
                portalShiplist.setEpcSkuId(rs.getString("EPC_SKU_ID"));
                portalShiplist.setImei(rs.getString("IMEI"));
                portalShiplist.setProductType(rs.getString("PRODUCT_TYPE"));
                portalShiplist.setEsnNumber(rs.getString("ESN_NO"));
                portalShiplist.setShipmentDate(rs.getString("SHIPMENT_DATE"));
                portalShiplist.setSim(rs.getString("SIM"));
                portalShiplist.setLineItemNo(rs.getString("LINE_ITEM_NO"));
                portalShiplist.setDeviceDisplayName(rs.getString("DISPLAY_NAME"));
                portalShipArrlist.add(portalShiplist);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalShipmentInfoFromDB", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalShipmentInfoFromDB", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalShipmentInfoFromDB", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalShipmentInfoFromDB", e);
                }
            }
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

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();

            while (rs.next())
            {
                apiOutput = new OrderAPIDetailsBean();
                apiOutput.setOrderId(rs.getString("ORDER_ID"));
                apiOutput.setErrorMessage(rs.getString("ERROR_MESSAGE"));
                apiOutput.setSource(rs.getString("SOURCE"));
                apiOutput.setaPIName(rs.getString("API_NAME"));
                apiOutput.setSysCreationDate(rs.getString("SYS_CREATION_DATE"));
                apiOutput.setOriginatorID(rs.getString("ORIGINATOR_ID"));
                apiOutput.setSeqNumber(rs.getString("SEQ_NUM"));
                apiOutput.setErrorInResponse(rs.getString("HASERROR"));
                apiList.add(apiOutput);
            }
            orderApiRsponse.setOrderAPIList(apiList);

        }
        catch (Exception e)
        {
            orderApiRsponse.setErrorCode(PSOConstants.ERROR_CODE);
            orderApiRsponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            ;
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getAPIDataInfo", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getAPIDataInfo", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getAPIDataInfo", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getAPIDataInfo", e);
                }
            }
        }

        return orderApiRsponse;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getAPIRequestBody(java.lang.String)
     */
    @Override
    public String getAPIRequestResponseBody(String seq_number, String callType)
    {
        String sql = getApiBodyQuery(callType);

        String apiReqBody = null;

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, seq_number);
            rs = pstm.executeQuery();

            while (rs.next())
            {
                apiReqBody = rs.getString(1);
            }

        }
        catch(Exception e){
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getAPIRequestBody", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getAPIRequestResponseBody", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getAPIRequestResponseBody", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getAPIRequestResponseBody", e);
                }
            }
        }

        return apiReqBody;
    }
    
    public String getApiBodyQuery(String callType)
    {
        return ("request".equals(callType)) ? OrderQueries.getAPIRequest() : OrderQueries.getAPIResponse();
    }

    /*
     * ZIG_AUTO_MASTER
     */
    public PortalOrderMasterResponseBean getZigAutoMasterData(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getZigAutoMasterData", "Order ID : " + orderId);

        PortalOrderMasterResponseBean portalOrderlist = null;

        String sql = OrderQueries.getPortalOrderDetails();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            portalOrderlist = new PortalOrderMasterResponseBean();

            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                portalOrderlist.setOrderId(rs.getString("order_id"));
                portalOrderlist.setStatus(rs.getString("status_code"));
                portalOrderlist.setRetry(rs.getString("retry"));
                portalOrderlist.setSys_creation_date(rs.getString("sys_creation_date"));
                portalOrderlist.setSys_update_date(rs.getString("sys_update_date"));
                portalOrderlist.setOriginatorId(rs.getString("Originator_id"));
                portalOrderlist.setErrorCode(0);
                portalOrderlist.setErrorMsg("Success");
            }
            
            if (StringUtils.isEmpty(portalOrderlist.getOrderId()))
            {
                portalOrderlist.setErrorCode(PSOConstants.INFO_CODE);
                portalOrderlist.setErrorMsg(PSOConstants.NO_DATA);

                PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getZigAutoMasterData", PSOConstants.NO_DATA);
            }
        }
        catch (SQLException e)
        {
            portalOrderlist.setErrorCode(PSOConstants.ERROR_CODE);
            portalOrderlist.setErrorMsg(e.getMessage());
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getZigAutoMasterData", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getZigAutoMasterData", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getZigAutoMasterData", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getZigAutoMasterData", e);
                }
            }
        }

        

        return portalOrderlist;
    }

    /*
     * ZIG_EXTRA_ORDER - ORDER_TYPE
     */
    public String getOrderTypeFromExtraOrder(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getOrderTypeFromExtraOrder", "Order ID : " + orderId);

        String sql = OrderQueries.getOrderType();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        String orderStatus = null;
        try
        {

            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                orderStatus = rs.getString("order_type");
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderTypeFromExtraOrder", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderTypeFromExtraOrder", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderTypeFromExtraOrder", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderTypeFromExtraOrder", e);
                }
            }
        }

        if (orderStatus == null)
        {
            PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getOrderTypeFromExtraOrder", PSOConstants.NO_DATA);
        }

        return orderStatus;
    }

    /*
     * ZIG_CUSTOMER_BACKEND_INFO - BAN & CTN
     */
    public PortalOrderMasterResponseBean getCustomerBANandCTN(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getCustomerBANandCTN", "Order ID : " + orderId);

        PortalOrderMasterResponseBean portalOrderlist = null;

        String sql = OrderQueries.getOrderBANandCTN();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            portalOrderlist = new PortalOrderMasterResponseBean();

            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                portalOrderlist.setBan(rs.getString("BAN_NUMBER"));
                portalOrderlist.setPtn(rs.getString("CTN_NUMBER"));
            }
        }
        catch (SQLException e)
        {
            portalOrderlist.setErrorCode(PSOConstants.ERROR_CODE);
            portalOrderlist.setErrorMsg(e.getMessage());
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getCustomerBANandCTN", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getCustomerBANandCTN", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getCustomerBANandCTN", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getCustomerBANandCTN", e);
                }
            }
        }

        return portalOrderlist;
    }

    /*
     * ZIG_ENROLLMENT
     */
    public PortalEnrollmentInfo getOrderEnrollmentInfo(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getOrderEnrollmentInfo", "Order ID : " + orderId);

        PortalEnrollmentInfo enrollInfo = null;

        String sql = OrderQueries.getEnrollment();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            enrollInfo = new PortalEnrollmentInfo();

            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                enrollInfo.setFirstName(rs.getString("first_name"));
                enrollInfo.setLastName(rs.getString("last_name"));
                enrollInfo.setEmail(rs.getString("email"));
                enrollInfo.setPhoneNumber(rs.getString("phone_number"));
                enrollInfo.setAddress1(rs.getString("address1"));
                enrollInfo.setAddress2(rs.getString("address2"));
                enrollInfo.setCity(rs.getString("city"));
                enrollInfo.setState(rs.getString("state"));
                enrollInfo.setZipCode(rs.getString("zip_code"));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderEnrollmentInfo", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderEnrollmentInfo", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderEnrollmentInfo", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderEnrollmentInfo", e);
                }
            }
        }

        return enrollInfo;
    }

    /*
     * ZIG_LINEITEM_INFO
     */
    @Override
    public List<PortalLineItemInfoBean> getPortalLineItemInfo(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getPortalLineItemInfo", "Order ID : " + orderId);

        ArrayList<PortalLineItemInfoBean> lineItemsList = new ArrayList<PortalLineItemInfoBean>();
        PortalLineItemInfoBean lineItem = null;

        String sql = OrderQueries.getPortalLineItemInfoSQL();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
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
            
            
            if (lineItemsList == null || lineItemsList.isEmpty())
            {
                PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getPortalLineItemInfo", PSOConstants.NO_DATA);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalLineItemInfo", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalLineItemInfo", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalLineItemInfo", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalLineItemInfo", e);
                }
            }
        }

        return lineItemsList;
    }

    public boolean getBooleanForServiceCall(String value)
    {
        if (PSOConstants.DB_VALUE.equals(value))
            return true;
        else
            return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getEnsLineItemInfo(java.lang.String)
     */
    @Override
    public List<EnsembleLineItemInfoBean> getEnsLineItemInfo(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getEnsLineItemInfo", "Order ID : " + orderId);

        ArrayList<EnsembleLineItemInfoBean> enslineItemsList = new ArrayList<EnsembleLineItemInfoBean>();
        EnsembleLineItemInfoBean lineItem = null;

        String sql = OrderQueries.getEnsLineItemInfoSQL();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getENSDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
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
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsLineItemInfo", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsLineItemInfo", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsLineItemInfo", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsLineItemInfo", e);
                }
            }
        }

        if (enslineItemsList == null || enslineItemsList.isEmpty())
        {
            PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getEnsLineItemInfo", PSOConstants.NO_DATA);
        }

        return enslineItemsList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getPortalOrderPortDetails(java.lang.String)
     */
    @Override
    public List<PortalOrderPortRequestBean> getPortalOrderPortDetails(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getPortalOrderPortDetails", "Order ID : " + orderId);

        ArrayList<PortalOrderPortRequestBean> portItemList = new ArrayList<PortalOrderPortRequestBean>();
        PortalOrderPortRequestBean portLine = null;

        String sql = OrderQueries.getPortalPortinInfoSQL();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
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
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalOrderPortDetails", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalOrderPortDetails", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalOrderPortDetails", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalOrderPortDetails", e);
                }
            }
        }

        if (portItemList == null || portItemList.isEmpty())
        {
            PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getPortalOrderPortDetails", PSOConstants.NO_DATA);
        }

        return portItemList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getEnsOrderPortDetails(java.lang.String)
     */
    @Override
    public List<EnsOrderPortRequestBean> getEnsOrderPortDetails(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getEnsOrderPortDetails", "Order ID : " + orderId);

        ArrayList<EnsOrderPortRequestBean> portItemList = new ArrayList<EnsOrderPortRequestBean>();
        EnsOrderPortRequestBean portLine = null;

        String sql = OrderQueries.getEnsPortinInfoSQL();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getENSDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
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
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsOrderPortDetails", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsOrderPortDetails", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsOrderPortDetails", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getEnsOrderPortDetails", e);
                }
            }
        }

        if (portItemList == null || portItemList.isEmpty())
        {
            PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getEnsOrderPortDetails", PSOConstants.NO_DATA);
        }

        return portItemList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getPortalLineSimAndImeiDetails(java.lang.String)
     */
    @Override
    public List<PortalShipmentInfo> getPortalLineSimAndImeiDetails(String orderId)
    {
        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getPortalLineSimAndImeiDetails", "Order ID : " + orderId);

        ArrayList<PortalShipmentInfo> portLineList = new ArrayList<PortalShipmentInfo>();
        PortalShipmentInfo portLine = null;

        String sql = OrderQueries.getOrderLineSIMandIMEIDetailsSQL();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            rs = pstm.executeQuery();
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
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalLineSimAndImeiDetails", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalLineSimAndImeiDetails", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalLineSimAndImeiDetails", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPortalLineSimAndImeiDetails", e);
                }
            }
        }

        if (portLineList == null || portLineList.isEmpty())
        {
            PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getPortalLineSimAndImeiDetails", PSOConstants.NO_DATA);
        }

        return portLineList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#getOrderCurrentValue(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getOrderCurrentValue(String orderId, String lineId, String updateType)
    {
        String currentValue = null;
        String sql = null;

        if ("sim".equalsIgnoreCase(updateType))
        {
            sql = OrderQueries.getCurrentSIMSQL();
        }
        else if ("imei".equalsIgnoreCase(updateType))
        {
            sql = OrderQueries.getCurrentIMEISQL();
        }
        else if ("status".equalsIgnoreCase(updateType))
        {
            sql = OrderQueries.getCurrentStatusSQL();
        }
        else if ("retry".equalsIgnoreCase(updateType))
        {
            sql = OrderQueries.getCurrentRetrySQL();
        }

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, orderId);
            if ("sim".equalsIgnoreCase(updateType) || "imei".equalsIgnoreCase(updateType))
            {
                pstm.setString(2, lineId);
            }

            rs = pstm.executeQuery();
            while (rs.next())
            {
                currentValue = rs.getString(1);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderCurrentValue", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderCurrentValue", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderCurrentValue", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getOrderCurrentValue", e);
                }
            }
        }

        return currentValue;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.OrderInfoManagerDAO#orderStatusList()
     */
    @Override
    public List<String> getOrderStatusList()
    {

        List<String> statusList = new ArrayList<String>();

        String sql = OrderQueries.getOrderStatusList();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                statusList.add(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "orderStatusList", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "orderStatusList", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "orderStatusList", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "orderStatusList", e);
                }
            }
        }

        return statusList;
    }

    public InventoryStatusofItemBean getInventoryStatus(String skuId)
    {

        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getInventoryStatus", "SKU ID : " + skuId);

        InventoryStatusofItemBean inventoryDetails = null;

        String sql = OrderQueries.getInventoryStatus();
        String sql1 = OrderQueries.getUpholdLevel();

        PreparedStatement pstm = null;
        PreparedStatement pstm1 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            inventoryDetails = new InventoryStatusofItemBean();

            pstm = con.prepareStatement(sql);
            pstm.setString(1, skuId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                inventoryDetails.setDisplayName(rs.getString("DISPLAY_NAME"));
                inventoryDetails.setAvailStatus(rs.getString("AVAIL_STATUS"));
                inventoryDetails.setStockLevel(rs.getString("STOCK_LEVEL"));
                inventoryDetails.setStockThresh(rs.getString("STOCK_THRESH"));
            }

            pstm1 = con.prepareStatement(sql1);
            pstm1.setString(1, skuId);
            rs1 = pstm1.executeQuery();
            while (rs1.next())
            {
                if (null != rs1.getString("UPHOLD_LEVEL"))
                {
                    int stockFlag = Integer.parseInt(inventoryDetails.getStockLevel()) - Integer.parseInt(inventoryDetails.getStockThresh()) - Integer.parseInt(rs1.getString("UPHOLD_LEVEL"));
                    if (stockFlag > 0)
                    {
                        inventoryDetails.setStockStatus("SKU is in Stock");
                    }
                    else
                    {
                        inventoryDetails.setStockStatus("SKU is Out of Stock");
                    }
                }
            }

        }
        catch (SQLException e)
        {
            inventoryDetails.setErrorCode(PSOConstants.ERROR_CODE);
            inventoryDetails.setErrorMsg(e.getMessage());
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getInventoryStatus", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getInventoryStatus", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getInventoryStatus", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getInventoryStatus", e);
                }
            }

            if (pstm1 != null)
            {
                try
                {
                    pstm1.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getInventoryStatus", e);
                }
            }
            if (rs1 != null)
            {
                try
                {
                    rs1.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getInventoryStatus", e);
                }
            }
        }

        return inventoryDetails;

    }

    public NameDataBean getESNReuseData(String ESN)
    {

        PSOLoggerSrv.printDEBUG(logger,CLASS_NAME, "getESNReuseData", "ESN:" + ESN);

        NameDataBean nameData = null;

        String sql = OrderQueries.getESNReuseData();
        String sql1 = OrderQueries.getNameOfCustomerQuery();
        String sql2 = OrderQueries.getNameForCustomerQuery();
        PreparedStatement pstm = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        Connection con = this.getENSDbConnction();

        try
        {
            nameData = new NameDataBean();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, ESN);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                nameData.setCustId(rs.getString("customer_id"));

            }

            pstm1 = con.prepareStatement(sql1);
            if (null != nameData.getCustId())
            {
                pstm1.setString(1, nameData.getCustId());
                rs1 = pstm1.executeQuery();
                while (rs1.next())
                {
                    nameData.setNameId(rs1.getString("name_id"));
                    break;
                }
            }
            

            pstm2 = con.prepareStatement(sql2);
            if (null != nameData.getNameId())
            {
                pstm2.setString(1, nameData.getNameId());
                rs2 = pstm2.executeQuery();
                while (rs2.next())
                {
                    nameData.setFirstName(rs2.getString("FIRST_NAME"));
                    nameData.setLastName(rs2.getString("LAST_BUSINESS_NAME"));
                }
            }

        }
        catch (SQLException e)
        {
            nameData.setErrorCode(PSOConstants.ERROR_CODE);
            nameData.setErrorMsg(e.getMessage());
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getInventoryStatus", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getESNReuseData", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getESNReuseData", e);
                }
            }
            if (pstm1 != null)
            {
                try
                {
                    pstm1.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getESNReuseData", e);
                }
            }
            if (pstm2 != null)
            {
                try
                {
                    pstm2.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getESNReuseData", e);
                }
            }
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getESNReuseData", e);
                }
            }

            if (rs1 != null)
            {
                try
                {
                    rs1.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getESNReuseData", e);
                }
            }
            if (rs2 != null)
            {
                try
                {
                    rs2.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getESNReuseData", e);
                }
            }
        }

        return nameData;

    }

}
