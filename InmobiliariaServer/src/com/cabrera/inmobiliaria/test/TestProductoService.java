package com.cabrera.inmobiliaria.test;


import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.beans.factory.annotation.*;

import com.cabrera.inmobiliaria.dao.ProductoDAO;
import com.cabrera.inmobiliaria.service.ProductoService;

import java.util.*;

import edu.curso.java.spring.bo.Producto;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class TestProductoService extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ProductoService productoService;
	
	@Test
	public void alta() {
	}
	
	
}
