package edu.cusrso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.cusrso.java.spring.bo.Auto;
import edu.cusrso.java.spring.bo.Persona;
import edu.cusrso.java.spring.bo.SoyUnPrototype;
import edu.cusrso.java.spring.bo.SoyUnSingleton;


public class Principal1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SoyUnSingleton soyUnSingleton1 = (SoyUnSingleton) appContext.getBean("unSingleton");
		SoyUnSingleton soyUnSingleton2 = (SoyUnSingleton) appContext.getBean("unSingleton");
		SoyUnSingleton soyUnSingleton3 = (SoyUnSingleton) appContext.getBean("unSingleton");
		SoyUnSingleton soyUnSingleton4 = (SoyUnSingleton) appContext.getBean("unSingleton");
		
		SoyUnPrototype soyUnPrototype1 = (SoyUnPrototype) appContext.getBean("unPrototype");
		SoyUnPrototype soyUnPrototype2 = (SoyUnPrototype) appContext.getBean("unPrototype");
		SoyUnPrototype soyUnPrototype3 = (SoyUnPrototype) appContext.getBean("unPrototype");
		SoyUnPrototype soyUnPrototype4 = (SoyUnPrototype) appContext.getBean("unPrototype");
	}

}
