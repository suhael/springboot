package com.suhael.service;

import com.suhael.repository.PersonRepository;
import com.suhael.repository.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> showAllPeople(){
        List<Person> people = personRepository.findAll();
        return people;
    }
}
