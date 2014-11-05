package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service("log")
@Aspect // Aspect = Pointcut + Advice(Before, After, Around....)
public class LogAdvice {
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	@Before("allPointcut()")
	public void printLog(JoinPoint jp) { 
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[���� ó��] " + method + 
			"() �޼��� ARGS ���� : " + args[0].toString());
	}
	
}
