
/**
 * Ein Turm fuer eine Tuerme von Hannoi-Simulation.
 * 
 * @author Lukas Reining 
 * @version 1.0
 */
public class Turm
{
    private Stack<Scheibe> stab;

    /**
     * Konstruktor für Objekte der Klasse Turm
     * 
     * @param scheibenzahl Die Anzahl an Scheiben die der Turm von beginn an besitzt.
     */
    public Turm(int scheibenzahl){
        stab = new Stack<Scheibe>();
        fuellen(scheibenzahl);
    }

    /**
     * Default Konstruktor fuer einen Turm ohne Scheiben.
     */
    public Turm(){
        stab = new Stack<Scheibe>();
    }

    /**
     * Gibt die oben liegende Scheibe zurueck und entfernt diese vom Turm.
     * 
     * @return Die oben liegende Scheibe.
     */
    public Scheibe nehmeOberste(){
        Scheibe oberste = stab.top();
        stab.pop();
        return oberste;
    }

    /**
     * Legt eine Scheibe oben auf den Turm herauf.
     * 
     * @param scheibe Die aufzulegende Scheibe.
     */
    public void scheibeAuflegen(Scheibe scheibe){
        stab.push(scheibe);
    }

    /**
     * Fuellt den Turm mit einer gegebenen Zahl an Scheiben.
     * 
     * @param scheibenzahl Die Menge an Scheiben die hinzugefuegt werden sollen.
     */
    private void fuellen(int scheibenzahl){
        for(int i = scheibenzahl; i>0; i--){
            stab.push(new Scheibe(i));
        }
    }

    /**
     * Gibt den Turm auf der Konsole aus.
     */
    public void print(){
        Stack<Scheibe> inverted = new Stack<Scheibe>();
        while(!stab.isEmpty()){
            //Tempsaving current Scheibe
            Scheibe current = stab.top();
            inverted.push(current);
            stab.pop();
            //Printing it out
            //System.out.format("%5s", current.toString());
            System.out.println(current.toString());
        }
        //Recreating the original Stack
        while(!inverted.isEmpty()){
            stab.push(inverted.top());
            inverted.pop();
        }
    }
}
