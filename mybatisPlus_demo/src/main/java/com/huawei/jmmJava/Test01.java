package com.huawei.jmmJava;

import lombok.extern.slf4j.Slf4j;

import static cn.hutool.core.thread.ThreadUtil.sleep;

@Slf4j
public class Test01 {
    // volatile  易变的  ，告诉线程 只能从  主存中取值    线程自己的工作缓存不可用
    static boolean run = true;

    //  加锁也可以保证   可见性
    final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                // ....
//                log.info("11");
                synchronized (lock) {
                    if (!run) {
                        break;
                    }
                }
            }
        });
        t.start();
        sleep(500);
        log.info("停止了");
        synchronized (lock) {
            run = false; // 线程t不会如预想的停下来
        }
    }
}
