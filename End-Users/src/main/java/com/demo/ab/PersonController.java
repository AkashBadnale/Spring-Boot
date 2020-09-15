package com.demo.ab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@ApiOperation(value = "Create New User")
	@PostMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> createPerson(@RequestBody PersonDto person) {
		PersonDto savedPerson = personService.createPerson(person);
		String res;
		if (savedPerson != null) {
			res = "Registration Successfull.";
		} else {
			res = "Sorry ! could not register your information. Please try again.";
		}
		return ResponseEntity.ok(res);
	}

	@ApiOperation(value = "Get User")
	@GetMapping(value = "/person/{email}", produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> getPerson(@PathVariable String email) {
		PersonDto savedPerson = personService.getPerson(email);
		String res;
		if (savedPerson != null) {
			res = savedPerson.getFirstName() + " " + savedPerson.getLastName() 
			+ ", email : " + savedPerson.getEmail()+ ", Mo : " + savedPerson.getMobileNumber();
		} else {
			res = "Sorry ! could not find your info, Please try again.";
		}
		return ResponseEntity.ok(res);
	}
}
