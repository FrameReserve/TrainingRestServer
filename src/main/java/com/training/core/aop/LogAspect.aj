package com.training.core.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Athos on 2016-07-31.
 */
@Component
@Scope
@Aspect
@Order(1)
public aspect LogAspect {
    public static Logger logger = Logger.getLogger(LogAspect.class);
    @Pointcut("@annotation(com.training.core.annotation.ServiceLog)")
    public void serviceAspect(){

    }

    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+":Aspectj Before");
    }

    @After("serviceAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+":Aspectj After");
    }
    @AfterReturning("serviceAspect()")
    public void doAfterReturn(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+":Aspectj AfterReturning");
    }

//    @AfterThrowing(value = "serviceAspect()", throwing = "ex")
//    public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
//        System.out.println(joinPoint.getSignature().getName()+":Aspectj AfterThrowing");
//        System.out.println(ex.getMessage()+":Aspectj AfterThrowing");
//    }

}
