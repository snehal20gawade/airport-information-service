package com.country.airport.info.airportinformation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Backing model to hold airport data
 *
 */
@Data
@Builder
@Entity
@Table(name = "airport")
@AllArgsConstructor
public class Airport implements Serializable {
    @Id
    private int id;
    private String ident;
    private String type;
    private String name;
    private String isoCountry;
    @OneToMany
    @JoinColumn(name = "airportRef")
    private List<Runway> runways;
    protected Airport() {
    }
}
