package es.urjc.code.repositories;

import es.urjc.code.entities.Airport;
import es.urjc.code.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para Flight.
 *
 *  @author Miguel G. Sanguino
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
