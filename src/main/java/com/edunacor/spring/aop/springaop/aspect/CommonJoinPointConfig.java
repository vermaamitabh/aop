package com.edunacor.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.edunacor.spring.aop.springaop..*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("execution(* com.edunacor.spring.aop.springaop.business.*.*(..))")
	public void businessLayerExecution() {}
	
	@Pointcut("@annotation(com.edunacor.spring.aop.springaop.aspect.TrackTime)")
	public void trackTimeAnnotation() {} 
	
}
