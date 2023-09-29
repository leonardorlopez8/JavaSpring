package edu.curso.java.spring.mvc.form;

import java.util.Date;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ProductoForm {

	private Long id;
	
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombre;
	
	@NotNull
	@Digits(integer = 8, fraction = 2)
	private Double precio;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha1 = new Date();
	
	public Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}

	public Date getFecha2() {
		return fecha2;
	}

	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}

	public Date getFecha3() {
		return fecha3;
	}

	public void setFecha3(Date fecha3) {
		this.fecha3 = fecha3;
	}

	@DateTimeFormat(style="SS")
	private Date fecha2 = new Date();
	
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fecha3 = new Date();
}
