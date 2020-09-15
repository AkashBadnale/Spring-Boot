package com.demo.ab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long>{

	@Query(value = "SELECT * FROM PERSON where EMAIL=:email", nativeQuery=true)
	Person findByEmail(String email);
}
