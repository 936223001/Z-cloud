package com.zqj.common.config;

import com.zqj.common.interceptor.ServerProtectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * @Description 将 校验网关请求头的拦截器 加入到Spring的拦截器链
 * @author zhuqijing
 * @date 2021/4/21
 * @Version 1.0
 **/
@Configuration
public class ServerProtectConfigure implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor serverProtectInterceptor() {
        return new ServerProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serverProtectInterceptor());
    }
}
