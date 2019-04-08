package com.ba.springcloud.gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author Administrator
 * @date 2019年4月4日
 * @version 1.0
 */
@Slf4j
@Configuration
public class FilterConfig {
	
	@Bean
	@Order(-1)
	public GlobalFilter a() {
	    return (exchange, chain) -> {
	        log.info("first pre filter");
	        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
	            log.info("third post filter");
	        }));
	    };
	}
	
	@Bean
	@Order(0)
	public GlobalFilter b() {
	    return (exchange, chain) -> {
	        log.info("second pre filter");
	        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
	            log.info("second post filter");
	        }));
	    };
	}

	@Bean
	@Order(1)
	public GlobalFilter c() {
	    return (exchange, chain) -> {
	        log.info("third pre filter");
	        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
	            log.info("first post filter");
	        }));
	    };
	}
	
	
	/**
	 * ip限流
	 * @return
	 */
	@Bean
	public KeyResolver ipKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
	}
	
	/**
	 * 根据用户限流
	 * @return
	 */
	//@Bean
	public KeyResolver userKeyResolver() {
	    return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
	}
	
	/**
	 * 根据url限流
	 * @return
	 */
	//@Bean
	KeyResolver apiKeyResolver() {
	    return exchange -> Mono.just(exchange.getRequest().getPath().value());
	}
	
	
}
