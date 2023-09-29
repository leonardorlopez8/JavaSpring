package edu.curso.java.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.aop.demo.HolaMundoAOP;


public class PrincipalAOP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		HolaMundoAOP holaMundo = (HolaMundoAOP) appContext.getBean(HolaMundoAOP.class);
		
		try {
			holaMundo.saludar("esto es aop");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
