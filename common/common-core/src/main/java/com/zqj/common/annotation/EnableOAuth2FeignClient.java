package com.zqj.common.annotation;

import com.zqj.common.config.OAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/***
 * @Description 使Feign请求拦截器生效的注解
 * @author zhuqijing
 * @date 2021/4/19
 * @Version 1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OAuth2FeignConfigure.class)
public @interface EnableOAuth2FeignClient {
}
