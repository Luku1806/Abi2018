/**
 * Der Held dient als Superklasse fuer verschiedene Helden.
 * Er beinhaltet alle gemeinsam geteilten Faehigkeiten und Eigenschaften der Helden.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Held
{
    //Anfang der Attribute
    protected String name;
    protected int staerke;
    protected int angriffswert;
    protected int lebenspunkte;
    private Waffe meineWaffe;

    /**
     * Konstruktor des Helden.
     * @param pName Der Name des Helden.
     * @param pStaerke Die Staerke des Helden.
     * @param pMaxLebenspunkte Die Lebenspunkte zum Zeitpunkt der Erstellung des Helden.
     */
    public Held(String pName, int pStaerke, int pMaxLebenspunkte)
    {
        this.name = pName;
        this.staerke = pStaerke;
        this.lebenspunkte = pMaxLebenspunkte;
        this.meineWaffe = null;
        this.angriffswert = this.angriffswertBerechnen();
    }

    /**
     * Der Spieler greift ein Monster an.
     * @param pMonster Das anzugreifende Monster.
     * @param pKampfregel Die geltende Kampfregel.
     */
    public void angreifen(Monster pMonster, Kampfregel pKampfregel){
        pKampfregel.kampf(this,pMonster);
    }

    /**
     * Gibt dem Spieler eine Waffe.
     * @param pWaffe Die Waffe die der Spieler erhalten soll.
     */
    public void erhalteWaffe(Waffe pWaffe){
        meineWaffe = pWaffe;
    }

    /**
     * Entzieht dem Spieler seine Waffe.
     */
    public void verliereWaffe(){
        meineWaffe = null;
    }

    /**
     * Berechnet den Angriffswert des Helden. Dieser setzt sich aus seiner Staerke und dem Bonus seiner Waffe zusammen.
     * @return Der berechnete Angriffswert.
     */
    protected int angriffswertBerechnen(){
        int angriffswert = 0;
        if(meineWaffe != null){
            angriffswert += meineWaffe.getBonus();
        }
        angriffswert += staerke;
        return angriffswert;
    }

    /**
     * Die sondierende Methode fuer den Namen des Spielers.
     * @return Der Name des Spielers.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Die sondierende Methode fuer die Lebenspunkte des Spielers.
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
     * Die sondierende Methode fuer den Angriffswert des Spielers.
     * @return Der Angriffswert des Spielers.
     */
    public int getAngriffswert(){
        return this.angriffswert;
    }
}
