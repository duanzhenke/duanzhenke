package com.huawei.jmmJava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test001 {

    private Test001() {
    }

    private static Test001 INSTANCE = null;

    public static Test001 getInstance() {
        if (INSTANCE == null) {
            synchronized (Test001.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Test001();
                }
            }

        }
        return INSTANCE;
    }
}
