package com.example.customer.SpringCrud.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.customer.SpringCrud.service.CustomerServiceImpl.*(..))")
    public Object aroundServices(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        long begin = System.currentTimeMillis();
        logger.info("This transaction is on service of "+ proceedingJoinPoint.getSignature().toShortString());

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long time = end  - begin;
        logger.info("This transaction took "+ time);
        return result;
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void PostMapping(){}

    @Before("GetMapping()")
    public void beforeGetMapping(JoinPoint joinPoint){
       logger.info("AspectJ Test: GetMapping started");
       logger.info("AspectJ Test: " + joinPoint.getSignature().toShortString());
    }

    @Before("PostMapping()")
    public void beforePostMapping(JoinPoint joinPoint){
        logger.info("AspectJ Test: PostMapping started");
        logger.info("AspectJ Test: " + joinPoint.getSignature().toShortString());
    }
}
