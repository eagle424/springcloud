package com.ba.springcloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @date 2019年4月4日
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping("")
    public String fallback(){
    	log.info("---------------------------- call hytrix fallback -----------------------------");
        return "出现错误，error";
        
    }
}
