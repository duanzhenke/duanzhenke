package com.huawei.jmmJava;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CASTest01 {
    public static void main(String[] args) {
        // 执行测试代码
        Account01.demo(new AccountSafe01(10000));
    }
}


interface Account01 {
    // 获取余额
    Integer getBalance();

    // 取款
    void withdraw(Integer amount);

    /**
     * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
     * 如果初始余额为 10000 那么正确的结果应当是 0
     */
    static void demo(AccountSafe01 account) {
        List<Thread> ts = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance()
                + " cost: " + (end - start) / 1000_000 + " ms");
    }
}


class AccountSafe01 implements Account01 {
    //    private Integer balance;
//  使用原子类
    private AtomicInteger balance;

    public AccountSafe01(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        /*while (true) {
           *//*
              cas  思想实现
            // 获取余额的最新值
            int prev = balance.get();
            // 修改后的余额
            int next = prev - amount;
            //  修改后的余额  同步到主存中
            boolean b = balance.compareAndSet(prev, next);
            if (b) {
                break;
            }*//*

        }*/
        balance.getAndAdd(-1*amount);
    }
}