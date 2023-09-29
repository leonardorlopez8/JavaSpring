package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.dao.ClienteDAO;


public class Principal1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SoyUnSingleton soyUnSingleton1 = (SoyUnSingleton) appContext.getBean(SoyUnSingleton.class);

		soyUnSingleton1.setTexto("Hola soy el singleton 1");
		
		SoyUnSingleton soyUnSingleton2 = (SoyUnSingleton) appContext.getBean(SoyUnSingleton.class);

		soyUnSingleton2.setTexto("Hola soy el singleton 2");
		
		System.out.println("Texto singleton1: " + soyUnSingleton1.getTexto());
		System.out.println("Texto singleton2: " + soyUnSingleton2.getTexto());

	}

}
