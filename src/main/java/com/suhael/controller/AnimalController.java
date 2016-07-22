package com.suhael.controller;

import com.suhael.repository.animal.Animal;
import com.suhael.repository.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showSimpleResponse(Model model){
        List<Animal> animals = animalRepository.findAll();
        model.addAttribute("animals", animals);
        return "animal";
    }
}
