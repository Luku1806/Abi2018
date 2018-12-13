import java.awt.*;
import javax.swing.*;

/**
 * Zeichnet eine rekursive Dreiecksgrafik.
 *
 * @author Lukas Reining
 * @version 1.0
 */
public class Quadratrekursion extends JApplet
{
    private int startSize = 100;

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
        drawRects(g,(this.getWidth()/2)-startSize,(this.getHeight()/2)-startSize, startSize);
    }
    
    public void drawRects(Graphics g ,int x,int y, int size){
        if(size < 10){
            return;
        }
        g.drawRect(x, y, size,size);
        int newSize = size/2;
        drawRects(g,x-(newSize*2), y+(newSize/2), size/2);
        drawRects(g,x+size+newSize, y+(newSize/2), size/2);
    }
}
