package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service("afterThrowing")
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* com.multicampus.biz..*Impl.*(..))")
	public void allPointcut(){}
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) { 
		String method = jp.getSignature().getName();	
		
		System.out.println("[���� ó��] " + method + 
			"() �޼��� ���� �� �߻��� ���� �޽��� : " + 
				exceptObj.getMessage());
	}
	
}