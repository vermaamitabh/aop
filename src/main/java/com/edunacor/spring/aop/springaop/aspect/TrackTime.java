package com.edunacor.spring.aop.springaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  //Applied only on methods
@Retention(RetentionPolicy.RUNTIME) //Apply only on runtime
public @interface TrackTime {

}
