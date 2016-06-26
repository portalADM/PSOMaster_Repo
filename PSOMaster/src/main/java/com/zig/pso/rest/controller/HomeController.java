package com.zig.pso.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zig.pso.logging.PSOLoggerSrv;

@RestController
@RequestMapping("/")
public class HomeController
{

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllName()
    {

        PSOLoggerSrv.printINFO("############### THIS IS TEST LOG FILE ###########################");

        List<String> nameList = new ArrayList<String>();
        nameList.add("NILESH");
        nameList.add("SACHIN");
        nameList.add("RAHUL");

        return new ResponseEntity<List<String>>(nameList, HttpStatus.OK);
    }
}
