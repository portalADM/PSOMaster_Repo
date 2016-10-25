/************************************************************************************************************
 * Class Name : UpdateOrderManagerDAOImpl.java 
 * Description: 
 * Author : Ankita Mishra 
 * Date : Aug 1, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.OrderUpdateInputData;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;
import com.zig.pso.utility.CommonUtility;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

/**
 * 
 */
@Repository
public class UpdateOrderManagerDAOImpl implements UpdateOrderManagerDAO
{
    private Connection portalDBConnection = null;

    /**
     * @param portalDBConnection
     */
    public UpdateOrderManagerDAOImpl()
    {
        portalDBConnection = DBConnection.getPortalDBConnection();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderStatus(com.zig.pso.rest .bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateOrderStatus(UpdateOrderRequestBean updateOrderRequest)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateOrderStatus();
        
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, updateOrderRequest.getNewValue());
            pstm.setString(2, updateOrderRequest.getOrderId());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                updateOrderRes.setErrorCode(PSOConstants.INFO_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.NO_ORDER_UPDATED);
                updateOrderRes.setLogRefId(logRefID);
                
            }
            else
            {
                updateOrderRes = updateOrderTrack(updateOrderRequest, "ZIG_AUTO_MASTER",logRefID);
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.ORDER_UPDATE_SUCCESSFULL);
                updateOrderRes.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateOrderStatus", logRefID, sql,updateOrderRequest, updateOrderRes.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
            updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateOrderRes.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateOrderStatus", logRefID, sql,updateOrderRequest, e);
        }

        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderSim(com.zig.pso.rest .bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateOrderSim(UpdateOrderRequestBean updateOrderRequest)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateOrderSim();
        
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, updateOrderRequest.getNewValue());
            pstm.setString(2, updateOrderRequest.getOrderId());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                updateOrderRes.setErrorCode(PSOConstants.INFO_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.NO_ORDER_UPDATED);
                updateOrderRes.setLogRefId(logRefID);
            }
            else
            {
                updateOrderRes = updateOrderTrack(updateOrderRequest, "ZIG_ORDER_SHIPMENT_INFO",logRefID);
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.ORDER_UPDATE_SUCCESSFULL);
                updateOrderRes.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateOrderSim", logRefID, sql,updateOrderRequest, updateOrderRes.getErrorMsg());
            
        }
        catch (SQLException e)
        {
            updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
            updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateOrderRes.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateOrderSim", logRefID, sql,updateOrderRequest, e);
        }
        
        return updateOrderRes;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderImei(com.zig.pso.rest .bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateOrderImei(UpdateOrderRequestBean updateOrderRequest)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateOrderIMEI();
        
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, updateOrderRequest.getNewValue());
            pstm.setString(2, updateOrderRequest.getOrderId());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                updateOrderRes.setErrorCode(PSOConstants.INFO_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.NO_ORDER_UPDATED);
                updateOrderRes.setLogRefId(logRefID);
            }
            else
            {
                updateOrderRes = updateOrderTrack(updateOrderRequest, "ZIG_ORDER_SHIPMENT_INFO",logRefID);
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.ORDER_UPDATE_SUCCESSFULL);
                updateOrderRes.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateOrderImei", logRefID,sql,updateOrderRequest, updateOrderRes.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
            updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateOrderRes.setLogRefId(logRefID);
            
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateOrderImei", logRefID, sql,updateOrderRequest, e);
        }
        
        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderRetryCount(com.zig.pso .rest.bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateOrderRetryCount(UpdateOrderRequestBean updateOrderRequest)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateOrderRetryCount();
        
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, updateOrderRequest.getNewValue());
            pstm.setString(2, updateOrderRequest.getOrderId());
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                updateOrderRes.setErrorCode(PSOConstants.INFO_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.NO_ORDER_UPDATED);
                updateOrderRes.setLogRefId(logRefID);
            }
            else
            {
                updateOrderRes = updateOrderTrack(updateOrderRequest, "ZIG_AUTO_MASTER",logRefID);
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.ORDER_UPDATE_SUCCESSFULL);
                updateOrderRes.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateOrderRetryCount", logRefID,sql,updateOrderRequest, updateOrderRes.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
            updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateOrderRes.setLogRefId(logRefID);
            
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateOrderRetryCount", logRefID, sql,updateOrderRequest, e);
        }
        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderTrack(com.zig.pso.rest.bean.UpdateOrderRequestBean)
     */
    public BaseResponseBean updateOrderTrack(UpdateOrderRequestBean updateOrderRequest, String tablename, String logRefId)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String sql = OrderQueries.updateOrderTrack();
        
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            pstm.setString(1, updateOrderRequest.getOrderId());
            pstm.setString(2, updateOrderRequest.getType());
            pstm.setString(3, updateOrderRequest.getNewValue());
            pstm.setString(4, logRefId);
            pstm.setString(5, "admin");
            pstm.setString(6, tablename);
            int i = pstm.executeUpdate();
            if (i < 1)
            {
                updateOrderRes.setErrorCode(PSOConstants.INFO_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.NO_ORDER_INSERTED);
                updateOrderRes.setLogRefId(logRefId);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.ORDER_INSERT_SUCCESSFULL);
                updateOrderRes.setLogRefId(logRefId);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateOrderTrack", logRefId,sql,updateOrderRequest, updateOrderRes.getErrorMsg());
        }
        catch (SQLException e)
        {
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateOrderTrack", logRefId, sql,updateOrderRequest, e);
        }
        
        
        return updateOrderRes;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateBulkOrderStatus(java.util.ArrayList)
     */
    @Override
    public BaseResponseBean updateBulkOrderStatus(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateOrderStatus();
        
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);

            for (OrderUpdateInputData order : orderUpdateData)
            {
                pstm.setString(1, order.getStatus().trim());
                pstm.setString(2, order.getOrderId());
                pstm.addBatch();
            }

            int[] recordsUpdated = pstm.executeBatch();
            if (recordsUpdated.length < 0)
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
                updateOrderRes.setLogRefId(logRefID);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.BULK_UPDATE_SUCCESS);
                updateOrderRes.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateBulkOrderStatus", logRefID,sql,orderUpdateData, updateOrderRes.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
            updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateOrderRes.setLogRefId(logRefID);
            
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateBulkOrderStatus", logRefID, sql,orderUpdateData, e);
        }

        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateBulkOrderSim(java.util.ArrayList)
     */
    @Override
    public BaseResponseBean updateBulkOrderSim(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateOrderSim();
        
        try
        {
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);

            for (OrderUpdateInputData order : orderUpdateData)
            {
                pstm.setString(1, order.getSim().trim());
                pstm.setString(2, order.getOrderId());
                pstm.addBatch();
            }

            int[] recordsUpdated = pstm.executeBatch();
            if (recordsUpdated.length < 0)
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
                updateOrderRes.setLogRefId(logRefID);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.BULK_UPDATE_SUCCESS);
                updateOrderRes.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateBulkOrderSim", logRefID,sql,orderUpdateData, updateOrderRes.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
            updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateOrderRes.setLogRefId(logRefID);
            
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateBulkOrderSim", logRefID, sql,orderUpdateData, e);
        }

        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateBulkOrderImei(java.util.ArrayList)
     */
    @Override
    public BaseResponseBean updateBulkOrderImei(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateOrderIMEI();
        
        try
        {
            
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);

            for (OrderUpdateInputData order : orderUpdateData)
            {
                pstm.setString(1, order.getImei().trim());
                pstm.setString(2, order.getOrderId());
                pstm.addBatch();
            }

            int[] recordsUpdated = pstm.executeBatch();
            if (recordsUpdated.length < 0)
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
                updateOrderRes.setLogRefId(logRefID);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.BULK_UPDATE_SUCCESS);
                updateOrderRes.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateBulkOrderImei", logRefID,sql,orderUpdateData, updateOrderRes.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
            updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateOrderRes.setLogRefId(logRefID);
            
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateBulkOrderImei", logRefID, sql,orderUpdateData, e);
        }

        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateBulkOrderRetryCount(java.util.ArrayList)
     */
    @Override
    public BaseResponseBean updateBulkOrderRetryCount(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        
        String sql = OrderQueries.updateOrderRetryCount();
        
        try
        {
            
            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);

            for (OrderUpdateInputData order : orderUpdateData)
            {
                pstm.setString(1, order.getRetryCount().trim());
                pstm.setString(2, order.getOrderId());
                pstm.addBatch();
            }

            int[] recordsUpdated = pstm.executeBatch();
            if (recordsUpdated.length < 0)
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
                updateOrderRes.setLogRefId(logRefID);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.BULK_UPDATE_SUCCESS);
                updateOrderRes.setLogRefId(logRefID);
            }
            
            PSOLoggerSrv.printSQL_DEBUG("UpdateOrderManagerDAOImpl", "updateBulkOrderRetryCount", logRefID,sql,orderUpdateData, updateOrderRes.getErrorMsg());
        }
        catch (SQLException e)
        {
            updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
            updateOrderRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            updateOrderRes.setLogRefId(logRefID);
            
            PSOLoggerSrv.printERROR("UpdateOrderManagerDAOImpl", "updateBulkOrderRetryCount", logRefID, sql,orderUpdateData, e);
        }

        return updateOrderRes;
    }

}
