package com.zqj.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/***
 * @Description 资源服务器的配置类 (认证服务器本身也可以对外提供Rest服务，所以也是资源服务器)
 * @EnableResourceServer 声明开启 OAuth 资源服务器的功能
 * @author zhuqijing
 * @date 2021/4/18
 * @Version 1.0
 **/
@Order(2)
@Configuration
@EnableResourceServer
public class ResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests().antMatchers("/actuator/**").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }
}

// todo:资源服务器应该是单独放在一个starter中（febs-common-security-starter）
