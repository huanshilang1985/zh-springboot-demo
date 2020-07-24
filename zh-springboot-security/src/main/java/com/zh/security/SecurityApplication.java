package com.zh.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author he.zhang
 * @since 2020/7/8 14:09
 */
@SpringBootApplication
public class SecurityApplication {

    private final static Logger logger = LoggerFactory.getLogger(SecurityApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(SecurityApplication.class, args);
            logger.info("======== SecurityApplication 启动成功 ========");
        } catch (Exception e) {
            logger.error("SecurityApplication 启动异常", e);
        }

    }

}
