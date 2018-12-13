
/**
 * Der Besitzer eines Rollers kann diesen fahren und ihn Betanken, sofern er genug Geld besitzt
 * @author Lukas Reining
 * @version 1.0 vom 27.02.2016
 */
public class Besitzer
{
    // Anfang Attribute
    private String name;
    private double geld;
    public Roller meinRoller;
    // Ende der Attribute
    
    /**
     * Der Konstruktor erzeugt ein Objekt der Klasse, wobei alle Attribute per Parameterübergabe initialisiert werden.
     * @param pName Gibt den Startwert des Attributs name an.
     * @param pGeld Gibt den Startwert des Attributs Geld an.
     * @param pRoller Ein Objekt der Klasse Rover wird referenziert.
     */
    public Besitzer(String pName , double pGeld , Roller pRoller )
    {
       name = pName;
       geld = pGeld;
       meinRoller = pRoller;
    }

    /**
     * Die sondierende Methode für das Attribut name.
     * @return Das Attribut name wird zurückgegeben.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Die sondierende Methode für das Attribut geld.
     * @return Das Attribut geld wird zurückgegeben.
     */
    public double getGeld()
    {
        return geld;
    }
    
    /**
     * Der Tankinhalt des Objekts meinRoller wird erhöht und das geld wird (Der Einfachheit halber) um pMenge reduziert.
     * @param Der Tankinhalt wir um pMenge
     */
    public void tankeDeinenRoller(double pMenge){
        if (pMenge * 1.5 <= geld){
            meinRoller.tanke(pMenge);
            geld = geld - (pMenge * 1.5);
        }
    }
    
    /**
     * Der Kilometerstand des Objekts meinRoller wird erhöht.
     * @param pStrecke Gibt die zu fahrende Strecke an.
     */
    public void fahreDeinenRoller(int pStrecke){
        meinRoller.fahre(pStrecke);
    }
    
    /**
     * Das Geld des Besitzers wird erhöht.
     * @param pSumme Der Wert, um den geld erhöht wird.
     */
    public void erhalteTaschengeld(double pSumme){
        geld = geld + pSumme;
    }
}
