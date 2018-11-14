package com.country.airport.info.airportinformation.service;


import com.country.airport.info.airportinformation.exception.AirportServiceClientException;
import com.country.airport.info.airportinformation.model.Airport;
import com.country.airport.info.airportinformation.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {
    private AirportRepository airportRepository;

    AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport getAirport(int id) throws AirportServiceClientException {
        return airportRepository.findById(id);
    }
}
