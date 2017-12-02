/************************************************************************************************************
 * Class Name :  StuckOrderDetailsServiceImpl.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.dao.StuckOrderDetailsDAO;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.OSHFMultiLineResponse;
import com.zig.pso.rest.bean.OSHFOrdersResponse;
import com.zig.pso.rest.bean.OSHFSingleLineResponse;
import com.zig.pso.rest.bean.StuckOrderDetailsResponse;
 

/**
 * 
 */

@Service
public class StuckOrderDetailsServiceImpl implements StuckOrderDetailsService
{

	/* (non-Javadoc)
	 * @see com.zig.pso.service.StuckOrderDetailsService#getSegregatedOrders(java.lang.String)
	 */
	@Autowired
	StuckOrderDetailsDAO stuckOrderDetailsDAO;
	
	@Override
	public StuckOrderDetailsResponse getSegregatedOrders(String status) {
		PSOLoggerSrv.printDEBUG("StuckOrderDetailsServiceImpl", "getSegregatedOrders", "status : " +status);
		StuckOrderDetailsResponse stuckOrderDetailsResponse= new StuckOrderDetailsResponse();
		
		if (status.equals("OSHF")){
			OSHFOrdersResponse oSHFOrdersResponse=new OSHFOrdersResponse();
			
			List<OSHFSingleLineResponse> oSHFSingleLineResponselist=new ArrayList<OSHFSingleLineResponse>();
			oSHFSingleLineResponselist=stuckOrderDetailsDAO.getOSHFSingleLineOrder();
			oSHFOrdersResponse.setOSHFSingleLineResponselist(oSHFSingleLineResponselist);
			
			List<OSHFMultiLineResponse> oSHFMultiLineResponseList=new ArrayList<OSHFMultiLineResponse>();
			oSHFMultiLineResponseList=stuckOrderDetailsDAO.getOSHFMultiLineOrder();
			oSHFOrdersResponse.setOSHFMultiLineResponseList(oSHFMultiLineResponseList); 
			
			stuckOrderDetailsResponse.setOshfOrdersResponse(oSHFOrdersResponse);	
		}
        return stuckOrderDetailsResponse;
	}
	

}
