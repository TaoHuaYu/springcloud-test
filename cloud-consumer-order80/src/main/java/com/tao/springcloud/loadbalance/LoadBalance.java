package com.tao.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author TaoHuaYu
 * @create 2023-07-15 16:14
 */
public interface LoadBalance {
    /**
     * 获取服务器中活着的服务数
     * @param serviceInstances
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
