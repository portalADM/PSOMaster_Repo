/************************************************************************************************************
 * Class Name :  UserDAOImple.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 26, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;
import com.zig.pso.rest.bean.RejectPendingUserRequest;
import com.zig.pso.rest.bean.UserMaster;
import com.zig.pso.rest.bean.UserSearchRequestBean;
import com.zig.pso.utility.CommonUtility;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;


/**
 * 
 */
@Repository
public class UserDAOImpl implements UserDAO
{
    public UserDAOImpl()
    {
        super();
    }

    private Connection getPortalDbConnction()
    {
        return DBConnection.getPortalDBConnection();
    }
    
    public String authenticateUser(LoginRequestBean loginRequest)
    {
        String empId = StringUtils.EMPTY;
        
        String sql = OrderQueries.getauthenticateUserQuery();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, loginRequest.getUsername());
            pstm.setString(2, loginRequest.getPassword());
            rs = pstm.executeQuery();
            while (rs.next())
            {
                empId = rs.getString("EMP_ID");
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("UserDAOImpl", "authenticateUser", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "authenticateUser", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "authenticateUser", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "authenticateUser", e);
                }
            }
        }
        
        return empId;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#addNewUserSignUpRequest(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean registerUser(UserMaster user)
    {
        BaseResponseBean newUserReq = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.addNewUserSignUpQuery();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getEmpId());
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getFirstName());
            pstm.setString(4, user.getLastName());
            pstm.setString(5, user.getEmail());
            pstm.setString(6, user.getCompany());
            pstm.setString(7, PSOConstants.OPEN);
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                newUserReq.setErrorCode(PSOConstants.INFO_CODE);
                newUserReq.setErrorMsg(PSOConstants.NO_DATA_INSERTED);
                newUserReq.setLogRefId(logRefID);
            }
            else
            {
                newUserReq.setErrorCode(PSOConstants.SUCCESS_CODE);
                newUserReq.setErrorMsg(PSOConstants.DATA_INSERT_SUCCESSFULL);
                newUserReq.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UserDAOImpl", "addNewUserSignUpRequest", logRefID, sql,user, newUserReq.getErrorMsg());
        }
        catch (SQLException e)
        {
            newUserReq.setErrorCode(PSOConstants.ERROR_CODE);
            newUserReq.setErrorMsg(PSOConstants.BACKEND_ERROR);
            newUserReq.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("UserDAOImpl", "addNewUserSignUpRequest", logRefID, sql,user, e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "addNewUserSignUpRequest", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "addNewUserSignUpRequest", e);
                }
            }
        }

        return newUserReq;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#getUserPendingApprovalList()
     */
    @Override
    public ArrayList<UserMaster> getUserPendingApprovalList()
    {
        ArrayList<UserMaster> pendingUserList = new ArrayList<UserMaster>();
        String sql = OrderQueries.pendingUserList();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                pendingUserList.add(new UserMaster(rs.getString("EMP_ID"), rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("COMPANY"),rs.getString("STATUS")));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("UserDAOImpl", "getUserPendingApprovalList", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserPendingApprovalList", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserPendingApprovalList", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserPendingApprovalList", e);
                }
            }
        }

        return pendingUserList;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#rejectUser(java.lang.String)
     */
    @Override
    public BaseResponseBean rejectUser(RejectPendingUserRequest rejectUserreq)
    {
        BaseResponseBean rejectUserResponse = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.rejectUser();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, rejectUserreq.getRejectComments());
            pstm.setString(2, rejectUserreq.getEmpId());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                rejectUserResponse.setErrorCode(PSOConstants.INFO_CODE);
                rejectUserResponse.setErrorMsg(PSOConstants.NO_DATA_UPDATED);
                rejectUserResponse.setLogRefId(logRefID);
            }
            else
            {
                rejectUserResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                rejectUserResponse.setErrorMsg(PSOConstants.DATA_UPDATE_SUCCESSFULL);
                rejectUserResponse.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UserDAOImpl", "rejectUser", logRefID, sql,rejectUserreq, rejectUserResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            rejectUserResponse.setErrorCode(PSOConstants.ERROR_CODE);
            rejectUserResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            rejectUserResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("UserDAOImpl", "rejectUser", logRefID, sql,rejectUserreq, e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "rejectUser", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "rejectUser", e);
                }
            }
        }

        return rejectUserResponse;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#getUserDataByEmpId(java.lang.String)
     */
    @Override
    public UserMaster getPendingUserDataByEmpId(String employeeId)
    {
        UserMaster userData = new UserMaster();
        String sql = OrderQueries.getPendingUserDataByEmpId();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, employeeId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                userData.setCompany(rs.getString("COMPANY"));
                userData.setEmail(rs.getString("EMAIL"));
                userData.setEmpId(rs.getString("EMP_ID"));
                userData.setFirstName(rs.getString("FIRSTNAME"));
                userData.setLastName(rs.getString("LASTNAME"));
                userData.setStatus(rs.getString("STATUS"));
                userData.setUsername(rs.getString("USERNAME"));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("UserDAOImpl", "getPendingUserDataByEmpId", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getPendingUserDataByEmpId", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getPendingUserDataByEmpId", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getPendingUserDataByEmpId", e);
                }
            }
        }

        return userData;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#createUserAssignments(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean createUserAssignments(UserMaster userData)
    {
        BaseResponseBean createUserAssignmentResponse = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.doUserAssignmentsQuery();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, userData.getEmpId());
            pstm.setString(2, userData.getUsername());
            pstm.setString(3, "test12345");
            pstm.setString(4, userData.getFirstName());
            pstm.setString(5, userData.getLastName());
            pstm.setString(6, userData.getEmail());
            pstm.setString(7, userData.getCompany());
            pstm.setInt(8, userData.getGroupId());
            pstm.setString(9, "Admin");
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                createUserAssignmentResponse.setErrorCode(PSOConstants.INFO_CODE);
                createUserAssignmentResponse.setErrorMsg(PSOConstants.NO_DATA_INSERTED);
                createUserAssignmentResponse.setLogRefId(logRefID);
            }
            else
            {
                createUserAssignmentResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                createUserAssignmentResponse.setErrorMsg(PSOConstants.DATA_INSERT_SUCCESSFULL);
                createUserAssignmentResponse.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UserDAOImpl", "createUserAssignments", logRefID, sql,userData, createUserAssignmentResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            createUserAssignmentResponse.setErrorCode(PSOConstants.ERROR_CODE);
            createUserAssignmentResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            createUserAssignmentResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("UserDAOImpl", "createUserAssignments", logRefID, sql,userData, e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "createUserAssignments", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "createUserAssignments", e);
                }
            }
        }

        return createUserAssignmentResponse;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#updateUserAssignments(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean updateUserAssignments(UserMaster userData)
    {
        BaseResponseBean updateUserAssignmentResponse = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateUserAssignmentsQuery();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, userData.getFirstName());
            pstm.setString(2, userData.getLastName());
            pstm.setString(3, userData.getEmail());
            pstm.setString(4, userData.getCompany());
            pstm.setInt(5, userData.getGroupId());
            pstm.setString(6, "Admin");
            pstm.setString(7, userData.getEmpId());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                updateUserAssignmentResponse.setErrorCode(PSOConstants.INFO_CODE);
                updateUserAssignmentResponse.setErrorMsg(PSOConstants.NO_DATA_INSERTED);
                updateUserAssignmentResponse.setLogRefId(logRefID);
            }
            else
            {
                updateUserAssignmentResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateUserAssignmentResponse.setErrorMsg(PSOConstants.DATA_INSERT_SUCCESSFULL);
                updateUserAssignmentResponse.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UserDAOImpl", "updateUserAssignments", logRefID, sql,userData, updateUserAssignmentResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateUserAssignmentResponse.setErrorCode(PSOConstants.ERROR_CODE);
            updateUserAssignmentResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateUserAssignmentResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("UserDAOImpl", "updateUserAssignments", logRefID, sql,userData, e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "updateUserAssignments", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "updateUserAssignments", e);
                }
            }
        }

        return updateUserAssignmentResponse;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#getUserList()
     */
    @Override
    public ArrayList<UserMaster> getUserList(UserSearchRequestBean userSearchReq)
    {
        ArrayList<UserMaster> userList = new ArrayList<UserMaster>();
        StringBuilder sql = new StringBuilder(OrderQueries.getUserListQuery());
        
        List<String> colList = new ArrayList<String>();
        if(StringUtils.isNotEmpty(userSearchReq.getCompany())){
            colList.add("A.COMPANY");
        }
        if(StringUtils.isNotEmpty(userSearchReq.getEmpId())){
            colList.add("A.EMP_ID");
        }
        if(userSearchReq.getGroupId()!=0){
            colList.add("A.GROUP_ID");
        }
        if(userSearchReq.getRoleId()!=0){
            colList.add("C.ROLE_ID");
        }
        
        StringBuilder whereClause = new StringBuilder(" ");
        for(String s : colList){
            whereClause.append(" AND ");
            whereClause.append(s);
            whereClause.append(" = ?");
        }
        sql.append(whereClause);
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        UserMaster user = null;
        
        try
        {
            pstm = con.prepareStatement(sql.toString());
            int paramPos = 1;
            for(String s : colList){
                if(s.equals("A.COMPANY"))
                        pstm.setString(paramPos, userSearchReq.getCompany());
                if(s.equals("A.EMP_ID"))
                    pstm.setString(paramPos, userSearchReq.getEmpId());
                if(s.equals("A.GROUP_ID"))
                    pstm.setInt(paramPos, userSearchReq.getGroupId());
                if(s.equals("C.ROLE_ID"))
                    pstm.setInt(paramPos, userSearchReq.getRoleId());
                
                paramPos++;
            }
            
            rs = pstm.executeQuery();
            while (rs.next())
            {
                user = new UserMaster();
                user.setId(rs.getInt("USER_ID"));
                user.setEmpId(rs.getString("EMP_ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setLastName(rs.getString("LASTNAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setCompany(rs.getString("COMPANY"));
                user.setGroupId(rs.getInt("GROUP_ID"));
                user.setUserGroup(rs.getString("GROUP_NAME"));
                user.setUserRole(rs.getString("ROLE_NAME"));
                userList.add(user);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("UserDAOImpl", "getUserList", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserList", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserList", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserList", e);
                }
            }
        }

        return userList;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#getUserDetailsByEmpId(java.lang.String)
     */
    @Override
    public UserMaster getUserDetailsByEmpId(String employeeId)
    {
        UserMaster user = new UserMaster();
        String sql = OrderQueries.getUserDataByEmpId();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, employeeId);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                user = new UserMaster();
                user.setId(rs.getInt("USER_ID"));
                user.setEmpId(rs.getString("EMP_ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setLastName(rs.getString("LASTNAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setCompany(rs.getString("COMPANY"));
                user.setGroupId(rs.getInt("GROUP_ID"));
                user.setUserGroup(rs.getString("GROUP_NAME"));
                user.setUserRole(rs.getString("ROLE_NAME"));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("UserDAOImpl", "getUserDetailsByEmpId", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserDetailsByEmpId", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserDetailsByEmpId", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "getUserDetailsByEmpId", e);
                }
            }
        }
        return user;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#deletePendingUserRequest(java.lang.String)
     */
    @Override
    public BaseResponseBean deletePendingUserRequest(String employeeId)
    {
        BaseResponseBean deletePendingUserResponse = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.getDeletePendingUserReqQuery();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, employeeId);
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                deletePendingUserResponse.setErrorCode(PSOConstants.INFO_CODE);
                deletePendingUserResponse.setErrorMsg(PSOConstants.NO_DATA_UPDATED);
                deletePendingUserResponse.setLogRefId(logRefID);
            }
            else
            {
                deletePendingUserResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                deletePendingUserResponse.setErrorMsg(PSOConstants.DATA_UPDATE_SUCCESSFULL);
                deletePendingUserResponse.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UserDAOImpl", "deletePendingUserRequest", logRefID, sql,employeeId, deletePendingUserResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            deletePendingUserResponse.setErrorCode(PSOConstants.ERROR_CODE);
            deletePendingUserResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            deletePendingUserResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("UserDAOImpl", "deletePendingUserRequest", logRefID, sql,employeeId, e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "deletePendingUserRequest", e);
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
                    PSOLoggerSrv.printERROR("UserDAOImpl", "deletePendingUserRequest", e);
                }
            }
        }

        return deletePendingUserResponse;
    }
    
    

}
