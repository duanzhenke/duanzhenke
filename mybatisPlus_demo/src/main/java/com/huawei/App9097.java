package com.huawei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huawei.mapper")
public class App9097 {
    public static void main(String[] args) {
        SpringApplication.run(App9097.class, args);
    }
}
