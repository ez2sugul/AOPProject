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
		
		System.out.println("[사전 처리] " + method + 
			"() 메서드 ARGS 정보 : " + args[0].toString());
	}
	
}
