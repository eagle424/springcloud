package com.ba.springcloud.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PYF
 * @date 2019年3月22日
 * @version 1.0
 */
@RestController
public class UserController {
    /**
     * 提供的一个restful服务，返回内容格式：服务协议://服务器地址:服务端口/服务uri
     *
     * @param request
     * @return
     */
    @RequestMapping("/info")
    public String info(HttpServletRequest request) {
        String message = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        return message;
    }
}
