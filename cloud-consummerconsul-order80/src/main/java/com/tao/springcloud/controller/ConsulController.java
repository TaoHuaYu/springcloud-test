package com.tao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author TaoHuaYu
 * @create 2023-07-11 22:13
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class ConsulController {
    @Autowired
    private RestTemplate restTemplate;
    private static final String PAYMENT_URL="httP://cloud-provider-payment";

    @GetMapping("/getmessage")
    public Object getMessage(){
        Object forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/getmessage", Object.class);
        return forObject;
    }
}
