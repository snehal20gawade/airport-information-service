package com.country.airport.info.airportinformation.reposiotry;


import com.country.airport.info.airportinformation.model.Airport;
import com.country.airport.info.airportinformation.model.Runway;
import com.country.airport.info.airportinformation.repository.AirportRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AirportRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    AirportRepository airportRepository;

    @After
    public void cleanup() {
        this.testEntityManager.clear();
    }

    @Test
    public void testFindById() {
        Airport airport = airportRepository.findById(6525);
        assertThat(airport.getName(), is("Epps Airpark"));
        assertThat(airport.getIsoCountry(), is("US"));
    }

    @Test
    public void testPersistAndFindById() {
        this.testEntityManager.persist(mockAirports());
        Airport airport = airportRepository.findById(123);
        assertAll(
                ()->assertThat(airport.getName(), is("Test Airport")),
                ()->assertThat(airport.getIsoCountry(), is("US")));
    }

    private Airport mockAirports() {
        return Airport.builder()
                .id(123)
                .name("Test Airport")
                .isoCountry("US")
                .type("Small")
                .runways(Arrays.asList(Runway.builder().id(999).airportRef(123).airportIdent("xyz").build()))
                .build();
    }


}
