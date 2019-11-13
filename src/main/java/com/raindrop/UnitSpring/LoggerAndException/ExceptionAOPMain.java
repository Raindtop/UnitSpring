package com.raindrop.UnitSpring.LoggerAndException;

import com.alibaba.fastjson.JSONObject;
import com.raindrop.UnitSpring.Model.ResponseData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


//申明是个Spring管理的Bean
@Component
//申明是一个切面
@Aspect
public class ExceptionAOPMain {

    /**
     * 设置切面点
     */
    @Pointcut("@annotation(com.raindrop.UnitSpring.LoggerAndException.ExceptionAno)")
    public void adminRequired() {
    }

    /**
     * 方法执行之前
     */
    @Before("com.raindrop.UnitSpring.LoggerAndException.ExceptionAOPMain.adminRequired()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        StringBuilder log = new StringBuilder("入参为");
        for (Object arg : args) {
            log.append(arg + " ");
        }

    }

    /**
     * 方法执行之后
     */
    @After("com.raindrop.UnitSpring.LoggerAndException.ExceptionAOPMain.adminRequired()")
    public void after(JoinPoint joinPoint) {
        System.out.println("故事结束！");
    }

    /**
     * 抛出异常之后
     */
    @AfterThrowing(pointcut = "com.raindrop.UnitSpring.LoggerAndException.ExceptionAOPMain.adminRequired()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("异常：" + ex);
        ResponseData data = new ResponseData();
        data.setFalseAndMessage("服务器异常，请稍后重试");
    }

    /**
     * 正常返回之后
     */
    @AfterReturning(pointcut = "com.raindrop.UnitSpring.LoggerAndException.ExceptionAOPMain.adminRequired()", returning = "obj")
    public void afterReturn(Object obj) {
        System.out.println("放回成功，返回值为：" + JSONObject.toJSONString(obj));
    }

    /**
     * 环绕通知
     */
    @Around("com.raindrop.UnitSpring.LoggerAndException.ExceptionAOPMain.adminRequired()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            ResponseData data = new ResponseData();
            String str = "服务器异常，请稍后重试";
            if(e instanceof NullPointerException){
                str = "空指针异常";
            }
            return data.setFalseAndMessage("服务器异常，请稍后重试");
        }
        return result;
    }
}
