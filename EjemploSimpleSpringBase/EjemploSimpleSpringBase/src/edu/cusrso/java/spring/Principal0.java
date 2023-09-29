package edu.cusrso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.cusrso.java.spring.bo.Auto;
import edu.cusrso.java.spring.bo.Persona;


public class Principal0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		Auto auto = new Auto();
		auto.setModelo("FIAT 123");
		
		Persona persona = new Persona();
		persona.setNombre("Juan Perez");
		persona.setAuto(auto);
		
		persona.manejar();
		*/
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Persona miPersona = (Persona) appContext.getBean("miPersonaX");
		miPersona.manejar();
	}

}
