package com.tao.springcloud.controller;

import com.tao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TaoHuaYu
 * @create 2023-07-17 16:10
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/ok/{id}")
    public String ok(@PathVariable("id")Integer id){
       return paymentService.paymentInfo_ok(id);
    }
    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable("time")Integer time){
        return paymentService.paymentInfo_timeOut(time);
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id")Integer id){
        String s = paymentService.paymentCircuitBreak(id);
        return s;
    }
}
