package com.zqj.consumer;

import com.zqj.common.annotation.CloudApplication;
import com.zqj.common.annotation.EnableOAuth2FeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@CloudApplication
@EnableOAuth2FeignClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
