package com.tao.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tao.springcloud.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TaoHuaYu
 * @create 2023-07-17 16:53
 */
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "defaultGlobalFallback")
public class HystrixController {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/ok/{id}")
    public String ok(@PathVariable("id")Integer id){
       return hystrixService.ok(id);
    }

    @HystrixCommand  //加了@DefaultProperties属性注解，并且没有写具体方法名字，就用统一全局的
    @GetMapping("/timeout/{time}")
    public  String timeout(@PathVariable("time") Integer time){
        return hystrixService.timeout(time);
    }

    public String defaultGlobalFallback(){
        return "调用fallback服务降级";
    }
}
