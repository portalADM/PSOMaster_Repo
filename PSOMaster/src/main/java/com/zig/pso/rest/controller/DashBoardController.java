/************************************************************************************************************
 * Class Name : OrderStatusDisplayController.java Description:
 * 
 * Author : Pankaj Chaudhary Date : July 31, 2016 
 * **********************************************************************************************************
 */

package com.zig.pso.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.rest.bean.StuckOrderDetailResponse;
import com.zig.pso.rest.bean.StuckOrdersCount;
import com.zig.pso.service.DashboardService;
import com.zig.pso.service.OrderInfoManagerService;

@RestController
public class DashBoardController
{
	@Autowired
	DashboardService dashboardService;
	
	@RequestMapping(value ="/stuckOrderCount",method=RequestMethod.GET)
	public ResponseEntity<StuckOrderDetailResponse>   getStuckOrders()
	{
		   PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

		   StuckOrderDetailResponse stuckOrdersList = new StuckOrderDetailResponse();
		   
		   ArrayList<StuckOrdersCount> stuckOrderCountList = dashboardService.getStuckOrderList();
		   stuckOrdersList.setStuckOrderList(stuckOrderCountList);
	        return new ResponseEntity<StuckOrderDetailResponse>(stuckOrdersList, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/stuckOrderList/{status}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<String>>   getStuckOrders(@PathVariable("status") String status)
	{
		   PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

		   ArrayList<String> stuckOrderCountList = dashboardService.getStuckOrderList1(status);
	        return new ResponseEntity<ArrayList<String>>(stuckOrderCountList, HttpStatus.OK);
	}
	//@RequestMapping(value = "/stuckOrder/{status}", method = RequestMethod.GET)
   /* public ResponseEntity<ArrayList<String>> getAllApiDetails(@PathVariable("status") String status)
    {

        PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

        ArrayList<ApiOrderMasterResponseBean> nameList = new ArrayList<ApiOrderMasterResponseBean>();
        // nameList.setOrderId(id);
        nameList = orderService.getAPIOrderDataInfo(id);
        return new ResponseEntity<ArrayListString>(nameList, HttpStatus.OK);
    }*/
	
	@RequestMapping(value ="/stuckOrderHandled",method=RequestMethod.GET)
	public ResponseEntity<StuckOrderDetailResponse>   getStuckOrderhandled()
	{
		   PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

		   StuckOrderDetailResponse stuckOrdersList = new StuckOrderDetailResponse();
		   
		   ArrayList<StuckOrdersCount> stuckOrderCountList = dashboardService.getStuckOrderhandled();
		   stuckOrdersList.setStuckOrderList(stuckOrderCountList);
	        return new ResponseEntity<StuckOrderDetailResponse>(stuckOrdersList, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/stuckOrderallStatus",method=RequestMethod.GET)
	public ResponseEntity<StuckOrderDetailResponse>   getStuckOrderallStatus()
	{
		   PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

		   StuckOrderDetailResponse stuckOrdersList = new StuckOrderDetailResponse();
		   
		   ArrayList<StuckOrdersCount> stuckOrderCountList = dashboardService.getStuckOrderallStatus();
		   stuckOrdersList.setStuckOrderList(stuckOrderCountList);
	        return new ResponseEntity<StuckOrderDetailResponse>(stuckOrdersList, HttpStatus.OK);
	}
	
}	
