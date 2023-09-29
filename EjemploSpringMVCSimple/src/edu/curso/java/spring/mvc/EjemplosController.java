package edu.curso.java.spring.mvc;


import java.beans.PropertyEditorSupport;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.apache.cxf.jaxrs.provider.JSONUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import com.sun.corba.se.impl.copyobject.JavaStreamObjectCopierImpl;

import edu.curso.java.spring.bo.*;
import edu.curso.java.spring.mvc.form.ProductoForm;
import edu.curso.java.spring.service.ProductoService;

@Controller
public class EjemplosController {

	@RequestMapping(value = "/ejemplos/holamundo1", method = RequestMethod.GET)
	public String actionHolaMundo1(Model model)  {
		model.addAttribute("saludo", "Hola Mundo");
	 	return null;
	}

	@RequestMapping(value = "/ejemplos/holamundo2", method = RequestMethod.GET)
	public String holaMundo2(@RequestParam(value="texto",  required = false) String texto, Model model)  {
		model.addAttribute("saludo", "Hola Mundo " + texto);
	 	return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String holaMundo3(@RequestParam(value="texto") String texto, HttpSession session, WebRequest request,Model model)  {
		System.out.println("Session id: " + session.getId());
		System.out.println("Locale: " +  request.getLocale().getDisplayLanguage());
		model.addAttribute("saludo", "Hola Mundo " + texto);
	 	return "/ejemplos/holamundo2";
	}


	@RequestMapping(value = "/ejemplos/holamundo4conid/{nombre}/{id}", method = RequestMethod.GET)
	public String holaMundo4(@PathVariable Long id,@PathVariable String nombre ,Model model)  {
		model.addAttribute("saludo", "Hola Mundo " + nombre + " " + id);
	 	return "/ejemplos/holamundo4";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String holaMundo5(Model model)  {
		model.addAttribute("saludo", "Esperando el post...");
	 	return "/ejemplos/holamundo5";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String guardar5(@RequestParam(value="texto") String texto, Model model)  {
		System.out.println(texto);
		model.addAttribute("saludo", "Hola Mundo " + texto);
	 	return "/ejemplos/holamundo5";
	}

	
	
	
}



