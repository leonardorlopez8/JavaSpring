package com.cabrera.inmobiliaria.bo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Operacion {
	
	@Id
	@GeneratedValue
	private Long id;
	private TipoOperacion tipoOperacion;
	private Double monto;
	private Date fechaConcrecion;
	@OneToMany
	public Set<Persona> compradores;
	@OneToMany
	public Set<Persona> vendedores;
	@OneToMany
	public Set<Pago> pagos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

	
	public Set<Persona> getCompradores() {
		return compradores;
	}

	public void setCompradores(Set<Persona> compradores) {
		this.compradores = compradores;
	}

	public Set<Persona> getVendedores() {
		return vendedores;
	}

	public void setVendedores(Set<Persona> vendedores) {
		this.vendedores = vendedores;
	}

	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFechaConcrecion() {
		return fechaConcrecion;
	}

	public void setFechaConcrecion(Date fechaConcrecion) {
		this.fechaConcrecion = fechaConcrecion;
	}
	
}