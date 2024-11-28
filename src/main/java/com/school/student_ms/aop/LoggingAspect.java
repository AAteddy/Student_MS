package com.school.student_ms.aop;


import com.school.student_ms.exception.ItemNotFoundException;
import com.school.student_ms.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;


@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.school.student_ms.service..*(..))")
    public Object printServiceLogger(ProceedingJoinPoint pjp) throws Throwable {
        try {
            long startingTime = System.currentTimeMillis();
            Object obj = pjp.proceed();
            long endingTime = System.currentTimeMillis();
            log.info("From AOP: {} : {} milliseconds",
                    pjp.getSignature(), (endingTime - startingTime));
            return obj;
        } catch (ValidationException e) {
            throw new ValidationException(e.getMessage());
        } catch (ItemNotFoundException e) {
            throw new ItemNotFoundException(e.getMessage());
        }
    }
}
