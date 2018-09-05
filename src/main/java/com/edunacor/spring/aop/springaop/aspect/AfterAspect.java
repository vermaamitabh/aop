package com.edunacor.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP is used to intercept the bean calls.
//Here we define AOP and configuration
@Configuration
@Aspect   //THE COMBINATION OF "ADVICE" AND "POINTCUT" is called "Aspect"
public class AfterAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//what kind of method calls, I would intercept
	//Format to define something to intercept calls inside a specific package is
	//execution(* PACKAGE.*.*(..)) => it is also called "pointcut"
	//(intercept-methods-which-returns-any-type<SPACE><PACKAGE>.any-class.all-methods(irrespective-of-arguments))
	
	@AfterReturning(value ="com.edunacor.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", 
			returning = "result")
	public void after(JoinPoint joinPoint, Object result) {  //joinpoint is the specific execution instance of a method
		//the statements here are called "advice". 
		//Basically, it is What should be done after interception
		logger.info("Intercepted method calls {}  retruns {}",joinPoint, result);
	}
	
	//Spring AOP framework ensures that all such weaving get executed at right moment 
	//using Aspect, pointcut, joinPoint.This process is called WEAVING. 
	//The framework which does weaving is called weaver 
	
	//you can use same way to intercept exceptions using @AfterThrowing
}
