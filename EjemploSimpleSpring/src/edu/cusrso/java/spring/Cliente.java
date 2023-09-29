package edu.cusrso.java.spring;

public class Cliente {
	private Long id;

	public Cliente() {
		id = new Long(-1);
		nombre = "Sin nombre";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return id + " - " + nombre;
	}
}
