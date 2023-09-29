package edu.curso.java.jms.selectors;

import java.util.Date;
import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class RecibeCola {
	public static void main(String args[]) {
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
			// Creamos la conexion y la sesion

			// Creamos una sesion de envio
			QueueSender enviaACola = sesion.createSender(cola);

			/*
			 * PropertySelector Costo > 100.00 TimeStamp BETWEEN 1057576423231
			 * AND 10575788993265 Delivery Mode PERSISTENT Priority >= 5 AND <=
			 * 8 Message ID > WMBRK123456 Redelivered FALSE Correlation ID =
			 * WMBRKABCDEFG
			 */

			// Creamos una sesion de recepcion con un selector
			QueueReceiver recibeDeCola = sesion.createReceiver(cola,
					"grupo = 'ventas'");
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

						System.out
								.println("**************************************************************");

					}
				} else {
					System.out.println("No hay mas mensajes");
					break;
				}
			}
			// Cerramos la conexion
			conexion.close();

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
