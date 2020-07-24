package com.zh.security.controller;

import com.zh.security.entity.SysUser;
import com.zh.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 首页Controller
 *
 * @author he.zhang
 * @since 2020/7/8 14:30
 */
@Controller
public class HomeController {

    private final SysUserService userService;

    @Autowired
    public HomeController(SysUserService userService){
        this.userService = userService;
    }

    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(SysUser userDTO){
        // 此处省略校验逻辑
        userService.insert(userDTO);
        return "redirect:register?success";
    }



}
