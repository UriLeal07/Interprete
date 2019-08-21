package pruebainterprete;

// Clase PalabraReservada: define la estructura de una palabra reservada.
public class PalabraReservada {
    // tipo - tipo de palabra reservada.
    private int tipo;
    // palabra - palabra reservada.
    private String palabra;
    // etiqueta - significado de la palabra reservada.
    private String etiqueta;

    public PalabraReservada(int tipo, String palabra, String etiqueta) {
        this.tipo = tipo;
        this.palabra = palabra;
        this.etiqueta = etiqueta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}
