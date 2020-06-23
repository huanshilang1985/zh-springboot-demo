package com.zh.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 测试一些公共配置
 *
 * @author he.zhang
 * @date 2020/4/3 20:50
 */
@SpringBootApplication
public class CommonApplication {

    private static final Logger log = LoggerFactory.getLogger(CommonApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
        log.info("========== CommonApplication Started ==========");
    }


}
