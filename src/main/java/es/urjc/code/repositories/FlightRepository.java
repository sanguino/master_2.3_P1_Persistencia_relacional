package es.urjc.code.repositories;

import es.urjc.code.dtos.FlightCodeCompanyDTO;
import es.urjc.code.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para Flight.
 *
 * @author Miguel G. Sanguino
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "select new es.urjc.code.dtos.FlightCodeCompanyDTO(f.code, f.company, f.departureDateTime, f.duration) from Flight f join Airport a on a = f.destinationAirport where a.city = ?1 and function('date_format', f.departureDateTime, '%Y-%m-%d') = ?2 order by f.departureDateTime")
    List<FlightCodeCompanyDTO> findFlightsLandedInCityAndDate(String city, String date);

}
