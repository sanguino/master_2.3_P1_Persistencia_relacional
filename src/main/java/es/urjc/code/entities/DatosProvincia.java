package es.urjc.code.entities;

/**.
 *
 * @author Miguel G. Sanguino
 */

public class DatosProvincia {

    private int Anyo;
    private int Valor;

    public DatosProvincia() {
    }

    public DatosProvincia(int anyo, int valor) {
        Anyo = anyo;
        Valor = valor;
    }

    public int getAnyo() {
        return Anyo;
    }

    public void setAnyo(int anyo) {
        Anyo = anyo;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    @Override
    public String toString() {
        return "DatosProvincia{" +
                "Anyo=" + Anyo +
                ", Valor=" + Valor +
                '}';
    }
}
