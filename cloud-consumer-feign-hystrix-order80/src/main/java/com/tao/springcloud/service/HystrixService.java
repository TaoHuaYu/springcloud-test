package com.tao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author TaoHuaYu
 * @create 2023-07-17 16:50
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface HystrixService {
    @GetMapping("payment/ok/{id}")
    public String ok(@PathVariable("id")Integer id);
    @GetMapping("payment/timeout/{time}")
    public String timeout(@PathVariable("time")Integer time);

}
