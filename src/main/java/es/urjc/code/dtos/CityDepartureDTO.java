package es.urjc.code.dtos;

import java.time.LocalDateTime;

/**
 * @author Miguel G. Sanguino
 */
public class CityDepartureDTO {

    private String city;

    private LocalDateTime departure;

    public CityDepartureDTO() {
    }

    public CityDepartureDTO(String city, LocalDateTime departure) {
        this.city = city;
        this.departure = departure;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "FlightCityDepartureDTO{" +
                "flightCity='" + city + '\'' +
                ", flightDateTime=" + departure +
                '}';
    }
}