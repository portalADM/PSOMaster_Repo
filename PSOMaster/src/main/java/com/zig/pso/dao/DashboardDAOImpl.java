/************************************************************************************************************
 * Class Name : DashboardDAOImpl.java 
 * Description: This class is responsible for providing stuck order statistics from databse for Dashboard page.
 * Author     : Nilesh Patil 
 * Date       : Aug 2, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.StuckOrderBacklogDBResultsBean;
import com.zig.pso.rest.bean.StuckOrdersCount;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

/**
 * 
 */
@Repository
public class DashboardDAOImpl implements DashboardDAO
{

    /**
	 * 
	 */
    private static Connection portalDBConnection = null;

    public DashboardDAOImpl()
    {
        portalDBConnection = DBConnection.getPortalDBConnection();
    }

    /*
     * This method gives Stuck order counts
     * 
     * @see com.zig.pso.dao.DashboardDAO#getStuckOrderList()
     */
    @Override
    public ArrayList<StuckOrdersCount> getStuckOrderList()
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderList", "");

        ArrayList<StuckOrdersCount> stuckOrderList = new ArrayList<StuckOrdersCount>();
        String sql = OrderQueries.getstuckOrdersCount();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            StuckOrdersCount stuckOrderCount = null;
            while (rs.next())
            {
                stuckOrderCount = new StuckOrdersCount();
                stuckOrderCount.setCount(rs.getInt("count"));
                stuckOrderCount.setOrderStatus(rs.getString("status_code"));
                stuckOrderList.add(stuckOrderCount);
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList", e);
        }

        return stuckOrderList;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.DashboardDAO#getStuckOrderList1()
     */
    @Override
    public ArrayList<String> getStuckOrderList1(String status)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderList1", "status : " + status);

        ArrayList<String> stuckOrderList = new ArrayList<String>();
        String sql = OrderQueries.getstuckOrdersbyStatus();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, status);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
            {
                stuckOrderList.add(rs.getString("order_id"));
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList1", e);
        }
        return stuckOrderList;

    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.DashboardDAO#getStuckOrderhandled()
     */
    @Override
    public ArrayList<StuckOrdersCount> getStuckOrderhandled()
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderhandled",  "");

        ArrayList<StuckOrdersCount> stuckOrderList = new ArrayList<StuckOrdersCount>();
        String sql = OrderQueries.getOrderHandled();
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            StuckOrdersCount stuckOrderCount = null;
            while (rs.next())
            {
                stuckOrderCount = new StuckOrdersCount();
                stuckOrderCount.setDateOfHandlingl(rs.getString(1));
                stuckOrderCount.setCount(rs.getInt(2));
                stuckOrderList.add(stuckOrderCount);
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderhandled", e);
        }
        return stuckOrderList;

    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.DashboardDAO#getStuckOrderallStatus()
     */
    @Override
    public ArrayList<StuckOrdersCount> getStuckOrderallStatus()
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderallStatus",  "");

        ArrayList<StuckOrdersCount> stuckOrderList = new ArrayList<StuckOrdersCount>();
        String sql = OrderQueries.getstuckOrderStatusbyCount();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            StuckOrdersCount stuckOrderCount = null;
            while (rs.next())
            {
                stuckOrderCount = new StuckOrdersCount();
                stuckOrderCount.setCount(rs.getInt("count"));
                stuckOrderCount.setOrderStatus(rs.getString("status_code"));
                stuckOrderList.add(stuckOrderCount);
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderallStatus", e);
        }
        return stuckOrderList;
    }

	/* (non-Javadoc)
	 * @see com.zig.pso.dao.DashboardDAO#getStuckOrderBackloagDetails()
	 */
	@Override
	public ArrayList<StuckOrderBacklogDBResultsBean> getStuckOrderBackloagDetails() {
		PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderBackloagDetails",  "");

        ArrayList<StuckOrderBacklogDBResultsBean> stuckOrderList = new ArrayList<StuckOrderBacklogDBResultsBean>();
        String sql = OrderQueries.getPortalStuckOrderBacklogInfoSQL();

        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            StuckOrderBacklogDBResultsBean stuckOrderCount = null;
            while (rs.next())
            {
                stuckOrderCount = new StuckOrderBacklogDBResultsBean();
                stuckOrderCount.setCount(rs.getInt("ORDER_COUNT"));
                stuckOrderCount.setOrderCreationDate(rs.getString("CREATION_DATE"));
                stuckOrderCount.setStatusCode(rs.getString("STATUS_CODE"));
                stuckOrderList.add(stuckOrderCount);
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderallStatus", e);
        }
        return stuckOrderList;
	}
}
