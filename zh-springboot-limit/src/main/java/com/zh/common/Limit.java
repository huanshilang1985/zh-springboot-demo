package com.zh.common;

import java.lang.annotation.*;

/**
 * 自定义限流注解
 *
 * @author he.zhang
 * @since 2020/7/8 11:37
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Limit {

    /**
     * 名字
     */
    String name() default "";

    /**
     * key
     */
    String key() default "";

    /**
     * key的前缀
     */
    String prefix() default "";

    /**
     * 给定的时间范围，单位秒
     */
    int period();

    /**
     * 显示一段时间内的最多访问次数
     */
    int count();

    /**
     * 限流的类型（用户自定义key、请求ip）
     */
    LimitType limitType() default LimitType.CUSTOMER;
}
