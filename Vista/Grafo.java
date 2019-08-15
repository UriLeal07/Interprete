package Vista;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class Grafo
{
    private final ArrayList <Cara> caras;
    
    public Grafo()
    {
        caras = new ArrayList <>();
    }
    
    public void agregarCara(int x, int y, int radio, String nombre, int modo)
    {
        Cara c = new Cara(x,y,radio,nombre,modo);
        //c.getCara().
	caras.add(c);
    }
    
    public String mostarCaras()
    {
        String cad = " ";
        
        for(Cara v: caras)
            cad += v.getNombre()+" , ";
        
        return cad;
    }

    public void dibujar(Graphics2D g2)
    {
        // Pintamos los caras
        for(Cara c : caras)
	    c.dibujar(g2);
    }
    
    public void limpiar(Lienzo l)
    {
        caras.clear();
        Cara.nCaras = 0;
        l.repaint();
    }
    
    public Cara getCara(Point2D p)
    {
	for(Cara v: caras)
            if(v.getCara().contains(p))
                return v;
        
	return null;
    }

    public int getIndex(Point2D p)
    {
        for(int i = 0; i < caras.size(); i++)
            if((caras.get(i)).getCara().contains(p))
                return i;
        
        return -1;
    }
    
    public int getIndex(String v)
    {
        int i;
        
        for(i = 0; i < caras.size(); i++)
            if(caras.get(i).getNombre().equals(v))
                return i;
        
        return -1;
    }
    
    public ArrayList <Cara> getLista() { return caras; }
}