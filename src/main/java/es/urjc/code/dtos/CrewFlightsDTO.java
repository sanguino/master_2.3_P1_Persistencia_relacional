package es.urjc.code.dtos;

import java.time.LocalDateTime;

/**
 * @author Miguel G. Sanguino
 */
public class CrewFlightsDTO {

    private String crewCode;

    private String flightCity;

    private LocalDateTime flightDateTime;

    public CrewFlightsDTO() {
    }

    public CrewFlightsDTO(String crewCode, String flightCity, LocalDateTime flightDateTime) {
        this.crewCode = crewCode;
        this.flightCity = flightCity;
        this.flightDateTime = flightDateTime;
    }

    public String getCrewCode() {
        return crewCode;
    }

    public void setCrewCode(String crewCode) {
        this.crewCode = crewCode;
    }

    public String getFlightCity() {
        return flightCity;
    }

    public void setFlightCity(String flightCity) {
        this.flightCity = flightCity;
    }

    public LocalDateTime getFlightDateTime() {
        return flightDateTime;
    }

    public void setFlightDateTime(LocalDateTime flightDateTime) {
        this.flightDateTime = flightDateTime;
    }

    @Override
    public String toString() {
        return "CrewFlightsDTO{" +
                "crewCode='" + crewCode + '\'' +
                ", flightCity='" + flightCity + '\'' +
                ", flightDateTime=" + flightDateTime +
                '}';
    }
}