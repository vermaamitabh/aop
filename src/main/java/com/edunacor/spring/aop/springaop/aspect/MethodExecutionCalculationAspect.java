package com.edunacor.spring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect   
public class MethodExecutionCalculationAspect {
	//Here we calculate the time taken to execute the method call
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Around("execution(* com.edunacor.spring.aop.springaop..*.*(..))")
	@Around("com.edunacor.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {  
		
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		
		long timeTaken = endTime - startTime;
		logger.info("Time taken by {} is {} miliseconds",joinPoint, timeTaken);
	}
	
}
