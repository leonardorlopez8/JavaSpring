package edu.curso.java.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.bo.Cliente;
import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ClienteDAO;
import edu.curso.java.spring.dao.ProductoDAO;

@Service
@Transactional(rollbackFor=Exception.class)
public class GestorClientesService {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ProductoDAO productoDAO;
	
	
	public Long crearClienteConSaldoInicial(Cliente cliente) {
		cliente.setSaldo(1000);
		long id = clienteDAO.guardarCliente(cliente);
		return id;
	}
	
	
	public Long crearClienteConProducto(Cliente cliente, Producto producto) throws Exception {
		cliente.setSaldo(1000);
		long id = clienteDAO.guardarCliente(cliente);
		productoDAO.insertaProducto(producto);
		
		throw new Exception("Error....");
		//return id;
	}
	
}
