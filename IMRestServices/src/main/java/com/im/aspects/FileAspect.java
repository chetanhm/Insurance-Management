package com.im.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Aspect
public class FileAspect {

		@Around("execution(* com.im.controller.FileController.addFile(..))")
		public Object authenticateAdmin(ProceedingJoinPoint pjp) throws Throwable
		{
			MultipartFile file=(MultipartFile) pjp.getArgs()[0];
			
			if(file.getContentType().toString().equals("application/pdf")||file.getContentType().toString().equals("image/jpeg"))
			{
				Object obj=pjp.proceed();
				return obj;
			}
			return null;
			
		}
	
}
