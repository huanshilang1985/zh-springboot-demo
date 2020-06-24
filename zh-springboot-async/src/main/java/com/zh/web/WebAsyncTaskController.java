package com.zh.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 方式3：WebAsyncTask
 * 和方式2差不多，在Callable外包一层，给WebAsyncTask设置一个超时回调，即可实现超时处理。
 *
 * @author he.zhang
 * @since 2020/6/24 15:58
 */
@Slf4j
@RestController
@RequestMapping("/asyncTask")
public class WebAsyncTaskController {

    @ResponseBody
    @GetMapping("/req")
    public WebAsyncTask<String> webAsyncReq() {
        log.info("外部线程：[{}]", Thread.currentThread().getName());
        Callable<String> result = () -> {
            log.info("内部线程开始：[{}]", Thread.currentThread().getName());

            // 设置sleep时间，超过下面的WebAsyncTask的等待时间就会走下面的代码。
            TimeUnit.SECONDS.sleep(2);

            log.info("内部线程返回：[{}]", Thread.currentThread().getName());
            return "返回值success";
        };
        WebAsyncTask<String> wat = new WebAsyncTask<>(3000L, result);
        wat.onTimeout(() -> "返回值-超时");
        return wat;
    }

}
