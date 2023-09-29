package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.bo.Cliente;
import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ClienteDAO;
import edu.curso.java.spring.dao.ProductoDAO;


public class PrincipalJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProductoDAO productoDAO = (ProductoDAO) appContext.getBean(ProductoDAO.class);
		Producto producto = new Producto();
		producto.setId(123);
		producto.setNombre("TV LCD");
		producto.setPrecio(1000);
		
		productoDAO.insertaProducto(producto);
	}

}
