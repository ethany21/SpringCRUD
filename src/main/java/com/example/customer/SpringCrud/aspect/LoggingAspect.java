package com.example.customer.SpringCrud.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void PostMapping(){}

    @Before("GetMapping()")
    public void beforeGetMapping(JoinPoint joinPoint){
       logger.info("=====================AspectJ Test: GetMapping started");
    }

    @Before("PostMapping()")
    public void beforePostMapping(JoinPoint joinPoint){
        logger.info("=====================AspectJ Test: PostMapping started");
    }



}
