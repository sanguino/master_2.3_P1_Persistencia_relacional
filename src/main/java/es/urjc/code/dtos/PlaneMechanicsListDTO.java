package es.urjc.code.dtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Miguel G. Sanguino
 */
public class PlaneMechanicsListDTO {

    private String plane;

    private Set<MechanicNameSurnameDTO> mechanics;

    public PlaneMechanicsListDTO() {
    }

    public PlaneMechanicsListDTO(String plane) {
        this.plane = plane;
        this.mechanics = new HashSet<>();
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public void addMechanic(MechanicNameSurnameDTO mechanic) {
        mechanics.add(mechanic);
    }

    public Set<MechanicNameSurnameDTO> getMechanics() {
        return mechanics;
    }

    @Override
    public String toString() {
        return "PlaneMechanicsListDTO{" +
                "plane='" + plane + '\'' +
                ", mechanics=" + mechanics +
                '}';
    }
}