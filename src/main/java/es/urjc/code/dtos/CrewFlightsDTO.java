package es.urjc.code.dtos;

import es.urjc.code.entities.Flight;
import es.urjc.code.entities.FlightCrew;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel G. Sanguino
 */
public class CrewFlightsDTO {

    private String crewCode;

    private List<FlightCityDepartureDTO> flightCityDepartureDTOS;

    public CrewFlightsDTO() {
    }

    public CrewFlightsDTO(String crewCode, List<FlightCrew> flightsCrew) {
        this.crewCode = crewCode;
        this.flightCityDepartureDTOS = new ArrayList<>();
        flightsCrew.forEach(flightCrew -> {
            Flight flight = flightCrew.getFlight();
            FlightCityDepartureDTO fcdto = new FlightCityDepartureDTO(flight.getDestinationAirport().getCity(), flight.getDepartureDateTime());
            this.flightCityDepartureDTOS.add(fcdto);
        });
    }

    public String getCrewCode() {
        return crewCode;
    }

    public void setCrewCode(String crewCode) {
        this.crewCode = crewCode;
    }

    public List<FlightCityDepartureDTO> getFlightCityDepartureDTOS() {
        return flightCityDepartureDTOS;
    }

    public void setFlightCityDepartureDTOS(List<FlightCityDepartureDTO> flightCityDepartureDTOS) {
        this.flightCityDepartureDTOS = flightCityDepartureDTOS;
    }

    @Override
    public String toString() {
        return "CrewFlightsDTO{" +
                "crewCode='" + crewCode + '\'' +
                ", flightCityDepartureDTOS=" + flightCityDepartureDTOS +
                '}';
    }
}