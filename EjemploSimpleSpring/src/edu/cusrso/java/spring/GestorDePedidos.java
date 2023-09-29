package edu.cusrso.java.spring;

public class GestorDePedidos {
	
	private Integer cantidadDePedidos;

	public GestorDePedidos() {
		System.out.println("Creando un nuevo gestor de pedidos....");
	}
	
	public Integer getCantidadDePedidos() {
		return cantidadDePedidos;
	}

	public void setCantidadDePedidos(Integer cantidadDePedidos) {
		this.cantidadDePedidos = cantidadDePedidos;
	}
	
	public double calcularSaldoTotal() {
		return cantidadDePedidos * 30;
	}
	
	public void setPedido(Pedido pedido) {
		System.out.println("Set del pedido: " + pedido.getTipo());
	}
}
