package edu.curso.java.jms;


import javax.jms.*;
import javax.naming.*;
import org.apache.activemq.ActiveMQConnectionFactory;


public class EnviaCola {

	public static void main(String[] args) {
		InitialContext contextoInicial = null;
		QueueSession session = null;
		try {
			
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		
			Connection conexion = factory.createConnection();
			session = (QueueSession) conexion.createSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			
			Queue cola = session.createQueue("TestQueue");

			QueueSender enviaACola = session.createSender(cola);
			
			
			//****************************************************************
			// Creamos un mensaje de texto
			TextMessage mensaje = session.createTextMessage();
			mensaje.setText("Esto es un mensaje");
			// Lo enviamos
			enviaACola.send(mensaje);
			System.out.println("Mensaje enviado: " + mensaje.getText());

			
			//****************************************************************
			
			mensaje = session.createTextMessage();
			
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\"?>");
			sb.append("<favoritos>");
			sb.append("<pagina valoracion=\"10\">");
			sb.append("<nombre>Soy Feliz - El canal de la mujer</nombre>");
			sb.append("<direccion>http://www.soyfeliz.org</direccion>");
			sb.append("</pagina>");
			sb.append("</favoritos>");
			mensaje.setText(sb.toString());
			// Lo enviamos
			enviaACola.send(mensaje);
			System.out.println("Mensaje enviado: " + mensaje.getText());
			
			//****************************************************************
			
			MapMessage mapMessage = session.createMapMessage();
			
			mapMessage.setString("idCliente", "cu534564563");
			mapMessage.setBoolean("esDeudor", true);
			
			mapMessage.setDouble("deuda", 458485.43);
			System.out.println("Mensaje enviado: " + mapMessage.getMapNames());
			enviaACola.send(mapMessage);
			
			//****************************************************************
			Persona persona = new Persona();
			persona.setNombre("Maria Marta");
			persona.setEdad(54);
			
			ObjectMessage objectMessage = session.createObjectMessage(persona);
			objectMessage.setObject(persona);
			
			enviaACola.send(objectMessage);
			
			System.out.println("Mensaje enviado: " + objectMessage.getObject());
			
			//****************************************************************
			
			BytesMessage bytesMessage = session.createBytesMessage();
			String textoEnBytes = "textoEnBytes";
			byte[] datos = textoEnBytes.getBytes();
			bytesMessage.writeBytes(datos);
			
			enviaACola.send(bytesMessage);
			System.out.println("Mensaje enviado: " + textoEnBytes);
			
			
			// Cerramos la conexion
			conexion.close();
		
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
	}

}
