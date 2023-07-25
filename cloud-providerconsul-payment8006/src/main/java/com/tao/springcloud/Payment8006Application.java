package com.tao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TaoHuaYu
 * @create 2023-07-11 21:02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8006Application.class,args);
    }
}
