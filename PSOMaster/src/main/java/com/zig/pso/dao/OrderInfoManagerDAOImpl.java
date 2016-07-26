/************************************************************************************************************
 * Class Name : OrderInfoManagerDAOImpl.java Description: This class implements methods for order related operations. Author : Ankita Mishra Date : Jun 26, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalEnrollmentInfo;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
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
            e.printStackTrace();
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
        ArrayList<PortalShipmentInfo> portalShipArrlist = new ArrayList<PortalShipmentInfo>();
        String sql = OrderQueries.getPortalOrderData();
        String shipSql = OrderQueries.getShipmentOrderData();

        try
        {
            portalOrderlist = new PortalOrderMasterResponseBean();

            PreparedStatement pstm = portalDBConnection.prepareStatement(shipSql);
            pstm.setString(1, OrderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                PortalShipmentInfo portalShiplist = new PortalShipmentInfo();
                portalShiplist.setEpc_sku_id(rs.getString("Epc_sku_id"));
                portalShiplist.setImei(rs.getString("imei"));
                portalShiplist.setProduct_type(rs.getString("product_type"));
                portalShiplist.setEsn_number(rs.getString("esn_no"));
                portalShiplist.setShipment_date(rs.getString("shipment_date"));
                portalShiplist.setSim(rs.getString("sim"));
                portalShipArrlist.add(portalShiplist);

            }
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
                portalOrderlist.setPortalShipmentInfo(portalShipArrlist);

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
            portalOrderlist.setErrorCode((e.getErrorCode()));
            portalOrderlist.setErrorMsg(e.getMessage());
            // e.printStackTrace();
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
                ensOrderlist.setPtn(rs.getString("PTN"));
                ensOrderlist.setPtnStatus(rs.getString("PTN_STATUS"));
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
            ensOrderlist.setErrorCode((e.getErrorCode()));
            ensOrderlist.setErrorMsg(e.getMessage());
            // e.printStackTrace();
        }

        return ensOrderlist;
    }

}
