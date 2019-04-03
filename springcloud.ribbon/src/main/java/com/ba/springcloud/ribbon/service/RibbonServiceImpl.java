package com.ba.springcloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author PYF
 * @date 2019年3月25日
 * @version 1.0
 */
@Service
public class RibbonServiceImpl implements RibbonService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(fallbackMethod = "getInfoFailure")
	public String getInfo() {
        String message;
        try {
            System.out.println("调用 服务USER/info");
            message = restTemplate.getForObject("http://USER/info", String.class);
            System.out.println("服务 USER/info 返回信息 : " + message);
            System.out.println("调用 服务 USER/info 成功！");
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }
	
	@Override
	public String getInfoFailure() {
        String message = "网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
        return message;
    }
	
}
