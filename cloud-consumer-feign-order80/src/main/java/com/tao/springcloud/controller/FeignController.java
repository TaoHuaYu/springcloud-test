package com.tao.springcloud.controller;

import com.tao.springcloud.entity.CommonResult;
import com.tao.springcloud.entity.Payment;
import com.tao.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TaoHuaYu
 * @create 2023-07-15 21:07
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/select/{id}")
    public CommonResult<Payment> selectPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.selectPaymentById(id);
    }
    @GetMapping("/timout")
    public String timout() {
        return paymentFeignService.timout();
    }
}
