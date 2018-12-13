import java.util.ArrayList;

/**
 * Die Klasse Datenbank bietet Möglichkeiten zum Speichern
 * von CD-,DVD- und Buch-Objekten. Eine Liste aller CDs, DVDs und Buecher
 * kann auf der Konsole ausgegeben werden.
 * 
 * Diese Version speichert die Daten nicht im Dateisystem und
 * bietet keine Suchfunktion.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2006.03.30
 */
public class Datenbank
{
    private ArrayList<Medium> medien;

    /**
     * Erzeuge eine leere Datenbank.
     */
    public Datenbank()
    {
        medien = new ArrayList<Medium>();
    }

    /**
     * Erfasse das gegebene Medium in der Datenbank.
     * @param dasMedium Das einzutragende Medium.
     */
    public void erfasseMedium(Medium dasMedium){
        medien.add(dasMedium);
    }

    /**
     * Gib eine Liste aller aktuell gespeicherten CDs,
     * DVDs und Buecher auf der Konsole aus.
     */
    public void auflisten()
    {
        // Liste der CDs ausgeben
        for(CD cd : medien) {
            cd.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }

        // Liste der DVDs ausgeben
        for(DVD dvd : dvds) {
            dvd.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }

        // Liste der Buecher ausgeben
        for(Buch buch : buecher) {
            buch.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }
    }
}
