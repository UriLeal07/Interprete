package Modelo;

import java.util.ArrayList;

// Clase Sintaxis: clase que contiene el conjunto de reglas sintácticas.
public class Sintaxis {
    // reglas - lista que contiene las reglas sintácticas.
    ArrayList<Regla> reglas;
    
    public Sintaxis() {
        reglas = new ArrayList<>();
        
        Regla aux = new Regla(0, "0,8,1");
        reglas.add(aux);
        aux = new Regla(3, "3,9,12,11,12,11,12,11,8,11,7,10");
        reglas.add(aux);
        aux = new Regla(4, "4,9,8,10");
        reglas.add(aux);
        aux = new Regla(5, "5,9,12,10");
        reglas.add(aux);
        aux = new Regla(6, "6,9,8,11,7,10");
        reglas.add(aux);
        aux = new Regla(2, "2");
        reglas.add(aux);
    }
    
    public String getRegla(int identificador){
        String regla = "";
        Regla aux;
        boolean ban = false;
        int i = 0;
        while (!ban && i < reglas.size()) {
            aux = reglas.get(i);
            if (aux.getIdentificador() == identificador) {
                regla = aux.getValor();
                ban = true;
            }
            i++;
        }
        
        return regla;
    }
}
