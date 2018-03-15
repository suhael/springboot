package com.suhael.controller;

import com.suhael.SpringbootApplication;
import com.suhael.model.Customer;
import com.suhael.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/get")
    public List<Customer> get() {
//        return repository.findByLastName("Mayer");
        return repository.findAll();
    }

    @GetMapping("/save")
    public void save() {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : repository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        for (Customer bauer : repository.findByLastName("Bauer")) {
            log.info(bauer.toString());
        }
        log.info("");
    }
}
