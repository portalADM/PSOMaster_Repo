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
public class StuckOrderDetailsDAOImpl implements StuckOrderDetailsDAO{
	
	private static Connection portalDBConnection = null;

	    public StuckOrderDetailsDAOImpl()
	    {
	        portalDBConnection = DBConnection.getPortalDBConnection();
	    }
	    
	    private Connection getPortalDbConnction()
	    {
	        return DBConnection.getPortalDBConnection();
	    }


	/* (non-Javadoc)
	 * @see com.zig.pso.dao.StuckOrderDetailsDAO#getOSHFSingleLineOrder()
	 */
	@Override
	public ArrayList<OSHFSingleLineResponse> getOSHFSingleLineOrder() {
		PSOLoggerSrv.printDEBUG("StuckOrderDetailsDAOImpl", "getOSHFSingleLineOrder","");
		String sql= null;

        ArrayList<OSHFSingleLineResponse> OSHFSingleLineResponseList= new ArrayList<OSHFSingleLineResponse>();
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
            	OSHFSingleLineResponse OSHFSingleLineResponse=new OSHFSingleLineResponse();
            	OSHFSingleLineResponse.setOrderId(rs.getString("ORDER_ID"));
            	OSHFSingleLineResponse.setImei(rs.getString("IMEI"));
            	OSHFSingleLineResponse.setSim(rs.getString("SIM"));
            	OSHFSingleLineResponse.setBillOfLading(rs.getString("ORDER_TRACK_NO"));
            	OSHFSingleLineResponse.setScac(rs.getString("SCAC_CODE"));
            	OSHFSingleLineResponseList.add(OSHFSingleLineResponse);
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("StuckOrderDetailsDAOImpl", "getOSHFSingleLineOrder", e);
        }
        finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR("StuckOrderDetailsDAOImpl", "getOSHFSingleLineOrder", e);
                }
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR("StuckOrderDetailsDAOImpl", "getOSHFSingleLineOrder", e);
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
                    PSOLoggerSrv.printERROR("StuckOrderDetailsDAOImpl", "getOSHFSingleLineOrder", e);
                }
            }
        }

        return OSHFSingleLineResponseList;
	}

	/* (non-Javadoc)
	 * @see com.zig.pso.dao.StuckOrderDetailsDAO#getOSHFMultiLineOrder()
	 */
	@Override
	public ArrayList<OSHFMultiLineResponse> getOSHFMultiLineOrder() {
		PSOLoggerSrv.printDEBUG("StuckOrderDetailsDAOImpl", "getOSHFMultiLineOrder","");
		String sql= null;

        ArrayList<OSHFMultiLineResponse> OSHFMultiLineResponseList= new ArrayList<OSHFMultiLineResponse>();
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
            	OSHFMultiLineResponse OSHFMultiLineResponse=new OSHFMultiLineResponse();
            	OSHFMultiLineResponse.setOrderId(rs.getString("ORDER_ID"));
            	OSHFMultiLineResponse.setImei(rs.getString("IMEI"));
            	OSHFMultiLineResponse.setSim(rs.getString("SIM"));
            	OSHFMultiLineResponse.setOrder_track_no(rs.getString("ORDER_TRACK_NO"));
            	OSHFMultiLineResponse.setScac(rs.getString("SCAC_CODE"));
            	OSHFMultiLineResponse.setEsn(rs.getString("ESN_NO"));
            	
            	
            	OSHFMultiLineResponseList.add(OSHFMultiLineResponse);
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("StuckOrderDetailsDAOImpl", "getOSHFMultiLineOrder", e);
        }
        finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR("StuckOrderDetailsDAOImpl", "getOSHFMultiLineOrder", e);
                }
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR("StuckOrderDetailsDAOImpl", "getOSHFMultiLineOrder", e);
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
                    PSOLoggerSrv.printERROR("StuckOrderDetailsDAOImpl", "getOSHFMultiLineOrder", e);
                }
            }
        }

        return OSHFMultiLineResponseList;
	}

}
