
package com.school.student_ms.aop;


import com.school.student_ms.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class ValidationAspect {

    @Around("execution(* com.school.student_ms.service..*(..))")
    public Object handleValidationExceptionAspect(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (ValidationException ex) {
            log.error("Validation Exception from AOP : {} : {}", pjp.getSignature(), ex.getMessage());
            throw ex;
        } catch (Exception e) {
            log.error("General Exception from AOP: {}", e.getMessage());
            throw new RuntimeException("Exception from AOP : " + e.getMessage(), e);
        }

    }
}
