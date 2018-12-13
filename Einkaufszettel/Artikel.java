
/**
 * Die Klasse stellt einen Artikel da, der zum Einkaufszettel hinzugefuegt werden kann.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Artikel
{
    // Variablen
    private String artikelName;
    // Ende Variablen
    
    /**
     * Konstruktor.
     * Variablen werden initialisiert.
     * 
     * @param pArtikelName Der Name des Artikels.
     */
    public Artikel(String pArtikelName)
    {
        artikelName = pArtikelName;
    }
    
    /**
     * Gibt den Artikelnamen als String zurueck.
     * 
     * @return Der Artikelname.
     */
    public String getArtikelName(){
        return this.artikelName;
    }
}
