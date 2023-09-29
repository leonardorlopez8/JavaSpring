package edu.curso.java.jms.selectors;

import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class EnviaCola {

	public static void main(String[] args) {
		InitialContext contextoInicial = null;
		QueueSession sesion = null;
		try {
			// Conseguimos de la JNDI los objetos administrados

			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
					"tcp://localhost:61616");

			Connection conexion = factory.createConnection();
			sesion = (QueueSession) conexion.createSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);

			Queue cola = sesion.createQueue("TestQueue");
			
			// Creamos una sesion de envio
			QueueSender enviaACola = sesion.createSender(cola);
			// Creamos una sesion de envio

			// ****************************************************************
			// Creamos un mensaje de texto
			TextMessage mensaje = sesion.createTextMessage();
			mensaje.setStringProperty("grupo", "ventas");
			mensaje.setLongProperty("idSuc", 4507);
			mensaje.setText("Esto es un mensaje para ventas en pero para sucursal 4507");
			// Lo enviamos
			enviaACola.send(mensaje);
			System.out.println("Mensaje enviado: " + mensaje.getText());

			// ****************************************************************
			// Creamos un mensaje de texto
			mensaje = sesion.createTextMessage();
			mensaje.setStringProperty("grupo", "reclamos");
			mensaje.setText("Esto es un mensaje para reclamos");
			// Lo enviamos
			enviaACola.send(mensaje);
			System.out.println("Mensaje enviado: " + mensaje.getText());

			// ****************************************************************

			// Cerramos la conexion
			conexion.close();

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
