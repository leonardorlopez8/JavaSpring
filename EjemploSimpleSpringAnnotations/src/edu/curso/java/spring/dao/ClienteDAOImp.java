package edu.curso.java.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.bo.Cliente;

@Repository
//@Transactional(rollbackFor = Exception.class)
public class ClienteDAOImp implements ClienteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Long guardarCliente(Cliente cliente) {
		sessionFactory.getCurrentSession().save(cliente);
		return cliente.getId();
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		sessionFactory.getCurrentSession().update(cliente);
	}

	@Override
	public void borrarCliente(Long id) {
		Cliente cliente = this.buscarClientePorId(id);
		sessionFactory.getCurrentSession().delete(cliente);
		
	}

	@Override
	public Cliente buscarClientePorId(Long id) {
		return (Cliente) sessionFactory.getCurrentSession().get(Cliente.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> recuperarClientes() {
		return  sessionFactory.getCurrentSession().createQuery("from Cliente").list();
	}

}
