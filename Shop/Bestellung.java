/**
 * Die Bestellung enthaelt ein T-Shirt und den Bestaetigungsstatus.
 * Sie kann mit der ID-Nummer zugeordnet werden.
 * 
 * @author Lukas Reining
 * @version 12.01.2018
 */
public class Bestellung{
    
    private boolean bestaetigt;
    private int idnr;
    private TShirt ware;
    
    /**
     * Konstruktor für Objekte der Klasse Bestellung
     */
    public Bestellung(TShirt shirt, int idnr){
        this.ware = shirt;
        this.idnr = idnr;
    }
    
    /**
     * Bestaetigt die Bestellung.
     */
    public void bestaetigen(){
        this.bestaetigt = true;
    }
    
    //Getter
    public boolean istBestaetigt(){
        return this.bestaetigt;
    }
    
    public int getID(){
        return this.idnr;
    }
    
    public TShirt getShirt(){
        return this.ware;
    }
}
