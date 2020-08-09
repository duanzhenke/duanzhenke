package com.huawei.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;
@Slf4j
public class TryLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            log.debug("启动...");
            if (!lock.tryLock()) {
                log.debug("获取立刻失败，返回");
                return;
            }
            try {
                log.debug("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        t1.start();
        lock.lock();
        log.debug("main获得了锁");
    }
}
