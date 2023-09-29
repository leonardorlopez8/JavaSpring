package edu.cusrso.java.spring;

public class GestorDeClientesHibernate implements IGestorDeClientes {

	@Override
	public Long guardarCliente(Cliente cliente) {
		System.out.println("Guardando un cliente mediante Hibernate");
		long id = 1;
		return id;
	}

	@Override
	public Cliente recuperarCliente(Long id) {
		System.out.println("Recuperando un cliente mediante Hibernate");
		Cliente cliente = new Cliente();
		// TODO Auto-generated method stub
		return cliente;
	}


}
