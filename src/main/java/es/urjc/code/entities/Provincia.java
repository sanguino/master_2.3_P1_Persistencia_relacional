package es.urjc.code.entities;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Entity MongoDB Provincia.
 *
 * @author Miguel G. Sanguino
 */

public class Provincia {

    @Id
    private String id;
    private String Nombre;
    private String CA;
    private String Superficie;
    private List<DatosProvincia> Datos;

    public Provincia() {
    }

    public Provincia(String nombre, String CA, String superficie) {
        Nombre = nombre;
        this.CA = CA;
        Superficie = superficie;
    }

    public Provincia(String nombre, String CA, String superficie, List<DatosProvincia> datos) {
        Nombre = nombre;
        this.CA = CA;
        Superficie = superficie;
        Datos = datos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }

    public String getSuperficie() {
        return Superficie;
    }

    public void setSuperficie(String superficie) {
        Superficie = superficie;
    }

    public List<DatosProvincia> getDatos() {
        return Datos;
    }

    public void setDatos(List<DatosProvincia> datos) {
        Datos = datos;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "id='" + id + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", CA='" + CA + '\'' +
                ", Superficie='" + Superficie + '\'' +
                ", Datos=" + Datos +
                '}';
    }
}
