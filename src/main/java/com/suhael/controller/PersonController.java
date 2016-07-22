package com.suhael.controller;

import com.suhael.repository.PersonRepository;
import com.suhael.repository.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(method = RequestMethod.GET)
    public String showSimpleResponse(Model model){
        List<Person> people = personRepository.findAll();
        model.addAttribute("people", people);
        return "person";
    }
}
