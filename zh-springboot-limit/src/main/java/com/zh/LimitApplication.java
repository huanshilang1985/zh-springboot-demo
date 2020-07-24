package com.zh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author he.zhang
 * @since 2020/7/8 11:40
 */
@SpringBootApplication
public class LimitApplication {

    private final static Logger logger = LoggerFactory.getLogger(LimitApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(LimitApplication.class, args);
            logger.info(" =========== LimitApplication 启动成功 ===========");
        } catch (Exception e) {
            logger.error("LimitApplication 启动失败", e);
        }
    }

}
