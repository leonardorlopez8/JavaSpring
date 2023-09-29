package edu.cusrso.java.spring;

import java.util.*;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EjemploGeneral implements ApplicationContextAware {

	private String saludos;
	

	private List<String> listaStrings = new ArrayList<String>();
	private Set<Cliente> setClientes = new HashSet<Cliente>();
	private Map<Integer, String> mapDeIntegers = new HashMap<Integer, String>();
	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("EjemploGeneral: set del ApplicationContext");
		this.applicationContext = applicationContext;
	}
	
	
	public EjemploGeneral() {
		System.out.println("EjemploGeneral: Creando el bean.....");
	}
	
	public void initOK() {
		System.out.println("EjemploGeneral: listo para trabajar.....");
	}
	
	public void meEstanMatando() {
		System.out.println("EjemploGeneral: Saludos......... RIP....");
	}

	public void mostrarDatos() {
		System.out.println(saludos);
		for (String s  : listaStrings) {
			System.out.println("listaStrings: " + s);
		}
		
		for(Cliente c : setClientes) {
			System.out.println("setClientes: " + c);
		}
		
		for(Entry<Integer, String> e : mapDeIntegers.entrySet()) {
			System.out.println("mapDeIntegers: " + e.getKey() + " - " + e.getValue());
		}
		
	}

	public List<String> getListaStrings() {
		return listaStrings;
	}

	public void setListaStrings(List<String> listaStrings) {
		System.out.println("EjemploGeneral: set del listaStrings");
		this.listaStrings = listaStrings;
	}

	public Set<Cliente> getSetClientes() {
		return setClientes;
	}

	public void setSetClientes(Set<Cliente> setClientes) {
		System.out.println("EjemploGeneral: set del setSetClientes");
		this.setClientes = setClientes;
	}
	
	public Map<Integer, String> getMapDeIntegers() {
		return mapDeIntegers;
	}

	public void setMapDeIntegers(Map<Integer, String> mapDeIntegers) {
		System.out.println("EjemploGeneral: set del mapDeIntegers");
		this.mapDeIntegers = mapDeIntegers;
	}
	
	
	public String getSaludos() {
		return saludos;
	}


	public void setSaludos(String saludos) {
		System.out.println("EjemploGeneral: set del saludos");
		this.saludos = saludos;
	}
	
}
