package com.ruifeng.quickstart.logs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Slf4j
@Component
public class WebLogAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
    public void webLog() {}

    @Before("webLog() && args(requestArg, ..)")
    public void doBefore(JoinPoint joinPoint, String requestArg) {
        log.info(joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName() + "(" +  requestArg + ")");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("URI {}", request.getRequestURI());
        log.info("HTTP-METHOD {}", request.getMethod());
        log.info("IP {}", request.getRemoteAddr());


        if (!ObjectUtils.isEmpty(request)) {
            Map<String, Object> headers = new HashMap();
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                Object headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName.toString());
                headers.put(headerName.toString(), headerValue);
            }
            log.info("HEADER {}", headers);
        }
    }

}
