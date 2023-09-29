package edu.curso.java.jms;

import java.util.Date;
import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class RecibeCola {
	public static void main (String args[]){
		InitialContext contextoInicial = null;
		QueueSession session = null;
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			Connection conexion = factory.createConnection();
			
			
			
			session = (QueueSession) conexion.createSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			
			Queue cola = session.createQueue("TestQueue");
			
			// Creamos una sesion de recepcion
			QueueReceiver recibeDeCola = session.createReceiver(cola);

			// Iniciamos la recepcion de mensajes
			conexion.start();
			
			
			
			
			while (true) {


				Message mensaje= recibeDeCola.receive(5000);
				
				if (mensaje != null){
					System.out.println("ID: " +  mensaje.getJMSMessageID());
					if (mensaje instanceof TextMessage){
						// Lo mostramos
						TextMessage m = (TextMessage)mensaje;
						System.out.println("Recibido mensaje Text:  " + m.getText());
					
						System.out.println("Priority: " + m.getJMSPriority());
						System.out.println("Fecha del Msg: " + new Date(m.getJMSTimestamp()));

						System.out.println("**************************************************************");
						
					} else if (mensaje instanceof ObjectMessage){
						ObjectMessage m = (ObjectMessage)mensaje;
						System.out.println("Recibido mensaje Obj: " + m.getObject().getClass().getName());
						Persona persona = (Persona) m.getObject();
						System.out.println("Nombre de la persona : " + persona.getNombre());
						System.out.println("Edad : " + persona.getEdad());
						
						System.out.println("**************************************************************");
						
					} else if (mensaje instanceof BytesMessage){
						BytesMessage m = (BytesMessage)mensaje;
						long cantidadDeBytes = m.getBodyLength();
						System.out.println("Recibido mensaje Bytes cantidad: " + cantidadDeBytes);
						
						byte datos[] = new byte[(int)cantidadDeBytes]; 
						m.readBytes(datos);
						String texto = new String(datos);
						System.out.println("Recibido mensaje Bytes: " + texto);
						
						System.out.println("**************************************************************");
					}  else if (mensaje instanceof MapMessage){
						MapMessage m = (MapMessage)mensaje;
						
						String idCliente = m .getString("idCliente");
						boolean esDeudor = m .getBoolean("esDeudor");
						double deuda = m .getDouble("deuda");
						
						System.out.println("Recibido mensaje Map:");
						System.out.println("idCliente " + idCliente);
						System.out.println("esDeudor " + esDeudor);
						System.out.println("deuda " + deuda);
						
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
