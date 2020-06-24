package com.zh.service.impl;

import com.zh.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * 异步Service
 *
 * @author he.zhang
 * @since 2020/6/24 18:01
 */
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    /**
     * 注解@Async需要放在Service层，并指定返回值，放到Controller层会失效。
     */
    @Async("myThreadPool")
    @Override
    public Future<String> taskA() {
        log.info("当前线程：[{}]", Thread.currentThread().getName());
        return new AsyncResult<>("hello world task A");
    }

    @Async("myThreadPool")
    @Override
    public Future<String> taskB() {
        log.info("当前线程：[{}]", Thread.currentThread().getName());
        return new AsyncResult<>("hello world task B");
    }
}
