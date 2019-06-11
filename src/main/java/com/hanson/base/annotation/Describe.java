package com.hanson.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by hanlin on 2019年5月9日
 **/
// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
// 字段、枚举的常量
@Target(ElementType.FIELD)
public @interface Describe {
    public String value() default "";
}
