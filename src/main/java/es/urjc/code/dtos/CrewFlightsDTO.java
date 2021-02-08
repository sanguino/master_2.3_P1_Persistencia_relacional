package es.urjc.code.dtos;

import es.urjc.code.entities.Flight;
import es.urjc.code.entities.FlightCrew;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel G. Sanguino
 */
public class CrewFlightsDTO {

    private String name;

    private String surName;

    private long flightsTotal;

    private Duration durationTotal;

    public CrewFlightsDTO() {
    }

    public CrewFlightsDTO(String name, String surName, long flightsTotal, long durationTotal) {
        this.name = name;
        this.surName = surName;
        this.flightsTotal = flightsTotal;
        this.durationTotal = Duration.ofMinutes(durationTotal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public long getFlightsTotal() {
        return flightsTotal;
    }

    public void setFlightsTotal(long flightsTotal) {
        this.flightsTotal = flightsTotal;
    }

    public Duration getDurationTotal() {
        return durationTotal;
    }

    public void setDurationTotal(Duration durationTotal) {
        this.durationTotal = durationTotal;
    }

    @Override
    public String toString() {
        return "CrewFlightsDTO{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", flightsTotal=" + flightsTotal +
                ", durationTotal=" + durationTotal.toHours() + "h " + durationTotal.toMinutesPart() + "m" +
                '}';
    }
}