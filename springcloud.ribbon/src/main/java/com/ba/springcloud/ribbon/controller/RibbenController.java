package com.ba.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.springcloud.ribbon.service.RibbonService;

/**
 * @author PYF
 * @date 2019年3月25日
 * @version 1.0
 */
@RestController
public class RibbenController {
	
	@Autowired
	RibbonService ribbonService;
	
	@RequestMapping("/info")
    public String ribbonInfo() {
        String message = ribbonService.getInfo();
        return "获取的信息:" + message;
    }
	
	@RequestMapping("/")
    public String index() {
        String message = ribbonService.getInfo();
        return "获取的信息:" + message;
    }
}
