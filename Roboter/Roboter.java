
/**
 * Beschreiben Sie hier die Klasse Roboter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.awt.*;
public class Roboter
{
    int xPos, yPos;
    
    public Roboter(int x, int y)
    {
        xPos = x;
        yPos = y;
    }

    public void zeigen(Graphics g)
    {
        //Bauch
        g.drawRect(xPos-35,yPos-45,70,90);
        //Arm links
        g.drawRect(xPos-55,yPos-45,20,50);
        //Arm rechts    
        g.drawRect(xPos+35,yPos-45,20,50);
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
        g.fillOval(xPos ,yPos , 1 , 1);
        //Hut
        //g.drawRect(xPos-30,yPos-115,60,10);
    }
}
