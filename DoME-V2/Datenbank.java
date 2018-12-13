import java.util.ArrayList;

/**
 * Die Klasse Datenbank bietet Möglichkeiten zum Speichern
 * von CD- und DVD-Objekten. Eine Liste aller CDs und DVDs
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
    private ArrayList<CD> cds;
    private ArrayList<DVD> dvds;

    /**
     * Erzeuge eine leere Datenbank.
     */
    public Datenbank()
    {
        cds = new ArrayList<CD>();
        dvds = new ArrayList<DVD>();
    }
    
    /**
     * Erfasse das gegebene Medium in der Datenbank.
     * @param dasMedium Das einzutragende Medium.
     */
    public void erfasseMedium(Medium dasMedium){
        if(dasMedium instanceof DVD){
            dvds.add((DVD)dasMedium);
        }else if(dasMedium instanceof CD){
            cds.add((CD)dasMedium);
        }else{
            System.out.println("Medium konnte nicht gelsesen werden!");
        }
    }

    /**
     * Erfasse die gegebene CD in dieser Datenbank.
     * @param dieCD Die einzutragende CD.
     */
    @Deprecated
    public void erfasseCD(CD dieCD)
    {
        cds.add(dieCD);
    }

    /**
     * Erfasse die gegebene DVD in dieser Datenbank.
     * @param dieDVD Die einzutragende DVD.
     */
    @Deprecated
    public void erfasseDVD(DVD dieDVD)
    {
        dvds.add(dieDVD);
    }

    /**
     * Gib eine Liste aller aktuell gespeicherten CDs und
     * DVDs auf der Konsole aus.
     */
    public void auflisten()
    {
        // Liste der CDs ausgeben
        for(CD cd : cds) {
            cd.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }

        // Liste der DVDs ausgeben
        for(DVD dvd : dvds) {
            dvd.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }
    }
}
