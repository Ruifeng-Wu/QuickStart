package com.ruifeng.subproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SubProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubProjectApplication.class, args);
    }

}
