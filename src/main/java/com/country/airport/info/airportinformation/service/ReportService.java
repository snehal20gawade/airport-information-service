package com.country.airport.info.airportinformation.service;

import org.springframework.stereotype.Service;


/**
 * Service class for report operation
 * @author Devidas_Gawade
 *
 */
@Service
public class ReportService {
	/*

	*//**
	 * This methods returns top ten countries with highest number of airports
	 * @return countries
	 *//*
	public List<Country> topTenCountries() {
		Comparator<Country> airortSizeAscending = (Country c1, Country c2) -> Integer.compare(c2.getAirports().size(),
				c1.getAirports().size());
		List<Country> countries = null;
		return countries.stream().sorted(airortSizeAscending).limit(10).collect(Collectors.toList());

	}

	*//**
	 * This methods returns top ten countries with lowest number of airports
	 * @return countries
	 *//*
	public List<Country> lastTenCountries() {
		Comparator<Country> airortSizeDecending = (Country c1, Country c2) -> Integer.compare(c1.getAirports().size(),
				c2.getAirports().size());
		List<Country> countries = null;
		return countries.stream().sorted(airortSizeDecending).limit(10).collect(Collectors.toList());

	}

	*//**
	 * This method return country and associated runway types
	 * @return map
	 *//*
	public Map<Country, Set<String>> countryTypeOfRunways() {
		List<Country> countries = null;

		return countries.stream()
				.flatMap(country -> country.getAirports().stream()
						.map(airport -> new AbstractMap.SimpleEntry<Country, Airport>(country, airport)))
				.flatMap(entry -> entry.getValue().getRunways().stream()
						.map(runway -> new AbstractMap.SimpleEntry<Country, Runway>(entry.getKey(), runway)))
				.collect(Collectors.groupingBy(entry -> entry.getKey(),
						Collectors.mapping(
								entry -> entry.getValue().getSurface(),

								Collectors.toSet())));

	}

	*//**
	 * Method to find most common runway identifications
	 * @return
	 *//*
	public List<String> topCommonRunwayIden() {
		return null;

		*//*return populateData.getRunways().stream().map(runway -> runway.getLeIdent())
				.collect(Collectors.groupingBy(ide -> ide, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(10).map(Map.Entry::getKey)
				.collect(Collectors.toList());*//*

	}*/
}
