package com.zh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author he.zhang
 * @since 2020/6/24 16:34
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {


    @Bean(name = "myThreadPool")
    public static ThreadPoolExecutor myThreadPoolExecutor(){
        // 线程池核心线程数量
        int corePoolSize = 12;
        // 线程池最大数量
        int maximumPoolSize = 24;
        // 空闲线程存活时间
        long keepAliveTime = 5;
        // 缓冲队列
        BlockingQueue queue = new ArrayBlockingQueue(20);
        return new ThreadPoolExecutor(corePoolSize,maximumPoolSize, keepAliveTime, TimeUnit.MINUTES, queue);
    }

}
