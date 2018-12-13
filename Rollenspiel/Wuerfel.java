/**
 * Ein Wuerfel.
 * @author Lukas Reining
 * @version 1.0
 */
import java.util.*;

public class Wuerfel
{
    private int anzahlWuerfelseiten;
    private Random random;

    /**
     * Konstruktor fuer den Würfel.
     * @param pAnzahlWuerfelseiten Die Anzahl der Wuerfelseiten.
     */
    public Wuerfel(int pAnzahlWuerfelseiten)
    {
       anzahlWuerfelseiten = pAnzahlWuerfelseiten;
    }

    /**
     * Gibt einen zufaelligen Wert zwischen 1 und der Anzahl von Wuerfelseiten aus.
     * @return Der Zufallswert:
     */
    public int wuerfeln(){
     return random.nextInt(anzahlWuerfelseiten)+ 1;
    }
}
