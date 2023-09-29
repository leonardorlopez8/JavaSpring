package edu.curso.java.spring.dao;

import java.util.List;

import edu.curso.java.spring.bo.Producto;

public interface ProductoDAO {

	public void insertaProducto(Producto producto);
	
	public List<Producto> listarProductos();
}
