package es.urjc.code.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Entity Flight.
 *
 * @author Miguel G. Sanguino
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String code;
    private String company;

    @OneToOne //(cascade=CascadeType.ALL)//, mappedBy="flight")
    private Plane plane;

    @OneToOne //(cascade=CascadeType.ALL)//, mappedBy="flight")
    private Airport originAirport;

    @OneToOne //(cascade=CascadeType.ALL)//), mappedBy="flight")
    private Airport destinationAirport;

    private LocalDateTime departureDateTime;

    private int duration;

    @OneToMany(mappedBy = "flight", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<FlightCrew> crew;

    private String crewListId;


    public Flight() {
    }

    public Flight(String code, String company, Plane plane, Airport originAirport, Airport destinationAirport, LocalDateTime departureDateTime, int duration, String crewListId) {
        this.code = code;
        this.company = company;
        this.plane = plane;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureDateTime = departureDateTime;
        this.duration = duration;
        this.crewListId = crewListId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<FlightCrew> getCrew() {
        return crew;
    }

    public void setCrew(List<FlightCrew> crew) {
        this.crew = crew;
    }

    public String getCrewListId() {
        return crewListId;
    }

    public void setCrewListId(String crewListId) {
        this.crewListId = crewListId;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", company='" + company + '\'' +
                ", plane=" + plane +
                ", originAirport=" + originAirport +
                ", destinationAirport=" + destinationAirport +
                ", departureDateTime=" + departureDateTime +
                ", duration=" + duration +
                ", crew=" + crew +
                ", crewListId='" + crewListId + '\'' +
                '}';
    }
}
