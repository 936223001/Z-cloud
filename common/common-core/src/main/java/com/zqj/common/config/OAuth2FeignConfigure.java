package com.zqj.common.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

/***
 * @Description Feign请求拦截器 (拦截Feign请求，手动往请求头上加入令牌即可)
 * @author zhuqijing
 * @date 2021/4/19
 * @Version 1.0
 **/
public class OAuth2FeignConfigure {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {

            // 添加 gateway Token
            String gatewayToken = new String(Base64Utils.encode("zqj:gateway:123456".getBytes()));
            requestTemplate.header("GatewayToken", gatewayToken);

            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
            }
        };
    }
    
}
