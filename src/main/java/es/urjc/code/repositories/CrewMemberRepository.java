package es.urjc.code.repositories;

import es.urjc.code.entities.CrewMember;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para CrewMember.
 *
 *  @author Miguel G. Sanguino
 */
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {

    CrewMember findTopByCode(String code);

}
