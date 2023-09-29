package edu.curso.java.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class SoyUnPrototype {
	private String texto;
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public SoyUnPrototype() {
		System.out.println("Creando SoyUnPrototype");
	}
}
