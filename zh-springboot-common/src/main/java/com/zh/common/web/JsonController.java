package com.zh.common.web;

import com.zh.common.common.JsonResult;
import com.zh.common.common.OpResult;
import com.zh.common.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author he.zhang
 * @date 2020/4/3 21:29
 */
@RestController
@RequestMapping("result")
public class JsonController {

    /**
     * 使用slf4j日志集成工具，可以方便切换日志框架
     */
    private static final Logger log = LoggerFactory.getLogger(JsonController.class);

    @RequestMapping("/user")
    public JsonResult<User> getUser(){
        log.info("getUser.........");
        User user = new User(1, "大理", "123456");
        return new JsonResult<>(user);
    }

    @RequestMapping("/list")
    public OpResult<List<User>> getUserList(){
        List<User> list = new ArrayList<User>(){{
            add(new User(1, "大理", "123456"));
            add(new User(2, "重庆", "123457"));
        }};
        return OpResult.getSuccResultData("获取用户列表成功", list);
    }

    @RequestMapping("/map")
    public JsonResult<Map> getMap(){
        Map<String, Object> map = new HashMap<String, Object>(){{
            put("作者信息", new User(1, "大理", "123456"));
            put("文章名称", "我是谁");
        }};
        return new JsonResult<>(map);
    }

}
