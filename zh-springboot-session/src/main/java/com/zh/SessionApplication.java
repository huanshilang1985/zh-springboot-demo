package com.zh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot共享Session
 *
 * 项目中要引入spring-session-data-redis包，每次请求都会自动在redis记录session
 * 测试方式：
 * 1. 本地启动服务，端口8080，访问set，get方法。查看redis里是否有值。修改端口为8081，在调用get方法看结果是否正确。
 * 2. 部署2份服务，并使用Nginx配置为集群，调动测试。
 *
 * @author he.zhang
 * @since 2020/6/28 9:46
 */
@SpringBootApplication
public class SessionApplication {

    private final static Logger log = LoggerFactory.getLogger(SessionApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(SessionApplication.class, args);
            log.info("========== SessionApplication 启动成功 ==========");
        } catch (Exception e) {
            log.error("SessionApplication启动失败", e);
        }
    }
}
