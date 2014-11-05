package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service("around")
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		String method = pjp.getSignature().getName();
		
		long start = System.currentTimeMillis();
		
		obj = pjp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println(method + "() 메서드 수행에 걸린 시간 : " + 
				(end - start) + "ms(초)");
		
		return obj;
	}
	
}
