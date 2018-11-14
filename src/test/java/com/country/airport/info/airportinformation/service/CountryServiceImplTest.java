package com.country.airport.info.airportinformation.service;


import com.country.airport.info.airportinformation.exception.AirportServiceClientException;
import com.country.airport.info.airportinformation.model.Airport;
import com.country.airport.info.airportinformation.model.Country;
import com.country.airport.info.airportinformation.model.Runway;
import com.country.airport.info.airportinformation.repository.CountryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {
    @Mock
    CountryRepository countryRepository;
    @Mock
    Country country;
    @Mock
    Airport airport;

    private CountryServiceImpl countryService;

    @Before
    public void setUp() {
        countryService = new CountryServiceImpl(countryRepository);
    }

    @Test
    public void testGetCountry() throws Exception {
        when(countryRepository.findByCode("NL")).thenReturn(mockCountry(99999, "NL", "Netherlands", "EU"));
        Country country = countryService.getCountry("NL");
        assertAll(
                () -> assertThat(country.getId()).isEqualTo(99999),
                () -> assertThat(country.getCode()).isEqualTo("NL"),
                () -> assertThat(country.getName()).isEqualTo("Netherlands"));
    }

    @Test
    public void testGetAirports() throws AirportServiceClientException {
        when(countryRepository.findByCodeOrName("US", "US")).thenReturn(mockCountryWithAirports());
        List<Airport> airports = countryService.getAirports("US");
        assertThat(airports).extracting("id", "isoCountry", "name")
                .containsExactly(tuple(123, "US", "Test Airport"), tuple(555, "US", "Test Airport1"));
    }

    @Test
    public void testGetCountryByNameOrCodeException() {
        when(countryRepository.findByCodeOrName("YZ", "YZ")).thenReturn(null);
        try {
            countryService.getCountryByNameOrCode("YZ");
        } catch (AirportServiceClientException e) {
            assertThat(e).isInstanceOf(AirportServiceClientException.class).extracting("message").containsExactly("Country : YZ, does not exist.");
        }
    }



    private Country mockCountry(int id, String code, String name, String continent) {
        return Country.builder().id(id).code(code).name(name).continent(continent).build();
    }

    private Country mockCountryWithAirports() {
        return Country.builder().id(99999).code("US").name("United States").continent("NA")
                .airports(mockAirports()).build();
    }

    private List<Airport> mockAirports() {
        return Arrays.asList(Airport.builder()
                        .id(123)
                        .name("Test Airport")
                        .isoCountry("US")
                        .type("Small")
                        .runways(Arrays.asList(Runway.builder().id(999).airportRef(123).airportIdent("xyz").build()))
                        .build(),
                Airport.builder()
                        .id(555)
                        .name("Test Airport1")
                        .isoCountry("US")
                        .type("Big")
                        .runways(Arrays.asList(Runway.builder().id(222).airportRef(555).airportIdent("nlm").build()))
                        .build());
    }
}
