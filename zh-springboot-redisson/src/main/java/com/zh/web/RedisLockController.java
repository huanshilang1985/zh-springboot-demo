package com.zh.web;

import com.zh.lock.RedisDistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * redis分布式锁Controller
 *
 * @author he.zhang
 * @since 2020/6/23 18:20
 */
@RestController
@RequestMapping("/redis")
public class RedisLockController {

    @Autowired
    private RedisDistributedLocker redisDistributedLocker;

    /**
     * 锁测试的共享变量
     */
    private Integer lockCount = 10;

    /**
     * 无锁的共享变量
     */
    private Integer count = 10;

    /**
     * 模拟并发测试加锁和不加锁
     */
    @GetMapping("/test")
    public void lock(){
        // 模拟线程数
        int threadNum = 10;
        // 计数器
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for(int i =0; i < threadNum; i++){
            MyRunnable myRunnable = new MyRunnable(countDownLatch);
            Thread myThread = new Thread(myRunnable);
            myThread.start();
        }
        // 释放所有线程
        countDownLatch.countDown();
    }

    /**
     * 加锁测试
     */
    private void testLockCount(){
        String lockKey = "lock-test-key";
        try {
            redisDistributedLocker.lock(lockKey, 2, TimeUnit.SECONDS);
            lockCount--;
            System.out.println("lockCount的值" + lockCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            redisDistributedLocker.unlock(lockKey);
        }
    }

    /**
     * 无锁测试
     */
    private void testCount(){
        count--;
        System.out.println("count的值：" + count);
    }

    public class MyRunnable implements Runnable {

        final CountDownLatch countDownLatch;

        public MyRunnable(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run(){
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                System.out.println("线程异常");
                e.printStackTrace();
            }
            // 无锁操作
            testCount();
            // 加锁操作
            testLockCount();
        }

    }
}


