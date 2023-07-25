package com.tao.springcloud.service;

import com.tao.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author TaoHuaYu
 * @create 2023-07-04 17:06
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment selectPaymentById(@Param("id") Long id);
}
