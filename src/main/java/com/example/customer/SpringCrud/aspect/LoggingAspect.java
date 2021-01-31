package com.example.customer.SpringCrud.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("within(com.example.customer.SpringCrud.controller.*)")
    public void beforeListCustomers(){

        System.out.println("\n=======>>>> Executing @Before, Request Get Method");

    }

}
