package Vista;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.*;
import javax.swing.ImageIcon;

public class Cara
{
    public final static int feliz = 0;
    public final static int triste = 1;
    public final static int enojada = 2;
    public final static int dormida = 3;
    public final static int neutral = 4;
    public static int nCaras = 0;
    
    private String nombre;
    private int modo;
    private final Font font;
    private Point2D origen;
    private Ellipse2D cara;
    private Ellipse2D ojoIzq;
    private Ellipse2D ojoDer;
    private Color color;
    private int diametro;
    private int radio;
    private final int separacion = 5;
    
    public Cara(int x, int y, int radio, String nombre, int modo)
    {
        this.nombre = nombre;
        this.modo = modo;
        this.radio = radio;
        
        origen = new Point2D.Float(x, y);
        diametro = (radio+radio);
        color = Color.YELLOW;
        
        cara = new Ellipse2D.Float(x - radio, y - radio, diametro, diametro);
        ojoDer = new Ellipse2D.Float((float)cara.getCenterX()+(radio/4), (float)cara.getCenterY()-(radio/2), (radio/4), (radio/4));
        ojoIzq = new Ellipse2D.Float((float)cara.getCenterX()-(radio/2), (float)cara.getCenterY()-(radio/2), (radio/4), (radio/4));
        
        font = new Font("Arial", Font.BOLD, 11);
        nCaras++;
    }
    
    public void dibujar(Graphics2D g2)
    {
        g2.setPaint(color);
        g2.fill(cara);
        g2.setPaint(Color.BLACK);
        
        switch(modo)
        {
            case feliz:
                g2.fill(ojoDer);
                g2.fill(ojoIzq);
                g2.fillArc((int)(cara.getCenterX()-(radio/3)), (int)(cara.getCenterY()-(radio/4)), (int)(ojoDer.getWidth()*3), (int)(ojoDer.getHeight()*3), 180, 180);
            break;
                
            case triste:
                
            break;
                
            case enojada:
                
            break;
                
            case dormida:
                
            break;
            
            default:
                g2.fill(ojoDer);
                g2.fill(ojoIzq);
                g2.fillRect((int)(cara.getCenterX()-(radio/2)), (int)(cara.getCenterY()+(radio/8)), (int)(ojoDer.getWidth()*4), (int)(ojoDer.getHeight()/3));
        }
        
        g2.setFont(font);
        g2.drawString(nombre, ((float)origen.getX()-radio), ((float)origen.getY()-radio));
        
    }
    
    public Ellipse2D getCara() { return cara; }
    public String getNombre() { return nombre; }
    public Point2D getOrigen() { return origen; }
    public Color getColor() { return color; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setColor(Color c) { color = c; }
    public void setCirculo(Ellipse2D cara) { this.cara = cara; }
}