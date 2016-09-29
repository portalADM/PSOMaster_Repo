/************************************************************************************************************
 * Class Name : OrderMasterController.java Description:
 * 
 * Author : Ankita Mishra Date : Jun 29, 2016 **********************************************************************************************************
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
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.service.OrderInfoManagerService;

/**
 * 
 */
@RestController
public class OrderMasterController
{

    @Autowired
    OrderInfoManagerService orderService;

    @RequestMapping(value = "/portalOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<PortalOrderMasterResponseBean> getAllName(@PathVariable("id") String id)
    {

        PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

        PortalOrderMasterResponseBean nameList = new PortalOrderMasterResponseBean();
        // nameList.setOrderId(id);
        nameList = orderService.getPortalOrderDataInfo(id);
        return new ResponseEntity<PortalOrderMasterResponseBean>(nameList, HttpStatus.OK);
    }

    @RequestMapping(value = "/ensembleOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<EnsOrderMasterResponseBean> getAllEnsDetail(@PathVariable("id") String id)
    {

        PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

        EnsOrderMasterResponseBean nameList = new EnsOrderMasterResponseBean();
        // nameList.setOrderId(id);
        nameList = orderService.getEnsOrderDataInfo(id);
        return new ResponseEntity<EnsOrderMasterResponseBean>(nameList, HttpStatus.OK);
    }

    @RequestMapping(value = "/apiOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<ApiOrderMasterResponseBean>> getAllApiDetails(@PathVariable("id") String id)
    {

        PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

        ArrayList<ApiOrderMasterResponseBean> nameList = new ArrayList<ApiOrderMasterResponseBean>();
        // nameList.setOrderId(id);
        nameList = orderService.getAPIOrderDataInfo(id);
        return new ResponseEntity<ArrayList<ApiOrderMasterResponseBean>>(nameList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAPIRequest/{seq_number}", method = RequestMethod.GET)
    public ResponseEntity<String> getAPIRequest(@PathVariable("seq_number") String seq_number)
    {
        String data = orderService.getAPIRequestBody(seq_number);
        return new ResponseEntity<String>(data, HttpStatus.OK);
    }

}
