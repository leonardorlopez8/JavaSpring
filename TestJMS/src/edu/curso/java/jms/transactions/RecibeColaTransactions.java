package edu.curso.java.jms.transactions;

import java.util.Date;
import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

import edu.curso.java.jms.Persona;

public class RecibeColaTransactions {
	public static void main(String args[]) {
		InitialContext contextoInicial = null;
		QueueSession sesion = null;
		try {
			
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
					"tcp://localhost:61616");

			
			Connection conexion = factory.createConnection();
			sesion = (QueueSession) conexion.createSession(true,
					QueueSession.AUTO_ACKNOWLEDGE);

			Queue cola = sesion.createQueue("TestQueue");
			// Creamos la conexion y la sesion

			// Creamos una sesion de envio
			QueueSender enviaACola = sesion.createSender(cola);
			// Creamos una sesion de recepcion
			QueueReceiver recibeDeCola = sesion.createReceiver(cola);

			// Iniciamos la recepcion de mensajes
			conexion.start();

			while (true) {
				
				Message mensaje= recibeDeCola.receive(5000);

				if (mensaje != null) {

					System.out.println("ID: " + mensaje.getJMSMessageID());
					if (mensaje instanceof TextMessage) {
						// Lo mostramos
						TextMessage m = (TextMessage) mensaje;
						System.out.println("Recibido mensaje Text:  "
								+ m.getText());
						System.out.println("Priority: " + m.getJMSPriority());
						System.out.println("Fecha del Msg: "
								+ new Date(m.getJMSTimestamp()));
						System.out.println("Expiration: "
								+ new Date(m.getJMSExpiration()));

						System.out
								.println("**************************************************************");

					}

				} else {
					System.out.println("No hay mas mensajes");
					break;
				}
			}

			sesion.commit();
			// sesion.rollback();

			// Cerramos la conexion
			conexion.close();

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
