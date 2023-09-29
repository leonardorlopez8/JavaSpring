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
public class ErroresController {
	
	 @ExceptionHandler(Exception.class)
	public String handlerException(Exception ex, HttpServletRequest request)  {
		 System.out.println("Hay un error....");
		 return "/ejemplos/holamundo5";
	}

}



