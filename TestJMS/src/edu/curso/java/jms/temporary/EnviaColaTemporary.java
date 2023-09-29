package edu.curso.java.jms.temporary;

import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class EnviaColaTemporary implements MessageListener {

	public static void main(String[] args) {
		new EnviaColaTemporary();
	}

	public EnviaColaTemporary() {
		InitialContext contextoInicial = null;
		QueueSession sesion = null;
		try {
			
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
					"tcp://localhost:61616");

			// Creamos la conexion y la sesion
			Connection conexion = factory.createConnection();
			sesion = (QueueSession) conexion.createSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);

			Queue cola = sesion.createQueue("TestQueue");
		
			// Creamos una sesion de envio
			QueueSender enviaACola = sesion.createSender(cola);

			// Creamos una cola temporal....

			TemporaryQueue colaRespuesta = sesion.createTemporaryQueue();
			QueueReceiver queueReceiver = sesion.createReceiver(colaRespuesta);
			queueReceiver.setMessageListener(this);

			// Creamos un mensaje de texto
			TextMessage mensaje = sesion.createTextMessage();
			// Cola de respuesta
			mensaje.setJMSReplyTo(colaRespuesta);
			mensaje.setText("Esto es un mensaje.....");
			// Lo enviamos
			enviaACola.send(mensaje);
			System.out.println("Mensaje enviado: " + mensaje.getText());
			System.out.println("Espero la respuesta.....");

			// Iniciamos la recepcion de mensajes
			conexion.start();

			// Cerramos la conexion
			// conexion.close();

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	public void onMessage(Message mensaje) {
		try {
			// Si es un mensaje de texto, lo mostramos
			if (mensaje instanceof TextMessage) {
				TextMessage m = (TextMessage) mensaje;
				System.out.println("Mensaje recibido: " + m.getText());
				System.out.println("ID: " + m.getJMSMessageID());
				System.out.println("CorrelationID: " + m.getJMSCorrelationID());

			}
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
