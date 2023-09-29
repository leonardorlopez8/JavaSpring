package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.dao.ClienteDAO;


public class Principal2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SoyUnPrototype soyUnPrototype1 = (SoyUnPrototype) appContext.getBean(SoyUnPrototype.class);

		soyUnPrototype1.setTexto("Hola soy el soyUnPrototype 1");
		
		SoyUnPrototype soyUnPrototype2 = (SoyUnPrototype) appContext.getBean(SoyUnPrototype.class);

		soyUnPrototype2.setTexto("Hola soy el soyUnPrototype 2");
		
		System.out.println("Texto soyUnPrototype1: " + soyUnPrototype1.getTexto());
		System.out.println("Texto soyUnPrototype2: " + soyUnPrototype2.getTexto());

	}

}
