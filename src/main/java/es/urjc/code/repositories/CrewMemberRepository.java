package es.urjc.code.repositories;

import es.urjc.code.dtos.CrewFlightsDTO;
import es.urjc.code.entities.CrewMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para CrewMember.
 *
 *  @author Miguel G. Sanguino
 */
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {

    List<CrewMember> findByCode(String code);

}
