package es.urjc.code.repositories;

import es.urjc.code.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para Airport.
 *
 * @author Miguel G. Sanguino
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {

}
