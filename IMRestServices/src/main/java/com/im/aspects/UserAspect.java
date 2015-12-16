package com.im.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.im.collection.UserDetails;
import com.im.entity.AddPolicy;
import com.im.service.UserDetailsService;

@Component
@Aspect
class UserAspect{
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
	@Around("execution(* com.im.controller.PolicyController.addPolicy(..))")
	public Object authenticateUserOnAddPolicy(ProceedingJoinPoint pjp) throws Throwable
	{
		String requestId=pjp.getArgs()[1].toString();
		/*check if agent*/
		UserDetails user=registerService.getUserById(requestId);
		String userId=registerService.getUserByUsername(((AddPolicy)pjp.getArgs()[0]).getUserName()).getId();
		if(requestId.equals(userId)||user.getUserType().equals("agent"))
		{
			Object obj=pjp.proceed();
			return obj;
		}
		return null;
		
	}
}