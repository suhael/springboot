package com.suhael;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootApplication.class)
@WebIntegrationTest
public class IntegrationTest {

    @Test(expected = HttpClientErrorException.class)
    public void pageNotFound() {
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://localhost:8080/bogusPage", String.class);
            fail("should result in HTTP 404");
        } catch (HttpClientErrorException ex) {
            assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
            throw ex;
        }
    }
}
