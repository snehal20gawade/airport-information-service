package com.country.airport.info.airportinformation.reposiotry;


import com.country.airport.info.airportinformation.model.Country;
import com.country.airport.info.airportinformation.repository.CountryRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    CountryRepository countryRepository;

    @After
    public void cleanup() {
        this.testEntityManager.clear();
    }

    @Test
    public void testFindByCode() {
        Country country = countryRepository.findByCode("IN");
        assertThat(country.getName(), is("India"));
    }

    @Test
    public void testFindByCodeOrName() {
        Country country = countryRepository.findByCodeOrName("NL", "Netherlands");
        Assertions.assertAll(
                () -> assertThat(country.getName(), is("Netherlands")),
                () -> assertThat(country.getCode(), is("NL")));
    }

    @Test
    public void testPersistAndFindByCodeOrName() {
        this.testEntityManager.persist(mockCountry());
        Country country = countryRepository.findByCodeOrName("AB", "TestCountry");

        Assertions.assertAll(
                () -> assertThat(country.getId(), is(99999)),
                () -> assertThat(country.getCode(), is("AB")));
    }

    private Country mockCountry() {
        return Country.builder().id(99999).code("AB").name("TestCountry").continent("EU").build();
    }


}
