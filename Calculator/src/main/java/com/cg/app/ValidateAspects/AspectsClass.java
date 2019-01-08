package com.cg.app.ValidateAspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectsClass {
	
	Logger logger = Logger.getLogger(AspectsClass.class.getName());
	
	@Before("execution(* com.cg.app.service.Calculator.*.*(..))")
	public void log1() {
		logger.info("Before                                             Logging the Method");
	}
	
	@After("execution(* com.cg.app.service.Calculator.*.*(..))")
	public void log2() {
		logger.info("After                                                 Logging the Method");
	}
	
	@Around("execution(* com.cg.app.service.Calculator.*.*(..))")
	public Object log3(ProceedingJoinPoint pjp) throws Throwable {
		
		logger.info("Before Logging THe Method");
		logger.info("Function Nmae is : " + pjp.getSignature());
		logger.info("Parameters are : ");
		Object[] params = pjp.getArgs();
		for(int i = 0; i< params.length; i++) {
			logger.info("Parameter is ata index" + i + " is " + params[i]);
		}
		Object retVal = pjp.proceed();
		logger.info("After Logging The Method");
		return retVal;
	}

	@AfterReturning(pointcut = "execution(* com.cg.app.service.Calculator.*.*(..))",
			returning = "retVal")
	public void log4(Integer retVal) {
		logger.info("returned value is " + retVal);
	}
	
	@AfterThrowing(pointcut = "execution(* com.cg.app.service.Calculator.*.*(..))", throwing = "ex")
	public void log5(Exception ex) {
		logger.info("exception is" + ex);
	}
}
