package edu.curso.java.test;

import junit.framework.TestCase;

import edu.curso.java.misobjetos.*;

public class TestGestorDeClientes extends TestCase{

	public void testRescuperarCliente() {
		GestorDeClientes gestorDeClientes = new GestorDeClientes();
		Cliente cliente = gestorDeClientes.buscarCliente(12345);
		assertNotNull("Error al recuperar el cliente", cliente);
	}
	
	public void testGuardarCliente() throws Exception {
		GestorDeClientes gestorDeClientes = new GestorDeClientes();
		Cliente cliente = new Cliente();
		cliente.setNombre("Juan");
		gestorDeClientes.guardarCliente(cliente);
		
	}
}
