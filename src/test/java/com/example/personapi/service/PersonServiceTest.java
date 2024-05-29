package com.example.personapi.service;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.personapi.model.Person;
import com.example.personapi.repository.PersonRepository;

@ExtendWith(MockitoExtension.class) 
public class PersonServiceTest {
	
	@InjectMocks
	PersonService personService;
	
	@Mock
	PersonRepository personRepository;
	
	@Test
	void checkResultWhenGetAllPeople() {
		List<Person> persons = new java.util.ArrayList<>();
		Person person = new Person();
		person.setAddress("Address");
		person.setBirthDate(new java.util.Date());
		person.setDni("12345678");
		person.setId(1L);
		person.setName("Name");
		person.setSurname("Surname");
		persons.add(person);
		/** esto es un nuevo comentario**/
		/** Otro comentario para realizar pruebas**/
		
		when(this.personRepository.findAll()).thenReturn(persons);
		
		List<Person> allPeople = this.personService.getAllPeople();
		
		Assertions.assertAll(
						() -> Assertions.assertNotNull(allPeople),
						() -> Assertions.assertFalse(allPeople.isEmpty()), 
						() -> Assertions.assertEquals(person.getAddress(), allPeople.get(0).getAddress())
				);	
		
	}
	
	

}
