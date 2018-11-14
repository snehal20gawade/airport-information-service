package com.country.airport.info.airportinformation.controller;


import com.country.airport.info.airportinformation.model.Runway;
import com.country.airport.info.airportinformation.service.AirportService;
import com.country.airport.info.airportinformation.service.RunwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/runways")
public class RunwayController {

    private AirportService airportService;
    private RunwayService runwayService;

    @Autowired
    public RunwayController(AirportService airportService, RunwayService runwayService) {
        this.airportService = airportService;
        this.runwayService = runwayService;
    }


    @GetMapping("/{runwayId}")
    public ResponseEntity<Runway> findRunwayById(@PathVariable int runwayId) {
        return ResponseEntity.ok(runwayService.getRunway(runwayId));
    }
}
