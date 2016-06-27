package com.zig.pso.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.service.OrderInfoManagerService;

@RestController
public class HomeController
{
    /*
     * Order Service injection
     */
    @Autowired
    OrderInfoManagerService orderService;

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllName()
    {

        PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

        List<String> nameList = new ArrayList<String>();
        nameList = orderService.getOrderIds();
        return new ResponseEntity<List<String>>(nameList, HttpStatus.OK);
    }

}
