package com.example.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.personapi.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
}