package es.urjc.code.repositories;

import es.urjc.code.entities.FlightCrew;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para FlightCrew.
 *
 * @author Miguel G. Sanguino
 */
public interface FlightCrewRepository extends JpaRepository<FlightCrew, Long> {

}
