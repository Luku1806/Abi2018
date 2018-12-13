
import java.awt.*;
import javax.swing.*;

/**
 * Tragen Sie hier eine Beschreibung der Applet-Klasse Zeichenbrett ein.
 *
 * @author (Kilian Jacoby) 
 * @version (1.0)
 */
public class Zeichenbrett extends JApplet
{

    /**
     * Wird vom Browser oder Applet-Viewer aufgerufen, um dieses Applet darüber 
     * zu informieren, dass es in das System geladen wurde. Wird stets vor dem
     * ersten Aufruf der start-Methode aufgerufen.
     */
    public void init()
    {
        // Workaround für einen Sicherheitskonflikt mit einigen Browsern wie
        // einige Versionen von Netscape & Internet Explorer, die keinen Zugriff
        // auf die AWT-Systemevent-Queue erlauben, wie ihn JApplets beim Starten
        // vornehmen. Ist für Ihren Browser möglicherweise unnötig.
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);

        // tragen Sie hier die Initialisierungen ein, die Ihr Applet benötigt

    }

    /**
     * Dies ist wahrscheinlich die wichtigste Methode in Ihrem Applet: hier wird
     * das Applet gezeichnet. Die paint-Methode wird jedes Mal aufgerufen, wenn 
     * das Applet auf dem Bildschirm gezeichnet werden soll. Tragen Sie daher 
     * hier den Code ein, der das Applet darstellt.
     *
     * @param  g   das Graphics-Objekt für dieses Applet
     */
    public void paint(Graphics g)
    {
        drawPicture(g);
    }

    /**
     * Schreibt einen Text in die Mitte des Bildschirms
     */
    public void mitte(Graphics g){
        g.drawString("Beispiel-JApplet", this.getWidth()/2 - 50,  this.getHeight()/2);
    }

    /**
     * Zeichnet eine Reihe aus 10 Kreisen
     */
    public void zehnerReihen(Graphics g){
        for(int j=0; j<10; j++){
            for (int i = 0; i < 10; i++){
                g.drawOval(40*i,40*j,40,40);
            }
        }
    }

    /**
     * Zeichnet ein 9x9 Muster aus Kreisen , diese sind abwechselnd schwarz und weiß
     */
    public void neunerReihenMuster(Graphics g){
        boolean schwarz = false;
        for(int j=0; j<9; j++){
            for (int i = 0; i < 9; i++){
                if(schwarz){
                    g.fillOval(40*i,40*j,40,40);
                    schwarz = false;
                }else if(!schwarz){
                    g.drawOval(40*i,40*j,40,40);
                    schwarz = true;
                }
            }
        }
    }

    /**
     * Zeichnet einen zweidimensionalen Farbverlauf
     */
    public void zewiDimenFarbverlauf(Graphics g){
        for(int j=0; j<10; j++){
            for (int i = 0; i < 10; i++){
                g.setColor (new Color(i*25,255, j*25));
                g.fillRect(i*40,j*40,40,40);
                g.setColor(Color.BLACK);
                g.drawRect(i*40,j*40,40,40);
            }
        }
    }
    
    /**
     * Führ jeden Grafik-Befehl einmal aus
     */
    public void graphicBefehle(Graphics g){
         g.setColor(Color.GREEN);
        g.drawLine(0 , this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        g.fillArc(0, 0, 100, 100, 0, 180);
        g.fillRect(300 , 300 , 100 , 100);
        g.fillRoundRect(200,10,100,100,20,20);
        g.fillOval(100 , 300 , 100 , 100);
    }
    
    /**
     * Malt ein Bild
     */
    public void drawPicture(Graphics g){
        g.drawLine(0 , this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        g.drawLine(this.getWidth()/2-50 ,this.getHeight()/2 + 150 , this.getWidth()/2 - 40 , this.getHeight()/2 + 20);
        g.drawLine(this.getWidth()/2+10 ,this.getHeight()/2 + 150 , this.getWidth()/2 , this.getHeight()/2 + 20);
        g.fillOval(this.getWidth()/2 - 65 , this.getHeight()/2 - 90, 90 , 120);
        g.fillOval(this.getWidth()/2 - 52 , this.getHeight()/2 - 160, 75 , 75);
        g.setColor(Color.GREEN);
        g.fillOval(this.getWidth()/2 - 32 , this.getHeight()/2 - 145, 5 , 5);
        g.fillOval(this.getWidth()/2 , this.getHeight()/2 - 145, 5 , 5);
    }
}
