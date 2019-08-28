package Modelo;

import Controlador.Interprete;
import java.util.ArrayList;

// Clase Traductor: se encarga de hacer la traducción de las funciones.
public class Traductor
{
    public int traducir(ArrayList<Token> instruccion, Interprete interprete)
    {
        String nombre;
        int coordX, coordY, radio, modo, nseg;
        int tipo = instruccion.get(0).getTipo();
        int res = 0;
        
        switch (tipo)
        {
            case 0:
                // inicio
                System.out.println("Inicio del programa");
            break;
            
            case 3:
                //dibujar cara
                coordX = Integer.parseInt(instruccion.get(2).getValor());
                coordY = Integer.parseInt(instruccion.get(4).getValor());
                radio = Integer.parseInt(instruccion.get(6).getValor());
                nombre = instruccion.get(8).getValor();
                if (instruccion.get(10).getValor().equals("feliz")) {
                    modo = 0;
                } else if (instruccion.get(10).getValor().equals("triste")) {
                    modo = 1;
                } else if (instruccion.get(10).getValor().equals("enojada")) {
                    modo = 2;
                } else if (instruccion.get(10).getValor().equals("dormida")) {
                    modo = 3;
                } else {
                    modo = 4;
                }
                
                System.out.println("Creando cara en (" + coordX + ", " + coordY + ") con radio = " + radio + " con "
                        + "nombre " + nombre + " y en modo " + instruccion.get(10).getValor());
                
                res = interprete.crearCara(coordX, coordY, radio, nombre, modo);
                
                
            break;
                
            case 4:
                // eliminar cara
                nombre = instruccion.get(2).getValor();
                res = interprete.eliminarCara(nombre);
                
                System.out.println("Eliminando cara con nombre " + nombre);
            break;
                
            case 5:
                // dormir
                
                nseg = Integer.parseInt(instruccion.get(2).getValor());
                System.out.println("Durmiendo programa " + nseg + " segundos");
                res = interprete.dormir(nseg);
                
            break;
                
            case 6:
                // cambiar modo
                nombre = instruccion.get(2).getValor();
                if (instruccion.get(4).getValor().equals("feliz")) {
                    modo = 0;
                } else if (instruccion.get(4).getValor().equals("triste")) {
                    modo = 1;
                } else if (instruccion.get(4).getValor().equals("enojada")) {
                    modo = 2;
                } else if (instruccion.get(4).getValor().equals("dormida")) {
                    modo = 3;
                } else {
                    modo = 4;
                }
                
                res = interprete.cambiarModo(nombre, modo);
                System.out.println("Cambiando modo de cara con nombre " + nombre + " a modo " + instruccion.get(4).getValor());
            
            break;
                
            case 2:
                // fin
                System.out.println("Fin del programa");
            break;
            
            default:
                System.out.println("Default");
        }
        
        return res;
    }
}

