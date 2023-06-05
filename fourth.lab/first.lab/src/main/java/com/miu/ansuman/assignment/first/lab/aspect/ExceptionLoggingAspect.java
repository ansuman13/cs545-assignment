package com.miu.ansuman.assignment.first.lab.aspect;

import com.miu.ansuman.assignment.first.lab.domain.ExceptionLogger;
import com.miu.ansuman.assignment.first.lab.repo.ExceptionLoggerRepo;
import com.miu.ansuman.assignment.first.lab.util.StaticContext;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@AllArgsConstructor
public class ExceptionLoggingAspect {

    private final StaticContext staticContext;
    private final ExceptionLoggerRepo exceptionLoggerRepository;

    @AfterThrowing(pointcut = "execution(* com.miu.ansuman.assignment.first.lab.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        var method = joinPoint.getSignature().getDeclaringTypeName().split("\\.");
        var exceptionLogger = ExceptionLogger.builder()
                .exceptionType(ex.getClass().getName())
                .date(new Date())
                .principle(staticContext.getCurrentUser())
                .module(method[method.length - 1].replace("ServiceImpl", ""))
                .build();
        exceptionLoggerRepository.save(exceptionLogger);
    }

}
