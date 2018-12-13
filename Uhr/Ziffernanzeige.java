
/**
 * Es wird eine Anzeige für ein oder mehrstellige Zahlen erzeugt,
 * die bis zu einem gesetzten Limit erhöht werden kann und dann auf 0 zurück springt.
 * @author Kilian und Lukas 
 * @version 1.0
 */
public class Ziffernanzeige
{
    // Attribute
    private int wert;
    private int maxWert;

    /**
     * Konstruktor für Objekte der Klasse Ziffernanzeige
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
     * Konstruktor für Objekte der Klasse Ziffernanzeige
     * @param pMaxWert Der maxmimale Wert bevor der Wert auf 0 gesetzt wird
     */
    public Ziffernanzeige(int pMaxWert)
    {
        maxWert = pMaxWert;
        wert = 0;
    }

    /**
     * Die Sondierende Methode für das Attribut wert.
     * @return Gibt das Attribut wert zurück
     */
    public int getWert(){
        return wert;
    }
    
    /**
     * Setzt den Wert der Anzeige auf einen gewählten Wert , solange dieser den maxWert nicht übersteigt
     * @param Der gewünschte Wert auf den der Wert gesetzt werden soll
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
     * Falls der Wert unter 10 liegt wird eine führende 0 hinzugefügt
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
