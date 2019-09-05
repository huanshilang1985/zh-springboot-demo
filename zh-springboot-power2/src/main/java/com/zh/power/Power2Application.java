package com.zh.power;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author zhanghe
 * Desc: Power2启动类
 * Date 2019/8/28 21:53
 */
@SpringBootApplication
@EnableEurekaClient
public class Power2Application {

    public static void main(String[] args) {
        SpringApplication.run(Power2Application.class, args);
        System.out.println("====== Power2 Start ========");
    }

}
