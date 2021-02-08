package es.urjc.code.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Entity CrewMember.
 *
 * @author Miguel G. Sanguino
 */

@Entity
public class CrewMember extends Employee {

    private String position;

    private String company;

    @OneToMany(mappedBy = "crewMember", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<FlightCrew> flights;

    public CrewMember() {
        super();
    }

    public CrewMember(String code, String name, String surname, String position, String company) {
        super(code, name, surname);
        this.position = position;
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<FlightCrew> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightCrew> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        String employee = super.toString();
        return employee + " Crew{" +
                "position='" + position + '\'' +
                ", company='" + company + '\'' +
                //", flights=" + flights +
                '}';
    }
}
