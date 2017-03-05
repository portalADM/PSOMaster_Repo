/************************************************************************************************************
 * Class Name : OrderMasterController.java 
 * Description: This class is serving REST calls for Order Master Page.
 * Author : Ankita Mishra 
 * Date : Jun 29, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.OrderPortInDetailsResponseBean;
import com.zig.pso.rest.bean.PortalOrderLineSIMandIMEIDetailsBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.service.OrderInfoManagerService;

/**
 * This controller is responsible for providing all the details regarding the order.
 */
@RestController
public class OrderMasterController
{

    @Autowired
    OrderInfoManagerService orderService;

    /**
     * This Method provides order details from Portal Core Database.
     */
    @RequestMapping(value = "/portalOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<PortalOrderMasterResponseBean> getPortalOrderDetails(@PathVariable("id") String id)
    {

        PSOLoggerSrv.printDEBUG("OrderMasterController", "getPortalOrderDetails", "Order ID : " + id);

        PortalOrderMasterResponseBean nameList = new PortalOrderMasterResponseBean();
        nameList = orderService.getPortalOrderDataInfo(id);
        return new ResponseEntity<PortalOrderMasterResponseBean>(nameList, HttpStatus.OK);
    }

    /**
     * This Method provides order details from Ensemble Database.
     */
    @RequestMapping(value = "/ensembleOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<EnsOrderMasterResponseBean> getOrderEnsDetail(@PathVariable("id") String id)
    {

        PSOLoggerSrv.printDEBUG("OrderMasterController", "getOrderEnsDetail", "Order ID : " + id);

        EnsOrderMasterResponseBean nameList = new EnsOrderMasterResponseBean();
        nameList = orderService.getEnsOrderDataInfo(id);
        return new ResponseEntity<EnsOrderMasterResponseBean>(nameList, HttpStatus.OK);
    }

    /**
     * This Method provides order API details
     */
    @RequestMapping(value = "/apiOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiOrderMasterResponseBean> getOrderApiDetails(@PathVariable("id") String id)
    {
        PSOLoggerSrv.printDEBUG("OrderMasterController", "getOrderApiDetails", "Order ID : " + id);
        ApiOrderMasterResponseBean orderApiResponse = new ApiOrderMasterResponseBean();
        orderApiResponse = orderService.getAPIOrderDataInfo(id);
        return new ResponseEntity<ApiOrderMasterResponseBean>(orderApiResponse, HttpStatus.OK);
    }

    /**
     * This Method provides order API Request XML
     */
    @RequestMapping(value = "/getAPIRequestResponse/{seq_number}/CallType/{CallType}", method = RequestMethod.GET)
    public ResponseEntity<String> getOrderAPIRequest(@PathVariable("seq_number") String seq_number,@PathVariable("CallType") String callType)
    {
        PSOLoggerSrv.printDEBUG("OrderMasterController", "getOrderAPIRequest", "seq_number : " + seq_number);

        String data = orderService.getAPIRequestResponseBody(seq_number,callType);
        return new ResponseEntity<String>(data, HttpStatus.OK);
    }
    
    /**
     * This Method provides order Port in Details
     */
    @RequestMapping(value = "/getPortInDetails/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderPortInDetailsResponseBean> getPortinDetails(@PathVariable("id") String orderId)
    {
        PSOLoggerSrv.printDEBUG("OrderMasterController", "getPortinDetails", "orderId : " + orderId);

        OrderPortInDetailsResponseBean portData = orderService.getPortalOrderPortDetails(orderId);
        return new ResponseEntity<OrderPortInDetailsResponseBean>(portData, HttpStatus.OK);
    }
    
    
    
    /**
     * This Method provides order Line's SIM and IMEI details from Portal Core Database.
     */
    @RequestMapping(value = "/getPortalLineSimandImei/{id}", method = RequestMethod.GET)
    public ResponseEntity<PortalOrderLineSIMandIMEIDetailsBean> getPortalLineSimandImei(@PathVariable("id") String id)
    {

        PSOLoggerSrv.printDEBUG("OrderMasterController", "getPortalLineSimandImei", "Order ID : " + id);

        PortalOrderLineSIMandIMEIDetailsBean nameList = new PortalOrderLineSIMandIMEIDetailsBean();
        nameList = orderService.getPortalLineSimAndImeiDetails(id);
        return new ResponseEntity<PortalOrderLineSIMandIMEIDetailsBean>(nameList, HttpStatus.OK);
    }

}
