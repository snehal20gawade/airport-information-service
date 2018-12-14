package com.country.airport.info.airportinformation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Backing model to hold country data
 *
 */

@Data
@Builder
@Entity
@Table(name = "country")
@AllArgsConstructor
public class Country implements Serializable {
    @Id
    private int id;
    private String code;
    private String name;
    private String continent;
    @OneToMany
    @JoinColumns(
            @JoinColumn(name = "isoCountry", referencedColumnName = "code"))
    private List<Airport> airports;

    protected  Country(){}
}
