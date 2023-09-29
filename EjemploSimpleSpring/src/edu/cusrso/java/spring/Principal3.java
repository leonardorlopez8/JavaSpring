package edu.cusrso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IGestorDeClientes gestorDeClientes = (IGestorDeClientes)appContext.getBean("gestorDeClientes");
		
		Cliente clienteNuevo = new Cliente();
		clienteNuevo.setNombre("Juan");
		gestorDeClientes.guardarCliente(clienteNuevo);
		
		long id = 1;
		Cliente clienteRecuperado = gestorDeClientes.recuperarCliente(id);
		
	}

}
