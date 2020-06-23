package com.zh.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 注解@ConfigurationProperties，用于读取yml配置文件中，以prefix值开头的一段内容，
 * 注解@ConfigurationProperties不能单独使用，需要和@Component一起使用
 * @author he.zhang
 * @date 2020/4/4 23:19
 */
@Component
@ConfigurationProperties(prefix = "user")
public class UserConfig {

    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
