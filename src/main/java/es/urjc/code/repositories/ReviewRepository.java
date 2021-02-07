package es.urjc.code.repositories;

import es.urjc.code.entities.Plane;
import es.urjc.code.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para Review.
 *
 *  @author Miguel G. Sanguino
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
