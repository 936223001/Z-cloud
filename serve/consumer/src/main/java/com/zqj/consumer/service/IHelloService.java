package com.zqj.consumer.service;

import com.zqj.consumer.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * @Description Feign客户端 (value 指定远程服务的名称,contextId 指定这个Feign Client的别名,fallbackFactory 指定了回退方法)
 * @author zhuqijing
 * @date 2021/4/19
 * @Version 1.0
 **/
@FeignClient(value = "producer", contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);

}
