package Vista;

import java.awt.*;
import javax.swing.*;

public class Lienzo extends JPanel
{
    private Grafo grafo;
    
    public Lienzo(Grafo g1)
    {
	//setLayout(null); // Quitamos gestor de distribucion
	grafo = g1;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	setBackground(Color.white);
        grafo.dibujar(g2);
    }
    
    public void limpiar(Grafo g1)
    {
	grafo = g1;
        Cara.nCaras = 0;
	repaint();
    }
}