/**
 * Die Klasse stellt einen Wuerfel dar.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Wuerfel
{
    private int seiten;
    
     /**
     * Standartkonstruktor fuer Wuerfel-Objekte mit 6 Seiten.
     */
    public Wuerfel(){
        seiten = 6;
    }

    /**
     * Konstruktor fuer Wuerfel-Objekte.
     * 
     * @param pSeiten Die Anzahl an Seiten die der Wuerfel besitzt.
     */
    public Wuerfel(int pSeiten){
        seiten = pSeiten;
    }

    /**
     * Simuliert einen Wuerfelwurf und gibt ein Ergebnis zwischen 1 und der Anzahl an Wuerfelseiten zurueck.
     * 
     * @return Das Wuerfelergebnis.
     */
    public int wuerfeln(){
        int ergebnis = (int)(Math.random()*seiten)+1;
        System.out.println(ergebnis);
        return ergebnis;
    }
}
