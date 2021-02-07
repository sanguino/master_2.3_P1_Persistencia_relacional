package es.urjc.code.entities;

import javax.persistence.*;
import java.time.Duration;
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

    private Duration duration;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<CrewMember> crew;



    public Flight() {
    }

    public Flight(String code, String company, Plane plane, Airport originAirport, Airport destinationAirport, LocalDateTime departureDateTime, Duration duration) {
        this.code = code;
        this.company = company;
        this.plane = plane;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureDateTime = departureDateTime;
        this.duration = duration;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewMember> crew) {
        this.crew = crew;
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
                ", departureDateTime=" + departureDateTime.format(DateTimeFormatter.ISO_DATE_TIME) +
                ", duration=" + duration.toHours() + "h " + duration.toMinutesPart() + "m" +
                ", crew=" + crew +
                '}';
    }
}
