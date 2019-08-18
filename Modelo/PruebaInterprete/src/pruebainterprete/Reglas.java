package pruebainterprete;

import java.util.ArrayList;

// Clase Reglas: clase que define la sintaxis de las funciones.
public class Reglas {
    // reglas - lista que contiene las reglas sintácticas.
    ArrayList<String> reglas;
    
    public Reglas() {
        reglas = new ArrayList<>();
        
        reglas.add(0, "0,8,1");
        reglas.add(3, "3,9,12,11,12,11,12,11,8,11,7,10");
        reglas.add(4, "4,9,8,10");
        reglas.add(5, "5,9,12,10");
        reglas.add(6, "6,9,8,11,7,10");
    }
}
