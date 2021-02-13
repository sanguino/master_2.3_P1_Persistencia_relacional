package es.urjc.code.repositories;

import es.urjc.code.dtos.CrewFlightsInterface;
import es.urjc.code.dtos.CrewFlightsDTO;
import es.urjc.code.entities.CrewMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para CrewMember.
 *
 * @author Miguel G. Sanguino
 */
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {

    CrewMember findTopByCode(String code);

    @Query(value = "select new es.urjc.code.dtos.CrewFlightsDTO(c.name, c.surname, count(fc.flight), sum(f.duration)) from CrewMember c join FlightCrew fc on fc.crewMember = c join Flight f on fc.flight = f group by c")
    List<CrewFlightsDTO> findAllFlightsAndDuration();

    @Query(value = "select c.name as name, c.surname as surName, count(f.id) as flightsTotal, sum(f.duration) as durationTotal from crew_member c join flight f on JSON_CONTAINS(f.crew_list_id, CAST(c.id as JSON ), '$') group by c.id", nativeQuery = true)
    List<CrewFlightsInterface> findAllFlightsAndDurationJSON();

}
