
/**
 * Die Klasse Topf stellt einen Topf dar, dem die Spieler ihren Einsatz hinzufügen können,
 * oder Einsatz entnehmen können.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Topf
{
    private int topfInhalt;

    /**
     * Konstruktor fuer Objekte der Klasse Topf.
     */
    public Topf()
    {
    }

    /**
     * Gibt den Wert des Geldes im Topf an.
     * 
     * @return Der Wert des Geldes im Topf.
     */
    public int getInhalt()
    {
        return topfInhalt;
    }

    /**
     * Setzt den Wert des Geldes im Topf.
     * @param pWert Der Wert auf den der Topfinhalt geaendert werden soll.
     */
    public void setInhalt(int pWert){
        topfInhalt = pWert;
    }
}
