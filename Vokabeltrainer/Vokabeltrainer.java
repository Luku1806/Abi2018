import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * Ein Vokabeltrainer mit Gui.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Vokabeltrainer{

    // Variablen
    private List<Vokabel> vokabelliste;
    // Ende Variablen

    /**
     * Konstruktor fuer Objekte der Klasse Vokabeltrainer
     */
    public Vokabeltrainer(){
        vokabelliste = new List<Vokabel>();
        addVokabel("Baum","Tree");
    }

    /**
     * Fuegt eine Vokabel hinzu.
     * 
     * @param pDeutsch Die deutsche Uebersetzung der Vokabel.
     * @param penglisch Die englische Uebersetzung der Vokabel.
     */
    public void addVokabel(String pDeutsch, String pEnglisch){
        vokabelliste.append(new Vokabel(pDeutsch,pEnglisch));
    }

    /**
     * Gibt die momentan erste Vokabel zurueck.
     * 
     * @return die momentan vorne stehende Vokabel.
     */
    public Vokabel getCurrentVokabel(){
        return vokabelliste.getContent();
    }
    
    /**
     * Setzt die aktuelle Vokabel auf die naechste in der Liste.
     * Wenn es bereits die letzte ist, wird wieder die erste Vokabel in der Liste angezeigt.
     */
    public void naechsteVokabel(){
        vokabelliste.next();
        if(!vokabelliste.hasAccess()){
            vokabelliste.toFirst();
        }
    }

}