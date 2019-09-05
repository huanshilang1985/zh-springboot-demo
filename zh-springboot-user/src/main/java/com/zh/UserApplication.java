package com.zh;

import com.zh.conf.OrderRuleConfig;
import com.zh.conf.PowerRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author zhanghe
 * Desc: 用户启动类
 * Date 2019/8/28 18:20
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({   //name是微服务的名称，configuration是负载策略类
        @RibbonClient(name = "power", configuration = PowerRuleConfig.class),
        @RibbonClient(name = "order", configuration = OrderRuleConfig.class)
})
@EnableFeignClients
@EnableHystrix
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        System.out.println("========= User Start ==========");
    }

}
