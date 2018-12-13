
/**
 * Die Klasse Roller ist das Fahrzeug, mit dem der Besitzer fahren kann.
 * 
 * @author Lukas und Kilian
 * @version 1.0 vom 23.02.2016
 */
public class Roller
{
    //Anfang der Attribute
    private double tankgroesse;
    private double tankinhalt;
    private double kilometerstand;
    //Ende der Attribute
    
    /**
     * Ein Objekt der Klasse wird erzeugt, wobei alle Attribute per Parameter initialisiert werden.
     * @param pTankgroesse Gibt den Startwert des Attributs tankgroesse an.
     * @param pKmStand Gibt den Startwert des Attributs kilometerstand an.
     * @param pTankinhalt Gibt den Startwert des Attributs tankinhalt an.
     */
    public Roller(double pTankgroesse , int pKmStand , double pTankinhalt)
    {
        tankgroesse = pTankgroesse;
        kilometerstand = pKmStand;
        tankinhalt = pTankinhalt;
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
}//end of Roller
