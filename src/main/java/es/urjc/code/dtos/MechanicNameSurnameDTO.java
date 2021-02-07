package es.urjc.code.dtos;

import java.util.Objects;

/**
 * @author Miguel G. Sanguino
 */

public class MechanicNameSurnameDTO {

    String name;

    String surName;

    public MechanicNameSurnameDTO() {
    }

    public MechanicNameSurnameDTO(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MechanicNameSurnameDTO that = (MechanicNameSurnameDTO) o;
        return name.equals(that.name) && surName.equals(that.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName);
    }

    @Override
    public String toString() {
        return "MechanicNameSurnameDTO{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
