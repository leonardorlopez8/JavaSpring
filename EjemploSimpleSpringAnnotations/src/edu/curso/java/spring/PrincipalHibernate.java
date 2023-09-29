package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.bo.Cliente;
import edu.curso.java.spring.dao.ClienteDAO;


public class PrincipalHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ClienteDAO clienteDAO = (ClienteDAO) appContext.getBean(ClienteDAO.class);
		Cliente cliente = new Cliente();
		cliente.setNombre("Juan Perez");
		cliente.setSaldo(3000);
		long id = clienteDAO.guardarCliente(cliente);
		System.out.println("Guardando cliente: " + id);
	}

}
