package edu.curso.java.spring.xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.oxm.*;
import org.springframework.stereotype.Component;

import edu.curso.java.spring.bo.Cliente;

@Component
@Scope(value="prototype")
public class GestorXML {

	private Cliente cliente;

	public GestorXML() {
		cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Juan");
		cliente.setFechaAlta(new Date());
		cliente.setSaldo(1000);
	}

	@Autowired
	@Qualifier("xStreamMarshaller")
	private Marshaller marshaller;

	@Autowired
	@Qualifier("xStreamMarshaller")
	private Unmarshaller unmarshaller;

	public void saveSettings() throws IOException {

		FileOutputStream os = null;
		try {
			os = new FileOutputStream("cliente.xml");
			this.marshaller.marshal(cliente, new StreamResult(os));
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public void loadSettings() throws IOException {
		FileInputStream is = null;
		try {
			is = new FileInputStream("cliente.xml");
			this.cliente = (Cliente) this.unmarshaller
					.unmarshal(new StreamSource(is));
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

}
