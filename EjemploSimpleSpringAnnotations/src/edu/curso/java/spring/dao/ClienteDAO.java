package edu.curso.java.spring.dao;

import java.util.List;

import edu.curso.java.spring.bo.Cliente;




public interface ClienteDAO {

	public Long guardarCliente(Cliente cliente);
	public void actualizarCliente(Cliente cliente);
	public void borrarCliente(Long id);
	public Cliente buscarClientePorId(Long id);
	public List<Cliente> recuperarClientes();

	
}
