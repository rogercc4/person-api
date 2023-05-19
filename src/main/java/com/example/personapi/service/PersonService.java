package com.example.personapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personapi.model.Person;
import com.example.personapi.repository.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> updatePerson(Long id, Person updatedPerson) {
        return personRepository.findById(id).map(person -> {
            person.setDni(updatedPerson.getDni());
            person.setName(updatedPerson.getName());
            person.setSurname(updatedPerson.getSurname());
            person.setAddress(updatedPerson.getAddress());
            person.setBirthDate(updatedPerson.getBirthDate());
            return personRepository.save(person);
        });
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
