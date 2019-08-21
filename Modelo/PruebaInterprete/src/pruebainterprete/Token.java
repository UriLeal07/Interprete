package pruebainterprete;

// Clase Token: define la estructura de un token.
//              Un token nos ayuda a identificar cada una de las palabras por su tipo,
//              su estructura es <tipo, valor, línea>
public class Token {
    // tipo - tipo de token correspondiente al diccionario de palabras reservadas.
    private int tipo;
    // valor - palabra.
    private String valor;
    // linea - número de línea de esa palabra.
    private int linea;

    public Token(int tipo, String valor, int linea) {
        this.tipo = tipo;
        this.valor = valor;
        this.linea = linea;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
