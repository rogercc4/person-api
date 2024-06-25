package com.example.personapi.controller;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.context.DynamicPropertySource;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Testcontainers
public class PersonApiIT {

    @LocalServerPort
    private int port;

    @Container
    private static final MySQLContainer MYSQL_CONTAINER = new MySQLContainer<>("mysql:8.0.30")
            .withDatabaseName("testcontainer")
            .withUsername("test")
            .withPassword("test")
            .withInitScript("mysql/init-test-data.sql");

    @DynamicPropertySource
    private static void setupProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", MYSQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
    }

    @BeforeEach
    void setup() {
        System.setProperty("karate.server.port", String.valueOf(this.port));
    }

    @Test
    void checkThanMySQLContainerIsRunning() {
        Assertions.assertTrue(MYSQL_CONTAINER.isRunning());
    }

    @Test
    void findPersonsWhenExists() {
        Results results = Runner.path("classpath:karate/feature").parallel(2);
        Assertions.assertEquals(0, results.getFailCount());
    }
}