package edu.curso.java.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestEjemploGeneral.class);
		suite.addTestSuite(TestCalculadora.class);
		suite.addTestSuite(TestGestorDeClientes.class);
		//$JUnit-END$
		return suite;
	}

}
