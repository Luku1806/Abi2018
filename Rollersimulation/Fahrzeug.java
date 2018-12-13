
/**
 * Diese Klasse dient als Vorlage f�r Fahzeuge, mit denen der Besitzer fahren kann
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
     * Konstruktor f�r Objekte der Klasse Fahrzeug
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
     * Die sondierende Methode f�r das Attribut kilometerstand.
     * @return Das Attribut kilometerstand wird zur�ckgegeben.
     */
    public double getKilometerstand()
    {
        return kilometerstand;
    }
    
    /**
     * Das Attribut tankinhalt wird erh�ht, sofern die Menge in den Tank passt.
     * @param pMenge Um diesen Wert wird der Tankinhalt erh�ht.
     */
    public void tanke(double pMenge){
        if(passtInTank(pMenge)){
            tankinhalt = tankinhalt + pMenge;
            System.out.println("Erfolgreich "+ pMenge+ " Liter getankt");
            System.out.println("Der Tankinhalt betr�gt nun " + tankinhalt + " Liter");
        }else {
             System.out.println("Nicht gen�gend Platz im Tank");
        }
    }
    
    /**
     * Die sondierende Methode f�r das Attribut tankinhalt.
     * @return Das Attribut tankinhalt wird zur�ckgegeben.
     */
    public double getTankinhalt(){
        return tankinhalt;
    }
    
    /**
     * Der Roller f�hrt eine bestimmte Strecke, sofern genug Tankinhalt vorhanden ist.
     * Er verbraucht 0,03 Liter pro Kilometer
     * @param pStrecke Die zu fahrende Strecke
     */
    public void fahre(int pStrecke){
        double spritverbrauch = 0.03 * pStrecke;
        if (spritverbrauch <= tankinhalt){
            kilometerstand = kilometerstand + pStrecke;
            tankinhalt = tankinhalt - spritverbrauch;
            System.out.println("Fahre...");
            System.out.println("Fahrt beendet. Der Kilometerstand betr�gt nun " + kilometerstand + " Kilometer.");
        }else{
            System.out.println("Nicht genug Tankinhalt vorhanden. Bitte tanken!");
        }
    }
    
    /**
     * Die sondierende Methode f�r das Attribut tankgroesse.
     * @return Das Attribut tankgroesse wird zur�ckgegeben.
     */
    public double getTankgroesse(){
        return tankgroesse;
    }
    
    /**
     * Es wird gepr�ft, ob die gew�nschte Menge Sprit noch in den Tank passt.
     * @param pMenge Gibt die gew�nschte zu tankende Menge an.
     * @return Gibt an, ob die gew�nschte Menge getankt werden kann.
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
