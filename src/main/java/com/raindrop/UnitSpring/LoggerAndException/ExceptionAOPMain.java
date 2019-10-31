package com.raindrop.UnitSpring.LoggerAndException;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAOPMain {

    /**
     * 设置切面点
     */
    @Pointcut("@annotation(com.raindrop.UnitSpring.LoggerAndException.ExceptionAno)")
    public void adminRequired() {}


}
