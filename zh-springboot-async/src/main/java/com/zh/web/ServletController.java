package com.zh.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 方式1：基于Servlet实现的异步请求
 *
 * @author he.zhang
 * @since 2020/6/24 14:42
 */
@Slf4j
@RestController
@RequestMapping("/servlet")
public class ServletController {

    @GetMapping("/req")
    public void servletReq(HttpServletRequest request, HttpServletResponse response) {
        // 打开异步请求
        AsyncContext asyncContext = request.startAsync();
        // 设置监听器：可设置其开始、完成、异常、超时等时间的回调处理
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                log.info("执行完成");
                // 这里可以做一些清理资源的操作....
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                log.error("JavaSync 超时了");
                // 做一些超时后的两个操作....
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                log.error("发生错误", asyncEvent.getThrowable());
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                log.info("线程开始");
            }
        });

        // 设置超时时间
        asyncContext.setTimeout(20000);
        asyncContext.start(new Thread(() ->{
            try {
                Thread.sleep(10000);
                log.info("内部线程：[{}]", Thread.currentThread().getName());
                asyncContext.getResponse().setCharacterEncoding("utf-8");
                asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                asyncContext.getResponse().getWriter().println("这是异步的请求返回");
            } catch (Exception e) {
                log.error("异步请求异常", e);
            }

            // 异步请求完成通知

            // 此时整个请求才完成
            asyncContext.complete();
        }));
        // 此时request的线程连接已经释放了
        log.info("主线程：[{}]", Thread.currentThread().getName());
    }


}
