package com.cafem.CafeMenu.core.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* com.cafem.CafeMenu.service.concretes.FoodServiceImpl.getAllFoods(..))")
    public Object measureGetAllExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        logger.info(joinPoint.getSignature() + " executed in " + duration + "ms to list all foods");

        return result;
    }

    @Around("execution(* com.cafem.CafeMenu.service.concretes.FoodServiceImpl.createFood(..))")
    public Object measureCreatedExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        logger.info(joinPoint.getSignature() + " executed in " + duration + "ms to create a food");

        return result;
    }

}
