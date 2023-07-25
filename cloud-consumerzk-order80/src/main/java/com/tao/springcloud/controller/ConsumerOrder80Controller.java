package com.tao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author TaoHuaYu
 * @create 2023-07-11 17:58
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class ConsumerOrder80Controller {
    private static final String PAYMENT_URL="http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getmessage")
    public String getMessage(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getmessage",String.class);
    }
}
