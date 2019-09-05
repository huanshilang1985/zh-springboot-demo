package com.zh.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author zhanghe
 * Desc:
 * Date 2019/8/28 18:30
 */
@ComponentScan("com.zh")
@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public TomcatServletWebServerFactory tomcat(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(5001);
        return tomcat;
    }

    /**
     * 负载算法
     * 如果不同系统采用不同的负载策略，IRule的声明不应该放在@ComponentScan的扫描路径下
     */
    @Bean
    public IRule iRule(){
        return new RetryRule();
    }

}
