
/**
 * Der Krieger ist eine Unterklasse des Helden und hat einen hoeheren Angriffswert da er eine hoehere Ausdauer hat.
 * 
 * @author Lukas Reining 
 * @version 1.0
 */
public class Krieger extends Held
{
    private int ausdauer; 

    /**
     * Konstruktor des Kriegers
     * @param pName Der Name des Kriegers.
     * @param pStaerke Die Staerke des Kriegers.
     * @param pMaxLebenspunkte Die Lebenspunkte zum Zeitpunkt der Erstellung des Kriegers.
     * @param pAusdauer Ausdauer des Kriegers.
     */
    public Krieger(String pName, int pStaerke, int pMaxLebenspunkte, int pAusdauer)
    {
        super(pName,pStaerke,pMaxLebenspunkte);
        this.ausdauer = pAusdauer;
        super.angriffswert = angriffswertBerechnen();
    }

    /**
     * Berechnet den durch die Ausdauer gesteigerten Angriffswert des Kriegers.
     * @return Der neue Angriffswert.
     */
    @Override
    public int angriffswertBerechnen(){
        return super.angriffswertBerechnen() * ausdauer;
    }
}
