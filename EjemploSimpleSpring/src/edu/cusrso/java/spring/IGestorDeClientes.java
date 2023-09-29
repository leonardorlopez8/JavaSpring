package edu.cusrso.java.spring;

public interface IGestorDeClientes {
	public Long guardarCliente(Cliente cliente);
	public Cliente recuperarCliente(Long id);
}
