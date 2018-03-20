package com.suhael.repository;

import com.suhael.SpringbootApplication;
import com.suhael.model.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
@TestPropertySource("/application-it.properties")
public class CustomerRepositoryIT {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testList() throws Exception {
//        customerRepository.save(new Customer("Jack", "Bauer"));
//        customerRepository.save(new Customer("Chloe", "O'Brian"));
//        customerRepository.save(new Customer("Kim", "Bauer"));
//        customerRepository.save(new Customer("David", "Palmer"));
//        customerRepository.save(new Customer("Michelle", "Dessler"));

        List<Customer> results = customerRepository.findByLastName("Bauer");
        assertThat(results.size(), is(greaterThan(0)));
    }

}