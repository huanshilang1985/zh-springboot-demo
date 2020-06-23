package com.zh.config;

import cn.hutool.core.util.StrUtil;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author he.zhang
 * @since 2020/6/23 17:09
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedissonClient redissonClient(){
        // 单节点Redis服务
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port);
        config.useSingleServer().setPassword(StrUtil.isNotBlank(password) ? password : null);

        // 添加主从配置
//        config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress("","");

        // 集群模式
//        config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://127.0.0.1:7000", "redis://127.0.0.1:7001").addNodeAddress("redis://127.0.0.1:7002");
        return Redisson.create(config);
    }

    @Bean
    public SpringContextHolder holder(){
        return new SpringContextHolder();
    }

}
