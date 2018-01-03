/************************************************************************************************************
 * Class Name :  StuckOrdersDetails.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.StuckOrderDetailsResponse;
import com.zig.pso.service.StuckOrderDetailsService;

/**
 * 
 */
@RestController
public class StuckOrderDetailsController
{
    static final Logger logger = Logger.getLogger(StuckOrderDetailsController.class);
    
    @Autowired
    StuckOrderDetailsService stuckOrderDetailsService;

    @RequestMapping(value = "/segregatedOrderList/{status}", method = RequestMethod.GET)
    public ResponseEntity<StuckOrderDetailsResponse> getSegregatedOrders(@PathVariable("status") String status)
    {
        PSOLoggerSrv.printDEBUG(logger,"StuckOrderDetailsController", "getSegregatedOrders", "status : " + status);

        StuckOrderDetailsResponse stuckOrderDetailsResponse = stuckOrderDetailsService.getSegregatedOrders(status);
        return new ResponseEntity<StuckOrderDetailsResponse>(stuckOrderDetailsResponse, HttpStatus.OK);
    }
}
