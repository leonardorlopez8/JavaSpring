package edu.curso.java.spring;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.dao.ClienteDAO;
import edu.curso.java.spring.xml.GestorXML;


public class Principal4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SoyUnTask soyUnTask = (SoyUnTask) appContext.getBean(SoyUnTask.class);
		
		soyUnTask.testAsync();
		
		GestorXML gestorXML = (GestorXML) appContext.getBean(GestorXML.class);
		try {
			gestorXML.saveSettings();
			gestorXML.loadSettings();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
