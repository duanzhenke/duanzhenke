package com.huawei.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * 一间大屋子有两个功能：睡觉、学习，互不相干。
 * 现在小南要学习，小女要睡觉，但如果只用一间屋子（一个对象锁）的话，那么并发度很低
 * 解决方法是准备多个房间（多个对象锁）
 */
@Slf4j
class BigRoom {
    public void sleep() throws InterruptedException {
        synchronized (this) {
            log.debug("sleeping 2 小时");
            Thread.sleep(2000);
        }
    }
    public void study() throws InterruptedException {
        synchronized (this) {
            log.debug("study 1 小时");
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        BigRoom bigRoom = new BigRoom();
        new Thread(() -> {
            try {
                bigRoom.study();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小南").start();
        new Thread(() -> {
            try {
                bigRoom.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小女").start();

        log.info("执行完成！！");
    }
}
