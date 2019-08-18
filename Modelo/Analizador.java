package Modelo;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Clase Analizador: contiene el método que se encarga de asignar el tipo de token que le corresponde a un pseudotoken.
public class Analizador {
    // Método que asigna el tipo de token, si existe, a un pseudotoken.
    // Recibe: pseudotokens - lista que contiene los pseudotokens leídos del código limpio.
    //         diccionario - objeto de tipo Diccionario que contiene la definición de las palabras reservadas,
    //                       y el método para buscarlas dentro del diccionario.
    // Devuelve: tokens - lista que contiene los tokens identificados de la lista de pseudotokens.
    public ArrayList<Token> asignarTokens(ArrayList<PseudoToken> pseudotokens, Diccionario diccionario) {
        ArrayList<Token> tokens = new ArrayList<>();
        for (int i = 0; i < pseudotokens.size(); i++) {
            PseudoToken pt = pseudotokens.get(i);
            
            int tipo = diccionario.buscar(pt.getValor());
            if (tipo >= 0) {
                Token t = new Token(tipo, pt.getValor(), pt.getLinea());
                tokens.add(t);
            } else {
                try {
                    int aux = Integer.parseInt(pt.getValor());
                    Token t = new Token(12, String.valueOf(aux), pt.getLinea());
                    tokens.add(t);
                } catch (NumberFormatException e) {
                    Pattern patron = Pattern.compile("[^A-Za-z0-9_]+");
                    Matcher encaja = patron.matcher(pt.getValor());
        
                    if (encaja.find()) {
                        System.out.println("ERROR: Parámetro no válido: " + pt.getValor() + ". Línea: " + pt.getLinea());
                    } else {
                        patron = Pattern.compile("^[^\\d].*");
                        encaja = patron.matcher(pt.getValor());
                        
                        if (encaja.find()) {
                            Token t = new Token(8, pt.getValor(), pt.getLinea());
                            tokens.add(t);
                        } else {
                            System.out.println("ERROR: Identificador no puede empezar por un dígito: " + pt.getValor() + ". Línea: " + pt.getLinea());
                        }
                    }
                }
            }
        }
        
        return tokens;
    }
}
