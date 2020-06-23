package com.zh.common.web;

import com.zh.common.common.JsonResult;
import com.zh.common.config.UserConfig;
import com.zh.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author he.zhang
 * @date 2020/4/4 23:24
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private UserConfig config;

    /**
     * 使用@Value注解，读取配置文件单个的值
     */
    @Value("${user.name}")
    private String name;

    @RequestMapping("/getValues")
    public JsonResult<String> getValues(){
        return new JsonResult<>(name);
    }

    @RequestMapping("/getConfig")
    public JsonResult<User> getConfig(){
        User user = new User(config.getId(), config.getName(), config.getPassword());
        return new JsonResult<>(user);
    }

}
