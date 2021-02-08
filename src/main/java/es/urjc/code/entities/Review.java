package es.urjc.code.entities;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Entity Review.
 *
 * @author Miguel G. Sanguino
 */
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne //(cascade=CascadeType.ALL)//, mappedBy="flight")
    private Plane plane;

    private LocalDate initDate;
    private LocalDate endDate;
    private Duration timeSpent;

    @OneToOne //(cascade=CascadeType.ALL)//, mappedBy="flight")
    private Mechanic mechanic;

    private String type;

    private String description;

    @OneToOne //(cascade=CascadeType.ALL)//, mappedBy="flight")
    private Airport airport;

    public Review() {
    }

    public Review(Plane plane, LocalDate initDate, LocalDate endDate, Duration timeSpent, Mechanic mechanic, String type, String description, Airport airport) {
        this.plane = plane;
        this.initDate = initDate;
        this.endDate = endDate;
        this.timeSpent = timeSpent;
        this.mechanic = mechanic;
        this.type = type;
        this.description = description;
        this.airport = airport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Duration getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Duration timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", plane=" + plane +
                ", initDate=" + initDate.format(DateTimeFormatter.ISO_DATE) +
                ", endDate=" + endDate.format(DateTimeFormatter.ISO_DATE) +
                ", timeSpent=" + timeSpent.toHours() + "h " + timeSpent.toMinutesPart() + "m" +
                ", mechanic=" + mechanic +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", airport=" + airport +
                '}';
    }
}
