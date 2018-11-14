package com.country.airport.info.airportinformation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Backing model to hold runway data
 * @author Devidas_Gawade
 *
 */
@Builder
@Data
@Entity
@Table(name = "runway")
@AllArgsConstructor

public class Runway implements Serializable {
	@Id
	private int id;
	private int airportRef;
	private String airportIdent;
	private String surface;
	private String leIdent;

	protected Runway(){}

	@Override
	public int hashCode(){
		return 5*this.id;
	}

}
