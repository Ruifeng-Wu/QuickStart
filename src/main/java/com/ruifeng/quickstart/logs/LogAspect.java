package com.ruifeng.quickstart.logs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LogAspect {
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void serviceLog() {}

    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
    public void webLog() {}

    @Before("serviceLog() && args(requestArg, ..)")
    public void doBefore(JoinPoint joinPoint, String requestArg) {
        log.info(joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName() + "(" +  requestArg + ")");
    }

    @AfterReturning(pointcut = "serviceLog()  || webLog()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info(joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName() +
                " Return value : " + result);
    }


    @AfterThrowing(pointcut = "serviceLog() || webLog()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("An exception has been thrown in " +
                joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
        log.error("Cause : " + exception.getMessage());
    }

    @Around("serviceLog() || webLog()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            long start = System.currentTimeMillis();
            String methodName = joinPoint.getSignature().getName();
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            log.info(joinPoint.getSignature().getDeclaringTypeName() + "." + methodName + " " + elapsedTime + "ms");
            return result;
        } catch (IllegalArgumentException e) {
            log.error(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
                    + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }

}
