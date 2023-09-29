package edu.cusrso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ControladorGeneralDePedidos controladorGeneralDePedidos = (ControladorGeneralDePedidos)appContext.getBean("controladorGeneralDePedidos");
		controladorGeneralDePedidos.hacerX();
		
		
	}

}
