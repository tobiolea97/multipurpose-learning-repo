package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.aop.service.MyService.performOperation(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before method execution");
    }
}
