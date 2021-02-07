package es.urjc.code.repositories;

import es.urjc.code.entities.CrewMember;
import es.urjc.code.entities.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para Mechanic.
 *
 *  @author Miguel G. Sanguino
 */
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

}
