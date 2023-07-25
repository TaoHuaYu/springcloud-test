package com.tao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TaoHuaYu
 * @create 2023-07-11 17:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80Application.class,args);
    }
}
