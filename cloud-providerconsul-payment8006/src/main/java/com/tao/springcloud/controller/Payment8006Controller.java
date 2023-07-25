package com.tao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author TaoHuaYu
 * @create 2023-07-11 21:03
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class Payment8006Controller {

    @Value("${server.port}")
    private String portName;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getmessage")
    public Object getMessage(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        for (ServiceInstance instance : instances) {
            String s = instance.getServiceId() + "\t" + instance.getUri() + "\t" + instance.getHost() ;
            log.info("=============="+s);
        }
        return instances;

    }
}
