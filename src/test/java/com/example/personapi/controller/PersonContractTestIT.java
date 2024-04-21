package com.example.personapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.HttpEntity;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.personapi.model.Person;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback
@Disabled
public class PersonContractTestIT {
	
    @Autowired
    private MockMvc mockMvc;
    
    private static final String URL_MOCK_SERVER = "http://localhost:8080/rest/Person+API/1.0.0/people";
    
    @Test
    public void getAllPersonTest() throws Exception {
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	ResponseEntity<List<Person>> response = restTemplate.exchange(
    			URL_MOCK_SERVER,
    		    HttpMethod.GET,
    		    null,
    		    new ParameterizedTypeReference<List<Person>>() {}
    		);
    	
        mockMvc.perform(get("/people")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(response.getStatusCode().value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void createPersonTest() throws Exception {
    	
    	RestTemplate restTemplate = new RestTemplate();
    	String dataNewPerson = "{\"dni\":\"45678901\",\"name\":\"Ricardo\",\"surname\":\"Sanchez\",\"address\":\"Su nueva casa 678\",\"birthDate\":\"1988-01-01\"}";
    	HttpEntity<String> requestEntity = new HttpEntity<>(dataNewPerson);
		ResponseEntity<String> responseMock = restTemplate.exchange(URL_MOCK_SERVER, HttpMethod.POST, requestEntity, String.class);
		
        mockMvc.perform(post("/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dataNewPerson))
                .andExpect(status().is(responseMock.getStatusCode().value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }
}