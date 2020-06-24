package com.zh.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 方式4：DeferredResult
 * DeferredResult 可以处理一些相对复杂一些的业务逻辑，最主要还是可以在另一个线程里面进行业务处理及返回，即可在两个完全不相干的线程间的通信。
 *
 * @author he.zhang
 * @since 2020/6/24 16:11
 */
@Slf4j
@RestController
@RequestMapping("/deferred")
public class DeferredResultController {

//    @Autowired
//    private ThreadPoolExecutor myThreadPool;

    @ResponseBody
    @GetMapping("/req")
    public DeferredResult<String> deferredResultReq() {
        log.info("外部线程：[{}]", Thread.currentThread().getName());
        // 设置超时时间
        DeferredResult<String> result = new DeferredResult<>(60 * 1000L);

        result.onTimeout(new Thread(() -> {
            log.error("DeferredResult超时");
            result.setResult("请求超时了");
        }));
        result.onCompletion(new Thread(()->{
            // 完成后
            log.info("调用完成");
        }));

//        myThreadPool.execute(new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.info("内部线程：[{}]", Thread.currentThread().getName());
//            result.setResult("DeferredResult业务处理完毕");
//        }));
        return result;
    }


}
