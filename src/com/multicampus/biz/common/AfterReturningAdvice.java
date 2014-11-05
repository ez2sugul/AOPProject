package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service("afterReturning")
@Aspect
public class AfterReturningAdvice {
	@Pointcut("execution(* com.multicampus.biz..*Impl.get*(..))")
	public void getPointcut(){}
	
	@AfterReturning(pointcut="getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) { 
		String method = jp.getSignature().getName();	
		
		System.out.println("[���� ó��] " + method + 
			"() �޼��� ���� �� : " + returnObj.toString());
	}
	
}
