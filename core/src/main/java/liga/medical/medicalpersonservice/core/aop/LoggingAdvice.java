package liga.medical.medicalpersonservice.core.aop;

import liga.medical.medicalpersonservice.core.util.LoggingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class LoggingAdvice {

    private final LoggingUtils loggingUtils;

    @Pointcut(value = "execution(* liga.medical.medicalpersonservice.core.controller.*.*(..))")
    public void restPointcut() { }

    @Around(value = "restPointcut()")
    public Object restLogger(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("log id: {} time: {} method name: {} {} user id: {}",
                loggingUtils.getLogId(),
                loggingUtils.getLocalDateTime(),
                methodName,
                className,
                loggingUtils.getUserEmail(authentication.getName()));


        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }

}
