package com.tao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author TaoHuaYu
 * @create 2023-07-07 10:31
 */
@SpringBootApplication
@EnableEurekaClient
public class providerPayment8002Application {
    public static void main(String[] args) {
        SpringApplication.run(providerPayment8002Application.class,args);
    }
}
