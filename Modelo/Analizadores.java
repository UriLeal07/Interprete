package Modelo;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import Controlador.Interprete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

// Clase Analizadoreses: contiene los métodos que se encargan de hacer el análisis léxico, sintáctico y semántico.
public class Analizadores implements ActionListener
{
    private Interprete interprete;
    int posicion, cont;
    ArrayList<Token> tokens;
    Sintaxis reglas;
    Diccionario diccionario;
    // Método que asigna el tipo de token, si existe, a un pseudotoken.
    // Recibe: pseudotokens - lista que contiene los pseudotokens leídos del código limpio.
    //         diccionario - objeto de tipo Diccionario que contiene la definición de las palabras reservadas,
    //                       y el método para buscarlas dentro del diccionario.
    // Devuelve: tokens - lista que contiene los tokens identificados de la lista de pseudotokens.
    public Analizadores(Interprete interprete, Sintaxis reglas, Diccionario diccionario)
    {
        this.interprete = interprete;
        this.reglas = reglas;
        this.diccionario = diccionario;
        tokens = new ArrayList<>();
        posicion = 0;
        cont = 0;
    }
    
    public ArrayList<Token> asignarTokens(ArrayList<PseudoToken> pseudotokens) {
        //ArrayList<Token> tokens = new ArrayList<>();
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
                        Token t = new Token(13, pt.getValor(), pt.getLinea());
                        tokens.add(t);
                    } else {
                        patron = Pattern.compile("^[^\\d].*");
                        encaja = patron.matcher(pt.getValor());
                        
                        if (encaja.find()) {
                            Token t = new Token(8, pt.getValor(), pt.getLinea());
                            tokens.add(t);
                        } else {
                            Token t = new Token(14, pt.getValor(), pt.getLinea());
                            tokens.add(t);
                        }
                    }
                }
            }
        }
        
        return tokens;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        compararConReglas();        
    }
    
    public boolean compararConReglas()
    {
        String error = "";
        ArrayList<Token> instruccion = new ArrayList<>();
        int i = posicion; //para el token pivote
        Token t = new Token();
        Traductor trad = new Traductor();
        boolean banError = false;
        
        int contFin = 0;
        while (i < tokens.size()) {
            t = tokens.get(i);
            
            String aux = reglas.getRegla(t.getTipo());
            if (contFin > 0) {
                System.out.println("No se esperaba: " + diccionario.obtenerEtiqueta(t.getTipo()) + " en la línea: " + t.getLinea());
                error = "No se esperaba: " + diccionario.obtenerEtiqueta(t.getTipo()) + " en la línea: " + t.getLinea();
                //Interprete.errores += error;
                interprete.setError(error);
                // ejecutar metodo para escribir errores
                i++;
            } else {
                if (!aux.equals("")){ //si tiene regla
                    String[] arr = aux.split(",");
                    int j = 0;
                    
                    while (j < arr.length){ //0-2
               
                        t = tokens.get(cont);
                        
                        if (j != 0) {
                            int numEntero = Integer.parseInt(arr[j]);
                            if (t.getTipo() == numEntero){
                                j++;
                                cont++;
                                instruccion.add(t);
                            } else {
                                if (!banError) {
                                    System.out.println("Se esperaba: " + diccionario.obtenerEtiqueta(numEntero) + " en la línea: " + t.getLinea() + " pero se recibió: " + diccionario.obtenerEtiqueta(t.getTipo()) + " - " + t.getValor());
                                    banError = true;
                                    error = "Se esperaba: " + diccionario.obtenerEtiqueta(numEntero) + " en la línea: " + t.getLinea() + " pero se recibió: " + diccionario.obtenerEtiqueta(t.getTipo()) + " - " + t.getValor();
                                    interprete.setError(error);
                                }
                                j = arr.length; //se sale, hay que comparar con el tamaño del array
                                i = tokens.size();
                            }
                        } else {
                            instruccion.add(t);
                            cont++;
                            j++;
                        }
                    }
                    
                    if (!banError)
                    {
                        // llamar a función que ejecuta la instrucción
                        // si instrucción es dormir
                        if (instruccion.get(0).getValor().equals("Dormir")) {
                            if (Integer.parseInt(instruccion.get(2).getValor()) <= 0 || Integer.parseInt(instruccion.get(2).getValor()) > 20) {
                                System.out.println("Tiempo fuera de los rangos válidos (1-20). Línea: " + t.getLinea());
                                banError = true;
                                i = tokens.size();
                                error = "Tiempo fuera de los rangos válidos (1-20). Línea: " + t.getLinea();
                                interprete.setError(error);
                            } else {
                                System.out.println("Durmiendo programa " + instruccion.get(2).getValor() + " segundos");
                                i = i+j; //0+3
                                posicion = i;

                                Timer timer = new Timer((Integer.parseInt(instruccion.get(2).getValor()) * 1000), this);
                                timer.setRepeats(false);
                                timer.start();
                                // terminar

                                return false;
                            }
                        } else {
                            int errorNo = trad.traducir(instruccion, interprete);

                            if (errorNo < 0)
                            {
                                banError = true;
                                i = tokens.size();
                                contFin++;

                                switch(errorNo)
                                {
                                    // Radio de cara demasiado chico
                                    case -1:
                                        error = "Funcion DibujarCara: La cara " + instruccion.get(8).getValor() + " es muy chica para visualizarse. Linea: " + t.getLinea();
                                    break;

                                    // Cara fuera de los bordes del lienzo
                                    case -2:

                                        error = "Funcion DibujarCara: Las coordenadas de la cara " + instruccion.get(8).getValor() + " estan fuera del marco de dibujo. Linea: " + t.getLinea();
                                    break;

                                    // Cara sobrepuesta con otra
                                    case -3:

                                        error = "Funcion DibujarCara: La cara " + instruccion.get(8).getValor() + " se sobrepone con alguna otra. Linea: " + t.getLinea(); 
                                    break;
                                    // No existe la cara ha eliminar
                                    case -4:

                                        error = "Funcion EliminarCara: La cara " + instruccion.get(2).getValor() + " no existe. Linea: " + t.getLinea(); 
                                    break;
                                    // Sleep fuera de rango 0-30
                                    case -5:

                                        error = "Funcion Dormir fuera del rango permitido [ 0-30 segs. ]. Linea: " + t.getLinea();
                                    break;
                                    // No existe la cara que se desea cambiar de modo
                                    case -6:

                                        error = "Funcion CambiarModo: La cara " + instruccion.get(2).getValor() + " no existe. Linea: " + t.getLinea(); 
                                    break;
                                    // Ya existe la cara que se pretende crear
                                    case -7:

                                        error = "Funcion DibujarCara: La cara " + instruccion.get(2).getValor() + " ya existe. Linea: " + t.getLinea();                                     

                                    default:
                                        System.out.println("Error default");
                                }

                                interprete.setError(error);
                            }
                        }
                        
                        instruccion = new ArrayList<>();
                    }
                    
                    i = i+j; //0+3
                    posicion = i;
                } else {
                    if (i == 0) {
                        if (!banError) {
                            System.out.println("Se esperaba: " + diccionario.obtenerEtiqueta(0) + " en la línea: " + t.getLinea() + " pero se recibió: " + diccionario.obtenerEtiqueta(t.getTipo()) + " - " + t.getValor());
                            error = "Se esperaba: " + diccionario.obtenerEtiqueta(0) + " en la línea: " + t.getLinea() + " pero se recibió: " + diccionario.obtenerEtiqueta(t.getTipo()) + " - " + t.getValor();
                            interprete.setError(error);
                            banError = true;
                        }

                    } else if (cont != tokens.size() - 1){
                        if (!banError) {
                            System.out.println("Se esperaba: nombre de función en la línea: " + t.getLinea() + " pero se recibió: " + diccionario.obtenerEtiqueta(t.getTipo()) + " - " + t.getValor());
                            error = "Se esperaba: nombre de función en la línea: " + t.getLinea() + " pero se recibió: " + diccionario.obtenerEtiqueta(t.getTipo()) + " - " + t.getValor();
                            interprete.setError(error);
                            banError = true;
                        }
                    }
                    i = tokens.size();
                }
                if (t.getTipo() == 2) {
                    contFin++;
                }
            }
        }
        
        if (i == tokens.size() && contFin <= 0) {
            if (t.getTipo() != 2) {
                if (!banError) {
                    System.out.println("Se esperaba: palabra reservada Fin en la línea: " + t.getLinea());
                    error = "Se esperaba: palabra reservada Fin en la línea: " + t.getLinea();
                    banError = true;
                    interprete.setError(error);
                }
            }
        }
        
        return banError;
    }
}
