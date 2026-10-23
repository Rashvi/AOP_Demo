package com.learningcoding.aop.aspect;

import com.learningcoding.aop.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
//    @Before("execution(* com.learningcoding.aop.service.StudentServiceImpl.createStudent(..))")
//    public void logBeforeMethod(JoinPoint joinPoint) {
//        System.out.println("Logging before method execution");
//        Object[] arg = joinPoint.getArgs();
//    }

    @Around("execution(* com.learningcoding.aop.service.StudentServiceImpl.createStudent(..))")
    public Student logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logging before method execution");
        Student result = (Student) joinPoint.proceed();
        System.out.println("Logging after method execution");
        return result;

    }
    @AfterReturning(value = "execution(* com.learningcoding.aop.service.StudentServiceImpl.afterReturnDemo(..))",
            returning = "result")
    public void logAfterReturningMethod(String result) {
        System.out.println("Logging after returning method , Return value is :"+result);
    }
    @AfterThrowing("execution(* com.learningcoding.aop.service.StudentServiceImpl.afterThrowing(..))")
    public void logAfterThrowingMethod() {
        System.out.println("An Exception Occured");
    }
}
