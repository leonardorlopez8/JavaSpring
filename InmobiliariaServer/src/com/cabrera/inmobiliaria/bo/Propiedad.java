package com.cabrera.inmobiliaria.bo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.EnumType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Propiedad {
	
	@Id
	@GeneratedValue
	private Long id;
	private String descripcion;
	private float longitud;
	private float latitud;
	private String direccion;
	private Integer metrosCubiertos;
	private Integer metrosDescubiertos;
	private Boolean balcon;
	@Enumerated(EnumType.STRING)
	private Orientacion orientacion;
	@OneToOne
	private Barrio barrio;
	@OneToMany
	private Set<Operacion> operaciones = new HashSet<Operacion>();
	private Persona duenio;
	private Double expensas;
	@OneToMany
	private List<Foto> fotos;

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Double getExpensas() {
		return expensas;
	}

	public void setExpensas(Double expensas) {
		this.expensas = expensas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMetrosCubiertos() {
		return metrosCubiertos;
	}

	public void setMetrosCubiertos(Integer metrosCubiertos) {
		this.metrosCubiertos = metrosCubiertos;
	}

	public Integer getMetrosDescubiertos() {
		return metrosDescubiertos;
	}

	public void setMetrosDescubiertos(Integer metrosDescubiertos) {
		this.metrosDescubiertos = metrosDescubiertos;
	}

	public Boolean getBalcon() {
		return balcon;
	}

	public void setBalcon(Boolean balcon) {
		this.balcon = balcon;
	}

	public Orientacion getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public Set<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(Set<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	public Persona getDuenio() {
		return duenio;
	}

	public void setDuenio(Persona duenio) {
		this.duenio = duenio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}