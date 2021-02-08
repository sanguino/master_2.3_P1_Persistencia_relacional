package es.urjc.code.repositories;

import es.urjc.code.dtos.MechanicNameSurnameDTO;
import es.urjc.code.entities.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para Mechanic.
 *
 * @author Miguel G. Sanguino
 */
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

    @Query(value = "select new es.urjc.code.dtos.MechanicNameSurnameDTO(m.name, m.surname) from Mechanic m")
    List<MechanicNameSurnameDTO> findMechanicsNameSurnameOnly();

}
