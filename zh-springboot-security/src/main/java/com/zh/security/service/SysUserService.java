package com.zh.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zh.security.entity.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author he.zhang
 * @since 2020-07-08
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 添加新用户
     *
     * username 唯一， 默认 USER 权限
     */
    void insert(SysUser userDO);

    /**
     * 查询用户信息
     * @param username 账号
     * @return UserEntity
     */
    SysUser getByUsername(String username);

}
