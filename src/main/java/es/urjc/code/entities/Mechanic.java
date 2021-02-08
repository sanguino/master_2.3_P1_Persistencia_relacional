package es.urjc.code.entities;

import javax.persistence.Entity;

/**
 * Entity Mechanic.
 *
 * @author Miguel G. Sanguino
 */

@Entity
public class Mechanic extends Employee {

    private int hiredYear;

    private String studies;

    public Mechanic() {
        super();
    }

    public Mechanic(String code, String name, String surname, int hiredYear, String studies) {
        super(code, name, surname);
        this.hiredYear = hiredYear;
        this.studies = studies;
    }

    public int getHiredYear() {
        return hiredYear;
    }

    public void setHiredYear(int hiredYear) {
        this.hiredYear = hiredYear;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    @Override
    public String toString() {
        String employee = super.toString();
        return employee + " Mechanic{" +
                "hiredYear=" + hiredYear +
                ", studies='" + studies + '\'' +
                '}';
    }
}
