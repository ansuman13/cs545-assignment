package com.miu.ansuman.assignment.first.lab.aspect;

import com.miu.ansuman.assignment.first.lab.domain.Logger;
import com.miu.ansuman.assignment.first.lab.repo.LoggerRepo;
import com.miu.ansuman.assignment.first.lab.util.StaticContext;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@AllArgsConstructor
public class LoggingAspect {

    private final LoggerRepo loggerRepo;
    private final StaticContext staticContext;

    @Pointcut("execution(* com.miu.ansuman.assignment.first.lab.controller..*(..))")
    public void logPointcutWithExecution() {
    }

    @Before("logPointcutWithExecution()")
    public void logMethodCallsWithExecutionAdvice(JoinPoint joinPoint) {
        var method = joinPoint.getSignature().getDeclaringTypeName().split("\\.");
        var logger = Logger.builder()
                .date(new Date())
                .principle(staticContext.getCurrentUser())
                .operation(joinPoint.getSignature().getName())
                .module(method[method.length - 1].replace("Controller", ""))
                .build();
        loggerRepo.save(logger);
    }


    @Before("execution(* com.miu.ansuman.assignment.first.lab.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("className: " + className);
        System.out.println("method name: " + methodName);
    }


}
