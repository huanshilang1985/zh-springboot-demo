package com.zh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 异步测试
 *
 * @author he.zhang
 * @since 2020/6/24 14:11
 */
@Slf4j
@SpringBootApplication
public class AsyncApplication {

     public static void main(String[] args) {
        try {
            SpringApplication.run(AsyncApplication.class, args);
            log.info("======= AsyncApplication 启动成功 ========");
        } catch (Exception e) {
            log.error("======= AsyncApplication 启动失败 ========", e);
        }
    }

}
