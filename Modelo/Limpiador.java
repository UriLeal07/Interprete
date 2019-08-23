package Modelo;

import java.util.ArrayList;

// Clase Limpiador: contiene el método que se encarga de limpiar el código de espacios, saltos de línea y tabuladores.
public class Limpiador {
    // Lista que contiene el número de línea de cada palabra.
    public ArrayList<Integer> posiciones;
    
    public Limpiador() {
        posiciones = new ArrayList<>();
    }
    
    // Método que se encarga de limpiar el código.
    // Recibe: text - código fuente.
    // Devuelve: nuevaCad - código limpio.
    public String limpiar(String text) {
        String cads[] = text.split("\n");
        String nuevaCad = "";
        
        // se limpian los espacios al inicio y al final de cada línea
        System.out.println("\n\n == CADENAS LIMPIAS DE ESPACIOS AL INICIO Y AL FINAL ==");
        for (int i = 0; i < cads.length; i++) {
            cads[i] = cads[i].trim();
            System.out.println(cads[i]);
        }
        
        // se omiten espacios extra, sólo mantiene 1 espacio
        for (int i = 0; i < cads.length; i++) {
            if (cads[i].length() != 0) {
                String tmp = "";
                int j = 0;
                do {
                    tmp += cads[i].charAt(j);
                    if (cads[i].charAt(j) == ' ' && j+1 != cads[i].length() && cads[i].charAt(j+1) == ' ') {
                        do {
                            j++;
                        } while (cads[i].charAt(j) == ' ');
                    } else {
                        j++;
                    }
                } while (j < cads[i].length());
                cads[i] = tmp;
            }
        }
        
        System.out.println("\n\n == CADENAS SIN ESPACIOS EXTRA (solo uno) ==");
        for (String cad : cads) {
            System.out.println(cad);
        }
        
        // se eliminan espacios dentro de paréntesis, siempre y cuando estén en la misma línea
        for (int i = 0; i < cads.length; i++) {
                boolean ban = false;
                String tmp = "";
                for (int j = 0; j < cads[i].length(); j++) {
                    if (cads[i].charAt(j) == '(') {
                        ban = true;
                    }
                    if (cads[i].charAt(j) == ')') {
                        ban = false;
                    }
                    if (ban == true) {
                        if (cads[i].charAt(j) != ' ') {
                            tmp += cads[i].charAt(j);
                        }
                    } else {
                        tmp += cads[i].charAt(j);
                    }
                }
                cads[i] = tmp;
        }
        
        System.out.println("\n\n == CADENAS SIN ESPACIOS (solo dentro de los paréntesis) ==");
        for (String cad : cads) {
            System.out.println(cad);
        }
        
        // se eliminan espacios entre el nombre de la función y los paréntesis, siempre y cuando estén en la misma línea
        for (int i = 0; i < cads.length; i++) {
            String tmp = "";
            for (int j = 0; j < cads[i].length(); j++) {
                if (cads[i].charAt(j) == ' ') {
                    if (j+1 != cads[i].length() && cads[i].charAt(j+1) != '(') {
                        tmp += cads[i].charAt(j);
                    }
                } else {
                    tmp += cads[i].charAt(j);
                }
            }
            cads[i] = tmp;
        }
        
        System.out.println("\n\n == CADENAS SIN ESPACIOS (entre nombre de función y parámetros) == ");
        for (int i = 0; i < cads.length; i++) {
            if (!cads[i].equals("")) {
                System.out.println(cads[i]);
                String aux[] = cads[i].split(" ");
                for (int j = 0; j < aux.length; j++) {
                    posiciones.add(j, i+1);
                }
                nuevaCad += cads[i] + " ";
            }
        }
        
        // se eliminan tabuladores
        String tmp = "";
        for (int i = 0; i < nuevaCad.length(); i++) {
            char aux = nuevaCad.charAt(i);
            if (aux != '\t') {
                tmp += aux;
            }
        }
        nuevaCad = tmp;
        
        System.out.println("\n\n == UNIÓN DE UNA SOLA CADENA ==");
        System.out.println(nuevaCad);
        System.out.println(posiciones.toString());
        
        return nuevaCad;
    }

    public ArrayList<Integer> getPosiciones() {
        return posiciones;
    }
    
    
}

