package edu.cusrso.java.spring;

public class ControladorGeneralDePedidos {
	private GestorDePedidos gestorDePedidos;

	public GestorDePedidos getGestorDePedidos() {
		return gestorDePedidos;
	}

	public void setGestorDePedidos(GestorDePedidos gestorDePedidos) {
		System.out.println("Asignando un gestor de pedidos…..");
		this.gestorDePedidos = gestorDePedidos;
	}
	
	public void hacerX() {
		System.out.println("Llamando al gestor de pedidos desde el ControladorGeneralDePedidos");
		System.out.println(gestorDePedidos.calcularSaldoTotal());
	}
	
	public Pedido crearPedido(String tipo) {
		System.out.println("creando tipo...");
		Pedido p = new Pedido();
		p.setTipo(tipo);
		return p;
	}
}
