package com.zh.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;

/**
 * Author zhanghe
 * Desc:
 * Date 2019/8/29 16:14
 */
public class OrderRuleConfig {

    @Bean
    public IRule iRule(){
        return new RetryRule();
    }

}
