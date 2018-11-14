package com.country.airport.info.airportinformation.controller;


import com.country.airport.info.airportinformation.model.Airport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 8089)
public class AirportControllerTest {

    @Autowired
    private AirportController service;
    @Autowired
    ObjectMapper objectMapper;

    RestTemplate restTemplate;
    ResponseEntity response;

    private static final String APPLICATION_JSON = "application/json";

    @Before
    public void setup() throws Exception {
        restTemplate = new RestTemplate();
        response = null;
    }

    // Using the WireMock APIs in the normal way:
    @Test
    public void testGetAirports() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        givenIExpectToCallGetAirports();
        ResponseEntity<Airport[]> responseEntity = restTemplate.getForEntity("http://localhost:8089/airports/country/IN", Airport[].class);
        assertThat("Verify Status Code", responseEntity.getStatusCode().equals(HttpStatus.OK));
        List<Airport> airports = Arrays.asList(responseEntity.getBody());
        assertThat(airports, Is.is(expectedAirports()));
    }

    private List<Airport> expectedAirports() {
        return Arrays.asList(Airport.builder().id(1234).ident("ABCD").type("heliport").name("Lowell Field")
                .isoCountry("XYZ").build());

    }

    // Stubbing WireMock
    private void givenIExpectToCallGetAirports() throws JsonProcessingException {
        stubFor(get(urlEqualTo("/airports/country/IN"))
                .willReturn(aResponse().withStatus(200).
                        withHeader("Content-Type", APPLICATION_JSON).
                        withBody(objectMapper.writeValueAsString(expectedAirports()))));
    }
}
