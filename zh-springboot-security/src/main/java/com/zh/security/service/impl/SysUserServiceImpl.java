package com.zh.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zh.security.dao.SysUserMapper;
import com.zh.security.entity.SysUser;
import com.zh.security.service.SysUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author he.zhang
 * @since 2020-07-08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public void insert(SysUser user) {
        encryptPassword(user);
        this.save(user);
    }

    @Override
    public SysUser getByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>().eq("username", username);
        wrapper.last("limit 1");
        return this.getOne(wrapper);
    }

    /**
     * 加密密码
     */
    private void encryptPassword(SysUser user){
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
    }
}
