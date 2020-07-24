package com.zh.common;

/**
 * 限流类型枚举类
 *
 * @author he.zhang
 * @since 2020/7/8 11:35
 */
public enum LimitType {

    /**
     * 自定义key
     */
    CUSTOMER,

    /**
     * 请求者IP
     */
    IP;
}
