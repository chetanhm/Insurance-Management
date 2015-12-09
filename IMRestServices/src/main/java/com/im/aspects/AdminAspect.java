package com.im.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.im.service.UserDetailsService;

@Component
@Aspect
class AdminAspect{
	@Autowired
	private UserDetailsService registerService;
	
	@Around("execution(* com.im.service.ProductDetailsImplementation.insertProduct(..))")
	public Object authenticateAdmin(ProceedingJoinPoint pjp) throws Throwable
	{
		String requestId=pjp.getArgs()[1].toString();
		String adminId=registerService.getUserByUsername("admin").getId();
		if(requestId.equals(adminId))
		{
			Object obj=pjp.proceed();
			return obj;
		}
		return null;
		
	}
	
}