
/**
 * Es wird eine Anzeige f�r ein oder mehrstellige Zahlen erzeugt,
 * die bis zu einem gesetzten Limit erh�ht werden kann und dann auf 0 zur�ck springt.
 * @author Kilian und Lukas 
 * @version 1.0
 */
public class Ziffernanzeige
{
    // Attribute
    private int wert;
    private int maxWert;

    /**
     * Konstruktor f�r Objekte der Klasse Ziffernanzeige
     * @param pMaxWert Der maxmimale Wert bevor der Wert auf 0 gesetzt wird
     * @param pWert Der Wert bei dem gestartet werden soll
     */
    public Ziffernanzeige(int pMaxWert , int pWert)
    {
        maxWert = pMaxWert;
        if (pWert <= maxWert && pWert >= 0){
            wert = pWert;
        }else {
            System.out.println("Falscher Wert");
        }   
    }
    
    /**
     * Konstruktor f�r Objekte der Klasse Ziffernanzeige
     * @param pMaxWert Der maxmimale Wert bevor der Wert auf 0 gesetzt wird
     */
    public Ziffernanzeige(int pMaxWert)
    {
        maxWert = pMaxWert;
        wert = 0;
    }

    /**
     * Die Sondierende Methode f�r das Attribut wert.
     * @return Gibt das Attribut wert zur�ck
     */
    public int getWert(){
        return wert;
    }
    
    /**
     * Setzt den Wert der Anzeige auf einen gew�hlten Wert , solange dieser den maxWert nicht �bersteigt
     * @param Der gew�nschte Wert auf den der Wert gesetzt werden soll
     */
    public void setWert(int pWert){
        if (pWert <= maxWert && pWert >= 0){
            wert = pWert;
        }else {
            System.out.println("Falscher Wert");
        }   
    }
    
    /**
     * Gibt dein Anzeigewert zweistellig aus.
     * Falls der Wert unter 10 liegt wird eine f�hrende 0 hinzugef�gt
     */
    public String getAnzeigewert(){
        if (wert < 10){
            return "0" + wert;
        }else {
            return "" + wert;
        }
    }
    
    /**
     * Erhoeht den Wert um 1.
     * Wenn der maxWert erreicht ist, wird der Wert auf 0 gesetzt.
     */
    public void erhoehen(){
        wert++;
        if (wert == maxWert){
            wert = 0;
        }
    }
}
