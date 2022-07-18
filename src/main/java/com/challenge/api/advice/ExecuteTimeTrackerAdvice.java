package com.challenge.api.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class ExecuteTimeTrackerAdvice {

    Logger logger = LoggerFactory.getLogger(ExecuteTimeTrackerAdvice.class);

    @Around("@annotation(com.challenge.api.advice.TrackExecutionTime)")
    public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
        Instant start = Instant.now();
        Object obj = pjp.proceed();
        Instant finish = Instant.now();
        long time = Duration.between(start, finish).toMillis();
        logger.info("Method name: " + pjp.getSignature() + " time taken to execute : " + time + " ms");
        return obj;
    }
}
