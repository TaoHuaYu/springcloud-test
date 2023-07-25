package com.tao.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author TaoHuaYu
 * @create 2023-07-04 21:23
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
