package com.huawei.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class OrderThreadPark {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.info("线程一 执行代码 1");
        }, "t1");
        t1.start();

        new Thread(() -> {
            log.info("线程一 执行代码 2");
            LockSupport.unpark(t1);
        }, "t2").start();
        log.info("程序执行完成 ！！");
    }
}
