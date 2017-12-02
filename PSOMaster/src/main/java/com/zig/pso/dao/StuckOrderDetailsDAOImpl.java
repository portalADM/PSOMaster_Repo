/************************************************************************************************************
 * Class Name :  StuckOrderDetailsDAOImpl.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.OSHFMultiLineResponse;
import com.zig.pso.rest.bean.OSHFSingleLineResponse;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

/**
 * 
 */
@Repository
public class StuckOrderDetailsDAOImpl implements StuckOrderDetailsDAO
{
    public static final String CLASS_NAME = "StuckOrderDetailsDAOImpl";

    private Connection getPortalDbConnction()
    {
        return DBConnection.getPortalDBConnection();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.StuckOrderDetailsDAO#getOSHFSingleLineOrder()
     */
    @Override
    public List<OSHFSingleLineResponse> getOSHFSingleLineOrder()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getOSHFSingleLineOrder", "");
        String sql = null;

        ArrayList<OSHFSingleLineResponse> oSHFSingleLineResponseList = new ArrayList<OSHFSingleLineResponse>();
        sql = OrderQueries.getstuckOrdersbySingleLine();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                OSHFSingleLineResponse oSHFSingleLineResponse = new OSHFSingleLineResponse();
                oSHFSingleLineResponse.setOrderId(rs.getString("ORDER_ID"));
                oSHFSingleLineResponse.setImei(rs.getString("IMEI"));
                oSHFSingleLineResponse.setSim(rs.getString("SIM"));
                oSHFSingleLineResponse.setBillOfLading(rs.getString("ORDER_TRACK_NO"));
                oSHFSingleLineResponse.setScac(rs.getString("SCAC_CODE"));
                oSHFSingleLineResponseList.add(oSHFSingleLineResponse);
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(CLASS_NAME, "getOSHFSingleLineOrder", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getOSHFSingleLineOrder", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getOSHFSingleLineOrder", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getOSHFSingleLineOrder", e);
                }
            }
        }

        return oSHFSingleLineResponseList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.StuckOrderDetailsDAO#getOSHFMultiLineOrder()
     */
    @Override
    public List<OSHFMultiLineResponse> getOSHFMultiLineOrder()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getOSHFMultiLineOrder", "");
        String sql = null;

        ArrayList<OSHFMultiLineResponse> oSHFMultiLineResponseList = new ArrayList<OSHFMultiLineResponse>();
        sql = OrderQueries.getstuckOrdersbyMultiLine();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                OSHFMultiLineResponse oSHFMultiLineResponse = new OSHFMultiLineResponse();
                oSHFMultiLineResponse.setOrderId(rs.getString("ORDER_ID"));
                oSHFMultiLineResponse.setImei(rs.getString("IMEI"));
                oSHFMultiLineResponse.setSim(rs.getString("SIM"));
                oSHFMultiLineResponse.setOrderTrackNo(rs.getString("ORDER_TRACK_NO"));
                oSHFMultiLineResponse.setScac(rs.getString("SCAC_CODE"));
                oSHFMultiLineResponse.setEsn(rs.getString("ESN_NO"));

                oSHFMultiLineResponseList.add(oSHFMultiLineResponse);
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(CLASS_NAME, "getOSHFMultiLineOrder", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getOSHFMultiLineOrder", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getOSHFMultiLineOrder", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getOSHFMultiLineOrder", e);
                }
            }
        }

        return oSHFMultiLineResponseList;
    }

}
