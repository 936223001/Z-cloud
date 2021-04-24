package com.zqj.common.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * @Description 校验网关请求头的拦截器（防止客户端绕过网关直接请求微服务）
 * @author zhuqijing
 * @date 2021/4/21
 * @Version 1.0
 **/
public class ServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 getaway Token
        String token = request.getHeader("GatewayToken");
        String getawayToken = new String(Base64Utils.encode("zqj:gateway:123456".getBytes()));
        // 校验 getaway Token的正确性
        if (StringUtils.equals(getawayToken, token)) {
            return true;
        } else {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("请通过网关获取资源");
            return false;
        }
    }

}
