package com.huawei.jmmJava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonitorService {
    private Thread monitor;
    private volatile boolean stop = false;
    private boolean starting = false;

    public void start() {
        log.info("尝试启动线程监控");
        if (starting) {
            return;
        }
        monitor = new Thread(() -> {
            while (true) {
                if (stop) {
                    log.info("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000l);
                    log.info("执行监控任务了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        monitor.start();
    }

    public void stop() {
        this.stop = true;
        monitor.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        MonitorService monitor = new MonitorService();

        monitor.start();
        Thread.sleep(4000l);
        monitor.stop();

    }
}
