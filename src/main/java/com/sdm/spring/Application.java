package com.sdm.spring;

import com.sdm.spring.repository.EsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    // logger
//    static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/index")
    public String index() {

//        logger.debug("debug log");
//        logger.info("info  log");
//        logger.warn("warn log");
//        logger.error("error log");

        return "index ELK !!";
    }


    @RequestMapping("/hello")
    public String hello() {

//        logger.debug("debug log");
//        logger.info("info  log");
//        logger.warn("warn log");
//        logger.error("error log");

        return "Hello ELK !!";
    }
}
