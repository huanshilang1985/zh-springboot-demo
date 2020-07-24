package com.zh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池，实现AsyncConfigurer接口，@Async的异步线程会自动使用
 *
 * @author he.zhang
 * @since 2020/6/24 16:34
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 最小线程数
        taskExecutor.setCorePoolSize(12);
        // 最大线程数
        taskExecutor.setMaxPoolSize(24);
        // 允许的空闲时间
        taskExecutor.setKeepAliveSeconds(5);
        // 等待队列数量
        taskExecutor.setQueueCapacity(10);
        // 淘汰策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线程名前缀
        taskExecutor.setThreadNamePrefix("getAsyncExecutor-");
        taskExecutor.initialize();
        return taskExecutor;
    }




}
