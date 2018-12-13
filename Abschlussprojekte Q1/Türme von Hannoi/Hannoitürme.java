
/**
 * Eine Tuerme von Hannoi-Simulation.
 * 
 * @author Lukas Reining
 * @version 1.0
 */
public class Hannoitürme{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Turm ausgangsturm, wechselturm, endturm;
    private int scheibenzahl;
    private int zuege;

    /**
     * Konstruktor für Objekte der Klasse Hannoitürme
     */
    public Hannoitürme(int scheibenzahl){
        this.scheibenzahl = scheibenzahl;
        ausgangsturm = new Turm(scheibenzahl);
        wechselturm = new Turm();
        endturm = new Turm();
    }

    /**
     * Loest das Tuerme von Hannoi-Spiel.
     */
    public void loesen(){
        long startTime =  System.currentTimeMillis();
        System.out.println("Starte Tuerme von Hannoi Simulation mit " + scheibenzahl + " Scheiben...");
        print();
        bewege(scheibenzahl,ausgangsturm,wechselturm,endturm);
        //Endergebnis
        long endtime = System.currentTimeMillis() - startTime;
        long millis = (endtime / 1000);
        long second = (endtime / 1000) % 60;
        long minute = (endtime / (1000 * 60)) % 60;
        long hour = (endtime / (1000 * 60 * 60)) % 24;
        String time = String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
        System.out.println("Das Spiel mit " + scheibenzahl + " Scheiben wurde innerhalb von " + zuege + " Zuegen geloest.\nDies hat " + time + " gedauert.");
    }

    /**
     * Der Randoffsche Algorithmus zur Loesung des Tuerme von Hannoi-Problems. 
     */
    private void bewege(int scheibenzahl, Turm a, Turm b, Turm c){
        if(scheibenzahl > 0){
            zuege++;
            bewege(scheibenzahl-1, a, c, b);
            c.scheibeAuflegen(a.nehmeOberste());
            print();
            bewege(scheibenzahl-1, b, a, c);
        }
    }

    /**
     * Gibt alle Tuerme auf der Konsole aus.
     */
    public void print(){
        System.out.println("Ausgangsturm:");
        ausgangsturm.print();
        System.out.println("Wechselturm:");
        wechselturm.print();
        System.out.println("Endturm:");
        endturm.print();
        System.out.println();
    }
}
