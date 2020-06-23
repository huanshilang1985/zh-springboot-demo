package com.zh.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot第一个Demo，测试Controller的基本方法
 *
 * @author he.zhang
 * @since 2020/3/12 9:47
 */
@SpringBootApplication
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class);
        System.out.println("========= FirstApplication =======");
    }

}
