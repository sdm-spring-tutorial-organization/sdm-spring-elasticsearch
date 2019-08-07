package com.sdm.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLoggerController {

    @RequestMapping("/index")
    public String index() {
        /*logger.debug("debug log");
        logger.info("info  log");
        logger.warn("warn log");
        logger.error("error log");*/
        return "index ELK !!";
    }

    @RequestMapping("/hello")
    public String hello() {
        /*logger.debug("debug log");
        logger.info("info  log");
        logger.warn("warn log");
        logger.error("error log");*/
        return "Hello ELK !!";
    }
}
