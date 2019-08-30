package Vista;

import java.awt.*;
import java.awt.geom.*;

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
    private BasicStroke stroke;
    private QuadCurve2D q;
    
    public Cara(int x, int y, int radio, String nombre, int modo)
    {
        this.nombre = nombre;
        this.modo = modo;
        this.radio = radio;
        
        origen = new Point2D.Float(x, y);
        diametro = (radio+radio);
        color = Color.YELLOW;
        stroke = new BasicStroke(3);
        q = new QuadCurve2D.Float();
        
        cara = new Ellipse2D.Float(x - radio, y - radio, diametro, diametro);
        
        ojoDer = new Ellipse2D.Float((float)cara.getCenterX()+(radio/4), (float)cara.getCenterY()-(radio/2), (radio/4), (radio/4));
        ojoIzq = new Ellipse2D.Float((float)cara.getCenterX()-(radio/2), (float)cara.getCenterY()-(radio/2), (radio/4), (radio/4));
        
        font = new Font("Consolas", Font.BOLD, 11);
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
            
                // Dibuja ojos
                g2.fill(ojoDer);
                g2.fill(ojoIzq);
                
                // Dibuja cara
                g2.fillArc((int)(cara.getCenterX()-(radio/3)), (int)(cara.getCenterY()-(radio/4)), (int)(ojoDer.getWidth()*3), (int)(ojoDer.getHeight()*3), 180, 180);
            break;
            
            case triste:
            
                // Dibuja ojo derecho
                q.setCurve(ojoDer.getMinX(), ojoDer.getMinY(), ojoDer.getCenterX(), ojoDer.getMaxY(), ojoDer.getMaxX(), ojoDer.getMinY());
                g2.setStroke(stroke);
                g2.draw(q);
                
                // Dibuja ojo izquierdo
                q.setCurve(ojoIzq.getMinX(), ojoIzq.getMinY(), ojoIzq.getCenterX(), ojoIzq.getMaxY(), ojoIzq.getMaxX(), ojoIzq.getMinY());
                g2.draw(q);
                
                // Dibuja cara
                g2.fillArc((int)(cara.getCenterX()-(radio/3)), (int)(cara.getCenterY()*1.1), (int)(ojoDer.getWidth()*3), (int)(ojoDer.getHeight()), 180, -180);
            break;
            
            case enojada:
                
                // Dibuja ojos
                g2.fillArc((int)(ojoDer.getMinX()), (int)(ojoDer.getMinY()), (int)(ojoDer.getWidth()), (int)(ojoDer.getHeight()), 180, 180);
                g2.fillArc((int)(ojoIzq.getMinX()), (int)(ojoIzq.getMinY()), (int)(ojoIzq.getWidth()), (int)(ojoIzq.getHeight()), 180, 180);
                
                // Dibuja cara
                g2.fillArc((int)(cara.getCenterX()-(radio/3)), (int)(cara.getCenterY()*1.01), (int)(ojoDer.getWidth()*3), (int)(ojoDer.getHeight()), 180, -180);
            break;
            
            case dormida:
                // Dibuja ojo derecho
                q.setCurve(ojoDer.getMinX(), ojoDer.getMinY(), ojoDer.getCenterX(), ojoDer.getMaxY(), ojoDer.getMaxX(), ojoDer.getMinY());
                g2.setStroke(stroke);
                g2.draw(q);
                
                // Dibuja ojo izquierdo
                q.setCurve(ojoIzq.getMinX(), ojoIzq.getMinY(), ojoIzq.getCenterX(), ojoIzq.getMaxY(), ojoIzq.getMaxX(), ojoIzq.getMinY());
                g2.draw(q);
                
                // Dibuja cara
                g2.fillRect((int)(cara.getCenterX()-(radio/2)), (int)(cara.getCenterY()+(radio/8)), (int)(ojoDer.getWidth()*4), (int)(ojoDer.getHeight()/3));
            break;
            
            default: // Neutral
                
                // Dibuja ojos
                g2.fill(ojoDer);
                g2.fill(ojoIzq);
                
                // Dibuja cara
                g2.fillRect((int)(cara.getCenterX()-(radio/2)), (int)(cara.getCenterY()+(radio/8)), (int)(ojoDer.getWidth()*4), (int)(ojoDer.getHeight()/3));
        }
        
        g2.setFont(font);
        g2.drawString(nombre, ((float)origen.getX()-radio), ((float)origen.getY()-radio));
    }
    
    public Ellipse2D getCara() { return cara; }
    public String getNombre() { return nombre; }
    public Point2D getOrigen() { return origen; }
    public int getRadio() { return radio; }
    public int getModo() { return modo; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCirculo(Ellipse2D cara) { this.cara = cara; }
    public void setModo(int modo) { this.modo = modo; }
}