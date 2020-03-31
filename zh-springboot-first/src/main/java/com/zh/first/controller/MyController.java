package com.zh.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author he.zhang
 * @date 2020/3/12 9:48
 */
@Controller
@RequestMapping("/")
public class MyController {

    @GetMapping("/msg")
    @ResponseBody
    public String msg(){
        return "success";
    }

    /**
     * 访问主页
     */
    @GetMapping("/index")
    public String index(){
        // 视图名称
        return "index";
    }

    /**
     * 输入时间，返回时间
     */
    @GetMapping("/date")
    @ResponseBody
    public Date getDate(Date myDate){
        return myDate;
    }

}
