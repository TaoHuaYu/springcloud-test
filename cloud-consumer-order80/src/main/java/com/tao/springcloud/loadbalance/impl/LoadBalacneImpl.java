package com.tao.springcloud.loadbalance.impl;

import com.tao.springcloud.loadbalance.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义轮询查询
 * @author TaoHuaYu
 * @create 2023-07-15 16:19
 */
@Component
public class LoadBalacneImpl implements LoadBalance {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int i = incrementAndGetModulo() % serviceInstances.size();
        ServiceInstance serviceInstance = serviceInstances.get(i);
        return serviceInstance;
    }
    public  final int incrementAndGetModulo(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current>=Integer.MAX_VALUE?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        return next;


    }
}
