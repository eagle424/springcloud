package com.ba.springcloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务启动类
 * 
 * @author PYF
 * @date 2019年3月22日
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);

	}

}
