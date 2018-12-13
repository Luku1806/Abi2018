/**
 * Beschreiben Sie hier die Klasse Roboter.
 * 
 * @author (Kilian und Lukas) 
 * @version (1.0)
 */
import java.awt.*;
public class RoboterResizable
{
    int xPos, yPos;
    int richtung = 1;
    int schrittweite = 50;
    int groessenFaktor;

    public RoboterResizable(int x, int y , int z)
    {
        xPos = x;
        yPos = y;
        groessenFaktor = z;
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
        if(richtung == 1){
            groessenFaktor++;
        }
        else if(richtung == 2){
            xPos +=schrittweite;
        }
        else if(richtung == 3){
            if(groessenFaktor > 1){
                groessenFaktor--;
            }
        }
        else if(richtung == 4){
            xPos -= schrittweite;
        }
    }

    /**
     * Zeichnet den Roboter in der Frontalansicht.
     */
    public void frontalAnsicht(Graphics g){
        //Bauch
        int bauchBreite = 14*groessenFaktor;
        int bauchHoehe = 18*groessenFaktor;
        g.drawRect(xPos-(bauchBreite/2),yPos-(bauchHoehe/2),bauchBreite,bauchHoehe);

        //Arme
        int armBreite = 4*groessenFaktor;
        int armHoehe = 12*groessenFaktor;
        //Arm links
        g.drawRect(xPos-(bauchBreite/2)-armBreite,yPos-(bauchHoehe/2),armBreite,armHoehe);        
        //Arm rechts    
        g.drawRect(xPos+(bauchBreite/2),yPos-(bauchHoehe/2),armBreite,armHoehe);

        //Hände
        int handHoehe = 3*groessenFaktor;
        //Hand links
        g.drawRect(xPos-(bauchBreite/2)-armBreite,yPos,armBreite,handHoehe);
        //Hand rechts
        g.drawRect(xPos+(bauchBreite/2),yPos,armBreite,handHoehe);

        //Beine
        int beinBreite = 4*groessenFaktor;
        int beinHoehe = 10*groessenFaktor;
        //Bein links
        g.drawRect(xPos-beinBreite-2*groessenFaktor ,yPos+(bauchHoehe/2),beinBreite,beinHoehe);
        //Bein rechts
        g.drawRect(xPos+(2*groessenFaktor),yPos+(bauchHoehe/2),beinBreite,beinHoehe);

        //Hals
        int halsBreite = 4*groessenFaktor;
        int halsHoehe = 4*groessenFaktor;
        g.drawRect(xPos-(halsBreite/2),yPos-(bauchHoehe/2)-halsHoehe,halsBreite,halsHoehe);

        //Kopf
        int kopfBreite = 10*groessenFaktor;
        int kopfHoehe = 10*groessenFaktor;
        g.drawRect(xPos-(kopfBreite/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe,kopfBreite,kopfHoehe);

        //Augen
        int augenBreite = 3*groessenFaktor;
        int augenHoehe = 3*groessenFaktor;
        int augenYPos = yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe + augenHoehe;
        //Auge links
        g.drawOval(xPos-augenBreite,augenYPos,augenBreite,augenHoehe);
        //Auge rechts
        g.drawOval(xPos,augenYPos,augenBreite,augenHoehe);

        //Popillen
        //Farbe Popillen
        g.setColor(Color.GREEN);
        //Popille linkes Auge
        g.fillOval(xPos-(2*groessenFaktor),augenYPos+groessenFaktor,groessenFaktor,groessenFaktor);
        //Popille rechtes Auge
        g.fillOval(xPos+groessenFaktor,augenYPos+groessenFaktor,groessenFaktor,groessenFaktor );
        g.setColor(Color.BLACK);

        //Mund
        int mundBreite = 5*groessenFaktor;
        int mundHoehe = 3*groessenFaktor;
        g.drawArc(xPos-(mundBreite/2),yPos-(bauchHoehe/2)-(halsHoehe)-(mundHoehe)-(mundHoehe/4),mundBreite,mundHoehe,180,180);
        //Bauchnabel
        g.fillRect(xPos-2 ,yPos-2 , 4 , 4);

        //Hut
        //Untersetite
        g.drawRect(xPos-((15*groessenFaktor)/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe-(groessenFaktor),15*groessenFaktor,groessenFaktor);
        //Oberer Teil
        g.drawRect(xPos-((10*groessenFaktor)/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe-(groessenFaktor)-(5*groessenFaktor),10*groessenFaktor,5*groessenFaktor);
    }

    /**
     * Zeichnet den Roboter in der Rückansicht.
     */
    public void rückAnsicht(Graphics g){
        //Bauch
        int bauchBreite = 14*groessenFaktor;
        int bauchHoehe = 18*groessenFaktor;
        g.drawRect(xPos-(bauchBreite/2),yPos-(bauchHoehe/2),bauchBreite,bauchHoehe);

        //Arme
        int armBreite = 4*groessenFaktor;
        int armHoehe = 12*groessenFaktor;
        //Arm links
        g.drawRect(xPos-(bauchBreite/2)-armBreite,yPos-(bauchHoehe/2),armBreite,armHoehe);        
        //Arm rechts    
        g.drawRect(xPos+(bauchBreite/2),yPos-(bauchHoehe/2),armBreite,armHoehe);

        //Hände
        int handHoehe = 3*groessenFaktor;
        //Hand links
        g.drawRect(xPos-(bauchBreite/2)-armBreite,yPos,armBreite,handHoehe);
        //Hand rechts
        g.drawRect(xPos+(bauchBreite/2),yPos,armBreite,handHoehe);

        //Beine
        int beinBreite = 4*groessenFaktor;
        int beinHoehe = 10*groessenFaktor;
        //Bein links
        g.drawRect(xPos-beinBreite-2*groessenFaktor ,yPos+(bauchHoehe/2),beinBreite,beinHoehe);
        //Bein rechts
        g.drawRect(xPos+(2*groessenFaktor),yPos+(bauchHoehe/2),beinBreite,beinHoehe);

        //Hals
        int halsBreite = 4*groessenFaktor;
        int halsHoehe = 4*groessenFaktor;
        g.drawRect(xPos-(halsBreite/2),yPos-(bauchHoehe/2)-halsHoehe,halsBreite,halsHoehe);

        //Kopf
        int kopfBreite = 10*groessenFaktor;
        int kopfHoehe = 10*groessenFaktor;
        g.drawRect(xPos-(kopfBreite/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe,kopfBreite,kopfHoehe);

        //Hut
        //Untersetite
        g.drawRect(xPos-((15*groessenFaktor)/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe-(groessenFaktor),15*groessenFaktor,groessenFaktor);
        //Oberer Teil
        g.drawRect(xPos-((10*groessenFaktor)/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe-(groessenFaktor)-(5*groessenFaktor),10*groessenFaktor,5*groessenFaktor);
    }

    /**
     * Zeichnet den Roboter in der linken Seitansicht.
     */
    public void linkeSeitansicht(Graphics g){
        //Bauch
        int bauchBreite = 10*groessenFaktor;
        int bauchHoehe = 18*groessenFaktor;
        g.drawRect(xPos-(bauchBreite/2),yPos-(bauchHoehe/2),bauchBreite,bauchHoehe);

        //Arme
        int armBreite = 4*groessenFaktor;
        int armHoehe = 12*groessenFaktor;
        //Arm links
        g.drawRect(xPos-(armBreite/2),yPos-(bauchHoehe/2),armBreite,armHoehe);        

        //Hände
        int handHoehe = 3*groessenFaktor;
        //Hand links
        g.drawRect(xPos-(armBreite/2),yPos,armBreite,handHoehe);;

        //Beine
        int beinBreite = 4*groessenFaktor;
        int beinHoehe = 10*groessenFaktor;
        //Bein links
        g.drawRect(xPos-(beinBreite/2),yPos+(bauchHoehe/2),beinBreite,beinHoehe);

        //Hals
        int halsBreite = 4*groessenFaktor;
        int halsHoehe = 4*groessenFaktor;
        g.drawRect(xPos-(halsBreite/2),yPos-(bauchHoehe/2)-halsHoehe,halsBreite,halsHoehe);

        //Kopf
        int kopfBreite = 10*groessenFaktor;
        int kopfHoehe = 10*groessenFaktor;
        g.drawRect(xPos-(kopfBreite/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe,kopfBreite,kopfHoehe);

        //Auge links
        int augenBreite = 2*groessenFaktor;
        int augenHoehe = 3*groessenFaktor;
        int augenYPos = yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe + augenHoehe;
        g.drawArc(xPos-(kopfBreite/2)-augenBreite+groessenFaktor,augenYPos,augenBreite,augenHoehe,90,180);

        //Hut
        //Untersetite
        g.drawRect(xPos-((15*groessenFaktor)/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe-(groessenFaktor),15*groessenFaktor,groessenFaktor);
        //Oberer Teil
        g.drawRect(xPos-((10*groessenFaktor)/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe-(groessenFaktor)-(5*groessenFaktor),10*groessenFaktor,5*groessenFaktor);
    }

    /**
     * Zeichnet den Roboter in der rechten Seitansicht.
     */
    public void rechteSeitansicht(Graphics g){
        //Bauch
        int bauchBreite = 10*groessenFaktor;
        int bauchHoehe = 18*groessenFaktor;
        g.drawRect(xPos-(bauchBreite/2),yPos-(bauchHoehe/2),bauchBreite,bauchHoehe);

        //Arme
        int armBreite = 4*groessenFaktor;
        int armHoehe = 12*groessenFaktor;
        //Arm links
        g.drawRect(xPos-(armBreite/2),yPos-(bauchHoehe/2),armBreite,armHoehe);        

        //Hände
        int handHoehe = 3*groessenFaktor;
        //Hand links
        g.drawRect(xPos-(armBreite/2),yPos,armBreite,handHoehe);;

        //Beine
        int beinBreite = 4*groessenFaktor;
        int beinHoehe = 10*groessenFaktor;
        //Bein links
        g.drawRect(xPos-(beinBreite/2),yPos+(bauchHoehe/2),beinBreite,beinHoehe);

        //Hals
        int halsBreite = 4*groessenFaktor;
        int halsHoehe = 4*groessenFaktor;
        g.drawRect(xPos-(halsBreite/2),yPos-(bauchHoehe/2)-halsHoehe,halsBreite,halsHoehe);

        //Kopf
        int kopfBreite = 10*groessenFaktor;
        int kopfHoehe = 10*groessenFaktor;
        g.drawRect(xPos-(kopfBreite/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe,kopfBreite,kopfHoehe);

        //Auge links
        int augenBreite = 2*groessenFaktor;
        int augenHoehe = 3*groessenFaktor;
        int augenYPos = yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe + augenHoehe;
        g.drawArc(xPos+(kopfBreite/2)-groessenFaktor,augenYPos,augenBreite,augenHoehe,270,180);

        //Hut
        //Untersetite
        g.drawRect(xPos-((15*groessenFaktor)/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe-(groessenFaktor),15*groessenFaktor,groessenFaktor);
        //Oberer Teil
        g.drawRect(xPos-((10*groessenFaktor)/2),yPos-(bauchHoehe/2)-halsHoehe-kopfHoehe-(groessenFaktor)-(5*groessenFaktor),10*groessenFaktor,5*groessenFaktor);

    }

    /**
     * Die sondierende Methode zur Schrittweite
     * @return Die Schrittweite
     */
    public int getSchrittweite(){
        return schrittweite;
    }

}