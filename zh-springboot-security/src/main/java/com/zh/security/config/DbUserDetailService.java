package com.zh.security.config;

import com.zh.security.entity.SysUser;
import com.zh.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义UserDetailsService，实现与数据库交互
 *
 * @author he.zhang
 * @since 2020/7/8 14:52
 */
@Service
public class DbUserDetailService implements UserDetailsService {

    private final SysUserService userService;

    @Autowired
    public DbUserDetailService(SysUserService userService){
        this.userService = userService;
    }

    /**
     * 根据用户名查询用户信息，用封装成SpringSecurity的User对象
     * @param username  用户名
     * @return UserDetails
     * @throws UsernameNotFoundException /
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.getByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在 !");
        }
        // 简单授权对象
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), simpleGrantedAuthorities);
    }
}
