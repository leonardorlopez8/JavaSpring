package edu.curso.java.spring.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EjemploLoggerAspect {

	//@Pointcut("execution(* edu.curso.java.spring.aop.demo.*.*(..))")
	//@Pointcut("execution(* edu.curso.java.spring.aop.demo.HolaMundoAOP.*(..))")
	//@Pointcut("execution(* edu.curso.java.spring.aop.demo.HolaMundoAOP.*(java.lang.String))")
	//public void metodosGenerals() {
	//}

	@Before("execution(* edu.curso.java.spring.aop.demo.HolaMundoAOP.*(java.lang.String))")
	public void logBeforeMethodCall(JoinPoint joinPoint) {
		System.out.println("@Before:Ejecutando before... " + joinPoint.getSignature().getName());
		System.out.println("@Before:Objeto: " + joinPoint.getTarget().toString());
		
		
	}

	
	
	@After("execution(* edu.curso.java.spring.aop.demo.HolaMundoAOP.*(java.lang.String))")
	public void logAfterMethodCall(JoinPoint joinPoint) {
		System.out.println("@After:Ejecutando after..." + joinPoint.getSignature().getName());
		
	}

	@Around("execution(* edu.curso.java.spring.aop.demo.HolaMundoAOP.*(java.lang.String))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("@Around:Ejecutando inicio Around...");
		System.out.println("@Around:Objeto: " + pjp.getTarget().toString());
		
		System.out.println("@Around:Signatura: " + pjp.getSignature().getName());
		
		String nuevoTexo = "(De donde salio esto?)";
		if(pjp.getArgs() != null && pjp.getArgs().length > 0) {
			for(Object arg : pjp.getArgs()) {
				System.out.println("Argumento: " + arg);
			}
		}
		Object output = pjp.proceed(new String[] { nuevoTexo});
		System.out.println("@Around:Ejecutando fin Around...");

		return output;
	}
	
	
	@AfterThrowing(pointcut="execution(* edu.curso.java.spring.aop.demo.HolaMundoAOP.*(java.lang.String))", throwing="ex")
	public void hayUnError(JoinPoint joinPoint, Exception ex) {
		System.out.println("@AfterThrowing:Hay un error");
		ex.printStackTrace();
	}
	
	@AfterReturning("execution(* edu.curso.java.spring.aop.demo.HolaMundoAOP.*(java.lang.String))")
	public void logAfterReturningCall(JoinPoint joinPoint) {
		System.out.println("@AfterReturning:AfterReturning after..." + joinPoint.getSignature().getName());
	}

}
