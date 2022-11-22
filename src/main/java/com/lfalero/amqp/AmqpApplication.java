package com.lfalero.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

//@EnableJms
@SpringBootApplication
public class AmqpApplication implements CommandLineRunner {

//    @Autowired
//    private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AmqpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//sendMessage("Hello World!");
	}

//	public void sendMessage(String text) {
//		System.out.println(String.format("Sending '%s'", text));
//		this.jmsTemplate.convertAndSend("registrar-solicitud-credito", text);
//	}
//
//	@JmsListener(destination = "registrar-solicitud-credito")
//	public void receiveMessage(String text) {
//		System.out.println(String.format("Received '%s'", text));
//	}
}
