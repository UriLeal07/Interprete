package Controlador;

import Vista.MainFrame;
import Modelo.Limpiador;
import Modelo.Analizadores;
import Modelo.Diccionario;
import Modelo.PseudoToken;
import Modelo.Separador;
import Modelo.Sintaxis;
import java.awt.Color;
import java.util.ArrayList;

public class Interprete
{
    private final MainFrame mFrame;
    private static int nInstruccion = 0;
    
    public Interprete(MainFrame mFrame)
    {
        this.mFrame = mFrame;
        nInstruccion = 0;
    }
    
    public void interpretar(String code)
    {
        nInstruccion = 0;
        Limpiador limpiador = new Limpiador();
        Separador separador = new Separador();
        Sintaxis reglas = new Sintaxis();
        Diccionario diccionario = new Diccionario();
        Analizadores analizadores = new Analizadores(this, reglas, diccionario);
        
        String aux = limpiador.limpiar(code);
        ArrayList<PseudoToken> pseudoTokens = separador.separar(aux, limpiador.getPosiciones());
        analizadores.asignarTokens(pseudoTokens);
        
        analizadores.compararConReglas();
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
    
    public void refresh() { mFrame.refresh(); }
    
    public void finish(boolean fin) { mFrame.finish(!fin); }
    
    public void setError(String err) { mFrame.getTxtError().setText(err); }
    
    public void printOutput(String out) { mFrame.getTxtOutput().append((++nInstruccion)+".- "+out+"\n"); }
    
    public void printOutError(String out)
    {
        mFrame.getTxtOutput().setForeground(Color.red);
        mFrame.getTxtOutput().append((++nInstruccion)+".- "+out+"\n");
    }
}