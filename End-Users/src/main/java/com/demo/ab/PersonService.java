package com.demo.ab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public PersonDto createPerson(PersonDto personDto) {
		Person newPerson = personDto.personDtoToEntity(personDto);
		Person savedPerson = personRepository.save(newPerson);
		PersonDto person = savedPerson.personEntityToDto(savedPerson);
		return person;
	}
	
	public PersonDto getPerson(String email) {
		Person savedPerson = personRepository.findByEmail(email);
		PersonDto person = savedPerson.personEntityToDto(savedPerson);
		return person;
	}
}
