package Modelo;

import java.util.ArrayList;

// Clase Separador: contiene el método que se encarga de separar el código limpio en pseudotokens.
public class Separador {
    // Método que separa las palabras en pseudotokens.
    // Recibe: cad - código limpio,
    //         posiciones - lista que contiene el número de línea de cada palabra.
    // Devuelve: pseudotokens - lista que contiene cada pseudotoken.
    public ArrayList<PseudoToken> separar(String cad, ArrayList<Integer> posiciones) {
        ArrayList<PseudoToken> pseudotokens = new ArrayList<>();
        int numPalabras = 0;
        
        String tmp = "";
        for (int i = 0; i < cad.length(); i++) {
            char aux = cad.charAt(i);
            PseudoToken pt;
            
            if (aux != ' ' && aux != '(' && aux != ')' && aux != ',') {
                tmp += aux;
            } else {
                switch (aux) {
                    case ' ':
                        if (!tmp.equals("")) {
                            pt = new PseudoToken(tmp, posiciones.get((posiciones.size() - numPalabras) - 1));
                            pseudotokens.add(pt);
                            tmp = "";
                        }   numPalabras++;
                    break;
                    case '(':
                        if (!tmp.equals("")) {
                            pt = new PseudoToken(tmp, posiciones.get((posiciones.size() - numPalabras) - 1));
                            pseudotokens.add(pt);
                            tmp = "";
                        }   pt = new PseudoToken("(", posiciones.get((posiciones.size() - numPalabras) - 1));
                        pseudotokens.add(pt);
                    break;
                    case ',':
                        if (!tmp.equals("")) {
                            pt = new PseudoToken(tmp, posiciones.get((posiciones.size() - numPalabras) - 1));
                            pseudotokens.add(pt);
                            tmp = "";
                        }   pt = new PseudoToken(",", posiciones.get((posiciones.size() - numPalabras) - 1));
                        pseudotokens.add(pt);
                    break;
                    case ')':
                        if (!tmp.equals("")) {
                            pt = new PseudoToken(tmp, posiciones.get((posiciones.size() - numPalabras) - 1));
                            pseudotokens.add(pt);
                            tmp = "";
                        }   pt = new PseudoToken(")", posiciones.get((posiciones.size() - numPalabras) - 1));
                        pseudotokens.add(pt);
                    break;
                }
            }
        }
        
        return pseudotokens;
    }
}
