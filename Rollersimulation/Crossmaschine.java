/**
 * Die Klasse Crossmaschine ist das Fahrzeug, mit dem der Besitzer fahren kann.
 * 
 * @author Lukas und Kilian
 * @version 1.0 vom 23.02.2016
 */
public class Crossmaschine extends Fahrzeug
{
    //Anfang der Attribute
    //Ende der Attribute
    
    /**
     * Ein Objekt der Klasse wird erzeugt, wobei alle Attribute per Parameter initialisiert werden.
     * @param pTankgroesse Gibt den Startwert des Attributs tankgroesse an.
     * @param pKmStand Gibt den Startwert des Attributs kilometerstand an.
     * @param pTankinhalt Gibt den Startwert des Attributs tankinhalt an.
     */
    public Crossmaschine(double pTankgroesse , int pKmStand , double pTankinhalt)
    {
        super(pTankgroesse , pTankinhalt , pKmStand);
    }
    
    /**
     * Das Crossmaschine fährt eine bestimmte Strecke des Rennens
     * Das Crossmaschine verbraucht 0,15 Liter pro Kilometer
     * @param pStrecke Die zu fahrende Strecke
     */
    public void rennenFahren(int pStrecke){
         double spritverbrauch = 0.15 * pStrecke;
        if (spritverbrauch <= tankinhalt){
            kilometerstand = kilometerstand + pStrecke;
            tankinhalt = tankinhalt - spritverbrauch;
            System.out.println("Fahre ein Rennen von " + pStrecke + " Kilometer(n)");
            System.out.println("Rennen beendet. Der Kilometerstand beträgt nun " + kilometerstand + " Kilometer.");
        }else{
            System.out.println("Nicht genug Tankinhalt vorhanden. Bitte tanken!");
        }
    }
}//end of Auto
