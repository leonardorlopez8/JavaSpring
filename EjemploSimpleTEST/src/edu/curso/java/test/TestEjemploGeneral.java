package edu.curso.java.test;


import javax.swing.text.StyledEditorKit.BoldAction;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import edu.curso.java.misobjetos.Calculadora;

public class TestEjemploGeneral extends TestCase {

	
	public void setUp() {
		System.out.println("Ejecutando un test en general");
	}
	
	public void testEjemplo1() {
		
		boolean valorTrue1 = true;
		boolean valorTrue2 = true;
		
		assertEquals("Los valores no son iguales", valorTrue1, valorTrue2);
	}

	public void testEjemplo2() {
		String texto = null;
		assertNull("El valor no es nulo", texto);
	}


	public void testEjemplo3() {
		double numero1 = 10;
		double numero2 = 20;
		
		assertTrue("numero1 es > que numero 2", numero2 > numero1);
	}

	
	public void tearDown()  {
		System.out.println("Finalizando del test en general");
	}

}
