package com.country.airport.info.airportinformation.service;

import com.country.airport.info.airportinformation.exception.AirportServiceClientException;
import com.country.airport.info.airportinformation.model.Airport;
import com.country.airport.info.airportinformation.model.Country;
import com.country.airport.info.airportinformation.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository)
    {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country getCountry(String countryCode) throws AirportServiceClientException {
        if (StringUtils.isEmpty(countryCode)) {
            throw new AirportServiceClientException("Missing required parameter!");
        }
        Country country = countryRepository.findByCode(countryCode);
        if (country == null) {
            throw new AirportServiceClientException("Country : " + countryCode + ", does not exist.");
        }
        return country;
    }

    @Override
    @Cacheable(value = "airports")
    public List<Airport> getAirports(String countryName) throws AirportServiceClientException {
        return getCountryByNameOrCode(countryName).getAirports();
    }

    @Override
    @Cacheable(value = "country")
    public Country getCountryByNameOrCode(String countryCodeORName) throws AirportServiceClientException {
        if (StringUtils.isEmpty(countryCodeORName)) {
            throw new AirportServiceClientException("Missing required parameter!");
        }
        Country country = countryRepository.findByCodeOrName(countryCodeORName, countryCodeORName);
        if (country == null) {
            throw new AirportServiceClientException("Country : " + countryCodeORName + ", does not exist.");
        }
        return country;
    }
}
