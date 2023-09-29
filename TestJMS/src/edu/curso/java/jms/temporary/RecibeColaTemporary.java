package edu.curso.java.jms.temporary;

import java.util.Date;
import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class RecibeColaTemporary {
	public static void main(String args[]) {
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

						System.out
								.println("**************************************************************");
						QueueSender queueSender = sesion.createSender((Queue) m
								.getJMSReplyTo());

						System.out.println("Te respondo a tu pedido.....");
						TextMessage respuesta = sesion.createTextMessage();
						respuesta.setJMSCorrelationID(m.getJMSMessageID());
						respuesta.setText("Llego ok el pedido....");
						queueSender.send(respuesta);
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
