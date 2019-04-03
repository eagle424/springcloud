package com.ba.springcloud.feign.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.springcloud.feign.service.UserFeignService;

/**
 * @author PYF
 * @date 2019年3月25日
 * @version 1.0
 */
@RestController
public class UserFeignController {

	@Resource
    private UserFeignService userFeignService;
	
	@RequestMapping("/feigninfo")
    public String feignInfo() {
        String message = userFeignService.getInfo();
        return "获取到的信息:" + message;
    }
}
