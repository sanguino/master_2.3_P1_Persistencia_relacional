package es.urjc.code.dtos;

import es.urjc.code.entities.Mechanic;

import java.time.Duration;
import java.util.List;

/**
 * @author Miguel G. Sanguino
 */
public class PlaneMechanicDTO {

    private String plate;

    private String maker;

    private String model;

    private String mechanicName;

    private String mechanicSurName;

    public PlaneMechanicDTO() {
    }

    public PlaneMechanicDTO(String plate, String maker, String model, String mechanicName, String mechanicSurName) {
        this.plate = plate;
        this.maker = maker;
        this.model = model;
        this.mechanicName = mechanicName;
        this.mechanicSurName = mechanicSurName;
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

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public String getMechanicSurName() {
        return mechanicSurName;
    }

    public void setMechanicSurName(String mechanicSurName) {
        this.mechanicSurName = mechanicSurName;
    }

    @Override
    public String toString() {
        return "PlaneReviewMechanicsDTO{" +
                "plate='" + plate + '\'' +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", mechanicName='" + mechanicName + '\'' +
                ", mechanicSurName='" + mechanicSurName + '\'' +
                '}';
    }
}