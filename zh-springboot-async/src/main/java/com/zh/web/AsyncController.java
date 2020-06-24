package com.zh.web;

import com.zh.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 方式5：@Async注解
 * 使用SpringBoot自带的@Async注解实现异步
 *
 * @author he.zhang
 * @since 2020/6/24 16:28
 */
@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/req")
    public String request(){
        log.info("进去请求");
        try {
            Future<String> futureA = asyncService.taskA();

            Future<String> futureB = asyncService.taskB();

            TimeUnit.SECONDS.sleep(2);
            return futureA.get() + "  " + futureB.get();
        } catch (Exception e) {
            log.error("异步操作出错", e);
        }log.info("等待结束");
        return "操作异常";
    }

    @Async
    @GetMapping("/req2")
    public Future<String> asyncMethodWithReturnType() {
        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world !!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }




}
