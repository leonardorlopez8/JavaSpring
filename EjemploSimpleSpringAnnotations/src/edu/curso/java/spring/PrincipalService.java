package edu.curso.java.spring;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.bo.Cliente;
import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ClienteDAO;
import edu.curso.java.spring.dao.ProductoDAO;
import edu.curso.java.spring.service.GestorClientesService;


public class PrincipalService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PrincipalService principalService = (PrincipalService) appContext.getBean(PrincipalService.class);
		
		Cliente cliente = (Cliente)	appContext.getBean(Cliente.class);
		cliente.setNombre("Andrés");
		cliente.setSaldo(1200.46);
		cliente.setFechaAlta(new Date());
		
	}

}
