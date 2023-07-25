package com.tao.springcloud.controller;

import com.tao.springcloud.entity.CommonResult;
import com.tao.springcloud.entity.Payment;
import com.tao.springcloud.loadbalance.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author TaoHuaYu
 * @create 2023-07-04 21:26
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL="http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalance loadBalance;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }
    @GetMapping("/payment/select/{id}")
    public CommonResult<Payment> select(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/select/"+id,CommonResult.class);
    }
    @GetMapping("/getforentity/select/{id}")
    public CommonResult<Payment> select1(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/select/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new CommonResult<>(444,"失败",null);
        }
    }
    @GetMapping("/select/{id}")
    public CommonResult<Payment> selectInfo(@PathVariable("id")Long id){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance instance = loadBalance.instance(serviceInstances);
        return restTemplate.getForObject(instance.getUri()+"/payment/select/"+id, CommonResult.class);

    }
}
