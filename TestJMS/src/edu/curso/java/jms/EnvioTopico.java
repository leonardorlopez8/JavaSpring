package edu.curso.java.jms;

import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class EnvioTopico {
	public static void main (String args[]){
		InitialContext contextoInicial = null;
		TopicSession session = null;
		try {
			
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			Connection conexion = factory.createConnection();
			
			session = (TopicSession) conexion.createSession(false,TopicSession.AUTO_ACKNOWLEDGE);
		
			Topic asunto = (Topic) session.createTopic("TestTopic");

			// Creamos una sesion de envio
			TopicPublisher enviaAAsunto = session.createPublisher(asunto);
			// Creamos un mensaje
			TextMessage mensaje = session.createTextMessage();
			mensaje.setText("Que miran....");
			// Lo enviamos
			enviaAAsunto.publish(mensaje);
			System.out.println("Mensaje enviado: " + mensaje.getText());
			// Cerramos la conexion
			conexion.close();
	
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}

