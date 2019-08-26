package Controlador;

import Vista.MainFrame;
import Modelo.Limpiador;
import Modelo.Analizadores;
import Modelo.Diccionario;
import Modelo.PseudoToken;
import Modelo.Separador;
import Modelo.Sintaxis;
import Modelo.Token;
import java.util.ArrayList;

public class Interprete extends Thread
{
    private final MainFrame mFrame;
    public static String errores = "";
    
    public Interprete(MainFrame mFrame)
    {
        this.mFrame = mFrame;
    }
    
    public boolean interpretar(String code)
    {
        errores = "";
        
        Limpiador limpiador = new Limpiador();
        Separador separador = new Separador();
        Analizadores analizadores = new Analizadores(this);
        Diccionario diccionario = new Diccionario();
        Sintaxis reglas = new Sintaxis();
        
        String aux = limpiador.limpiar(code);
        ArrayList<PseudoToken> pseudoTokens = separador.separar(aux, limpiador.getPosiciones());
        ArrayList<Token> tokens = analizadores.asignarTokens(pseudoTokens, diccionario);
        
        return analizadores.compararConReglas(tokens, reglas, diccionario);
    }
    
    public int crearCara(int x, int y, int radio, String nombre, int modo)
    {
        return mFrame.getGrafo().agregarCara(x, y, radio, nombre, modo);
    }
    
    public int cambiarModo(String name, int modo)
    {
        int res = mFrame.getGrafo().cambiarModoCara(name, modo);
        
        // Si se encontro y cambio modo de cara
        if(res == 0)
            mFrame.refresh();
        
        return res;
    }
    
    public int eliminarCara(String nombre)
    {
        return mFrame.getGrafo().eliminarCara(nombre);
    }
    
    public int dormir(int segs)
    {
        if(segs < 0 || segs > 30)
            return -5;
        
        try
        {
            sleep((segs*1000));
        }
        catch(InterruptedException e) { System.out.println("Thread error sleep"); }
        
        return 0;
    }
    
    public void refresh() { mFrame.refresh(); }
    
    public void checkError()
    {
        mFrame.getTxtError().setText(errores);
    }
}