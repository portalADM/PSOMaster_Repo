/************************************************************************************************************
 * Class Name :  GroupDAOImpl.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 25, 2017
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
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.GroupMaster;
import com.zig.pso.rest.bean.RoleMaster;
import com.zig.pso.utility.CommonUtility;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

/**
 * 
 */
@Repository
public class GroupDAOImpl implements GroupDAO
{
    public GroupDAOImpl()
    {
        super();
    }

    private Connection getPortalDbConnction()
    {
        return DBConnection.getPortalDBConnection();
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.GroupDAO#getRoleList()
     */
    @Override
    public ArrayList<RoleMaster> getRoleList()
    {
        ArrayList<RoleMaster> roleList = new ArrayList<RoleMaster>();
        String sql = OrderQueries.getRoleList();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                roleList.add(new RoleMaster(rs.getInt("ROLE_ID"), rs.getString("NAME"), rs.getString("ROLE_DESC")));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("GroupDAOImpl", "getRoleList", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "getRoleList", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "getRoleList", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "getRoleList", e);
                }
            }
        }

        return roleList;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.GroupDAO#addGroup(com.zig.pso.rest.bean.GroupMaster)
     */
    @Override
    public BaseResponseBean addGroup(GroupMaster group)
    {
        BaseResponseBean addGroupResp = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.addNewGroup();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            
            pstm = con.prepareStatement(sql);
            pstm.setString(1, group.getGroupName());
            pstm.setString(2, group.getGroupDesc());
            pstm.setInt(3, group.getRoleId());
            pstm.setString(4, group.getCreatedBy());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                addGroupResp.setErrorCode(PSOConstants.INFO_CODE);
                addGroupResp.setErrorMsg(PSOConstants.NO_DATA_INSERTED);
                addGroupResp.setLogRefId(logRefID);
            }
            else
            {
                addGroupResp.setErrorCode(PSOConstants.SUCCESS_CODE);
                addGroupResp.setErrorMsg(PSOConstants.GROUP_INSERT_SUCCESSFULL);
                addGroupResp.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("GroupDAOImpl", "addGroup", logRefID, sql,group, addGroupResp.getErrorMsg());
        }
        catch (SQLException e)
        {
            addGroupResp.setErrorCode(PSOConstants.ERROR_CODE);
            addGroupResp.setErrorMsg(PSOConstants.BACKEND_ERROR);
            addGroupResp.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("GroupDAOImpl", "addGroup", logRefID, sql,group, e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "addGroup", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "addGroup", e);
                }
            }
        }

        return addGroupResp;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.GroupDAO#updateGroup(com.zig.pso.rest.bean.GroupMaster)
     */
    @Override
    public BaseResponseBean updateGroup(GroupMaster group)
    {
        BaseResponseBean updateGroupResp = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateGroup();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, group.getGroupName());
            pstm.setString(2, group.getGroupDesc());
            pstm.setInt(3, group.getRoleId());
            pstm.setString(4, group.getCreatedBy());
            pstm.setInt(5, group.getGroupId());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                updateGroupResp.setErrorCode(PSOConstants.INFO_CODE);
                updateGroupResp.setErrorMsg(PSOConstants.NO_DATA_UPDATED);
                updateGroupResp.setLogRefId(logRefID);
            }
            else
            {
                updateGroupResp.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateGroupResp.setErrorMsg(PSOConstants.GROUP_UPDATE_SUCCESSFULL);
                updateGroupResp.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("GroupDAOImpl", "updateGroup", logRefID, sql,group, updateGroupResp.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateGroupResp.setErrorCode(PSOConstants.ERROR_CODE);
            updateGroupResp.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateGroupResp.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("GroupDAOImpl", "updateGroup", logRefID, sql,group, e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "updateGroup", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "updateGroup", e);
                }
            }
        }

        return updateGroupResp;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.GroupDAO#getGroupList()
     */
    @Override
    public ArrayList<GroupMaster> getGroupList()
    {
        ArrayList<GroupMaster> groupList = new ArrayList<GroupMaster>();
        String sql = OrderQueries.getGroupList();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                groupList.add(new GroupMaster(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("GroupDAOImpl", "getGroupList", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "getGroupList", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "getGroupList", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "getGroupList", e);
                }
            }
        }

        return groupList;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.GroupDAO#deleteGroup(int)
     */
    @Override
    public BaseResponseBean deleteGroup(int groupId)
    {
        BaseResponseBean deleteGroupResp = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.deleteGroup();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, groupId);
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                deleteGroupResp.setErrorCode(PSOConstants.INFO_CODE);
                deleteGroupResp.setErrorMsg(PSOConstants.NO_DATA_DELETED);
                deleteGroupResp.setLogRefId(logRefID);
            }
            else
            {
                deleteGroupResp.setErrorCode(PSOConstants.SUCCESS_CODE);
                deleteGroupResp.setErrorMsg(PSOConstants.GROUP_DELETE_SUCCESSFULL);
                deleteGroupResp.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("GroupDAOImpl", "deleteGroup", logRefID, sql,groupId, deleteGroupResp.getErrorMsg());
        }
        catch (SQLException e)
        {
            deleteGroupResp.setErrorCode(PSOConstants.ERROR_CODE);
            deleteGroupResp.setErrorMsg(PSOConstants.BACKEND_ERROR);
            deleteGroupResp.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("GroupDAOImpl", "deleteGroup", logRefID, sql,groupId, e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "deleteGroup", e);
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
                    PSOLoggerSrv.printERROR("GroupDAOImpl", "deleteGroup", e);
                }
            }
        }

        return deleteGroupResp;
    }

}
