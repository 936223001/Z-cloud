package com.zqj.consumer.fallback;

import com.zqj.consumer.service.IHelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/***
 * @Description
 * @author zhuqijing
 * @date 2021/4/19
 * @Version 1.0
 **/
@Slf4j
@Component
public class HelloServiceFallback implements FallbackFactory<IHelloService> {
    @Override
    public IHelloService create(Throwable throwable) {
        return new IHelloService() {
            @Override
            public String hello(String name) {
                log.error("调用producer服务出错", throwable);
                return "调用producer服务出错";
            }
        };
    }
}
