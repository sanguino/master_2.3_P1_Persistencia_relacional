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

    //@Query(value = "select new es.urjc.code.dtos.CrewFlightsDTO() from CrewMember c join Flight fc on c.id = fc.crew_id join flight f on fc.flight_id = f.id")
    //List<CrewFlightsDTO> findFlightsOfCrewMember(String code);

}
