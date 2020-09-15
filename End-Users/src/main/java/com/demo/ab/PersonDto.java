package com.demo.ab;

public class PersonDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long whatsappNumber;
    private Long mobileNumber;

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
    
	public Person personDtoToEntity(PersonDto personDto) {
		Person person = new Person();
		person.setEmail(personDto.getEmail());
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setMobileNumber(personDto.getMobileNumber());
		person.setPassword(personDto.getPassword());
		person.setWhatsappNumber(personDto.getWhatsappNumber());
		return person;
	}
}
