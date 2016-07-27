package com.suhael.controller;

import com.suhael.repository.PersonRepository;
import com.suhael.repository.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    public PersonController() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addPerson(Person person){
        personRepository.save(person);
        return "redirect:/person";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showAllPeople(Model model){
        List<Person> people = personRepository.findAll();
        model.addAttribute("people", people);
        return "person";
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    public String showPerson(@PathVariable("personId") Long personId, Model model){
        Person person = personRepository.findOne(personId);
        model.addAttribute("person", person);
        return "update";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updatePerson(Person person){
        personRepository.save(person);
        return "redirect:/person";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deletePersonById(Long id){
        personRepository.delete(id);
        return "redirect:/person";
    }


}
