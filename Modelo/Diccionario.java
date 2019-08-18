package Modelo;

import java.util.ArrayList;

// Clase Diccionario: define el significado de las palabras reservadas y su tipo,
//                    contiene el método que se encarga de buscar una palabra dentro del mismo diccionario.
public class Diccionario {
    ArrayList<PalabraReservada> palabras;
    
    public Diccionario() {
        palabras = new ArrayList<>();
        
        PalabraReservada aux = new PalabraReservada(0, "Programa", "palabra reservada Programa");
        palabras.add(aux);
        aux = new PalabraReservada(1, "Inicio", "palabra reservada Inicio");
        palabras.add(aux);
        aux = new PalabraReservada(2, "Fin", "palabra reservada Fin");
        palabras.add(aux);
        aux = new PalabraReservada(3, "DibujarCara", "nombre de función");
        palabras.add(aux);
        aux = new PalabraReservada(4, "EliminarCara", "nombre de función");
        palabras.add(aux);
        aux = new PalabraReservada(5, "Dormir", "nombre de función");
        palabras.add(aux);
        aux = new PalabraReservada(6, "CambiarModo", "nombre de función");
        palabras.add(aux);
        aux = new PalabraReservada(7, "triste", "modo");
        palabras.add(aux);
        aux = new PalabraReservada(7, "enojada", "modo");
        palabras.add(aux);
        aux = new PalabraReservada(7, "feliz", "modo");
        palabras.add(aux);
        aux = new PalabraReservada(7, "dormida", "modo");
        palabras.add(aux);
        aux = new PalabraReservada(7, "neutral", "modo");
        palabras.add(aux);
        aux = new PalabraReservada(8, "", "identificador");
        palabras.add(aux);
        aux = new PalabraReservada(9, "(", "paréntesis (");
        palabras.add(aux);
        aux = new PalabraReservada(10, ")", "paréntesis )");
        palabras.add(aux);
        aux = new PalabraReservada(11, ",", "separador ,");
        palabras.add(aux);
        aux = new PalabraReservada(12, "", "número");
        palabras.add(aux);
    }
    
    // Método que se encarga de buscar una palabra dentro del diccionario.
    // Recibe: cad - palabra a buscar.
    // Devuelve: tipo - tipo que le correspondería dentro del diccionario.
    public int buscar(String cad) {
        int tipo = -1;
        PalabraReservada aux;
        boolean ban = false;
        int i = 0;
        
        while (!ban && i < palabras.size()) {
            aux = palabras.get(i);
            if (aux.getPalabra().equals(cad)) {
                tipo = aux.getTipo();
                ban = true;
            }
            i++;
        }
        
        return tipo;
    }
}
