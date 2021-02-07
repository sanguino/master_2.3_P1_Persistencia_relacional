package es.urjc.code.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FlightCrewId implements Serializable {
    private Long flightId;
    private Long crewMemberId;

    public FlightCrewId() { }

    public FlightCrewId(Long flightId, Long crewMemberId) {
        this.flightId = flightId;
        this.crewMemberId = crewMemberId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getCrewMemberId() {
        return crewMemberId;
    }

    public void setCrewMemberId(Long crewMemberId) {
        this.crewMemberId = crewMemberId;
    }
}
