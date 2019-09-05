package com.zh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zh.common.Constant;
import com.zh.common.OpResult;
import com.zh.service.PowerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Author zhanghe
 * Desc:
 * Date 2019/8/28 18:20
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PowerClient powerClient;

    @RequestMapping("/getUser")
    public OpResult getUser(){
        Map<String, Object> map = new HashMap<>();
        map.put("id","11");
        map.put("name", "Tom");
        return OpResult.getSuccResultData(map);
    }

    @RequestMapping("getPower")
    public OpResult getPower(){
//        return OpResult.getSuccResultData(restTemplate.getForObject("http://localhost:5002/getPower", Object.class));
        return OpResult.getSuccResultData(restTemplate.getForObject(Constant.POWER_URL + "/getPower", Object.class));
    }

    @RequestMapping("getPower2")
    public OpResult getPower2(){
        return OpResult.getSuccResultData(powerClient.getPower());
    }

    /**
     * 测试Hystrix，降级处理
     * @return
     */
    @RequestMapping("/getUser2")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public OpResult getUser2(){
        Map<String, Object> map = new HashMap<>();
        map.put("id","11");
        return OpResult.getSuccResultData(map);
    }

    public OpResult fallbackMethod(){
        System.out.println("===fallbackMethod");
        return OpResult.getErrorResult("降级信息");
    }

}
