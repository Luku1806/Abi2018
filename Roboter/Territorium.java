
/**
 * Beschreiben Sie hier die Klasse Terretorium.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import java.awt.*;
import javax.swing.*;
public class Territorium extends JApplet
{
    Roboter robbi1, robbi2;
    public void init()
    {
        robbi1 = new Roboter(50,200);
        robbi2 = new Roboter(200,150);
    }

    public void paint(Graphics g)
    {
        robbi1.zeigen(g); 
        robbi2.zeigen(g);
    }
}