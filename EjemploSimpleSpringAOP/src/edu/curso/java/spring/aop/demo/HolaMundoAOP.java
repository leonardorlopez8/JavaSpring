package edu.curso.java.spring.aop.demo;

import org.springframework.stereotype.Component;

@Component
public class HolaMundoAOP {

	public void saludar(String texto) throws Exception{
		System.out.println("Saludando " + texto);
		
		if(1 == 1)
			throw new Exception("Demo de error....");
	}

}
