package com.nagarro.microservices.aop.aspect;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Aspect
public class LogAPIProxyCallsAspect {
	
	/***** Step: 1. // Setup the Logger Service, File Handler and SimpleFormatter Instances To Perform Logging *****/
	private static Logger logger;
	private FileHandler fileHandler;
	private SimpleFormatter formatter;
	
	public LogAPIProxyCallsAspect() throws SecurityException, IOException {
		this.initilizeLoggingConfiguration();
	}
	
	private void initilizeLoggingConfiguration() {
		logger = Logger.getLogger(getClass().getName());
		try {
			fileHandler = new FileHandler("ProxyAPICallLog.log", true);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		formatter = new SimpleFormatter();
		fileHandler.setFormatter(formatter);
		logger.addHandler(fileHandler);
		logger.setUseParentHandlers(false);
	}
	
	/***** Step: 2. // Define the Required PointCut *****/
	@Pointcut("execution(* com.nagarro.microservices.service.proxy.*.*(..))")
	private void logProxyAPIResponse() {}
	
	/***** Step: 3. // Define Required Advice with their implementation Action or aspect *****/
	@AfterReturning(pointcut = "logProxyAPIResponse()", returning = "result")
	public void performProxyAPILogging(JoinPoint apiCallJoinPoint, Object result) {
		
		String methodWhichIsCalled = apiCallJoinPoint.getSignature().getName();
		
		logger.info(Thread.currentThread() + "(" + System.currentTimeMillis() +  ")" + " : "+ methodWhichIsCalled + "\n Result Object :: " + result);
	}
	
	@AfterThrowing(pointcut = "logProxyAPIResponse()", throwing = "exception")
	public void performProxyAPIExceptionLogging(Throwable exception) {
		logger.warning(Thread.currentThread() + "(" + System.currentTimeMillis() +  ")" + " : "+ exception);
	}

}
