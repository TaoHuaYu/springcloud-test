package com.tao.springcloud.controller;


import com.tao.springcloud.entity.CommonResult;
import com.tao.springcloud.entity.Payment;
import com.tao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author TaoHuaYu
 * @create 2023-07-04 17:10
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String portName;

    /**
     * 查询paymetn
     * @param id
     * @return
     */
    @GetMapping("/select/{id}")
    public CommonResult selectPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.selectPaymentById(id);
        if (payment!=null){
            log.info("create===11111===="+payment);
            return new CommonResult<>(200,"成功"+"portName:"+portName,payment);
        }else {
            return new CommonResult(500,"失败");
        }

    };

    /**
     * 添加payment信息
     * @param payment
     * @return
     */
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if (i>0){
            log.info("------添加个数----"+i);
            return new CommonResult(200,"成功"+"portName:"+portName,i);
        }else {
            return new CommonResult(500,"失败");
        }
    }
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("----service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+instance.getUri());
        }
        return instances;
    }
    @GetMapping("/timout")
    public String timout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return portName;
    }

}
