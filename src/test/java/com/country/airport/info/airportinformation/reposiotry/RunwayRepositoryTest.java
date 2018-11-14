package com.country.airport.info.airportinformation.reposiotry;


import com.country.airport.info.airportinformation.model.Runway;
import com.country.airport.info.airportinformation.repository.RunwayRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RunwayRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    RunwayRepository runwayRepository;

    @After
    public void cleanup() {
        this.testEntityManager.clear();
    }

    @Test
    public void testFindById() {
        Runway runway = runwayRepository.findById(270932);
        assertAll(
                ()->assertThat(runway.getId(), is(270932)),
                ()->assertThat(runway.getAirportRef(), is(6526)));
    }

    @Test
    public void testPersistAndFindById() {
        this.testEntityManager.persist(mockRunway());
        Runway runway = runwayRepository.findById(999);
        assertAll(
                ()->assertThat(runway.getId(), is(999)),
                ()->assertThat(runway.getAirportRef(), is(123)));
    }

    private Runway mockRunway() {
        return Runway.builder().id(999).airportRef(123).airportIdent("xyz").build();
    }

}
