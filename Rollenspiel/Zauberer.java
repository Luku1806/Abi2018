
/**
 * Der Zauberer ist eine Unterklasse des Helden und kann sich selbst heilen.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Zauberer extends Held
{
    private int zauberkraft;

    /**
     * Konstruktor des Zauberers.
     * @param pName Der Name des Zauberers.
     * @param pStaerke Die Staerke des Zauberers.
     * @param pMaxLebenspunkte Die Lebenspunkte zum Zeitpunkt der Erstellung des Zauberers.
     * @param pZauberkraft Zauberkraft des Zauberers.
     */
    public Zauberer(String pName, int pStaerke, int pMaxLebenspunkte, int pZauberkraft)
    {
        super(pName,pStaerke,pMaxLebenspunkte);
        this.zauberkraft = pZauberkraft;
    }

    /**
     * Fuellt die eigenen Lebenspunkte um die Hoehe der Zauberkraft auf.
     */
    public void heilen(){
        lebenspunkte += this.zauberkraft;
    }

    /**
     * Die sondierende Methode für die Zauberkraft.
     * @return Die Zauberkraft.
     */
    public int getZauberkraft(){
        return this.zauberkraft;
    }
}
