package edu.curso.java.jms;

import java.io.Serializable;

public class Persona implements Serializable{
	private String nombre = "";
	private int edad = 0;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
