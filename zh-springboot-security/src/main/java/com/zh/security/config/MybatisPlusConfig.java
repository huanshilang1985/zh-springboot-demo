package com.zh.security.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置
 *
 * @author he.zhang
 * @since 2020/7/14 16:56
 */
@Configuration
@MapperScan("com.zh.security.dao")
public class MybatisPlusConfig {

    /**
     * MyBatisPlus的分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
