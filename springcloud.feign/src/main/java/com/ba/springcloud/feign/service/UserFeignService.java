package com.ba.springcloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PYF
 * @date 2019年3月25日
 * @version 1.0
 */
@FeignClient(value = "user")
public interface UserFeignService {
	
	@RequestMapping(value = "/info")
    String getInfo();
	
}
