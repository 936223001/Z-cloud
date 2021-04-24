package com.zqj.common.annotation;

import com.zqj.common.selector.CloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/***
 * @Description
 * @author zhuqijing
 * @date 2021/4/21
 * @Version 1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CloudApplicationSelector.class)
public @interface CloudApplication {
}
