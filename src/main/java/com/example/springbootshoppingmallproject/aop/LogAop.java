package com.example.springbootshoppingmallproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class LogAop {
    @Pointcut("execution(* com.example.springbootshoppingmallproject.controller..*.*(..))") //controller 하위 전부
    private void controllerLog() {

    }
    @Pointcut("execution(* com.example.springbootshoppingmallproject.service..*.*(..))") //service 하위 전부
    private void serviceLog() {

    }

    @Around("controllerLog() & serviceLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        log.info("--------------------------------------------");
        log.info("" + proceedingJoinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();

        stopWatch.stop();
        log.info("수행 시간: " + stopWatch.getTotalTimeSeconds());

        return result;

    }
}
