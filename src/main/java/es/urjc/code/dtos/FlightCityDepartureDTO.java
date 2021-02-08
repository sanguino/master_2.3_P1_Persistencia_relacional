package es.urjc.code.dtos;

import java.time.LocalDateTime;

/**
 * @author Miguel G. Sanguino
 */
public class FlightCityDepartureDTO {

    private String flightCity;

    private LocalDateTime flightDateTime;

    public FlightCityDepartureDTO() {
    }

    public FlightCityDepartureDTO(String flightCity, LocalDateTime flightDateTime) {
        this.flightCity = flightCity;
        this.flightDateTime = flightDateTime;
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
}