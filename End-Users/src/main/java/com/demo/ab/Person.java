package com.demo.ab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;


@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String firstName;
	
	@NonNull
	private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	@NonNull  
	private String email;
	
	@NonNull
	private String password;
	
	@NonNull
    private Long whatsappNumber;
    
	@NonNull
    private Long mobileNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(Long whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public PersonDto personEntityToDto(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setEmail(person.getEmail());
		personDto.setFirstName(person.getFirstName());
		personDto.setLastName(person.getLastName());
		personDto.setMobileNumber(person.getMobileNumber());
		personDto.setPassword(person.getPassword());
		personDto.setWhatsappNumber(person.getWhatsappNumber());
		return personDto;
	}
}
