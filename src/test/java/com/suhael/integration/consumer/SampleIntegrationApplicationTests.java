package com.suhael.integration.consumer;

import com.suhael.SpringbootApplication;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Basic integration tests for service demo application.
 *
 * @author Dave Syer
 * @author Andy Wilkinson
 */
public class SampleIntegrationApplicationTests {

    private static ConfigurableApplicationContext context;

    @BeforeClass
    public static void start() throws Exception {
        context = SpringApplication.run(SpringbootApplication.class);
    }

    @AfterClass
    public static void stop() {
        if (context != null) {
            context.close();
        }
    }

    @Test
    public void testVanillaExchange() throws Exception {
        assertTrue(true);
    }
}