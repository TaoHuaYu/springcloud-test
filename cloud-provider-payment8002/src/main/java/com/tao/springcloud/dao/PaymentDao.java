package com.tao.springcloud.dao;

import com.tao.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author TaoHuaYu
 * @create 2023-07-04 16:27
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment selectPaymentById(@Param("id") Long id);
}
