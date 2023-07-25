package com.tao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author TaoHuaYu
 * @create 2023-07-21 21:00
 */
@Component
public class PaymentFallbackService implements HystrixService{
    @Override
    public String ok(Integer id) {
        return "1111111111111";
    }

    @Override
    public String timeout(Integer time) {
        return "222222222222222222";
    }
}
