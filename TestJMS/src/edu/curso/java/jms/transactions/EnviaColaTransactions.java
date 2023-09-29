package edu.curso.java.jms.transactions;

import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

import edu.curso.java.jms.Persona;

public class EnviaColaTransactions {

	public static void main(String[] args) {
		InitialContext contextoInicial = null;
		QueueSession sesion = null;
		try {

			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
					"tcp://localhost:61616");

			Connection conexion = factory.createConnection();
			sesion = (QueueSession) conexion.createSession(true,
					QueueSession.AUTO_ACKNOWLEDGE);

			Queue cola = sesion.createQueue("TestQueue");

			// Creamos una sesion de envio
			QueueSender enviaACola = sesion.createSender(cola);

			for (int i = 0; i < 20; i++) {
				TextMessage mensaje = sesion.createTextMessage();
				mensaje.setText("Esto es un mensaje " + i);
				enviaACola.send(mensaje);
				System.out.println("Mensaje enviado: " + mensaje.getText());
			}

			// sesion.commit();
			sesion.rollback();

			// ****************************************************************

			// Cerramos la conexion
			conexion.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
