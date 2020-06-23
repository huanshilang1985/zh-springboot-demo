package com.zh.web;

import com.zh.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author he.zhang
 * @date 2020/4/21 19:41
 */
@RequestMapping("/")
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping("/getUser")
    public String getUser(){
        return demoService.getUser();
    }

}
