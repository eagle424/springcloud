package com.ba.springcloud.oauth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019年4月8日
 * @version 1.0
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/{name}")
    public String getUserName(@PathVariable String name) {
        return "hello,"+ name;
    }
}
