package com.cabrera.inmobiliaria.dao;

import java.util.List;

import com.cabrera.inmobiliaria.bo.Propiedad;

public interface PropiedadDAO extends GenericDAO<Propiedad, Long> {
	List<Propiedad> findAll();
	Propiedad findById(Long id);
}
