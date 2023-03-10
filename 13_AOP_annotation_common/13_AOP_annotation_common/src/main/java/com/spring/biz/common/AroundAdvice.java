package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		
		//핵심 메소드 실행전
		System.out.println("[Around BEFORE] 비즈니스 로직 실행전 처리");
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object returnObj = pjp.proceed(); //조인포인트 메소드 실행
		
		stopWatch.stop();
		
		//핵심 메소드 실행후
		System.out.println("[Around AFTER] 비즈니스 로직 실행후 처리");
		System.out.println("[around] " + methodName + "() 메소드 실행시간 : "
				+ stopWatch.getTotalTimeMillis() + "초(ms)");
		
		return returnObj;
	}
}
