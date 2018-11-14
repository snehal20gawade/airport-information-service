package com.country.airport.info.airportinformation.service;


import com.country.airport.info.airportinformation.exception.AirportServiceClientException;
import com.country.airport.info.airportinformation.model.Airport;

public interface AirportService {
	
	 Airport getAirport(int id) throws AirportServiceClientException;

}
