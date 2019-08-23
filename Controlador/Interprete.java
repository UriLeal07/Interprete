package Controlador;

import Vista.MainFrame;
import java.awt.Graphics;
import Modelo.Limpiador;
import Modelo.Analizadores;
import Modelo.Diccionario;
import Modelo.PseudoToken;
import Modelo.Regla;
import Modelo.Separador;
import Modelo.Sintaxis;
import Modelo.Token;
import java.util.ArrayList;

public class Interprete
{
    private MainFrame mFrame;
    //private Limpiador limpiador;
   // private Analizadores analizadores;
    //private ArrayList<PseudoToken> pseudoTokens;
    //private Separador separador;
    //private ArrayList<Token> tokens;
    //private Diccionario diccionario;
    //private Sintaxis reglas;
    public static String errores = "";
    
    public Interprete(MainFrame mFrame)
    {
        this.mFrame = mFrame;
        //limpiador = new Limpiador();
        //analizadores = new Analizadores(this);
        //pseudoTokens = new ArrayList<>();
        //separador = new Separador();
        //tokens = new ArrayList<>();
        //diccionario = new Diccionario();
        //reglas = new Sintaxis();
    }
    
    public boolean interpretar(String code)
    {
        errores = "";
        
        Limpiador limpiador = new Limpiador();
        Separador separador = new Separador();
        ArrayList<PseudoToken> pseudoTokens = new ArrayList<>();
        ArrayList<Token> tokens = new ArrayList<>();
        Analizadores analizadores = new Analizadores(this);
        Diccionario diccionario = new Diccionario();
        Sintaxis reglas = new Sintaxis();
        
        String aux = limpiador.limpiar(code);
        pseudoTokens = separador.separar(aux, limpiador.getPosiciones());
        tokens = analizadores.asignarTokens(pseudoTokens, diccionario);
        
        return analizadores.compararConReglas(tokens, reglas, diccionario);
    }
    
    public int crearCara(int x, int y, int radio, String nombre, int modo)
    {
        return mFrame.getGrafo().agregarCara(x, y, radio, nombre, modo);
    }
    
    public void checkError()
    {
        mFrame.getTxtError().setText(errores);
    }
    
    
}