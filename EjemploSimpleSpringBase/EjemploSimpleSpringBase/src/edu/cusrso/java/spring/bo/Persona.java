package edu.cusrso.java.spring.bo;

public class Persona {

	private String nombre;
	private Auto auto;
	
	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void manejar() {
		System.out.println("Hola mi nombre es " + nombre + " y estoy manejando el auto " + auto.getModelo());
	}
	
}
