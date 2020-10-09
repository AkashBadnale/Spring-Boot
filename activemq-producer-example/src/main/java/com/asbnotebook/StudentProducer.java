package com.asbnotebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendTo(String destination, Student student) {
		jmsTemplate.convertAndSend(destination, student);
		System.out.println("Producer> Message Sent");
	}
}