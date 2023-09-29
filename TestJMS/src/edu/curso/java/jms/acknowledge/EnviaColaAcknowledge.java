package edu.curso.java.jms.acknowledge;

import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

import edu.curso.java.jms.Persona;

public class EnviaColaAcknowledge {

	public static void main(String[] args) {
		InitialContext contextoInicial = null;
		QueueSession sesion = null;
		try {
			
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
					"tcp://localhost:61616");

			Connection conexion = factory.createConnection();
			sesion = (QueueSession) conexion.createSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);

			Queue cola = sesion.createQueue("TestQueue");
			
			// Creamos una sesion de envio
			QueueSender enviaACola = sesion.createSender(cola);

			// ****************************************************************
			// Creamos un mensaje de texto
			TextMessage mensaje = sesion.createTextMessage();
			mensaje.setText("Esto es un mensaje");
			// Lo enviamos
			enviaACola.send(mensaje);
			System.out.println("Mensaje enviado: " + mensaje.getText());

			// ****************************************************************

			mensaje = sesion.createTextMessage();

			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\"?>");
			sb.append("<favoritos>");
			sb.append("<pagina valoracion=\"10\">");
			sb.append("<nombre>Soy Feliz - El canal de la mujer</nombre>");
			sb.append("<direccion>http://www.soyfeliz.org</direccion>");
			sb.append("</pagina>");
			sb.append("</favoritos>");
			mensaje.setText(sb.toString());
			// Lo enviamos
			enviaACola.send(mensaje);
			System.out.println("Mensaje enviado: " + mensaje.getText());

			// ****************************************************************

			MapMessage mapMessage = sesion.createMapMessage();

			mapMessage.setString("idCliente", "cu534564563");
			mapMessage.setBoolean("esDeudor", true);

			mapMessage.setDouble("deuda", 458485.43);
			System.out.println("Mensaje enviado: " + mapMessage.getMapNames());
			enviaACola.send(mapMessage);

			// ****************************************************************
			Persona persona = new Persona();
			persona.setNombre("Maria Marta");
			persona.setEdad(54);

			ObjectMessage objectMessage = sesion.createObjectMessage(persona);
			// objectMessage.setObject(persona);

			enviaACola.send(objectMessage);

			System.out.println("Mensaje enviado: " + objectMessage.getObject());

			// ****************************************************************

			BytesMessage bytesMessage = sesion.createBytesMessage();
			String textoEnBytes = "textoEnBytes";
			byte[] datos = textoEnBytes.getBytes();
			bytesMessage.writeBytes(datos);

			enviaACola.send(bytesMessage);
			System.out.println("Mensaje enviado: " + textoEnBytes);

			// Cerramos la conexion
			conexion.close();

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
