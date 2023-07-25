package com.tao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author TaoHuaYu
 * @create 2023-07-22 19:16
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Dashboard9001Application {
    public static void main(String[] args) {
        SpringApplication.run(Dashboard9001Application.class,args);
    }
}
