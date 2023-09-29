package edu.cusrso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorDePedidos gestorDePedidosSimple = new GestorDePedidos();
		gestorDePedidosSimple.setCantidadDePedidos(20);
		System.out.println("Gestor simple: " + gestorDePedidosSimple.calcularSaldoTotal());
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		GestorDePedidos gestorDePedidosSpring1 = (GestorDePedidos)appContext.getBean("gestorDePedidos");
		System.out.println("Gestor spring: " + gestorDePedidosSpring1.calcularSaldoTotal());
		
		GestorDePedidos gestorDePedidosSpring2 = (GestorDePedidos)appContext.getBean("gestorDePedidos");
		System.out.println("Gestor spring: " + gestorDePedidosSpring2.calcularSaldoTotal());
		
	}

}
