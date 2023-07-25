package com.tao.springcloud.service.impl;

import com.tao.springcloud.dao.PaymentDao;
import com.tao.springcloud.entity.Payment;
import com.tao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TaoHuaYu
 * @create 2023-07-04 17:07
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment selectPaymentById(Long id) {
        return paymentDao.selectPaymentById(id);
    }
}
