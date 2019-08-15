package pruebainterprete;

import java.util.ArrayList;

public class Limpiador {
    ArrayList<Integer> posiciones;
    
    public Limpiador() {
        posiciones = new ArrayList<>();
    }
    
    public String limpiar(String text) {
        String cads[] = text.split("\n");
        String nuevaCad = "";
        
        // se limpian los espacios al inicio y al final de cada línea
        System.out.println("\n\n ==  CADENAS LIMPIAS DE ESPACIOS AL INICIO Y AL FINAL ==");
        for (int i = 0; i < cads.length; i++) {
            cads[i] = cads[i].trim();
            System.out.println(cads[i]);
            
            /* Pattern patron = Pattern.compile("[^A-Za-z0-9 ,()]+");
            Matcher encaja = patron.matcher(cads[i]);
        
            if (encaja.find()) {
                System.out.println("ERROR: Caracter no identificado en la línea: " + i+1);
            } */
        }
        
        // se omiten espacios extra
        for (int i = 0; i < cads.length; i++) {
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
        
        System.out.println("\n\n == CADENAS SIN ESPACIOS EXTRA (solo uno) ==");
        for (int i = 0; i < cads.length; i++) {
            System.out.println(cads[i]);
        }
        
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
        for (int i = 0; i < cads.length; i++) {
            System.out.println(cads[i]);
        }
        
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
            System.out.println(cads[i]);
            String aux[] = cads[i].split(" ");
            for (int j = 0; j < aux.length; j++) {
                posiciones.add(j, i+1);
            }
            nuevaCad += cads[i] + " ";
        }
        
        System.out.println("\n\n == UNIÓN DE UNA SOLA CADENA ==");
        System.out.println(nuevaCad);
        System.out.println(posiciones.toString());
        
        return nuevaCad;
    }
}
