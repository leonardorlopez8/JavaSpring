package com.cabrera.inmobiliaria.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.inmobiliaria.bo.Propiedad;
import com.cabrera.inmobiliaria.dao.PropiedadDAO;

@Service
@Transactional
public class PropiedadesService {

	private static Log log = LogFactory.getLog(PropiedadesService.class); 
	
	@Autowired
	private PropiedadDAO propiedadDAO;
		
	public Long guardarPropiedad(Propiedad propiedad) {
		return propiedadDAO.create(propiedad);
	}

	public void borrarProducto(Long id) {
		propiedadDAO.delete(propiedadDAO.findById(id));
	}

	public void actualizarPropiedad(Propiedad propiedad) {
		propiedadDAO.update(propiedad);
	}
	
	public Propiedad buscarPropiedad(Long id) {
		return propiedadDAO.findById(id);
	}

	public List<Propiedad> buscarProductos() {
		return propiedadDAO.findAll();
	}
}
