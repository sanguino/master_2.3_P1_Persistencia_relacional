package es.urjc.code.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * Entity FlightCrew.
 *
 * @author Miguel G. Sanguino
 */

@Entity
public class FlightCrew {

    @EmbeddedId
    private FlightCrewId id;

    @ManyToOne
    @MapsId("flightId")
    private Flight flight;

    @ManyToOne
    @MapsId("crewMemberId")
    private CrewMember crewMember;

    public FlightCrew() {
    }

    public FlightCrew(Flight flight, CrewMember crewMember) {
        this.flight = flight;
        this.crewMember = crewMember;
        this.id = new FlightCrewId(flight.getId(), crewMember.getId());
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public CrewMember getCrewMember() {
        return crewMember;
    }

    public void setCrewMember(CrewMember crewMember) {
        this.crewMember = crewMember;
    }
}
