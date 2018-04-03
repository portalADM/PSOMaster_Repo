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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.Authority;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.LoginRequestBean;
import com.zig.pso.rest.bean.RejectPendingUserRequest;
import com.zig.pso.rest.bean.SetupUserPasswordRequestBean;
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
    static final Logger logger = Logger.getLogger(UserDAOImpl.class);
    
    public static final String CLASS_NAME = "UserDAOImpl";
    
    public UserDAOImpl()
    {
        super();
    }

    private Connection getPortalDbConnction()
    {
        return DBConnection.getPortalDBConnection();
    }

    public UserMaster getUserByUsernameForAuthentication(LoginRequestBean loginRequest)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserByUsernameForAuthentication", StringUtils.EMPTY);
        UserMaster user = new UserMaster();
        String sql = OrderQueries.getUserByUsernameForAuthentication();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, loginRequest.getUsername());
            rs = pstm.executeQuery();
            while (rs.next())
            {
                user.setEmpId(rs.getString("EMP_ID"));
                user.setPassword(rs.getString("PASSWORD"));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "authenticateUser", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "authenticateUser", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "authenticateUser", e);
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
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "authenticateUser", e);
                }
            }
        }

        return user;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#addNewUserSignUpRequest(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean registerUser(UserMaster user)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "registerUser", StringUtils.EMPTY);
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

            PSOLoggerSrv.printSQL_DEBUG(logger,CLASS_NAME, "addNewUserSignUpRequest", logRefID, sql, user, newUserReq.getErrorMsg());
        }
        catch (SQLException e)
        {
            newUserReq.setErrorCode(PSOConstants.ERROR_CODE);
            newUserReq.setErrorMsg(PSOConstants.BACKEND_ERROR);
            newUserReq.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "addNewUserSignUpRequest", logRefID, sql, user, e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "addNewUserSignUpRequest", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "addNewUserSignUpRequest", e);
                }
            }
        }

        return newUserReq;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#getUserPendingApprovalList()
     */
    @Override
    public List<UserMaster> getUserPendingApprovalList()
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserPendingApprovalList", StringUtils.EMPTY);
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
                pendingUserList.add(new UserMaster(rs.getString("EMP_ID"), rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs
                        .getString("COMPANY"), rs.getString("STATUS")));
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserPendingApprovalList", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserPendingApprovalList", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserPendingApprovalList", e);
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
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserPendingApprovalList", e);
                }
            }
        }

        return pendingUserList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#rejectUser(java.lang.String)
     */
    @Override
    public BaseResponseBean rejectUser(RejectPendingUserRequest rejectUserreq)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "rejectUser", StringUtils.EMPTY);
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

            PSOLoggerSrv.printSQL_DEBUG(logger,CLASS_NAME, "rejectUser", logRefID, sql, rejectUserreq, rejectUserResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            rejectUserResponse.setErrorCode(PSOConstants.ERROR_CODE);
            rejectUserResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            rejectUserResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "rejectUser", logRefID, sql, rejectUserreq, e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "rejectUser", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "rejectUser", e);
                }
            }
        }

        return rejectUserResponse;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#getUserDataByEmpId(java.lang.String)
     */
    @Override
    public UserMaster getPendingUserDataByEmpId(String employeeId)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getPendingUserDataByEmpId", StringUtils.EMPTY);
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
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPendingUserDataByEmpId", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPendingUserDataByEmpId", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPendingUserDataByEmpId", e);
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
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getPendingUserDataByEmpId", e);
                }
            }
        }

        return userData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#createUserAssignments(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean createUserAssignments(UserMaster userData)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "createUserAssignments", StringUtils.EMPTY);
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
            pstm.setString(3, userData.getTempPassword());
            pstm.setString(4, userData.getFirstName());
            pstm.setString(5, userData.getLastName());
            pstm.setString(6, userData.getEmail());
            pstm.setString(7, userData.getCompany());
            pstm.setInt(8, userData.getGroupId());
            pstm.setString(9, userData.getUsername());
            pstm.setString(10, PSOConstants.USER_IN_PROGRESS); // I : User setup In Progress, A : Active
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

            PSOLoggerSrv.printSQL_DEBUG(logger,CLASS_NAME, "createUserAssignments", logRefID, sql, userData, createUserAssignmentResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            createUserAssignmentResponse.setErrorCode(PSOConstants.ERROR_CODE);
            createUserAssignmentResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            createUserAssignmentResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "createUserAssignments", logRefID, sql, userData, e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "createUserAssignments", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "createUserAssignments", e);
                }
            }
        }

        return createUserAssignmentResponse;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#updateUserAssignments(com.zig.pso.rest.bean.UserMaster)
     */
    @Override
    public BaseResponseBean updateUserAssignments(UserMaster userData)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "updateUserAssignments", StringUtils.EMPTY);
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
            pstm.setString(6, userData.getUsername());
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

            PSOLoggerSrv.printSQL_DEBUG(logger,CLASS_NAME, "updateUserAssignments", logRefID, sql, userData, updateUserAssignmentResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateUserAssignmentResponse.setErrorCode(PSOConstants.ERROR_CODE);
            updateUserAssignmentResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateUserAssignmentResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "updateUserAssignments", logRefID, sql, userData, e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "updateUserAssignments", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "updateUserAssignments", e);
                }
            }
        }

        return updateUserAssignmentResponse;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#getUserList()
     */
    @Override
    public List<UserMaster> getUserList(UserSearchRequestBean userSearchReq)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserList", StringUtils.EMPTY);
        ArrayList<UserMaster> userList = new ArrayList<UserMaster>();
        StringBuilder sql = new StringBuilder(OrderQueries.getUserListQuery());

        List<String> colList = new ArrayList<String>();
        if (StringUtils.isNotEmpty(userSearchReq.getCompany()))
        {
            colList.add("A.COMPANY");
        }
        if (StringUtils.isNotEmpty(userSearchReq.getEmpId()))
        {
            colList.add("A.EMP_ID");
        }
        if (userSearchReq.getGroupId() != 0)
        {
            colList.add("A.GROUP_ID");
        }
        if (userSearchReq.getRoleId() != 0)
        {
            colList.add("C.ROLE_ID");
        }

        StringBuilder whereClause = new StringBuilder(" ");
        for (String s : colList)
        {
            whereClause.append(" AND ");
            whereClause.append(s);
            whereClause.append(" = ?");
        }
        sql.append(whereClause).append("ORDER BY A.SYS_CREATION_DATE DESC");

        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();

        UserMaster user = null;

        try
        {
            pstm = con.prepareStatement(sql.toString());
            int paramPos = 1;
            for (String s : colList)
            {
                if (s.equals("A.COMPANY"))
                    pstm.setString(paramPos, userSearchReq.getCompany());
                if (s.equals("A.EMP_ID"))
                    pstm.setString(paramPos, userSearchReq.getEmpId());
                if (s.equals("A.GROUP_ID"))
                    pstm.setInt(paramPos, userSearchReq.getGroupId());
                if (s.equals("C.ROLE_ID"))
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
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserList", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserList", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserList", e);
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
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserList", e);
                }
            }
        }

        return userList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#getUserDetailsByEmpId(java.lang.String)
     */
    @Override
    public UserMaster getUserDetailsByEmpId(String employeeId)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserDetailsByEmpId", StringUtils.EMPTY);
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
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
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
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
                }
            }
        }
        return user;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#deletePendingUserRequest(java.lang.String)
     */
    @Override
    public BaseResponseBean deletePendingUserRequest(String employeeId)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "deletePendingUserRequest", StringUtils.EMPTY);
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

            PSOLoggerSrv.printSQL_DEBUG(logger,CLASS_NAME, "deletePendingUserRequest", logRefID, sql, employeeId, deletePendingUserResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            deletePendingUserResponse.setErrorCode(PSOConstants.ERROR_CODE);
            deletePendingUserResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            deletePendingUserResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "deletePendingUserRequest", logRefID, sql, employeeId, e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "deletePendingUserRequest", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "deletePendingUserRequest", e);
                }
            }
        }

        return deletePendingUserResponse;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UserDAO#setupPasswordForUser(java.lang.String, java.lang.String)
     */
    @Override
    public BaseResponseBean setupPasswordForUser(SetupUserPasswordRequestBean userPassword)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "setupPasswordForUser", StringUtils.EMPTY);
        BaseResponseBean setupUserPasswordResponse = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();

        String sql = OrderQueries.getSetupPasswordQuery();

        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();

        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, userPassword.getPassword());
            pstm.setString(2, PSOConstants.USER_ACTIVE);
            pstm.setString(3, userPassword.getEmpId());
            pstm.setString(4, userPassword.getEmailId());
            pstm.setString(5, userPassword.getTempPassword());
            pstm.setString(6, userPassword.getUsername());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                setupUserPasswordResponse.setErrorCode(PSOConstants.INFO_CODE);
                setupUserPasswordResponse.setErrorMsg(PSOConstants.NO_DATA_UPDATED);
                setupUserPasswordResponse.setLogRefId(logRefID);
            }
            else
            {
                setupUserPasswordResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                setupUserPasswordResponse.setErrorMsg(PSOConstants.USER_PW_SETUP_SUCCESSFULL);
                setupUserPasswordResponse.setLogRefId(logRefID);
            }

            PSOLoggerSrv.printSQL_DEBUG(logger,CLASS_NAME, "setupPasswordForUser", logRefID, sql, "Emp ID : " + userPassword.getEmpId() + ", Email ID : " + userPassword.getEmailId(),
                    setupUserPasswordResponse.getErrorMsg());
        }
        catch (SQLException e)
        {
            setupUserPasswordResponse.setErrorCode(PSOConstants.ERROR_CODE);
            setupUserPasswordResponse.setErrorMsg(PSOConstants.BACKEND_ERROR);
            setupUserPasswordResponse.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "setupPasswordForUser", logRefID, sql, "Emp ID : " + userPassword.getEmpId() + ", Email ID : " + userPassword.getEmailId(), e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "setupPasswordForUser", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "setupPasswordForUser", e);
                }
            }
        }

        return setupUserPasswordResponse;
    }

    public BaseResponseBean checkUsername(String userName)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "checkUsername", StringUtils.EMPTY);
        BaseResponseBean user = new BaseResponseBean();
        String sql = OrderQueries.getCheckUsername();
        ResultSet rs;
        int count;
        rs = null;
        count = 0;

        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, userName);
            rs = pstm.executeQuery();
            while (rs.next())
                count = rs.getInt("count");

            if (count > 0)
            {
                user.setErrorCode(PSOConstants.ERROR_CODE);
                user.setErrorMsg(PSOConstants.USERNAME_ALREADY_PRESENT);
            }
            else
            {
                user.setErrorCode(PSOConstants.SUCCESS_CODE);
                user.setErrorMsg(PSOConstants.VALID_USERNAME);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
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
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
                }
            }
        }
        return user;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#changeUserPassword(com.zig.pso.rest.bean.SetupUserPasswordRequestBean)
     */
    @Override
    public BaseResponseBean changeUserPassword(SetupUserPasswordRequestBean setupuserpasswordrequestbean)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "changeUserPassword", StringUtils.EMPTY);
        BaseResponseBean changeUserPasswordResponse = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        String sql;
        sql = OrderQueries.getChangePasswordQuery();
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, setupuserpasswordrequestbean.getPassword());
            pstm.setString(2, setupuserpasswordrequestbean.getEmpId());
            pstm.setString(3, setupuserpasswordrequestbean.getCurrentPassword());
            int i = pstm.executeUpdate();
            if(i < 1)
            {
                changeUserPasswordResponse.setErrorCode(PSOConstants.INFO_CODE);
                changeUserPasswordResponse.setErrorMsg(PSOConstants.NO_DATA_UPDATED);
                changeUserPasswordResponse.setLogRefId(logRefID);
            } else
            {
                changeUserPasswordResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                changeUserPasswordResponse.setErrorMsg(PSOConstants.USER_PW_CHANGE_SUCCESSFULL);
                changeUserPasswordResponse.setLogRefId(logRefID);
            }
            PSOLoggerSrv.printSQL_DEBUG(logger,CLASS_NAME, "changeUserPassword", logRefID, sql, (new StringBuilder()).append("Emp ID : ").append(setupuserpasswordrequestbean.getEmpId()).append(", Email ID : ").append(setupuserpasswordrequestbean.getEmailId()).toString(), changeUserPasswordResponse.getErrorMsg());

        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "changeUserPassword", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "changeUserPassword", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "changeUserPassword", e);
                }
            }
        }
        
        return changeUserPasswordResponse;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#getUserCurrentPassword(java.lang.String)
     */
    @Override
    public String getUserCurrentPassword(String empId)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserCurrentPassword", StringUtils.EMPTY);
        String sql;
        ResultSet rs;
        String currentPassword = StringUtils.EMPTY;
        sql = OrderQueries.getCurrentPasswordQuery();
        rs = null;
        
        PreparedStatement pstm = null;
        Connection con = this.getPortalDbConnction();
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, empId);
            rs = pstm.executeQuery();
            while (rs.next())
                currentPassword = rs.getString("PASSWORD");

        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserCurrentPassword", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserCurrentPassword", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserCurrentPassword", e);
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
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserCurrentPassword", e);
                }
            }
        }

        return currentPassword;
    }

    /* (non-Javadoc)
     * @see com.zig.pso.dao.UserDAO#getUserByUserName(java.lang.String)
     */
    @Override
    public UserMaster getUserByUserName(String userName)
    {
        PSOLoggerSrv.printDEBUG(logger, CLASS_NAME, "getUserByUserName", StringUtils.EMPTY);
        UserMaster user = null;
        String sql = OrderQueries.getUserDataByUserName();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection con = this.getPortalDbConnction();
        Set<Authority> authorities = new HashSet<Authority>();
        try
        {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, userName);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                user = new UserMaster();
                user.setId(rs.getInt("USER_ID"));
                user.setEmpId(rs.getString("EMP_ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setLastName(rs.getString("LASTNAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setCompany(rs.getString("COMPANY"));
                user.setGroupId(rs.getInt("GROUP_ID"));
                user.setUserGroup(rs.getString("GROUP_NAME"));
                user.setUserRole(rs.getString("ROLE_NAME"));
                authorities.add(new Authority(0, rs.getString("ROLE_NAME")));
                user.setAuthorities(authorities);
            }
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
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
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, "getUserDetailsByEmpId", e);
                }
            }
        }
        return user;
    }

}
