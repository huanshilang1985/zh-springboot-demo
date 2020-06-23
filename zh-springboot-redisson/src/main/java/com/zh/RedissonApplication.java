package com.zh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author he.zhang
 * @since 2020/6/23 17:01
 */
@SpringBootApplication
public class RedissonApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(RedissonApplication.class, args);
            System.out.println("=========RedissonApplication 启动成功=====");
        } catch (Exception e) {
            System.out.println("=========RedissonApplication 启动异常=====");
            e.printStackTrace();
        }
    }

}
