package com.tao.springcloud;

import com.tao.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author TaoHuaYu
 * @create 2023-07-04 21:07
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class)
public class OrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication80.class,args);
    }
}
