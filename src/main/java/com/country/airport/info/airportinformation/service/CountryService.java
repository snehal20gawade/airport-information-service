package com.country.airport.info.airportinformation.service;



import com.country.airport.info.airportinformation.exception.AirportServiceClientException;
import com.country.airport.info.airportinformation.model.Airport;
import com.country.airport.info.airportinformation.model.Country;

import java.util.List;


public interface CountryService {
    Country getCountry(String countryCode) throws AirportServiceClientException;
    Country getCountryByNameOrCode(String countryCodeOrName) throws AirportServiceClientException;
    List<Airport> getAirports(String CountryName)throws AirportServiceClientException;
}
