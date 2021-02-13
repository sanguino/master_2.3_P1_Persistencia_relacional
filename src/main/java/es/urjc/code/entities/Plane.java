package es.urjc.code.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Duration;

/**
 * Entity Plane.
 *
 * @author Miguel G. Sanguino
 */

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String plate;

    private String maker;

    private String model;

    private Duration flightHours;

    private String reviews;

    public Plane() {
    }

    public Plane(String plate, String maker, String model, Duration flightHours) {
        this.plate = plate;
        this.maker = maker;
        this.model = model;
        this.flightHours = flightHours;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Duration getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(Duration flightHours) {
        this.flightHours = flightHours;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", flightHours=" + flightHours.toHours() + 'h' +
                '}';
    }
}
