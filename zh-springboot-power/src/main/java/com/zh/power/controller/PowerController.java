package com.zh.power.controller;

import com.zh.common.OpResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author zhanghe
 * Desc:
 * Date 2019/8/28 21:32
 */
@RestController
public class PowerController {

    @RequestMapping("getPower")
    public Map getPower(){
        Map<String,Object> map = new HashMap<>();
        map.put("key", "power_1");
        return map;
    }

}
