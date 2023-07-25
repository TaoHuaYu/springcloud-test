package com.tao.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author TaoHuaYu
 * @create 2023-07-11 17:45
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String portName;

    @GetMapping("/getmessage")
    public String getMessage(){
        return portName+"--"+UUID.randomUUID().toString();
    }
}
