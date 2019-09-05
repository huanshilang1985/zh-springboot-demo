package com.zh.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author zhanghe
 * Desc: feign客户端
 * feign的负载均衡用的就是Ribbon配置的负载
 * Date 2019/8/29 16:27
 */
@FeignClient(name = "power")
public interface PowerClient {

    @RequestMapping("/getPower")
    Object getPower();

}
