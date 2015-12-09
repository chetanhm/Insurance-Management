package com.im.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class AdminAspect{
	
	@Around("execution(* *(..))")
	public void log(ProceedingJoinPoint pjp)
	{
		System.out.println("here");
	}
	
}