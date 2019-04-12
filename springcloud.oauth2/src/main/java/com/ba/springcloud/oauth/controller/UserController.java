package com.ba.springcloud.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019年4月8日
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/info")
	public String info() {
		return "hello user";
	}

}
