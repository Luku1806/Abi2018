
/**
 * Die Klasse Schachtel haelt die Hoelzer.
 * 
 * @author Janiel 
 * @version 1.0
 */
public class Schachtel
{
    private int anzahl;

    /**
     * Konstruktor für Objekte der Klasse Schachtel.
     */
    public Schachtel()
    {
        anzahl = 0;
    }

    /**
     * Nimmt Hoelzer auf.
     * @param pAnzahl ist die Anzahl der aufzunehmenden Hoelzer.
     */
    public void setAnzahl(int pAnzahl)
    {
        anzahl = pAnzahl;
    }

    /**
     * Die sondierende Methode fuer das Attribut anzahl.
     */
    public int getAnzahl()
    {
        return anzahl;
    }
}
