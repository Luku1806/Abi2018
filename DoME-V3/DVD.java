/**
 * Objekte dieser Klasse repräsentieren DVDs. Es werden
 * Informationen über eine DVD verwaltet, die wieder
 * abgefragt werden können.
 * 
 * @author Michael Kölling und David J. Barnes
 * @version 2006.03.30
 */
public class DVD extends Medium
{
    private String regisseur;

    /**
     * Konstruktor für Objekte der Klasse DVD
     * @param derTitel Der Titel dieser DVD.
     * @param derRegisseur Der Regisseur dieser DVD.
     * @param laenge Die Spielzeit des Hauptfilms.
     * @param pGenre Das Genre des Mediums.
     */
    public DVD(String derTitel, String dieRegie, int laenge, String pGenre)
    {
        super(derTitel,laenge,pGenre);
        regisseur = dieRegie;
    }

    /**
     * Gib die Details dieser DVD auf der Konsole aus.
     */
    public void ausgeben()
    {
        System.out.print("DVD: " + titel + " (" + spielzeit + " Min)");
        if(habIch) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + regisseur);
        System.out.println("    " + genre);
        System.out.println("    " + kommentar);
    }
}
