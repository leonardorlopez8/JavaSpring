package edu.curso.java.test;

import edu.curso.java.misobjetos.Calculadora;
import junit.framework.TestCase;


public class TestCalculadora extends TestCase{

	public void testSumar() {
		Calculadora calculadora = new Calculadora();
		double total = calculadora.sumar(10, 10);
		assertTrue("Error en la suma", total == 20);
	}
	
	public void testRestar() {
		Calculadora calculadora = new Calculadora();
		double total = calculadora.restar(10, 5);
		assertTrue("Error en la resta", total == 5);
	}
	
}
