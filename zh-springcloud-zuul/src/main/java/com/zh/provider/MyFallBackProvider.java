package com.zh.provider;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author zhanghe
 * Desc: 降级回退
 * Provider监听的是微服务级别的
 * 断路器监听的是api级别的
 * Date 2019/9/2 15:28
 */
public class MyFallBackProvider implements FallbackProvider {

    /**
     * 对哪个微服务降级回退
     */
    @Override
    public String getRoute() {
        return "power";
    }

    /**
     * 降级回退逻辑
     * @param route 微服务名字
     * @param cause 出错异常
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if(cause instanceof HystrixTimeoutException){
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 自定义处理方法
     * @param status
     * @return
     */
    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {

            /**
             * 返回错误状态码
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            /**
             * 返回状态值
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            /**
             * 返回内容
             */
            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            /**
             * 关闭方法，
             */
            @Override
            public void close() {

            }

            /**
             * 返回具体错误信息
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("系统繁忙，稍后再试".getBytes());
            }

            /**
             * 设置相应报头
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders heads = new HttpHeaders();
                heads.setContentType(MediaType.APPLICATION_JSON);
                return heads;
            }
        };
    }
}
