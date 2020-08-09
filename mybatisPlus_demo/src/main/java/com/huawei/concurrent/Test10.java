package com.huawei.concurrent;

import lombok.Data;

import java.util.concurrent.TimeUnit;

public class Test10 {
    public static void main(String[] args) {
    }
}



class  Guarded{
    private Object respone;

    public Object get() throws InterruptedException {
        synchronized (this){
            while (respone ==null){
                this.wait();
            }
        return respone;
        }
    }

    public void  complete(Object respone){
        synchronized (this){
            this.respone=respone;
            this.notifyAll();
        }


    }
}