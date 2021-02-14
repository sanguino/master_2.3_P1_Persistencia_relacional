package es.urjc.code.dtos;

/**
 * Entity MongoDB Provincia.
 *
 * @author Miguel G. Sanguino
 */

public class ComunidadesNumProvincias {

    private String comunidad;
    private int numeroProvincias;

    public ComunidadesNumProvincias() {
    }

    public ComunidadesNumProvincias(String comunidad, int numeroProvincias) {
        this.comunidad = comunidad;
        this.numeroProvincias = numeroProvincias;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public int getNumeroProvincias() {
        return numeroProvincias;
    }

    public void setNumeroProvincias(int numeroProvincias) {
        this.numeroProvincias = numeroProvincias;
    }

    @Override
    public String toString() {
        return "ComunidadesNumProvincias{" +
                "comunidad='" + comunidad + '\'' +
                ", numeroProvincias=" + numeroProvincias +
                '}';
    }
}
