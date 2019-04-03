package com.ba.springcloud.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * @author Administrator
 * @date 2019年4月3日
 * @version 1.0
 */
@Configuration
public class GatewayConfig {
	/*
	 * 更改Ribbon默认的负载均衡策略
	 */
	@Bean
	public IRule irule() {
		// 实现随机的负载均衡策略
		return new RoundRobinRule();
	}
}
