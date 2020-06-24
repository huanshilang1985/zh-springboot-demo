package com.zh.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * 方式2：Callable
 * 直接返回的参数包裹一层callable即可，可以实现WebMvcConfigurer接口，来设置默认线程池和超时处理
 *
 * @author he.zhang
 * @since 2020/6/24 14:58
 */
@Slf4j
@RestController
@RequestMapping("/callable")
public class CallableController {

    @ResponseBody
    @GetMapping("/req")
    public Callable<String> callableReq(){
        log.info("外部线程：[{}]", Thread.currentThread().getName());

        // 使用lambda简写的new Callable<String>
        return () -> {
            Thread.sleep(10000);
            log.info("内部线程：[{}]", Thread.currentThread().getName());
            return "我是返回值callable";
        };
    }

    /**
     * 实现WebMvcConfigurer接口，按需要还可以实现此接口的其他方法
     */
    @Configuration
    public class RequestAsyncPoolConfig implements WebMvcConfigurer {

        @Override
        public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
            // 处理callable超时
            configurer.setDefaultTimeout(60*1000);
            configurer.setTaskExecutor(new ThreadPoolTaskExecutor());
            configurer.registerCallableInterceptors(timeoutCallableProcessingInterceptor());
        }

        @Bean
        public TimeoutCallableProcessingInterceptor timeoutCallableProcessingInterceptor(){
            return new TimeoutCallableProcessingInterceptor();
        }
    }

}
