package com.zh.common.entity;

import org.springframework.util.StringUtils;

/**
 * 用户对象
 * @author he.zhang
 * @date 2020/4/3 21:28
 */
public class User {

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    public User(){

    }

    public User(Integer id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

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
