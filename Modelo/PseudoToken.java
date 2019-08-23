package Modelo;

// Clase PseudoToken: clase que define la estructura de un pseudotoken.
//                    Un pseudotoken es simplemente una estructura <valor, línea>
//                    que ayuda a separar cada palabra para un análisis sencillo.
public class PseudoToken {
    // valor - palabra.
    private String valor;
    // linea - número de línea de esa palabra.
    private int linea;

    public PseudoToken(String valor, int linea) {
        this.valor = valor;
        this.linea = linea;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    } 
}

