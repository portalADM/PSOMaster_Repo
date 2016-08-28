/************************************************************************************************************
 * Class Name : UpdateOrderManagerDAOImpl.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

/**
 * 
 */
@Repository
public class UpdateOrderManagerDAOImpl implements UpdateOrderManagerDAO {
	private Connection portalDBConnection = null;

	// private Connection ensDBConnection = null;

	/**
	 * @param portalDBConnection
	 * @param ensDBConnection
	 */
	public UpdateOrderManagerDAOImpl() {
		portalDBConnection = DBConnection.getPortalDBConnection();
		// ensDBConnection = DBConnection.getENSDBConnection();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderStatus(com.zig.pso.rest
	 * .bean.UpdateOrderRequestBean)
	 */
	@Override
	public BaseResponseBean updateOrderStatus(
			UpdateOrderRequestBean updateOrderRequest) {
		BaseResponseBean updateOrderRes = new BaseResponseBean();
		try {
			String sql = OrderQueries.updateOrderStatus();
			PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
			pstm.setString(1, updateOrderRequest.getNewValue());
			pstm.setString(2, updateOrderRequest.getOrderId());
			int i = pstm.executeUpdate();
			if (i < 1) {
				updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
				updateOrderRes.setErrorMsg(PSOConstants.Unsuccessful_while_updating_Info);
			} else {
				updateOrderRes = updateOrderTrack(updateOrderRequest,"ZIG_AUTO_MASTER");
				updateOrderRes.setErrorCode(PSOConstants.SUCCESS_CODE);
				updateOrderRes.setErrorMsg(PSOConstants.Successfully_updated_status);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
			updateOrderRes.setErrorMsg(PSOConstants.Unsuccessful_while_updating_Info);
		}

		return updateOrderRes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderSim(com.zig.pso.rest
	 * .bean.UpdateOrderRequestBean)
	 */
	@Override
	public BaseResponseBean updateOrderSim(
			UpdateOrderRequestBean updateOrderRequest) {
		try {
			String sql = OrderQueries.updateOrderSim();
			PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
			pstm.setString(1, updateOrderRequest.getNewValue());
			pstm.setString(2, updateOrderRequest.getOrderId());
			int i = pstm.executeUpdate();
			if (i < 1) {
				// message to be shown if not updated
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseResponseBean updateOrderRes = new BaseResponseBean();
		updateOrderRes = updateOrderTrack(updateOrderRequest,"ZIG_ORDER_SHIPMENT_INFO");
		updateOrderRes.setErrorCode(0);
		updateOrderRes.setErrorMsg("Successfully updated sim -inside DAO");
		return updateOrderRes;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderImei(com.zig.pso.rest
	 * .bean.UpdateOrderRequestBean)
	 */
	@Override
	public BaseResponseBean updateOrderImei(
			UpdateOrderRequestBean updateOrderRequest) {
		try {
			String sql = OrderQueries.updateOrderIMEI();
			PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
			pstm.setString(1, updateOrderRequest.getNewValue());
			pstm.setString(2, updateOrderRequest.getOrderId());
			int i = pstm.executeUpdate();
			if (i < 1) {
				// message to be shown if not updated
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseResponseBean updateOrderRes = new BaseResponseBean();
		updateOrderRes = updateOrderTrack(updateOrderRequest,"ZIG_ORDER_SHIPMENT_INFO");
		updateOrderRes.setErrorCode(0);
		updateOrderRes.setErrorMsg("Successfully updated imei -inside DAO");
		return updateOrderRes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderRetryCount(com.zig.pso
	 * .rest.bean.UpdateOrderRequestBean)
	 */
	@Override
	public BaseResponseBean updateOrderRetryCount(
			UpdateOrderRequestBean updateOrderRequest) {
		try {
			String sql = OrderQueries.updateOrderRetryCount();
			PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
			pstm.setString(1, updateOrderRequest.getNewValue());
			pstm.setString(2, updateOrderRequest.getOrderId());
			int i = pstm.executeUpdate();
			if (i < 1) {
				// message to be shown if not updated
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseResponseBean updateOrderRes = new BaseResponseBean();
		updateOrderRes = updateOrderTrack(updateOrderRequest,"ZIG_AUTO_MASTER");
		updateOrderRes.setErrorCode(0);
		updateOrderRes.setErrorMsg("Successfully updated retry -inside DAO");
		return updateOrderRes;
	}

	/* (non-Javadoc)
	 * @see com.zig.pso.dao.UpdateOrderManagerDAO#updateOrderTrack(com.zig.pso.rest.bean.UpdateOrderRequestBean)
	 */
	public BaseResponseBean updateOrderTrack(
			UpdateOrderRequestBean updateOrderRequest,String tablename) {
		try {
			String sql = OrderQueries.updateOrderTrack();
			PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
			pstm.setString(1, updateOrderRequest.getOrderId());
			pstm.setString(2, updateOrderRequest.getType());
			pstm.setString(3, updateOrderRequest.getNewValue());
			pstm.setString(4, "123456789");
			pstm.setString(5, "kalir");
			pstm.setString(6, tablename);
			int i = pstm.executeUpdate();
			if (i < 1) {
				// message to be shown if not updated
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseResponseBean updateOrderRes = new BaseResponseBean();
		updateOrderRes.setErrorCode(0);
		updateOrderRes.setErrorMsg("Successfully updated order track -inside DAO");
		return updateOrderRes;

	}
		
	

}
