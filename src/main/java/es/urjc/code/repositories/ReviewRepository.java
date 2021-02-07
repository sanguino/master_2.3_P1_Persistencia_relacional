package es.urjc.code.repositories;

import es.urjc.code.dtos.PlaneMechanicDTO;
import es.urjc.code.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para Review.
 *
 *  @author Miguel G. Sanguino
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select new es.urjc.code.dtos.PlaneMechanicDTO(p.plate, p.maker, p.model, m.name, m.surname) from Review r join Plane p on p = r.plane join Mechanic m on m = r.mechanic")
    List<PlaneMechanicDTO> findPlaneMechanics();


}
