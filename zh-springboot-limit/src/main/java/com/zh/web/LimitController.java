package com.zh.web;

import com.zh.common.Limit;
import com.zh.common.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流，测试Controller
 *
 * @author he.zhang
 * @since 2020/7/8 13:37
 */
@RestController
public class LimitController {

    private static final AtomicInteger ATOMIC_INTEGER_1 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_2 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_3 = new AtomicInteger();

    @Limit(key = "limitTest", period = 10, count = 3)
    @GetMapping("/limitTest1")
    public int testLimiter1(){
        return ATOMIC_INTEGER_1.incrementAndGet();
    }

    @Limit(key = "customer_limit_test", period = 10, count = 3, limitType = LimitType.CUSTOMER)
    @GetMapping("/limitTest2")
    public int testLimiter2(){
        return ATOMIC_INTEGER_2.incrementAndGet();
    }

    @Limit(key = "ip_limit_test", period = 10, count = 3, limitType = LimitType.IP)
    @GetMapping("/limitTest3")
    public int testLimiter3(){
        return ATOMIC_INTEGER_3.incrementAndGet();
    }
}