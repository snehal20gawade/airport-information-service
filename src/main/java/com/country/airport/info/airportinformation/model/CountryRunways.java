package com.country.airport.info.airportinformation.model;

import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Backing model to hold runways per country.
 * @author Devidas_Gawade
 *
 */
@Component("countryRunwaysBean")
public class CountryRunways {
	private String country;
	private List<String> runways;
	
	public List<String> getRunways() {
		return runways;
	}
	public void setRunways(List<String> runways) {
		this.runways = runways;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
