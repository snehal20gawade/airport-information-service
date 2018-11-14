package com.country.airport.info.airportinformation.repository;


import com.country.airport.info.airportinformation.model.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport,Integer> {
     Airport findById(int id);
}
