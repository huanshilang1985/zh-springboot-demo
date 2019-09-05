package com.zh.power;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author zhanghe
 * Desc: Power启动类
 * Date 2019/8/28 21:30
 */
@SpringBootApplication
@EnableEurekaClient
public class PowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerApplication.class, args);
        System.out.println("====== Power1 Start ========");
    }

}
