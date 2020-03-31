package com.zh.web;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author he.zhang
 * @date 2020/3/12 17:56
 */
@Controller
@RequestMapping("")
public class IndexController {


    @RequestMapping("/update")
    @ResponseBody
    public Map<String,String> update(@RequestParam("value") String value){
        Map<String,String> map = new HashMap<>();
        map.put("v",value);
        return map;
    }

    /**
     * 接收服务端调用/hello请求，
     * 并发结果发送到/topic/echarts
     * @param message 请求信息
     * @return String
     */
    @MessageMapping("/hello")
    @SendTo("/topic/echarts")
    public String ws(Message message){
        System.out.println("-----------------");
        // 获取传入的参数，这里用的是json格式的字符串
        byte bytes[] = (byte[]) message.getPayload();
        String s = new String(bytes);
        System.out.println(s);
        return "90";
    }

}
