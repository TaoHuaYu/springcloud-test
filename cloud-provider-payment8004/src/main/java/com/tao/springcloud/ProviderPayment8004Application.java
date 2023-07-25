package com.tao.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TaoHuaYu
 * @create 2023-07-11 16:00
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul和zookeeper作为服务中心的注册服务
public class ProviderPayment8004Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8004Application.class,args);
    }

}
