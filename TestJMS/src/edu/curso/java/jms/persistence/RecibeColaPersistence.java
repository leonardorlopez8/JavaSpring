package edu.curso.java.jms.persistence;

import java.util.Date;
import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

import edu.curso.java.jms.Persona;

public class RecibeColaPersistence {
	public static void main (String args[]){
		InitialContext contextoInicial = null;
		QueueSession sesion = null;
		try {

			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
					"tcp://localhost:61616");

			Connection conexion = factory.createConnection();
			sesion = (QueueSession) conexion.createSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);

			Queue cola = sesion.createQueue("TestQueue");
			
			// Creamos una sesion de recepcion
			QueueReceiver recibeDeCola = sesion.createReceiver(cola);

			// Iniciamos la recepcion de mensajes
			conexion.start();
			
			
			
			
			while (true) {
				// Tomamos un mensaje de la cola, el 5 indica que esperara 5 milisegundo
				// Message mensaje= recibeDeCola.receive(5)
				
				Message mensaje= recibeDeCola.receive(5000);
				
				
				
				if (mensaje != null){
					
					System.out.println("ID: " +  mensaje.getJMSMessageID());
					if (mensaje instanceof TextMessage){
						// Lo mostramos
						TextMessage m = (TextMessage)mensaje;
						System.out.println("Recibido mensaje Text:  " + m.getText());
						System.out.println("Priority: " + m.getJMSPriority());
						System.out.println("Fecha del Msg: " + new Date(m.getJMSTimestamp()));
						System.out.println("Expiration: " + new Date(m.getJMSExpiration()));
						

						System.out.println("**************************************************************");
						
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
