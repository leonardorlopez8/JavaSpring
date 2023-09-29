package edu.curso.java.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SoyUnTask {


	@Scheduled(fixedRate=50000) // En 50 seg
	public void testScheduledNormal1() {
		System.out.println("ejecutando testScheduledNormal - 1");
	}
	
	@Scheduled(cron = "0 0 3 * * ?") //Todos los dias a las 3 AM
	public void testScheduledNormal2() {
		System.out.println("ejecutando testScheduledNormal - 2");
	}
	
	
	@Async
	public void testAsync() {
		System.out.println("ejecutando testAsync");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("soy un hilo y no te quiero esperar...");
	}
}
