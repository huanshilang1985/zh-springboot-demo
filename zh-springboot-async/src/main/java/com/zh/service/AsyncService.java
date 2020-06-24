package com.zh.service;

import java.util.concurrent.Future;

/**
 * @author he.zhang
 * @since 2020/6/24 18:00
 */
public interface AsyncService {

    /**
     * 异步返回值必须是Future类型
     * @return Future<String>
     */
    Future<String> taskA();

    Future<String> taskB();
}
