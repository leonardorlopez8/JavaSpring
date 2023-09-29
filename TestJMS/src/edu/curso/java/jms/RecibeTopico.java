package edu.curso.java.jms;

import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class RecibeTopico implements MessageListener{
	
	public static void main (String args[]){
		RecibeTopico recibeTopico = new RecibeTopico();
		recibeTopico.suscribe();
	}
	
	public void suscribe(){
		InitialContext contextoInicial = null;
		TopicSession session = null;
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			Connection conexion = factory.createConnection();
			
			
			session = (TopicSession) conexion.createSession(false,TopicSession.AUTO_ACKNOWLEDGE);
		
			Topic asunto = (Topic) session.createTopic("TestTopic");

			TopicSubscriber suscrito = session.createSubscriber(asunto);
			
			
			// Añadimos nuestro listener para recibir mensajes
			suscrito.setMessageListener(this);
			// Iniciamos la recepcion
			conexion.start();
			System.out.println("Esperando algo......");
			
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//conexion.stop();
			//conexion.close();

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void onMessage(Message mensaje){
		// Se recibe un mensaje
		try{
			// Si es un mensaje de texto, lo mostramos
			if (mensaje instanceof TextMessage){
				TextMessage m = (TextMessage)mensaje;
				System.out.println("Mensaje recibido: " + m.getText());
			}
		} catch (JMSException e){
			e.printStackTrace();
		}
	}
	
}
