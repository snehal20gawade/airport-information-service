package com.country.airport.info.airportinformation.repository;



import com.country.airport.info.airportinformation.model.Runway;
import org.springframework.data.repository.CrudRepository;

public interface RunwayRepository extends CrudRepository<Runway,Integer> {
    Runway findById(int id);
}
