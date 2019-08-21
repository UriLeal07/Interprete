package pseudointerprete;

public class Regla {
    // identificador de la regla.
    private int identificador;
    // valor - palabra.
    private String valor;

    public Regla(int identificador, String valor) {
        this.identificador = identificador;
        this.valor = valor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}