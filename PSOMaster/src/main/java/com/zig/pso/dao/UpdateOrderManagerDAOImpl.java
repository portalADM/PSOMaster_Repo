/************************************************************************************************************
 * Class Name : UpdateOrderManagerDAOImpl.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;

import org.springframework.stereotype.Repository;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;
import com.zig.pso.utility.DBConnection;

/**
 * 
 */
@Repository
public class UpdateOrderManagerDAOImpl implements UpdateOrderManagerDAO
{
    private Connection portalDBConnection = null;

    private Connection ensDBConnection = null;

    /**
     * @param portalDBConnection
     * @param ensDBConnection
     */
    public UpdateOrderManagerDAOImpl()
    {
        portalDBConnection = DBConnection.getPortalDBConnection();
        ensDBConnection = DBConnection.getENSDBConnection();
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderStatus(com.zig.pso.rest.bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateOrderStatus(UpdateOrderRequestBean updateOrderRequest)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        updateOrderRes.setErrorCode(0);
        updateOrderRes.setErrorMsg("Successfully updated status- inside DAO");
        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderSim(com.zig.pso.rest.bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateOrderSim(UpdateOrderRequestBean updateOrderRequest)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        updateOrderRes.setErrorCode(0);
        updateOrderRes.setErrorMsg("Successfully updated sim -inside DAO");
        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderImei(com.zig.pso.rest.bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateOrderImei(UpdateOrderRequestBean updateOrderRequest)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        updateOrderRes.setErrorCode(0);
        updateOrderRes.setErrorMsg("Successfully updated imei -inside DAO");
        return updateOrderRes;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderRetryCount(com.zig.pso.rest.bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateOrderRetryCount(UpdateOrderRequestBean updateOrderRequest)
    {
        BaseResponseBean updateOrderRes = new BaseResponseBean();
        updateOrderRes.setErrorCode(0);
        updateOrderRes.setErrorMsg("Successfully updated retry -inside DAO");
        return updateOrderRes;
    }

}
