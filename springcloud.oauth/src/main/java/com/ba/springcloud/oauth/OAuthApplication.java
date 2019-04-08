package com.ba.springcloud.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 * @date 2019年4月8日
 * @version 1.0
 */
@EnableEurekaClient
public class OAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(OAuthApplication.class, args);
	}
}
