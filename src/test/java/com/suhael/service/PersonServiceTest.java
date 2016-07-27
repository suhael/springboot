package com.suhael.service;

import com.suhael.SpringbootApplication;
import com.suhael.repository.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringbootApplication.class)
public class PersonServiceTest {

    @Autowired
    private PersonServiceImpl personService;

    @Test
    public void testPersonService() {
        List<Person> people = personService.showAllPeople();
        assertEquals(people.size(), 2);
    }


}
