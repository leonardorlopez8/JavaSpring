package edu.curso.java.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SoyUnSingleton {

	private String texto;
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public SoyUnSingleton() {
		System.out.println("Creando SoyUnSingleton");
	}
}
