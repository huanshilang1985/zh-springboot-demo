package com.zh.lock;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 *
 * @author he.zhang
 * @since 2020/6/23 18:10
 */
public interface DistributedLocker {

    /**
     * 分布式加锁
     * @param lockKey 锁key
     * @return RLock
     */
    RLock lock(String lockKey);

    /**
     * 分布式加锁
     * @param lockKey 锁key
     * @param timeout 超时时间
     * @return RLock
     */
    RLock lock(String lockKey, int timeout);

    /**
     *  分布式加锁
     * @param lockKey 锁key
     * @param timeout 超时时间(秒)
     * @param unit    时间单位
     * @return RLock
     */
    RLock lock(String lockKey, int timeout, TimeUnit unit);

    /**
     * 尝试加锁
     * @param lockKey   锁Key
     * @param unit      时间单位
     * @param waitTime  等待时间
     * @param timeout   超时时间
     * @return boolean
     */
    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int timeout);

    /**
     * 分布式解锁
     * @param lockKey 锁Key
     */
    void unlock(String lockKey);

    /**
     * 分布式解锁
     * @param lock RLock
     */
    void unlock(RLock lock);
}
