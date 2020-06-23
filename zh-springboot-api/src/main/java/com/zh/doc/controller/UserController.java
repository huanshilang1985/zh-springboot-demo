package com.zh.doc.controller;

import com.zh.doc.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author he.zhang
 * @date 2020/6/16 9:27
 */

@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * 根据ID，查询用户列表
     *
     * @param ids id集合
     * @return List<UserEntity>
     */
    @RequestMapping(path = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
    public List<UserEntity> queryList(@RequestBody List<String> ids) {
        List<UserEntity> list = new ArrayList<>(3);
        list.add(new UserEntity("1", "zhanghe"));
        list.add(new UserEntity("2", "lis"));
        list.add(new UserEntity("3", "Tom"));
        return list;
    }

    /**
     * 保存用户
     *
     * @param entity 用户实体
     * @return UserEntity
     */
    @PostMapping("save")
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public UserEntity save(@RequestBody UserEntity entity) {
        return entity;
    }

}
