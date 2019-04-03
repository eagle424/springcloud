package com.ba.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author PYF
 * @date 2019年4月2日
 * @version 1.0
 */
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//		return builder.routes().route(
//				p -> p.path("/get").filters(f -> f.addRequestHeader("Hello", "World")).uri("http://httpbin.org:80"))
//				.build();
//	}

}