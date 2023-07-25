package com.tao.springcloud.service;

import com.tao.springcloud.entity.CommonResult;
import com.tao.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author TaoHuaYu
 * @create 2023-07-15 21:03
 */
@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("payment/select/{id}")
    public CommonResult<Payment> selectPaymentById(@PathVariable("id") Long id);
    @GetMapping("payment/timout")
    public String timout();
}
