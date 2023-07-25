package com.tao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author TaoHuaYu
 * @create 2023-07-17 16:48
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class FeignHystrixApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixApplication80.class,args);
    }
}
