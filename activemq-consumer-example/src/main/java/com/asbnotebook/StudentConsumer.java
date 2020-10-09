package com.asbnotebook;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class StudentConsumer {

	@JmsListener(destination = "${activemq.destination}", containerFactory = "jmsFactory")
	public void processToDo(Student student) {
		System.out.println("Consumer> " + student);
	}
}