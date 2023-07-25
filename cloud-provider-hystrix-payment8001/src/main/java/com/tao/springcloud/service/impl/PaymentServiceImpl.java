package com.tao.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author TaoHuaYu
 * @create 2023-07-17 16:06
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_of id:"+id+"======";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
    })
    @Override
    public String paymentInfo_timeOut(Integer time) {
        try {
            TimeUnit.SECONDS.sleep(time);
            System.out.println(time+"-----------------------------------------------------");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_timeout 等待"+time+"------";
    }
    public String paymentInfo_fallback(Integer time) {
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_fallback "+time+"------";
    }
    //===============服务熔断==================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    @Override
    public String paymentCircuitBreak(Integer id){
        if (id<0){
            throw new RuntimeException("不能为负数");
        }else {
            String uuid=IdUtil.simpleUUID();
            return Thread.currentThread().getName()+"\t"+"流水号："+uuid;
        }
    }
    public String paymentCircuitBreakFallback(Integer id){
        return "出错啦！";
    }

}
