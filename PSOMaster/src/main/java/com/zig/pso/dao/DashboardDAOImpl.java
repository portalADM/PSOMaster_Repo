/************************************************************************************************************
 * Class Name : DashboardDAOImpl.java 
 * Description: This class is responsible for providing stuck order statistics from databse for Dashboard page. 
 * Author : Nilesh Patil 
 * Date : Aug 2, 2016
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
import com.zig.pso.rest.bean.RegularOrdersCount;
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
    
    private Connection getPortalDbConnction()
    {
        return DBConnection.getPortalDBConnection();
    }

    /*
     * This method gives Stuck order counts
     * @see com.zig.pso.dao.DashboardDAO#getStuckOrderList()
     */
    @Override
    public ArrayList<StuckOrdersCount> getStuckOrderList()
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderList", "");

        ArrayList<StuckOrdersCount> stuckOrderList = new ArrayList<StuckOrdersCount>();
        String sql = OrderQueries.getstuckOrdersCount();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList", e);
                }
            }
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

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, status);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                stuckOrderList.add(rs.getString("order_id"));
            }

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList1", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList1", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList1", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderList1", e);
                }
            }
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
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderhandled", "");

        ArrayList<StuckOrdersCount> stuckOrderList = new ArrayList<StuckOrdersCount>();
        String sql = OrderQueries.getOrderHandled();
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderhandled", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderhandled", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderhandled", e);
                }
            }
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
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderallStatus", "");

        ArrayList<StuckOrdersCount> stuckOrderList = new ArrayList<StuckOrdersCount>();
        String sql = OrderQueries.getstuckOrderStatusbyCount();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderallStatus", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderallStatus", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderallStatus", e);
                }
            }
        }

        return stuckOrderList;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.DashboardDAO#getStuckOrderBackloagDetails()
     */
    @Override
    public ArrayList<StuckOrderBacklogDBResultsBean> getStuckOrderBackloagDetails()
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getStuckOrderBackloagDetails", "");

        ArrayList<StuckOrderBacklogDBResultsBean> stuckOrderList = new ArrayList<StuckOrderBacklogDBResultsBean>();
        String sql = OrderQueries.getPortalStuckOrderBacklogInfoSQL();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
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
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderBackloagDetails", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderBackloagDetails", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderBackloagDetails", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getStuckOrderBackloagDetails", e);
                }
            }
        }

        return stuckOrderList;
    }

    // RegularOrders Count DAO Methods

    @Override
    public int getRegisteredOrdersCount(String type)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getRegisteredOrdersCount", "");

        String sql = OrderQueries.getRegisteredOrderCount();
        int count = 0;
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            if (type == "ADDLINE")
                pstm.setString(1, "100");
            else if (type == "UPGRADE")
                pstm.setString(1, "200");
            else if (type == "SIMSWAP")
                pstm.setString(1, "300");
            
            rs = pstm.executeQuery();
            while (rs.next())
            {
                count = rs.getInt("count");
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getRegisteredOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getRegisteredOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getRegisteredOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getRegisteredOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getACTIorCNCLOrdersCount(String type)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getACTIorCNCLOrdersCount", "");

        String sql = OrderQueries.getACTIorCNCLOrderCount();
        int count = 0;
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            if (type == "ACTIVE")
                pstm.setString(1, "ACTI");
            else if (type == "CANCEL")
                pstm.setString(1, "CNCL");

            rs = pstm.executeQuery();
            while (rs.next())
            {
                count = rs.getInt("count");
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getACTIorCNCLOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getACTIorCNCLOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getACTIorCNCLOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getACTIorCNCLOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getOrdersCount(String type)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getOrdersCount", "");

        String sql = OrderQueries.getRegOrderCount();
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        int count = 0;
        try
        {
            pstm = con.prepareStatement(sql);
            if (type == "PORTIN")
                pstm.setString(1, "100");
            else if (type == "REGULAR")
                pstm.setString(1, "200");
            else if (type == "ACCESSORY")
                pstm.setString(1, "300");
            
            rs = pstm.executeQuery();
            while (rs.next())
            {
                count = rs.getInt("count");
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getPrepurchaseOrdersCount()
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getPrepurchaseOrdersCount", "");

        String sql = OrderQueries.getPrepurchaseOrderCount();
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        int count = 0;
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                count = rs.getInt("count");
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getPrepurchaseOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getPrepurchaseOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getPrepurchaseOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getPrepurchaseOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getByodOrdersCount()
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getByodOrdersCount", "");

        String sql = OrderQueries.getByodOrderCount();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        int count = 0;
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                count = rs.getInt("count");
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getByodOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getByodOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getByodOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getByodOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getSaveDeskOrdersCount()
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getSaveDeskOrdersCount", "");

        String sql = OrderQueries.getSaveDeskOrderCount();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        int count = 0;
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                count = rs.getInt("count");
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getSaveDeskOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getSaveDeskOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getSaveDeskOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getSaveDeskOrdersCount", e);
                }
            }
        }

        return count;
    }

    // **************************************************************************************
    // Dynamic Graphs Methods
    @Override
    public ArrayList<RegularOrdersCount> getOrdersCount(String fromDate, String toDate, String type)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getOrdersCount ", "");

        ArrayList<RegularOrdersCount> dynamicOrdersCountList = new ArrayList<RegularOrdersCount>();

        String sql = OrderQueries.getDynOrderCount();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fromDate);
            pstm.setString(2, toDate);
            pstm.setString(3, type);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                RegularOrdersCount DynamicOrdersCount = new RegularOrdersCount();
                DynamicOrdersCount.setCount(rs.getInt("count"));
                DynamicOrdersCount.setDate(rs.getString("SYS_CREATION_DATE"));
                dynamicOrdersCountList.add(DynamicOrdersCount);
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public ArrayList<RegularOrdersCount> getByodOrdersCount(String fromDate, String toDate)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getByodOrdersCount ", "");

        ArrayList<RegularOrdersCount> dynamicOrdersCountList = new ArrayList<RegularOrdersCount>();

        String sql = OrderQueries.getDynByodOrderCount();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fromDate);
            pstm.setString(2, toDate);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                RegularOrdersCount DynamicOrdersCount = new RegularOrdersCount();
                DynamicOrdersCount.setCount(rs.getInt("count"));
                DynamicOrdersCount.setDate(rs.getString("SYS_CREATION_DATE"));
                dynamicOrdersCountList.add(DynamicOrdersCount);
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getByodOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getByodOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getByodOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getByodOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public ArrayList<RegularOrdersCount> getPrepurchaseOrdersCount(String fromDate, String toDate)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getPrepurchaseOrdersCount ", "");

        ArrayList<RegularOrdersCount> dynamicOrdersCountList = new ArrayList<RegularOrdersCount>();

        String sql = OrderQueries.getDynPrepurchaseOrderCount();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fromDate);
            pstm.setString(2, toDate);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                RegularOrdersCount DynamicOrdersCount = new RegularOrdersCount();
                DynamicOrdersCount.setCount(rs.getInt("count"));
                DynamicOrdersCount.setDate(rs.getString("SYS_CREATION_DATE"));
                dynamicOrdersCountList.add(DynamicOrdersCount);
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getPrepurchaseOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getPrepurchaseOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getPrepurchaseOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getPrepurchaseOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public ArrayList<RegularOrdersCount> getSaveDeskOrdersCount(String fromDate, String toDate)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getSaveDeskOrdersCount ", "");

        ArrayList<RegularOrdersCount> dynamicOrdersCountList = new ArrayList<RegularOrdersCount>();

        String sql = OrderQueries.getDynSaveDeskOrderCount();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fromDate);
            pstm.setString(2, toDate);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                RegularOrdersCount DynamicOrdersCount = new RegularOrdersCount();
                DynamicOrdersCount.setCount(rs.getInt("count"));
                DynamicOrdersCount.setDate(rs.getString("SYS_CREATION_DATE"));
                dynamicOrdersCountList.add(DynamicOrdersCount);
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getSaveDeskOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getSaveDeskOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getSaveDeskOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getSaveDeskOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public ArrayList<RegularOrdersCount> getACTIorCNCLOrdersCount(String fromDate, String toDate, String type)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getACTIorCNCLOrdersCount ", "");

        ArrayList<RegularOrdersCount> dynamicOrdersCountList = new ArrayList<RegularOrdersCount>();

        String sql = OrderQueries.getDynACTIorCNCLOrderCount();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fromDate);
            pstm.setString(2, toDate);
            pstm.setString(3, type);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                RegularOrdersCount DynamicOrdersCount = new RegularOrdersCount();
                DynamicOrdersCount.setCount(rs.getInt("count"));
                DynamicOrdersCount.setDate(rs.getString("CREATION_DATE"));
                dynamicOrdersCountList.add(DynamicOrdersCount);
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getACTIorCNCLOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getACTIorCNCLOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getACTIorCNCLOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getACTIorCNCLOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public ArrayList<RegularOrdersCount> getRegisteredOrdersCount(String fromDate, String toDate, String type)
    {
        PSOLoggerSrv.printDEBUG("DashboardDAOImpl", "getRegisteredOrdersCount ", "");

        ArrayList<RegularOrdersCount> dynamicOrdersCountList = new ArrayList<RegularOrdersCount>();

        String sql = OrderQueries.getDynRegisteredOrderCount();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fromDate);
            pstm.setString(2, toDate);
            pstm.setString(3, type);

            rs = pstm.executeQuery();
            while (rs.next())
            {
                RegularOrdersCount DynamicOrdersCount = new RegularOrdersCount();
                DynamicOrdersCount.setCount(rs.getInt("count"));
                DynamicOrdersCount.setDate(rs.getString("SYS_CREATION_DATE"));
                dynamicOrdersCountList.add(DynamicOrdersCount);
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("DashboardDAOImpl", "getRegisteredOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getRegisteredOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getRegisteredOrdersCount", e);
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
                    PSOLoggerSrv.printERROR("DashboardDAOImpl", "getRegisteredOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }
}
