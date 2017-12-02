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
import java.util.List;

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
    public static final String CLASS_NAME = "DashboardDAOImpl";
    
    private Connection getPortalDbConnction()
    {
        return DBConnection.getPortalDBConnection();
    }

    /*
     * This method gives Stuck order counts
     * @see com.zig.pso.dao.DashboardDAO#getStuckOrderList()
     */
    @Override
    public List<StuckOrdersCount> getStuckOrderList()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getStuckOrderList", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderList", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderList", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderList", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderList", e);
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
    public List<String> getStuckOrderList1(String status)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getStuckOrderList1", "status : " + status);

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderList1", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderList1", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderList1", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderList1", e);
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
    public List<StuckOrdersCount> getStuckOrderhandled()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getStuckOrderhandled", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderhandled", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderhandled", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderhandled", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderhandled", e);
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
    public List<StuckOrdersCount> getStuckOrderallStatus()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getStuckOrderallStatus", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderallStatus", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderallStatus", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderallStatus", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderallStatus", e);
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
    public List<StuckOrderBacklogDBResultsBean> getStuckOrderBackloagDetails()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getStuckOrderBackloagDetails", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderBackloagDetails", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderBackloagDetails", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderBackloagDetails", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getStuckOrderBackloagDetails", e);
                }
            }
        }

        return stuckOrderList;
    }

    // RegularOrders Count DAO Methods

    @Override
    public int getRegisteredOrdersCount(String type)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getRegisteredOrdersCount", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getRegisteredOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getRegisteredOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getRegisteredOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getRegisteredOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getACTIorCNCLOrdersCount(String type)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getACTIorCNCLOrdersCount", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getACTIorCNCLOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getACTIorCNCLOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getACTIorCNCLOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getACTIorCNCLOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getOrdersCount(String type)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getOrdersCount", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getPrepurchaseOrdersCount()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getPrepurchaseOrdersCount", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getPrepurchaseOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getPrepurchaseOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getPrepurchaseOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getPrepurchaseOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getByodOrdersCount()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getByodOrdersCount", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getByodOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getByodOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getByodOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getByodOrdersCount", e);
                }
            }
        }

        return count;
    }

    @Override
    public int getSaveDeskOrdersCount()
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getSaveDeskOrdersCount", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getSaveDeskOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getSaveDeskOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getSaveDeskOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getSaveDeskOrdersCount", e);
                }
            }
        }

        return count;
    }

    // **************************************************************************************
    // Dynamic Graphs Methods
    @Override
    public List<RegularOrdersCount> getOrdersCount(String fromDate, String toDate, String type)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getOrdersCount ", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public List<RegularOrdersCount> getByodOrdersCount(String fromDate, String toDate)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getByodOrdersCount ", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getByodOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getByodOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getByodOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getByodOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public List<RegularOrdersCount> getPrepurchaseOrdersCount(String fromDate, String toDate)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getPrepurchaseOrdersCount ", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getPrepurchaseOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getPrepurchaseOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getPrepurchaseOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getPrepurchaseOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public List<RegularOrdersCount> getSaveDeskOrdersCount(String fromDate, String toDate)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getSaveDeskOrdersCount ", "");

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
            PSOLoggerSrv.printERROR(CLASS_NAME, "getSaveDeskOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getSaveDeskOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getSaveDeskOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getSaveDeskOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public List<RegularOrdersCount> getACTIorCNCLOrdersCount(String fromDate, String toDate, String type)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getACTIorCNCLOrdersCount ", "");

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
                RegularOrdersCount dynamicOrdersCount = new RegularOrdersCount();
                dynamicOrdersCount.setCount(rs.getInt("count"));
                dynamicOrdersCount.setDate(rs.getString("CREATION_DATE"));
                dynamicOrdersCountList.add(dynamicOrdersCount);
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(CLASS_NAME, "getACTIorCNCLOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getACTIorCNCLOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getACTIorCNCLOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getACTIorCNCLOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }

    @Override
    public List<RegularOrdersCount> getRegisteredOrdersCount(String fromDate, String toDate, String type)
    {
        PSOLoggerSrv.printDEBUG(CLASS_NAME, "getRegisteredOrdersCount ", "");

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
                RegularOrdersCount dynamicOrdersCount = new RegularOrdersCount();
                dynamicOrdersCount.setCount(rs.getInt("count"));
                dynamicOrdersCount.setDate(rs.getString("SYS_CREATION_DATE"));
                dynamicOrdersCountList.add(dynamicOrdersCount);
            }
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR(CLASS_NAME, "getRegisteredOrdersCount", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(CLASS_NAME, "getRegisteredOrdersCount", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getRegisteredOrdersCount", e);
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
                    PSOLoggerSrv.printERROR(CLASS_NAME, "getRegisteredOrdersCount", e);
                }
            }
        }

        return dynamicOrdersCountList;
    }
}
