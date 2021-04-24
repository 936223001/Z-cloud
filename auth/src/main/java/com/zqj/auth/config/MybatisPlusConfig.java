package com.zqj.auth.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 * @Description mybatis-plus 配置
 * @author zhuqijing
 * @date 2021/4/20
 * @Version 1.0
 **/
@Configuration
@MapperScan(basePackages = {"com.zqj.auth.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {
}
