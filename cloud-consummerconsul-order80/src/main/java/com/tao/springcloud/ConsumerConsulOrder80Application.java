package com.tao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TaoHuaYu
 * @create 2023-07-11 22:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOrder80Application.class,args);
    }
}
