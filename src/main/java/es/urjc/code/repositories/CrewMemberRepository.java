package es.urjc.code.repositories;

import es.urjc.code.dtos.CrewFlightsDTO;
import es.urjc.code.dtos.FlightCodeCompanyDTO;
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

    CrewMember findTopByCode(String code);
    @Query(value = "select new es.urjc.code.dtos.CrewFlightsDTO(c.name, c.surname, count(fc.flight), sum(f.duration)) from CrewMember c join FlightCrew fc on fc.crewMember = c join Flight f on fc.flight = f group by c")
    List<CrewFlightsDTO> findAllFlightsAndDuration();


}
