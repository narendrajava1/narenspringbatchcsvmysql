package com.naren.batch;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracePerformanceAspect {

	private final Logger logger = LoggerFactory.getLogger(TracePerformanceAspect.class);

	@Around ("execution(* com.naren.batch..*.*(..)))")
	public Object logTracePerformanceAspect(ProceedingJoinPoint joinPoint) throws Throwable {

		final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		//Get intercepted method details
		final String className = methodSignature.getDeclaringType().getSimpleName();
		final String methodName = methodSignature.getName();

		final long start = System.currentTimeMillis();

		final Object result = joinPoint.proceed();
		final long end = System.currentTimeMillis();

		//Log method execution time
		logger.info("Execution time of " + className + "." + methodName + " :: " + (end - start) + " ms");

		return result;
	}
}
