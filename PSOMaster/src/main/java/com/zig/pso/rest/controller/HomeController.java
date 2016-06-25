package com.zig.pso.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController
{

    private static final Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllName()
    {

        // logs debug message
        if (logger.isDebugEnabled())
        {
            logger.debug("getWelcome is executed!");
        }

        List<String> nameList = new ArrayList<String>();
        nameList.add("NILESH");
        nameList.add("SACHIN");
        nameList.add("RAHUL");

        return new ResponseEntity<List<String>>(nameList, HttpStatus.OK);
    }
}
