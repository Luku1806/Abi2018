
/**
 * Beschreiben Sie hier die Klasse Roboter.
 * 
 * @author (Kilian und Lukas) 
 * @version (1.0)
 */
import java.awt.*;
public class Roboter
{
    int xPos, yPos;
    int richtung = 1;
    int schrittweite = 50;

    public Roboter(int x, int y)
    {
        xPos = x;
        yPos = y;
    }

    public void zeigen(Graphics g)
    {
        if(richtung == 1){
            frontalAnsicht(g);
        }else if (richtung == 2){
            rechteSeitansicht(g);
        }else if (richtung == 3){
            rückAnsicht(g);
        }else if (richtung == 4){
            linkeSeitansicht(g);
        }
    }

    /**
     * Ändert die Richtung, sodass der Roboter sich bei jedem Aufruf die Ansicht nach links verschiebt.
     */
    public void dreheLinks(){
        richtung++;   
        if (richtung > 4){
            richtung = 1;
        } 
    }

    public void geheVor(){
        if(richtung == 2){
            xPos = xPos + schrittweite;
        }else if(richtung == 4){
             xPos = xPos - schrittweite;
        }
    }

    /**
     * Zeichnet den Roboter in der Frontalansicht.
     */
    public void frontalAnsicht(Graphics g){
        //Bauch
        g.drawRect(xPos-35,yPos-45,70,90);
        //Arm links
        g.drawRect(xPos-55,yPos-45,20,60);
        //Hand links
        g.drawRect(xPos-55,yPos,20,15);
        //Arm rechts    
        g.drawRect(xPos+35,yPos-45,20,60);
        //Hand rechts
        g.drawRect(xPos+35,yPos,20,15);
        //Bein links
        g.drawRect(xPos+10,yPos+45,20,50);
        //Bein rechts
        g.drawRect(xPos-30,yPos+45,20,50);
        //Hals
        g.drawRect(xPos-10,yPos-65,20,20);
        //Kopf
        g.drawRect(xPos-20,yPos-105,40,40);
        //Auge links
        g.drawOval(xPos-15,yPos-95,15,15 );
        //Auge rechts
        g.drawOval(xPos,yPos-95,15,15 );
        //Farbe Popillen
        g.setColor(Color.GREEN);
        //Popille linkes Auge
        g.fillOval(xPos-11,yPos-91,4,4 );
        //Popille rechtes Auge
        g.fillOval(xPos+4,yPos-91,4,4 );
        g.setColor(Color.BLACK);
        //Mund
        g.drawArc(xPos-10,yPos-80,20,10,180,180);
        //Bauchnabel
        g.fillRect(xPos-2 ,yPos-2 , 4 , 4);
        //Hut
        g.drawRect(xPos-30,yPos-110,60,5);
        g.drawRect(xPos-20,yPos-130,40,20);
    }

    /**
     * Zeichnet den Roboter in der Rückansicht.
     */
    public void rückAnsicht(Graphics g){
        //Bauch
        g.drawRect(xPos-35,yPos-45,70,90);
        //Arm links
        g.drawRect(xPos-55,yPos-45,20,60);
        //Hand links
        g.drawRect(xPos-55,yPos,20,15);
        //Arm rechts    
        g.drawRect(xPos+35,yPos-45,20,60);
        //Hand rechts
        g.drawRect(xPos+35,yPos,20,15);
        //Bein links
        g.drawRect(xPos+10,yPos+45,20,50);
        //Bein rechts
        g.drawRect(xPos-30,yPos+45,20,50);
        //Hals
        g.drawRect(xPos-10,yPos-65,20,20);
        //Kopf
        g.drawRect(xPos-20,yPos-105,40,40);
        //Hut
        g.drawRect(xPos-30,yPos-110,60,5);
        g.drawRect(xPos-20,yPos-130,40,20);
    }

    /**
     * Zeichnet den Roboter in der linken Seitansicht.
     */
    public void linkeSeitansicht(Graphics g){
        //Bauch
        g.drawRect(xPos-20,yPos-45,40,90);
        //Arm links
        g.drawRect(xPos-10,yPos-45,20,60);
        //Hand links
        g.drawRect(xPos-10,yPos,20,15);
        //Bein links
        g.drawRect(xPos-10,yPos+45,20,50);
        //Hals
        g.drawRect(xPos-10,yPos-65,20,20);
        //Kopf
        g.drawRect(xPos-20,yPos-105,40,40);
        //Auge links
        g.drawArc(xPos-24,yPos-95,5,15,90,180);
        //Hut
        g.drawRect(xPos-30,yPos-110,60,5);
        g.drawRect(xPos-20,yPos-130,40,20);
    }

    /**
     * Zeichnet den Roboter in der rechten Seitansicht.
     */
    public void rechteSeitansicht(Graphics g){
        //Bauch
        g.drawRect(xPos-20,yPos-45,40,90);
        //Arm links
        g.drawRect(xPos-10,yPos-45,20,60);
        //Hand links
        g.drawRect(xPos-10,yPos,20,15);
        //Bein links
        g.drawRect(xPos-10,yPos+45,20,50);
        //Hals
        g.drawRect(xPos-10,yPos-65,20,20);
        //Kopf
        g.drawRect(xPos-20,yPos-105,40,40);
        //Auge links
        g.drawArc(xPos+19,yPos-95,5,15,270,180);
        //Hut
        g.drawRect(xPos-30,yPos-110,60,5);
        g.drawRect(xPos-20,yPos-130,40,20);
    }
    
    public int getSchrittweite(){
        return schrittweite;
    }
}
