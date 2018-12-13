/**
 * Das Monster, gegen dass der Held kaempfen kann.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Monster
{
    private int angriffswert;
    private int lebenspunkte;

    /**
     * Konstruktor für das Monster.
     * @param pAngriffswert Der Angriffswert des Monsters.
     * @param pLebenspunkte Die Lebenspunkte zur Zeit der Erstellung des Monsters.
     */
    public Monster(int pAngriffswert,int pLebenspunkte)
    {
        this.angriffswert = pAngriffswert;
        this.lebenspunkte = pLebenspunkte;
    }

    /**
     * Die sondierende Methode für die Lebenspunkte des Spielers.
     * @return Die Lebenspunkte des Spielers.
     */
    public int getLebenspunkte(){
        return this.lebenspunkte;
    }
    
    /**
     * Setzt den Wert fuer die Lebenspunkte.
     * @param der Wert auf den die Lebenspunkte gesetzt werden sollen.
     */
     public void setLebenspunkte(int pLebenspunkte){
        this.lebenspunkte = pLebenspunkte;
    }

    /**
     * Die sondierende Methode für den Angriffswert des Spielers.
     * @return Der Angriffswert des Spielers.
     */
    public int getAngriffswert(){
        return this.angriffswert;
    }
}
