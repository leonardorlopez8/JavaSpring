package edu.curso.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class SoyAutowired {

	private SoyUnPrototype soyUnPrototype;

	@Autowired
	public void setSoyUnPrototype(SoyUnPrototype soyUnPrototype) {
		System.out.println("IoC!!!!");
		this.soyUnPrototype = soyUnPrototype;
	}

	@Autowired
	private SoyUnSingleton soyUnSingleton;
	

	public void saludarATodos() {
		System.out.println("Saludando a todos");
		soyUnPrototype.setTexto("Hola");
		soyUnSingleton.setTexto("Hola");
	}
	
	
}
