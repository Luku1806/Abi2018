
/**
 * Eine Scheibe fuer eine Tuerme von Hannoi-Simulation.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Scheibe{
    
    private int groesse;

    /**
     * Konstruktor für Objekte der Klasse Scheibe
     */
    public Scheibe(int groesse){
        this.groesse = groesse;
    }

    /**
     * Die Groesse der Scheibe.
     */
    public int getGroesse(){
        return this.groesse;
    }
    
    @Override
    public String toString(){
        String ausgabe = "";
        for(int i = 0; i < groesse; i++){
            ausgabe += "|";
        }
        return ausgabe;
    }
}
