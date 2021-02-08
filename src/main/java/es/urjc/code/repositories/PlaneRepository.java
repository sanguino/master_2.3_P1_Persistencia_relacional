package es.urjc.code.repositories;

import es.urjc.code.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para Plane.
 *
 * @author Miguel G. Sanguino
 */
public interface PlaneRepository extends JpaRepository<Plane, Long> {

}
