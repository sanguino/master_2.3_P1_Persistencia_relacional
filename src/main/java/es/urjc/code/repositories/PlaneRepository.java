package es.urjc.code.repositories;

import es.urjc.code.dtos.CrewFlightsInterface;
import es.urjc.code.dtos.MechanicsOfPlaneInterface;
import es.urjc.code.dtos.PlaneMechanicDTO;
import es.urjc.code.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para Plane.
 *
 * @author Miguel G. Sanguino
 */
public interface PlaneRepository extends JpaRepository<Plane, Long> {

    @Query(value = "select p.plate, m.name, m.surname from plane p join mechanic m on JSON_CONTAINS(p.reviews->'$[*].mechanic', CAST(m.id as JSON)) order by p.plate", nativeQuery = true)
    List<MechanicsOfPlaneInterface> findAllMechanicsOfaPlane();

}
