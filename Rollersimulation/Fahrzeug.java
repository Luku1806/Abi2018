
/**
 * Diese Klasse dient als Vorlage für Fahzeuge, mit denen der Besitzer fahren kann
 * 
 * @author Lukas Reining 
 * @version 1.0
 */
public class Fahrzeug
{
    //Anfang der Attribute
    protected double tankgroesse;
    protected double tankinhalt;
    protected int kilometerstand;
    //Ende der Attribute

    /**
     * Konstruktor für Objekte der Klasse Fahrzeug
     * @param tankgroesse Startwert der tankgroesse
     * @param tankinhalt Startwert des Attributs tankinhalt
     * @param kilometerstand Startwer des Attributs kilometerstand
     */
    public Fahrzeug(double pTankgroesse , double pTankinhalt , int pKilometerstand){
        tankgroesse = pTankgroesse;
        tankinhalt = pTankinhalt;
        kilometerstand = pKilometerstand;
    }
    
    //Beginn der Methoden

    /**
     * Die sondierende Methode für das Attribut kilometerstand.
     * @return Das Attribut kilometerstand wird zurückgegeben.
     */
    public double getKilometerstand()
    {
        return kilometerstand;
    }
    
    /**
     * Das Attribut tankinhalt wird erhöht, sofern die Menge in den Tank passt.
     * @param pMenge Um diesen Wert wird der Tankinhalt erhöht.
     */
    public void tanke(double pMenge){
        if(passtInTank(pMenge)){
            tankinhalt = tankinhalt + pMenge;
            System.out.println("Erfolgreich "+ pMenge+ " Liter getankt");
            System.out.println("Der Tankinhalt beträgt nun " + tankinhalt + " Liter");
        }else {
             System.out.println("Nicht genügend Platz im Tank");
        }
    }
    
    /**
     * Die sondierende Methode für das Attribut tankinhalt.
     * @return Das Attribut tankinhalt wird zurückgegeben.
     */
    public double getTankinhalt(){
        return tankinhalt;
    }
    
    /**
     * Der Roller fährt eine bestimmte Strecke, sofern genug Tankinhalt vorhanden ist.
     * Er verbraucht 0,03 Liter pro Kilometer
     * @param pStrecke Die zu fahrende Strecke
     */
    public void fahre(int pStrecke){
        double spritverbrauch = 0.03 * pStrecke;
        if (spritverbrauch <= tankinhalt){
            kilometerstand = kilometerstand + pStrecke;
            tankinhalt = tankinhalt - spritverbrauch;
            System.out.println("Fahre...");
            System.out.println("Fahrt beendet. Der Kilometerstand beträgt nun " + kilometerstand + " Kilometer.");
        }else{
            System.out.println("Nicht genug Tankinhalt vorhanden. Bitte tanken!");
        }
    }
    
    /**
     * Die sondierende Methode für das Attribut tankgroesse.
     * @return Das Attribut tankgroesse wird zurückgegeben.
     */
    public double getTankgroesse(){
        return tankgroesse;
    }
    
    /**
     * Es wird geprüft, ob die gewünschte Menge Sprit noch in den Tank passt.
     * @param pMenge Gibt die gewünschte zu tankende Menge an.
     * @return Gibt an, ob die gewünschte Menge getankt werden kann.
     */
    public boolean passtInTank(double pMenge){
        if (tankgroesse >= tankinhalt + pMenge){
            return true;
        }
        else{
            return false;
        }
    }
    //Ende Methoden
}
