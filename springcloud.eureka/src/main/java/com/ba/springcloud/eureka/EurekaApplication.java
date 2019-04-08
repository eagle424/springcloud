/**
 * 
 */
package com.ba.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册与发现服务
 * 
 * @author PYF
 * @date 2019年3月20日
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
//@EnableEurekaClient
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
