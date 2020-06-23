package com.zh.common.web;

import org.springframework.web.bind.annotation.*;

/**
 * Controller中使用的注解解释
 * 注解@RequestMapping的属性value指定映射路径，produces指定返回格式
 * @author he.zhang
 * @date 2020/4/4 23:35
 */
@RestController
@RequestMapping(value = "/test", produces = "application/json; charset=UTF-8")
public class PathController {

    /**
     * 方式1：指定使用get方式请求
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String testGet(){
        return "success";
    }

    /**
     * 方式2：指定使用get方式请求
     * 另外还有：@PostMapping， @PutMapping，@DeleteMapping
     */
    @GetMapping(value = "/get2")
    public String testGet2(){
        return "success";
    }

    /**
     * Get请求方式，使用注解@PathVariable指定接收的参数名
     * 注意：注解里的id，和url声明的id，名称是一样的，如果不一样会接收不到
     * @param id ID
     * @return String
     */
    @GetMapping("/user/{id}")
    public String testPathVariable(@PathVariable Integer id){
        System.out.println("获取到的id为：" + id);
        return "success";
    }

}
