package com.ba.springcloud.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author PYF
 * @date 2019年3月25日
 * @version 1.0
 */
@Configuration
public class RibbenConfig {
	@Bean
	@LoadBalanced // 实现负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
