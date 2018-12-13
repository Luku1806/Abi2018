
/**
 * Beschreiben Sie hier die Klasse Player.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.awt.Graphics;
import java.awt.Color;

public class Player
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public int x , y;
    public int directionX = 0;
    public int directionY = 0;
    public int speed;
    public Color color;

    /**
     * Konstruktor für Objekte der Klasse Player
     */
    public Player(int pX , int pY , Color c , int pSpeed)
    {
        x = pX;
        y = pY;
        color = c;
        speed = pSpeed;
    }

    public void render(Graphics g){
        g.setColor(color);
        g.fillOval(x , y , 50 , 50);
    }
    
    public void move(){
        x+= directionX * speed;
	    y+= directionY * speed;
    }
    
    public void update(){
        move();
    }
}
