package com.zqj.common.annotation;

import com.zqj.common.config.ServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/***
 * @Description 使拦截器生效的注解
 * @author zhuqijing
 * @date 2021/4/21
 * @Version 1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerProtectConfigure.class)
public @interface EnableServerProtect {
}
