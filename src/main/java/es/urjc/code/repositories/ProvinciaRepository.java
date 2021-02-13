package es.urjc.code.repositories;

import es.urjc.code.entities.Provincia;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio MongoDB Provincia.
 *
 * @author Miguel G. Sanguino
 */
public interface ProvinciaRepository extends MongoRepository<Provincia, String> {

}
