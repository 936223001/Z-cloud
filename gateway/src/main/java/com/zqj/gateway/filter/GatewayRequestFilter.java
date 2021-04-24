package com.zqj.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/***
 * @Description 网关过滤器 (防止客户端绕过网关，直接请求微服务。解决这个问题的大致思路是：在网关转发请求前，请求头部加入网关信息，然后在处理请求的微服务模块里定义全局拦截器，校验请求头部的网关信息，这样就能避免客户端直接访问微服务了)
 * @author zhuqijing
 * @date 2021/4/21
 * @Version 1.0
 **/
@Component
public class GatewayRequestFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 通过ServerWebExchange对象获取request和response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 在请求头添加网关密匙
        byte[] token = Base64Utils.encode(("zqj:gateway:123456").getBytes());
        ServerHttpRequest build = request.mutate().header("GatewayToken", new String(token)).build();
        ServerWebExchange newExchange = exchange.mutate().request(build).build();
        return chain.filter(newExchange);
    }
}
