package com.country.airport.info.airportinformation.service;


import com.country.airport.info.airportinformation.model.Runway;
import com.country.airport.info.airportinformation.repository.RunwayRepository;
import org.springframework.stereotype.Service;

@Service
public class RunwayServiceImpl implements RunwayService {

    private RunwayRepository runwayRepository;

    RunwayServiceImpl(RunwayRepository runwayRepository) {
        this.runwayRepository = runwayRepository;
    }

    @Override
    public Runway getRunway(int id) {
        return runwayRepository.findById(id);
    }

}
