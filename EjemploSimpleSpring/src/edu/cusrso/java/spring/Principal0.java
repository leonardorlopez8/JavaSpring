package edu.cusrso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		appContext.registerShutdownHook();
		
		EjemploGeneral ejemploGeneral = (EjemploGeneral)appContext.getBean("ejemploGeneral");
		ejemploGeneral.mostrarDatos();
		
		
		
	}

}
