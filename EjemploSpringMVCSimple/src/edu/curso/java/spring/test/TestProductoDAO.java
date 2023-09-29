package edu.curso.java.spring.test;


import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ProductoDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class TestProductoDAO extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ProductoDAO productoDAO;
	
	@Test
	public void alta() {
		Producto producto = new Producto();
		producto.setNombre(Constantes.NOMBRE_PRODUCTO);
		double precion = 1000;
		producto.setPrecio(precion);
		Constantes.ID_PRODUCTO = productoDAO.guardarProducto(producto);
		Producto productoRecuperado = productoDAO.buscarProductoPorId(Constantes.ID_PRODUCTO);
		Assert.assertNotNull("Error en el alta del producto", productoRecuperado);
	}
	
	@Test
	public void busqueda() {
		Producto productoRecuperado = productoDAO.buscarProductoPorId(Constantes.ID_PRODUCTO);
		Assert.assertNotNull("Error al buscar el producto", productoRecuperado);
		Assert.assertTrue("Error al recuperar el nombre", productoRecuperado.getNombre().equals(Constantes.NOMBRE_PRODUCTO));		
	}
	

	@Test
	public void noBusqueda() {
		long id = -1;
		Producto productoRecuperado = productoDAO.buscarProductoPorId(id);
		Assert.assertNull("Error al buscar el producto", productoRecuperado);
	}
	
	@Test
	public void busquedaCompleta() {
		List<Producto> productos = productoDAO.recuperarProductos();
		Assert.assertTrue("Error al recuperar los productos",  productos.size() > 0);		
	}
	
}
