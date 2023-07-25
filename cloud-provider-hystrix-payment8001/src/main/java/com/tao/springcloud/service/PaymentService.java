package com.tao.springcloud.service;

/**
 * @author TaoHuaYu
 * @create 2023-07-17 16:04
 */
public interface PaymentService {
    public String paymentInfo_ok(Integer id);
    public String paymentInfo_timeOut(Integer time);
    public String paymentCircuitBreak(Integer id);
}
