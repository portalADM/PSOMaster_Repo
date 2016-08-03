/************************************************************************************************************
 * Class Name : UpdateOrderController.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;
import com.zig.pso.service.UpdateOrderManagerService;

/**
 * 
 */
@RestController
public class UpdateOrderController
{
    @Autowired
    UpdateOrderManagerService updateService;

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> updateSingleOrder(@RequestBody UpdateOrderRequestBean updateOrderRequest)
    {

        PSOLoggerSrv.printINFO("############### updateOrder Rest ###########################");

        BaseResponseBean nameList = new BaseResponseBean();
        nameList = updateService.updateSingleOrderData(updateOrderRequest);
        return new ResponseEntity<BaseResponseBean>(nameList, HttpStatus.OK);
    }

}
