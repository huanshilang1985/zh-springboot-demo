package com.zh.doc.entity;

/**
 * 用户实体
 * @author he.zhang
 * @since 2020/6/16 9:26
 */
public class UserEntity {

    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    public UserEntity(String id, String username){
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
