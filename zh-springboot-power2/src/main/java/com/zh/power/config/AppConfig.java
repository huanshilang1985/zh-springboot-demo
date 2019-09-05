package com.zh.power.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author zhanghe
 * Desc: Power配置文件
 * Date 2019/8/28 21:37
 */
@ComponentScan("com.zh")
@Configuration
public class AppConfig {

    @Bean
    public TomcatServletWebServerFactory tomcat(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(5003);
        return tomcat;
    }

}
