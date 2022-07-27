package com.example.docker_demo.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.docker_demo.service..*(..))")
    public void allServiceLayerMethods() {
    }
}
