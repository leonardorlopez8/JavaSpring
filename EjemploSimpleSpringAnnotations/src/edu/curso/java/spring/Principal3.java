package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.dao.ClienteDAO;


public class Principal3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SoyAutowired soyAutowired = (SoyAutowired) appContext.getBean(SoyAutowired.class);

		soyAutowired.saludarATodos();
	}

}
