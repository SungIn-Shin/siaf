package com.siafweb.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//@ConfigurationProperties(prefix = "sample")
@RestController
public class LoginController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Value("${my.name}")
    String name;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginInit() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "login hello : " + name;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test hello";
    }
}
