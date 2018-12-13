/**
 * Die Klasse Auto ist das Fahrzeug, mit dem der Besitzer fahren kann.
 * 
 * @author Lukas und Kilian
 * @version 1.0 vom 23.02.2016
 */
public class Auto extends Fahrzeug
{
    //Anfang der Attribute
    //Ende der Attribute
    
    /**
     * Ein Objekt der Klasse wird erzeugt, wobei alle Attribute per Parameter initialisiert werden.
     * @param pTankgroesse Gibt den Startwert des Attributs tankgroesse an.
     * @param pKmStand Gibt den Startwert des Attributs kilometerstand an.
     * @param pTankinhalt Gibt den Startwert des Attributs tankinhalt an.
     */
    public Auto(double pTankgroesse , int pKmStand , double pTankinhalt)
    {
        super(pTankgroesse , pTankinhalt , pKmStand);
    }
    
    /**
     * Das Auto fährt eine bestimmte Strecke auf der Autobahn
     * Das Auto verbraucht 0,11 Liter pro Kilometer
     * @param pStrecke Die zu fahrende Strecke
     */
    public void autobahnFahren(int pStrecke){
         double spritverbrauch = 0.11 * pStrecke;
        if (spritverbrauch <= tankinhalt){
            kilometerstand = kilometerstand + pStrecke;
            tankinhalt = tankinhalt - spritverbrauch;
            System.out.println("Fahre auf der Autobahn " + pStrecke + " Kilometer)");
            System.out.println("Autobahnfahrt beendet. Der Kilometerstand beträgt nun " + kilometerstand + " Kilometer.");
        }else{
            System.out.println("Nicht genug Tankinhalt vorhanden. Bitte tanken!");
        }
    }
}//end of Auto
