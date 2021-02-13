package es.urjc.code.dtos;

/**
 * @author Miguel G. Sanguino
 */

public class MechanicsOfPlaneDTO {
    String plate;
    String name;
    String surName;

    public MechanicsOfPlaneDTO() {
    }

    public MechanicsOfPlaneDTO(String plate, String name, String surName) {
        this.plate = plate;
        this.name = name;
        this.surName = surName;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "MechanicsOfPlaneDTO{" +
                "plate='" + plate + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}