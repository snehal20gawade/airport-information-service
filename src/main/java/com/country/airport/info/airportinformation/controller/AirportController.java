package com.country.airport.info.airportinformation.controller;

import com.country.airport.info.airportinformation.exception.AirportServiceClientException;
import com.country.airport.info.airportinformation.model.Airport;
import com.country.airport.info.airportinformation.model.Runway;
import com.country.airport.info.airportinformation.service.AirportService;
import com.country.airport.info.airportinformation.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/airports")
public class AirportController {

    private CountryService countryService;
    private AirportService airportService;

    @Autowired
    public AirportController(CountryService countryService, AirportService airportService) {
        this.countryService = countryService;
        this.airportService = airportService;
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<Airport>> findAirportByCountryId(@PathVariable String countryId) {
        ResponseEntity<List<Airport>> response;
        try {
            response = new ResponseEntity(countryService.getAirports(countryId), HttpStatus.OK);
        } catch (AirportServiceClientException e) {
            response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/runways/{airportId}")
    public ResponseEntity<List<Runway>> getAirportRunways(@PathVariable int airportId) {
        ResponseEntity<List<Runway>> response;
        try {
            response = new ResponseEntity(airportService.getAirport(airportId).getRunways(), HttpStatus.OK);
        } catch (AirportServiceClientException e) {
            response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;

    }

}
