/**
 * Die Waffe mit der gekämpft werden kann.
 * 
 * @author Lukas Reining 
 * @version 1.0
 */

public class Waffe
{
    //Anfang der Attribute
    private String material;
    private int magie;
    private int bonus;

    /**
     * Konstruktor der Klasse Waffe.
     * @param pMaterial Das Material, aus dem die Waffe besteht.
     * @param pMagie Die Staerke der Magie, die die Waffe besitzt.
     */
    public Waffe(String pMaterial,int pMagie)
    {
        this.material = pMaterial;
        this.magie = pMagie;
        this.bonus = bonusBerechnen();
    }
    
    /**
     * UNFERTIG
     * Berechnet den Bonus der Waffe.
     * @return Der berechnete Waffenbonus.
     */
    public int bonusBerechnen(){
       return 2;
    }

    /**
     * Die sondierende Methode fuer den Bonus.
     * @return Der Bonus der Waffe.
     */
    public int getBonus()
    {
        return this.bonus;
    }
}
