package com.ba.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author PYF
 * @date 2019年3月25日
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class RibbonApplication {
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
