/************************************************************************************************************
 * Class Name :  DashboardDAOImpl.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Aug 2, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.StuckOrdersCount;
import com.zig.pso.utility.CommonUtility;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

/**
 * 
 */
@Repository
public class DashboardDAOImpl implements DashboardDAO {

	/**
	 * 
	 */
	private static Connection portalDBConnection = null;

	public DashboardDAOImpl() {
		portalDBConnection=DBConnection.getPortalDBConnection();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zig.pso.dao.DashboardDAO#getStuckOrderList()
	 */
	@Override
	public ArrayList<StuckOrdersCount> getStuckOrderList() {
		
		ArrayList<StuckOrdersCount> stuckOrderList=new ArrayList<StuckOrdersCount>();
		String sql=OrderQueries.getstuckOrdersCount();
		
		try {
			PreparedStatement pstm=portalDBConnection.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			StuckOrdersCount stuckOrderCount= null;
			while(rs.next()){
				stuckOrderCount = new StuckOrdersCount();
				stuckOrderCount.setCount(rs.getInt("count"));
				stuckOrderCount.setOrderStatus(rs.getString("status_code"));
				stuckOrderList.add(stuckOrderCount);
			}
			
		} catch (Exception e) {
			
			String logRefID = CommonUtility.getLogRefID();
			
			PSOLoggerSrv.printERROR(e,logRefID);
			
			 e.printStackTrace();
		}
		
		return stuckOrderList;
	}

	/* (non-Javadoc)
	 * @see com.zig.pso.dao.DashboardDAO#getStuckOrderList1()
	 */
	@Override
	public ArrayList<String> getStuckOrderList1(String status) {
		// TODO Auto-generated method stub
		ArrayList<String> stuckOrderList=new ArrayList<String>();
		String sql=OrderQueries.getstuckOrdersbyStatus();
		
		try {
			PreparedStatement pstm=portalDBConnection.prepareStatement(sql);
			pstm.setString(1, status);
			ResultSet rs=pstm.executeQuery();
			while(rs.next())
			{
				stuckOrderList.add(rs.getString("order_id"));
			}
			
		} catch (Exception e) {
			String logRefID = CommonUtility.getLogRefID();
			PSOLoggerSrv.printERROR(e,logRefID);
		}
		return stuckOrderList;
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
