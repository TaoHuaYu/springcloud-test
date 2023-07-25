package com.tao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author TaoHuaYu
 * @create 2023-07-15 20:55
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeign80Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign80Application.class,args);
    }
}
