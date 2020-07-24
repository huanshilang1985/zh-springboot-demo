package com.zh.web;

import com.zh.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /**
     * 异步操作，这里调用的asyncService的方法都使用了@Async注解，实现异步调用。
     * 在接接收到@Async的返回值Future<String>后，在进行处理
     * 注意：在Controller层使用@Async注解是不生效的。
     * @return
     */
    @GetMapping("/req")
    public String request(){
        log.info("进去请求");
        try {
            Future<String> futureA = asyncService.taskA();

            Future<String> futureB = asyncService.taskB();

//            TimeUnit.SECONDS.sleep(1);
            return futureA.get() + "  " + futureB.get();
        } catch (Exception e) {
            log.error("异步操作出错", e);
        }log.info("等待结束");
        return "操作异常";
    }

}
