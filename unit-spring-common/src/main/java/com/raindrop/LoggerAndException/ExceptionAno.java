package com.raindrop.LoggerAndException;

/*
 * @Description TODO AOP实现捕获异常
 * @Author Raindrop
 * @Date 2019/10/31
 */
public @interface ExceptionAno {

    String values() default "";

    String descript() default "自定义异常拦截注解";
}
