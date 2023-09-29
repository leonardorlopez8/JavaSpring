package edu.curso.java.jms.persistence;

import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

import edu.curso.java.jms.Persona;

public class EnviaColaPersistence {

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

			QueueSender enviaACola = sesion.createSender(cola);

			// ****************************************************************
			// Creamos un mensaje de texto
			TextMessage mensaje = sesion.createTextMessage();
			mensaje.setText("Esto es un mensajexxxxxxx");
			// Lo enviamos

			int prioridad = 1; // muy baja....
			long tiempoDeVida = 1000; // 1000 = 1 segundo
			// si es = 0 (never expires)

			enviaACola.send(mensaje, DeliveryMode.NON_PERSISTENT, prioridad,
					tiempoDeVida);
			System.out.println("Mensaje enviado: " + mensaje.getText());

			// ****************************************************************

			// Cerramos la conexion
			conexion.close();

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
