package es.urjc.code.dtos;

import es.urjc.code.entities.Flight;
import es.urjc.code.entities.FlightCrew;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel G. Sanguino
 */
public class CrewCitiesDTO {

    private String crewCode;

    private List<CityDepartureDTO> cityDepartureDTOS;

    public CrewCitiesDTO() {
    }

    public CrewCitiesDTO(String crewCode, List<FlightCrew> flightsCrew) {
        this.crewCode = crewCode;
        this.cityDepartureDTOS = new ArrayList<>();
        flightsCrew.forEach(flightCrew -> {
            Flight flight = flightCrew.getFlight();
            CityDepartureDTO fcdto = new CityDepartureDTO(flight.getDestinationAirport().getCity(), flight.getDepartureDateTime());
            this.cityDepartureDTOS.add(fcdto);
        });
    }

    public String getCrewCode() {
        return crewCode;
    }

    public void setCrewCode(String crewCode) {
        this.crewCode = crewCode;
    }

    public List<CityDepartureDTO> getFlightCityDepartureDTOS() {
        return cityDepartureDTOS;
    }

    public void setFlightCityDepartureDTOS(List<CityDepartureDTO> cityDepartureDTOS) {
        this.cityDepartureDTOS = cityDepartureDTOS;
    }

    @Override
    public String toString() {
        return "CrewFlightsDTO{" +
                "crewCode='" + crewCode + '\'' +
                ", flightCityDepartureDTOS=" + cityDepartureDTOS +
                '}';
    }
}