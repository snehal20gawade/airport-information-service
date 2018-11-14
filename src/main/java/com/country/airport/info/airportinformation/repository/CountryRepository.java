package com.country.airport.info.airportinformation.repository;



import com.country.airport.info.airportinformation.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
    Country findById(int id);
    Country findByCode(String code);
    Country findByCodeOrName(String code, String name);
}
